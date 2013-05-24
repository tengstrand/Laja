package net.sf.laja.parser.cdd.creator;

public class CreatorFactory implements CreatorParser.ICreatorFactory {
    private final String creatorClassname;
    public Creator creator;

    public CreatorFactory(String creatorClassname) {
        this.creatorClassname = creatorClassname;
    }

    public CreatorParser.IParameter createParameter() {
        return new Parameter();
    }

    public CreatorParser.IParameters createParameters() {
        return new Parameters();
    }

    public CreatorParser.IAsMethod createAsMethod() {
        return new AsMethod();
    }

    public CreatorParser.IClassStatement createClassStatement() {
        return new ClassStatement();
    }

    public CreatorParser.ICreator createCreator() {
        return creator = new Creator();
    }
}