package net.sf.laja.parser.cdd.behaviour;

import net.sf.laja.parser.cdd.behaviour.constructor.Importstatement;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ImportsTest {

    @Test
    public void containsStatement_missing() {
        Imports imports = new Imports();
        assertFalse(imports.containsStatement("a.b.c"));
    }

    @Test
    public void containsStatement_exists() {
        final String statement = "a.b.c";

        Imports imports = new Imports();
        Importstatement importstatement = new Importstatement();
        importstatement.setFullclassname(statement);
        imports.addImportstatement(importstatement);

        assertTrue(imports.containsStatement(statement));
    }

    @Test
    public void containsStatement_asterixExists() {
        Imports imports = createImports("a.b.c.MyClass");

        assertTrue(imports.containsStatement("a.b.c.*"));
    }

    @Test
    public void containsStatement_asterixMissing() {
        Imports imports = createImports("a.b.c.d.MyClass", "a.b.c.MyBehaviour", "a.b.c.MyState");

        assertFalse(imports.containsStatement("a.b.c.*"));
    }

    private Imports createImports(String... fullclassnames) {
        Imports imports = new Imports();

        for (String fullclassname : fullclassnames) {
            Importstatement importstatement = new Importstatement();
            importstatement.setFullclassname(fullclassname);
            imports.addImportstatement(importstatement);
        }
        return imports;
    }
}
