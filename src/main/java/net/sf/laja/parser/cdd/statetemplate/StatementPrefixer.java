package net.sf.laja.parser.cdd.statetemplate;

public class StatementPrefixer {
    private final String prefix;
    private final String statement;
    private final String searchFor;
    private final String replace;

    public StatementPrefixer(String prefix, String statement, String searchFor) {
        this(prefix, statement, searchFor, searchFor);
    }

    public StatementPrefixer(String prefix, String statement, String searchFor, String replace) {
        this.prefix = prefix;
        this.statement = "(" + statement + ")";
        this.searchFor = searchFor;
        this.replace = replace;
    }

    public String prefixAttribute() {
        String result = "";

        int lastIndex = 1;
        int index = statement.indexOf(searchFor, lastIndex);

        boolean skipIfPeriod = prefix.length() > 0;

        while (index > 0 && index < statement.length()-3) {
            if (!isLetter(index - 1)
                    && (!skipIfPeriod || !isPeriod(index - 1))
                    && !isLetter(index + searchFor.length())) {
                result += statement.substring(lastIndex, index) + prefix + replace;
                lastIndex = index + searchFor.length();
                index = statement.indexOf(searchFor, lastIndex+1);
            } else {
                index++;
            }
        }
        return result + statement.substring(lastIndex, statement.length() - 1);
    }

    boolean isLetter(int index) {
        return Character.isLetter(statement.subSequence(index, index + 1).charAt(0));
    }

    boolean isPeriod(int index) {
        return statement.substring(index, index + 1).equals(".");
    }
}
