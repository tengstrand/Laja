package net.sf.laja.parser.cdd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StatementConverterTest {
    private StatementConverter converter;

    @Before
    public void setUp() {
        converter = new StatementConverter();
    }

    @Test
    public void calculateSetStatement() {
        assertEquals("setTruckName(name, mutator)", converter.calculateSetStatement("truckName", "name"));
    }

    @Test
    public void calculateSetStatement_getMethod() {
        assertEquals("height.setHeightInCentimeters(heightInCentimeters, mutator)", converter.calculateSetStatement("height.getHeightInCentimeters()", "heightInCentimeters"));
    }
}
