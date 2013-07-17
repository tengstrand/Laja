package net.sf.laja.parser.cdd.creator;

public class CreatorFactory implements CreatorParser.ICreatorFactory {
    private final String creatorClassname;
    public Creator creator;

    public CreatorFactory(String creatorClassname) {
        this.creatorClassname = creatorClassname;
    }

    public CreatorParser.IPackageStatement createPackageStatement() {
        return new PackageStatement();
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

    public CreatorParser.IAparameterAttr createAparameterAttr() {
        return new AparameterAttr();
    }

    public CreatorParser.IAparameter createAparameter() {
        return new Aparameter();
    }

    public CreatorParser.IAparameters createAparameters() {
        return new Aparameters();
    }

    public CreatorParser.IClassStatement createClassStatement() {
        return new ClassStatement();
    }

    public CreatorParser.IParameterArgClass createParameterArgClass() {
        return new ParameterArgClass();
    }

    public CreatorParser.IParameterClass createParameterClass() {
        return new ParameterClass();
    }

    public CreatorParser.IParameterClasses createParameterClasses() {
        return new ParameterClasses();
    }

    public CreatorParser.ICreator createCreator() {
        return creator = new Creator();
    }
}
