package net.sf.laja.parser.cdd.behaviour;

import net.sf.laja.parser.cdd.behaviour.constructor.Importstatement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Imports implements BehaviourParser.IImports, Iterable<Importstatement> {
    public List<Importstatement> statements = new ArrayList<Importstatement>();

    public Iterator<Importstatement> iterator() {
        return statements.iterator();
    }

    public boolean containsStatement(String statement) {
        for (Importstatement importstatement : statements) {
            if (importstatement.fullclassname.equals(statement)) {
                return true;
            } else if (statement.endsWith(".*")) {
                if (isMatchingAsteriskImport(importstatement.fullclassname, statement)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * If we only have the two imports that we get when extending the Behaviour class,
     * then the statement that imports all state classes is required (that is why
     * imports ending with "Behaviour" and "State" is excluded).
     */
    private boolean isMatchingAsteriskImport(String fullclassname, String importWithAsterisk) {
        String compare = importWithAsterisk.substring(0, importWithAsterisk.length() - 2);
        int length = compare.length();
        if (fullclassname.length() > length + 1 &&
                fullclassname.substring(length, length+1).equals(".") &&
                fullclassname.indexOf(".", length + 1) < 0 &&
                !fullclassname.endsWith("Behaviour") &&
                !fullclassname.endsWith("State")) {
            return true;
        }
        return false;
    }

    public void addImportstatement(BehaviourParser.IImportstatement iimportstatement) {
        statements.add((Importstatement)iimportstatement);
    }

    @Override
    public String toString() {
        return "Imports{" +
                "statements=" + statements +
                '}';
    }
}
