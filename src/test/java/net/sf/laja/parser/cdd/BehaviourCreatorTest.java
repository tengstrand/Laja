package net.sf.laja.parser.cdd;

import net.sf.laja.parser.cdd.statetemplate.Attribute;
import net.sf.laja.parser.cdd.statetemplate.ClassStatement;
import net.sf.laja.parser.cdd.statetemplate.Imports;
import net.sf.laja.parser.cdd.statetemplate.StateTemplate;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BehaviourCreatorTest {
    private BehaviourCreator creator;

    @Before
    public void setUp() {
        creator = new BehaviourCreator();
    }

    @Test
    public void asBehaviourPackage() {
        String x = creator.asBehaviourPackage("net.sf.laja.cdd.state", "net.sf.laja.cdd.state.a.b", "net.sf.laja.cdd.behaviour");
        assertEquals("net.sf.laja.cdd.behaviour.a.b", x);
    }

    @Test
    public void asBehaviour() {
        StateTemplate stateTemplate = new StateTemplate("PersonStateTemplate");
        ClassStatement classStatement = new ClassStatement();
        classStatement.setClassname("PersonStateTemplate");
        stateTemplate.setClassStatement(classStatement);
        stateTemplate.setPackagename("com.myproject.state");
        stateTemplate.setImports(new Imports());

        List<Attribute> attributes = new ArrayList<Attribute>();
        attributes.add(attribute("int", "age"));
        attributes.add(attribute("String", "givenName"));
        attributes.add(attribute("String", "surname"));
        stateTemplate.setAttributes(attributes);

        stateTemplate.setSourceDir("C:\\Projects\\MyProject\\src\\java\\main\\com\\myproject\\state");
        stateTemplate.setOutputDir("C:/Projects/MyProject/src/java-gen/cdd/main/com/myproject/state");

        stateTemplate.setRootSrcDir("{.}/main");
        stateTemplate.setRootOutDir("{..}/java-gen/main");
        stateTemplate.setRootStatePackage("com.myproject.state");
        stateTemplate.setRootBehaviourPackage("com.myproject.behaviour");

        creator.asBehaviour(stateTemplate);
    }

    private Attribute attribute(String type, String variable) {
        Attribute attribute = new Attribute();
        attribute.setType(type);
        attribute.setVariable(variable);
        return attribute;
    }
}
