package net.sf.laja.parser.cdd.state;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Annotations implements StateParser.IAnnotations, Iterable<Annotation> {
    public String content;
    public List<Annotation> annotations = new ArrayList<Annotation>();

    public void addAnnotation(StateParser.IAnnotation iannotation) {
        Annotation annotation = (Annotation)iannotation;

        if (annotation.isValid()) {
            annotations.add(annotation);
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

    public boolean isType() {
        return is(Annotation.TYPE);
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

    public Annotation get(String annotationName) {
        for (Annotation annotation : annotations) {
            if (annotation.is(annotationName)) {
                return annotation;
            }
        }
        return null;
    }

    public Annotation getType() {
        return get(Annotation.TYPE);
    }

    public Annotation getOptional() {
        return get(Annotation.OPTIONAL);
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
