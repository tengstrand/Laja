package net.sf.laja.parser.cdd.state;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Annotations implements StateParser.IAnnotations, Iterable<Annotation> {
    public String content;
    public List<Annotation> annotations = new ArrayList<Annotation>();

    public void addAnnotation(String annotation) {
        if (Annotation.isValid(annotation.trim())) {
            annotations.add(new Annotation(annotation));
        } else {
            // TODO: add error handling
            System.out.println("# Unknown annotation: " + annotation);
        }
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isId() {
        return is(Annotation.ID);
    }

    public boolean isKey() {
        return is(Annotation.KEY);
    }

    public boolean isOptional() {
        return is(Annotation.OPTIONAL);
    }

    public boolean isEntity() {
        return isId() || isKey();
    }

    public boolean is(String annotationName) {
        for (Annotation annotation : annotations) {
            if (annotation.is(annotationName)) {
                return true;
            }
        }
        return false;
    }

    public Iterator<Annotation> iterator() {
        return annotations.iterator();
    }

    @Override
    public String toString() {
        return "Annotations{" +
                "content='" + content + '\'' +
                ", annotations=" + annotations +
                '}';
    }
}
