import java.util.Map;

import net.sf.laja.MacroCaller;
import net.sf.laja.parser.grammar.element.Def;

class PropertiesReader {
	public Object read(String filename) {
		def properties = new Properties()
		
		new File(filename).withInputStream {
			stream -> properties.load(stream) 
		}
		
		return properties
	}
}
