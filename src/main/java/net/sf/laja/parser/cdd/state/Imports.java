package net.sf.laja.parser.cdd.state;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Imports implements StateParser.IImports, Iterable<ImportStatement> {
    public List<ImportStatement> statements = new ArrayList<ImportStatement>();

    public void addImportstatement(StateParser.IImportstatement iimportstatement) {
        statements.add((ImportStatement)iimportstatement);
    }

    public boolean hasImports() {
        return !statements.isEmpty();
    }

    public Iterator<ImportStatement> iterator() {
        return statements.iterator();
    }

    @Override
    public String toString() {
        return "Imports{" +
                "statements=" + statements +
                '}';
    }
}
