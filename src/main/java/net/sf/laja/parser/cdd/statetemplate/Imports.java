package net.sf.laja.parser.cdd.statetemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Imports implements StateTemplateParser.IImports, Iterable<Importstatement> {
    public List<Importstatement> statements = new ArrayList<Importstatement>();

    public Imports() {
    }

    public Imports(Imports imports) {
        statements.addAll(imports.statements);
    }

    public Iterator<Importstatement> iterator() {
        return statements.iterator();
    }

    public void addImport(String fullclassname) {
        statements.add(new Importstatement(fullclassname));
    }

    public void addImports(Imports imports) {
        statements.addAll(imports.statements);
    }

    public void addImportstatement(StateTemplateParser.IImportstatement iimportstatement) {
        statements.add((Importstatement)iimportstatement);
    }

    public void addImportIfNotExists(Importstatement importstatement) {
        if (!statements.contains(importstatement)) {
            statements.add(importstatement);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Imports imports = (Imports) o;

        if (statements != null ? !statements.equals(imports.statements) : imports.statements != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return statements != null ? statements.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Imports{" +
                "statements=" + statements +
                '}';
    }
}
