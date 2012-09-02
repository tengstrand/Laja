package net.sf.laja.parser.template;

import java.util.List;

import net.sf.laja.parser.grammar.Ref;
import net.sf.laja.parser.grammar.element.Grammar;

import org.apache.commons.lang.StringUtils;

public class GrammarData {
	private String grammarName;
	private String grammarClass;
	private Grammar grammar;
	private List<Ref> refList;
	private static int id = 1;
	
	public GrammarData(Grammar grammar, String grammarName, List<Ref> refList) {
		this.grammar = grammar;
		this.grammarName = grammarName;
		this.refList = refList;
	}

	public String getGrammarName() {
		return grammarName;
	}

	public String getGrammarClass() {
		if (grammarClass == null) {
			for (Ref ref : refList) {
				if (ref.getRefname().equals(grammarName)) {
					grammarClass = ref.getClassName();
					return grammarClass;
				}
			}
			grammarClass = StringUtils.capitalize(grammarName);
		}
		return grammarClass;
	}
	
	public String getClassName() {
		return getGrammarClass() + "Parser";
	}
	
	public static int getId() {
		return id++;
	}
	
	public void resetId() {
		id = 1;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("General{")
			.append("id=").append(id)
			.append(", grammarName=").append(grammarName)
			.append(", grammarClass=").append(grammarClass)
			.append(", grammar=").append(grammar)
			.append("}");
		return buffer.toString();
	}
}
