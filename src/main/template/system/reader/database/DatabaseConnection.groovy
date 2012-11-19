
import java.sql.*;

public class DatabaseConnection {
	private Connection con;
	private String catalogue
	private String schema
	
	private List schemas
	private List tables;
	private List columns;
	
	/**
	 * Connects to a database.
	 * A call to close() need to be performed to close the connection
	 * when all database operations are finished.
	 */
	public DatabaseConnection(Map settings) {
		String driver = getMandatoryProperty(settings, "driver")
		String connection = getMandatoryProperty(settings, "connection")
		String user = getMandatoryProperty(settings, "user")
		String password = getMandatoryProperty(settings, "password")
		catalogue = getProperty(settings, "catalogue")
		schema = getProperty(settings, "schema")
		
		Class.forName(driver)
		this.con = DriverManager.getConnection(connection, user, password)
	}
	
	/**
	 * Public API to database meta data.
	 */
	public DatabaseMetaData getMetadata() {
		return con.getMetaData()
	}
	
	public Map readMetadata() {
		Map result = new HashMap()
		result.put("schemas", getSchemas())
		result.put("tables", getTables())
		result.put("columns", getColumns())
		result.put("relations", getRelations())
		
		return result
	}
	
    public List executeSql(String sql) {
        List result = new ArrayList()
        Statement statement = con.createStatement();

        try {
            if (statement.execute(sql)) {
                result = getResultSet(statement)
            }
        } catch (Exception e) {
            print("Could not execute SQL: " + sql + ". Exception: " + e);
        }
        statement.close()

        return result
    }
	
	private List getResultSet(Statement statement) {
		ResultSet rs = statement.getResultSet()
		ResultSetMetaData metadata = rs.getMetaData()

		List records = new ArrayList();
		
		while (rs.next()) {
			records.add(extractRecord(metadata, rs));
		}
		return records;
	}
	
	private Map extractRecord(ResultSetMetaData metadata, ResultSet rs) {
		Map record = new LinkedHashMap();
		
		int i = 0;
		while (++i <=metadata.getColumnCount()) {
			record.put(metadata.getColumnName(i).toLowerCase(), rs.getObject(i));
		}
		return record;
	}
	
	private getProperty(Map settings, String propertyName) {
		if (settings.containsKey(propertyName)) {
			return settings.get(propertyName)
		}
		return null
	}
	
	private getMandatoryProperty(Map settings, String propertyName) {
		String property = getProperty(settings, propertyName)
		
		if (property == null) {
			throw new RuntimeException("Connection property '" + propertyName + "' must be set.")
		}
		return property
	}
		
	private List getSchemas() {
		if (schemas == null) {
			schemas = new ArrayList()
			
			ResultSet rs = con.getMetaData().getSchemas();
	
			while(rs.next()) {
	    		schemas.add(rs.getString(1))
			}
			rs.close()
		}
		return schemas
	}	
		
	private List getTables() throws SQLException {
	    List tables = new ArrayList();
	
        for (String currentSchema : getSchemas()) {

			if (schema == null || schema.equalsIgnoreCase(currentSchema)) {
				println("** Schema: " + currentSchema + ", schema=" + schema)
	    		ResultSet rs = con.getMetaData().getTables(null, currentSchema, "%", null);

				while (rs.next()) {
					Map table = new LinkedHashMap()
					table.put("catalogue", lower(rs.getString("TABLE_CAT")))
					table.put("schema", lower(currentSchema))
					table.put("name", lower(rs.getString("TABLE_NAME")))
					table.put("description", lower(rs.getString("REMARKS")))
					table.put("columns", getColumnsForTable(table))
					tables.add(table)
 		    	}
				rs.close()
			}
		}
		return tables
	}
	
	private List getColumnsForTable(Map table) {
		getColumns()

		List tableColumns = new ArrayList()

		for (tableColumn in columns) {
			if (tableColumn.catalogue == table.catalogue && 
			    tableColumn.schema == table.schema &&
			    tableColumn.tableName == table.name) {
				tableColumns.add(tableColumn)
			}
		}
		return tableColumns
	}
	
	private List getColumns() throws SQLException {
		if (columns == null) {
       		for (String currentSchema : getSchemas()) {
				if (schema == null || schema.equalsIgnoreCase(currentSchema)) {
					ResultSet rs = con.getMetaData().getColumns(null, currentSchema, "%", "%")

					columns = new ArrayList()
			
					while (rs.next()) {
						Map column = new LinkedHashMap()
						column.put("catalogue", lower(rs.getString("TABLE_CAT")))
						column.put("schema", lower(rs.getString("TABLE_SCHEM")))
						column.put("tableName", lower(rs.getString("TABLE_NAME")))
						column.put("name", lower(rs.getString("COLUMN_NAME")))
						column.put("type", lower(rs.getString("TYPE_NAME")))
						column.put("size", rs.getInt("COLUMN_SIZE"))
						column.put("decimalDigits", rs.getInt("DECIMAL_DIGITS"))
						column.put("numPrecRadix", rs.getInt("NUM_PREC_RADIX"))
						column.put("nullAllowed", rs.getInt("NULLABLE"))
						column.put("description", lower(rs.getString("REMARKS")))
						column.put("defaultValue", lower(rs.getString("COLUMN_DEF")))
						column.put("maxLenthInChar", rs.getInt("CHAR_OCTET_LENGTH"))
						column.put("order", rs.getInt("ORDINAL_POSITION"))
						column.put("nullable", rs.getString("IS_NULLABLE").equals("YES"))
						columns.add(column)
					}
					rs.close()
				}
			}
		}
		
		return columns
	}
	
	private List getRelations() throws SQLException {
		ResultSet rs = con.getMetaData().getCrossReference(null, null, null, null, null, null)
		
		List relations = new ArrayList()
		
		while (rs.next()) {
			Map relation = new LinkedHashMap()
			relation.put("pkTableCatalogue", lower(rs.getString("PKTABLE_CAT")))
			relation.put("pkTableSchema", lower(rs.getString("PKTABLE_SCHEM")))
			relation.put("pkTableName", lower(rs.getString("PKTABLE_NAME")))
			relation.put("pkColumnName", lower(rs.getString("PKCOLUMN_NAME")))
			relation.put("fkTableCatalogue", lower(rs.getString("FKTABLE_CAT")))
			relation.put("fkTableSchema", lower(rs.getString("FKTABLE_SCHEM")))
			relation.put("fkTableName", lower(rs.getString("FKTABLE_NAME")))
			relation.put("fkColumnName", lower(rs.getString("FKCOLUMN_NAME")))
			relation.put("order", lower(rs.getString("KEY_SEQ")))
			relation.put("updateRule", lower(rs.getString("UPDATE_RULE")))
			relation.put("deleteRule", lower(rs.getString("DELETE_RULE")))
			relation.put("fkName", lower(rs.getString("FK_NAME")))
			relation.put("pkName", lower(rs.getString("PK_NAME")))
			relation.put("deferrability", lower(rs.getString("DEFERRABILITY")))
			relations.add(relation)
		}
		rs.close()
		
		return relations
	}
	
	private String lower(String string) {
		if (string == null) {
			return string
		}
		return string.toLowerCase()
	}
}
