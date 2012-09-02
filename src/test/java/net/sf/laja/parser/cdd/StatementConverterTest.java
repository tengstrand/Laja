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
        assertEquals("setTruckName(name)", converter.calculateSetStatement("truckName", "name"));
    }

    @Test
    public void calculateSetStatement_getMethod() {
        assertEquals("height.setHeightInCentimeters(heightInCentimeters)", converter.calculateSetStatement("height.getHeightInCentimeters()", "heightInCentimeters"));
    }
}
