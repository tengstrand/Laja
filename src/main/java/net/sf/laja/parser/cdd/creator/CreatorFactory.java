package net.sf.laja.parser.cdd.creator;

public class CreatorFactory implements CreatorParser.ICreatorFactory {
    private final String creatorClassname;
    public Creator creator;

    public CreatorFactory(String creatorClassname) {
        this.creatorClassname = creatorClassname;
    }

    public CreatorParser.ICreator createCreator() {
        return creator = new Creator();
    }
}
