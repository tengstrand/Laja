package net.sf.laja.template.data;

import java.util.List;

import net.sf.laja.TemplateParser.IAttributeMethodRef;
import net.sf.laja.TemplateParser.IAttributeRef;
import net.sf.laja.TemplateParser.IAttributeVariableRef;
import net.sf.laja.TemplateParser.IListIndex;
import net.sf.laja.TemplateParser.IMethodRef;
import net.sf.laja.TemplateParser.IVariableRef;
import net.sf.laja.context.ArrayListAdapter;
import net.sf.laja.context.Context;
import net.sf.laja.exception.LajaException;
import net.sf.laja.template.Args;
import net.sf.laja.template.IndexItem;
import net.sf.laja.template.ListIndex;
import net.sf.laja.template.Macro;
import net.sf.laja.template.Namespaces;

public class AttributeRef implements IAttributeRef, IAttributeMethodRef, IAttributeVariableRef {
	private VariableRef variableRef;
	private MethodRef methodRef;
	private ListIndex listIndex;

	private Namespaces namespaces;
	
	public AttributeRef(Namespaces namespaces) {
		this.namespaces = namespaces;
	}
	
	public void setVariableRef(IVariableRef ivariableRef) {
		variableRef = (VariableRef)ivariableRef;
	}

	public void setMethodRef(IMethodRef imethodRef) {
		methodRef = (MethodRef)imethodRef;
	}
	
	public void setListIndex(IListIndex ilistIndex) {
		listIndex = (ListIndex)ilistIndex;
	}

	public String getName() {
		if (isMethodRef()) {
			return getMethodName();
		}
		return getVariableName();
	}
	
	public boolean isMethodRef() {
		return methodRef != null;
	}

	public boolean isMacro(Context context) {
		return isMacro(context, false);
	}

	public boolean isFunction(Context context) {
		return isMacro(context, true);
	}
	
	private boolean isMacro(Context context, boolean isFunction) {
		if (!isMethodRef()) {
			return false;
		}
		Macro macro = getMacro(context);
		
		
		return macro != null && macro.isFunction() == isFunction;
	}
	
	public Macro getMacro(Context context) {
		Macro macro = context.getMacro(getMethodName());
		
		if (macro == null && !namespaces.isDefaultNamespace(context)) {
			// If macro not found in specified namespace, also look in default namespace
			macro = namespaces.getDefaultNamespace().getMacro(getMethodName());
		}		
		return macro;
	}
	
	public String getMethodName() {
		return methodRef.getMethodName();
	}
	
	public Args getMethodArguments() {
		return methodRef.getArguments();
	}
	
	public boolean hasMethodArguments() {
		return methodRef.getArguments() != null;
	}
	
	public String getVariableName() {
		return variableRef.getVariableName();
	}

	public boolean hasListIndex() {
		return listIndex != null;
	}
	
	public List<IndexItem> getListIndices() {
		return listIndex.getIndices();
	}

	public int evaluateListIndex(int index) {
		return listIndex.evaluateListIndex(index);
	}
	
	public String getListName(int toIndex) {
		String listName = getName();

		for (int index = 0; index<=toIndex; index++) {
			listName += "[" + listIndex.getIndices().get(index).getNumber() + "]";
		}
		return listName;
	}

	public Object evaluateArrayOrList(Object object) {
		if (object instanceof List) {
			return evaluateList((List)object, 0);
		}
		if (object.getClass().isArray()) {
			return evaluateList(new ArrayListAdapter<Object>(object), 0);
		}
		throw new LajaException("Element " + getListName(0) + " must be an array or List.");
	}
	
	private Object evaluateList(List<Object> list, int index) {
		int listIndex = evaluateListIndex(index); 
		
		if (listIndex >= list.size()) {
			throw new IndexOutOfBoundsException("Index out of bounds for list " + getListName(index) + ".");
		}
		Object element = list.get(listIndex);
		
		if (index == getListIndices().size()-1) {
			return element;
		}
		// Multi dimentional array, e.g: list[0][1].
		// TODO: Add support for multi dimensional arrays
		if (!(element instanceof List)) {
			throw new LajaException("Element " + getListName(index) + " must be an array or List.");
		}
		return evaluateList((List)element, index+1);
	}
	
	@Override
	public String toString() {
		return "AttributeRef{variableRef=" + variableRef + 
			", methodRef=" + methodRef + ", listIndex=" + listIndex + "}";
	}
}
