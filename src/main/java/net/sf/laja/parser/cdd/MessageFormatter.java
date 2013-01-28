package net.sf.laja.parser.cdd;

import net.sf.laja.parser.cdd.behaviour.Behaviour;
import net.sf.laja.parser.cdd.statetemplate.StateTemplate;
import net.sf.laja.template.Set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class MessageFormatter {

    public void printTable(Map<String, Behaviour> behaviours) {
        Map<String, TreeSet> states = new TreeMap<String, TreeSet>();

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
            List sortedBehaviours = new ArrayList(states.get(state));
            if (sortedBehaviours.contains(state)) {
                sortedBehaviours.remove(state);
                sortedBehaviours.add(0, state);
            }
            String stringBehaviours = sortedBehaviours.toString();
            row.addColumn(stringBehaviours.substring(1, stringBehaviours.length()-1));
            table.addRow(row);
        }
        System.out.println(table.text());
    }
}
