package net.sf.laja.parser.cdd;

import net.sf.laja.parser.cdd.statetemplate.StatementPrefixer;
import org.apache.commons.lang.StringUtils;

import java.io.File;

public class StatementConverter {
    public static final String[] TEMPLATES = new String[] { "Template", "Entity", "Value" };

    public String prefixAttribute(String prefix, String statement, String searchFor) {
        return new StatementPrefixer(prefix, statement, searchFor).prefixAttribute();
    }

    public String prefixAttribute(String prefix, String statement, String searchFor, String replace) {
        return new StatementPrefixer(prefix, statement, searchFor, replace).prefixAttribute();
    }

    public String calculateSetStatement(String statement, String variable) {
        String searchFor = statement;
        if (searchFor.indexOf(".") > 0) {
            searchFor = searchFor.substring(searchFor.lastIndexOf(".") + 1);
        }

        String replace;
        if (searchFor.length() >= 4 && searchFor.startsWith("get") && Character.isUpperCase(searchFor.charAt(3))) {
            replace = "set" + searchFor.substring(3, searchFor.length() - 1) + variable + ")";
        } else {
            replace = "set" + StringUtils.capitalize(searchFor) + "(" + variable + ")";
        }
        return new StatementPrefixer("", statement, searchFor, replace).prefixAttribute();
    }

    /**
     * Strips out the package from a full package class name, e.g:
     *   'csb.persistence.customer.CustomerInDb' into 'csb.persistence.customer'
     *
     * @param fullClassName
     * @return
     */
    public String asPackageName(String fullClassName) {
        int index = fullClassName.lastIndexOf(".");

        if (index < 0) {
            return fullClassName;
        }
        return fullClassName.substring(0, index);
    }

    public String asClassname(File file) {
        final String suffix = ".java";

        String classname = file.getName();
        for (String template : TEMPLATES) {
            if (classname.endsWith(template + suffix)) {
                return classname.substring(0, classname.length() - template.length() - suffix.length());
            }
        }
        return classname.substring(0, classname.length() - suffix.length());
    }
}
