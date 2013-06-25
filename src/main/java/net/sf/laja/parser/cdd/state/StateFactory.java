package net.sf.laja.parser.cdd.state;

public class StateFactory implements StateParser.IStateFactory {
    public final String stateClassname;
    public State state;

    public StateFactory(String stateClassname) {
        this.stateClassname = stateClassname;
    }

    public StateParser.IPackageStatement createPackageStatement() {
        return new PackageStatement();
    }

    public StateParser.IImportstatement createImportstatement() {
        return new ImportStatement();
    }

    public StateParser.IImports createImports() {
        return new Imports();
    }

    public StateParser.ICollectionType createCollectionType() {
        return new CollectionType();
    }

    public StateParser.IMapType createMapType() {
        return new MapType();
    }

    public StateParser.IType createType() {
        return new Type();
    }

    public StateParser.IAnnotationAttribute createAnnotationAttribute() {
        return new AnnotationAttribute();
    }

    public StateParser.IAnnotation createAnnotation() {
        return new Annotation();
    }

    public StateParser.IAnnotations createAnnotations() {
        return new Annotations();
    }

    public StateParser.IAttribute createAttribute() {
        return new Attribute();
    }

    public StateParser.IClassStatement createClassStatement() {
        return new ClassStatement();
    }

    public StateParser.IState createState() {
        return state = new State();
    }
}
