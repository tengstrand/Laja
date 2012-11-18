package net.sf.laja.parser.cdd.behaviour;

public class BehaviourMethod implements BehaviourParser.IBehaviourMethod {
    private String comment;
    public AsMethod asMethod;

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setAsMethod(BehaviourParser.IAsMethod iasMethod) {
        this.asMethod = (AsMethod)iasMethod;
        asMethod.setComment(comment);
    }
}
