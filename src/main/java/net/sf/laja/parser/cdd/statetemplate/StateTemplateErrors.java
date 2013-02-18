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
        String error = messages.size() == 1 ? "error" : "errors";
        System.out.println("# " + messages.size() + " " + error + " found:");
        for (String message : messages) {
            System.out.println(" - " + message);
        }
    }

    public List<String> getMessages() {
        return messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StateTemplateErrors that = (StateTemplateErrors) o;

        return messages.equals(that.messages);
    }

    @Override
    public String toString() {
        return "StateTemplateErrors{" +
                "messages=" + messages +
                '}';
    }
}
