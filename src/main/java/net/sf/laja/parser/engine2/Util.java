package net.sf.laja.parser.engine2;

import org.apache.commons.lang.StringUtils;

public class Util {

	public static final String replaceWhiteSpaces(String string) {
		return StringUtils
			.replace(string, "\\t", "\t")	// 0x0009  	HORIZONTAL TABULATION
			.replace("\\n", "\n")			// 0x000A 	NEW LINE
			.replace("\\f", "\f")			// 0x000C 	FORM FEED
			.replace("\\r", "\r");			// 0x000D	CARRIAGE RETURN
	}

	public static final String replaceSpecialCharacters(String string) {
		return StringUtils.replace(replaceWhiteSpaces(string), "\\\"", "\"");
	}

	public static String replaceSlash(String str) {
		char[] schar = new char[1];
		String sc = new String(schar);
		if (sc.equals("/")) {
			str = str.replace("\\", sc);
		} else if (sc.equals("\\")) {
			str = str.replace("/", sc);
		}
	
		return str;
	}	
	
	public static void append(StringBuilder builder, String property, String value) {
		builder.append(property).append("=");
		
		if (value == null) {
			builder.append("null");
		} else {
			builder.append("'").append(value).append("'");
		}
	}
}
