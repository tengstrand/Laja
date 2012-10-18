package net.sf.laja.parser.cdd;

import java.util.ArrayList;
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
}
