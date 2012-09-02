
import java.io.File;

class DatabaseReader {
	
	public DatabaseConnection connect(Map settings) {
		return new DatabaseConnection(settings)
	}
}
