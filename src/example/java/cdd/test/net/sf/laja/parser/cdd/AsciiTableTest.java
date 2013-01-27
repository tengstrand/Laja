package net.sf.laja.parser.cdd;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AsciiTableTest {

    @Test
    public void emptyTable() {
        AsciiTable table = new AsciiTable("State", "Behaviour");

        assertEquals(
                "+-------+-----------+\n" +
                "| State | Behaviour |\n" +
                "+-------+-----------+\n" +
                "+-------+-----------+", table.text());
    }

    @Test
    public void tableWithRows() {
        AsciiTable table = new AsciiTable("State", "Behaviour");
        table.addRow(row("Car", "Car, BigCar"));
        table.addRow(row("Person", "Person, SmallPerson"));

        assertEquals(
                "+--------+---------------------+\n" +
                "| State  | Behaviour           |\n" +
                "+--------+---------------------+\n" +
                "| Car    | Car, BigCar         |\n" +
                "| Person | Person, SmallPerson |\n" +
                "+--------+---------------------+", table.text());
    }

    private AsciiTable.Row row(String state, String behaviour) {
        AsciiTable.Row row = new AsciiTable.Row();
        row.addColumn(state);
        row.addColumn(behaviour);
        return row;
    }
}
