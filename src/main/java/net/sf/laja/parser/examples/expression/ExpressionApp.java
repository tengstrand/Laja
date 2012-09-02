package net.sf.laja.parser.examples.expression;

import net.sf.laja.parser.engine2.ParsingResult;
import net.sf.laja.parser.examples.expression.ExpressionParser.IExpressionFactory;
import net.sf.laja.parser.examples.expression.ExpressionParser.IExpressionFactoryFactory;

public class ExpressionApp {
	public static void main(String args[]) {
		String inputFile = "src/main/java/net/sf/laja/parser/examples/expression/expression.txt";
        
		ExpressionParser parser = new ExpressionParser(new IExpressionFactoryFactory() {
			public IExpressionFactory getFactory(int phase) {
				return new ExpressionFactory();
			}
		});
		
		try {
			ParsingResult result = parser.parseFile(inputFile);
			
			if (result.success()) {
				Expression exp = ((ExpressionFactory)parser.getFactory()).getExp();
				System.out.println("Result=" + exp.calculate());
			} else {
				System.out.println(result.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}