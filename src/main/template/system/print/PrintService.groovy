import net.sf.laja.parser.grammar.element.Def;

class PrintService {
	
	void print(def message) {
		System.out.print(message.toString())
	}

	void println(def message) {
		System.out.println(message.toString())
	}
}
