package net.sf.laja.parser.cdd.statetemplate;

import java.util.ArrayList;
import java.util.List;

public class StateTemplateErrors {
    private List<String> messages = new ArrayList<String>();
    
    public boolean hasErrors() {
        return messages.size() > 0;
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public void addMessages(StateTemplateErrors errors) {
        this.messages.addAll(errors.messages);
    }
    
    public void printMessages() {
        System.out.println();
        for (String message : messages) {
            System.out.println(message);
        }
    }

    public List<String> getMessages() {
        return messages;
    }

    @Override
    public String toString() {
        return "StateTemplateErrors{" +
                "messages=" + messages +
                '}';
    }
}
