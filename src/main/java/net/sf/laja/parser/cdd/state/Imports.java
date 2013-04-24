package net.sf.laja.parser.cdd.state;

import java.util.ArrayList;
import java.util.List;

public class Imports implements StateParser.IImports {
    public List<ImportStatement> statements = new ArrayList<ImportStatement>();

    public void addImportstatement(StateParser.IImportstatement iimportstatement) {
        statements.add((ImportStatement)iimportstatement);
    }

    @Override
    public String toString() {
        return "Imports{" +
                "statements=" + statements +
                '}';
    }
}
