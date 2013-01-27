package net.sf.laja.parser.cdd;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AsciiTable {
    private final Row header = new Row();
    private final List<Row> rows = new ArrayList<Row>();

    public AsciiTable(String... headers) {
        for (String header : headers) {
            this.header.addColumn(header);
        }
    }

    static class Widths implements Iterable<Integer> {
        List<Integer> widths;

        public Widths(List<String> columns) {
            widths = new ArrayList<Integer>(columns.size());
            for (int i=0; i<columns.size(); i++) {
                widths.add(columns.get(i).length());
            }
        }

        public Widths(Widths widths) {
            this.widths = new ArrayList<Integer>(widths.size());
            for (int i=0; i< widths.size(); i++) {
                this.widths.set(i, widths.widths.get(i));
            }
        }

        public int size() {
            return widths.size();
        }

        public void setMaxWidths(Widths that) {
            for (int i=0; i<size(); i++) {
                if (that.widths.get(i) > widths.get(i)) {
                    widths.set(i, that.widths.get(i));
                }
            }
        }

        private String separator() {
            String result = "+";
            for (Integer width : widths) {
                result += StringUtils.repeat("-", width + 2) + "+";
            }
            return result;
        }

        public Iterator<Integer> iterator() {
            return widths.iterator();
        }
    }

    public static class Row {
        private List<String> columns = new ArrayList<String>();

        public void addColumn(String column) {
            columns.add(column);
        }

        public Widths widths() {
            return new Widths(columns);
        }

        public String columns(Widths widths) {
            String result = "";
            Iterator<Integer> widthsIter = widths.iterator();
            for (String column : columns) {
                int lengthDiff = widthsIter.next() - column.length();
                result += "| " + column + StringUtils.repeat(" ", lengthDiff) + " ";
            }
            return result + "|";
        }
    }

    public String text() {
        Widths maxWidths = getMaxWidths();

        String result = maxWidths.separator() + br() + header.columns(maxWidths) + br() + maxWidths.separator() + br();

        for (Row row : rows) {
            result +=  row.columns(maxWidths) + br();
        }
        return result + maxWidths.separator();
    }

    private Widths getMaxWidths() {
        Widths result = header.widths();

        for (Row row : rows) {
            result.setMaxWidths(row.widths());
        }
        return result;
    }

    private String br() {
        return "\n";
    }

    public void addRow(Row row) {
        rows.add(row);
    }
}
