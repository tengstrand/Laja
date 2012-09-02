package net.sf.laja.template.data;

import net.sf.laja.exception.InterpretationException;
import net.sf.laja.parser.engine2.source.Source;

public class BooleanHelper {

	public static Boolean toBoolean(Object value, Source source, int indexInSource) {
		if (value instanceof Boolean) {
			return ((Boolean)value);
		} else {
			if (value == null) {
				throw new InterpretationException(source, indexInSource, "Can not evaluate null to a boolean value");
			}
			String string = value.toString();
			try {
				return new Boolean(string);
			} catch (NumberFormatException e) {
				throw new InterpretationException(source, indexInSource, "Boolean value (true/false) was expected, found:  " + string);
			}
		}
	}
}
