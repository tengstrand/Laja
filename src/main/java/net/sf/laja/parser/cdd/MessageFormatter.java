package net.sf.laja.parser.cdd;

import net.sf.laja.parser.cdd.behaviour.Behaviour;
import net.sf.laja.parser.cdd.statetemplate.StateTemplate;
import net.sf.laja.template.Set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class MessageFormatter {

    public void printAsSorted(String description, Map map) {
        String message = asSortedTrimmedString(new ArrayList(map.keySet()));
        System.out.println(description + message );
    }

    public String asSortedTrimmedString(List list) {
        String message = new TreeSet<String>(list).toString();
        return message.substring(1, message.length() - 1);
    }

    public void printTable(Map<String, Behaviour> behaviours) {
        Map<String, TreeSet> states = new HashMap<String, TreeSet>();

        for (Behaviour behaviour : behaviours.values()) {
            if (!states.containsKey(behaviour.cleanedStateClass)) {
                java.util.TreeSet tree = new TreeSet<String>();
                tree.add(behaviour.classname);
                states.put(behaviour.cleanedStateClass, tree);
            } else {
                states.get(behaviour.cleanedStateClass).add(behaviour.classname);
            }
        }

        AsciiTable table = new AsciiTable("State", "Behaviour");

        for (String state : states.keySet()) {
            AsciiTable.Row row = new AsciiTable.Row();
            row.addColumn(state);
            String behaviourStrings = states.get(state).toString();
            row.addColumn(behaviourStrings.substring(1, behaviourStrings.length()-1));
            table.addRow(row);
        }
        System.out.println(table.text());
    }
}
