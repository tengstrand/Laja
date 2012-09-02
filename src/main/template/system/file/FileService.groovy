
import java.io.File

class FileService {
	
	boolean fileExists(def path) {
		File file = new File(path)
		return file.exists() && file.isFile()
	}
	
	boolean directoryExists(def path) {
		File file = new File(path)
		return file.exists() && file.isDirectory()
	}
	
	boolean pathExists(def path) {
		return new File(path).exists()
	}
	
	boolean createDirectory(def path) {
		return new File(path).mkdir()
	}

	boolean createDirectoryPath(def path) {
		return new File(path).mkdirs()  
	}
}
