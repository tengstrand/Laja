package net.sf.laja.parser.grammar;

import java.util.ArrayList;
import java.util.List;

import net.sf.laja.parser.grammar.element.Constructor;
import net.sf.laja.parser.grammar.element.Outputmethod;

public class Ref {
	private boolean isReferenced;
	private boolean hasOutputMethod;
	private String className;
	private Constructor constructor;
	private String refname;
	private String stackName;
	private List<Outputmethod> outputmethodList = new ArrayList<Outputmethod>();

	public Ref(String c, Constructor constructor, String r) {
		className = c;
		this.constructor = constructor;
		refname = r;
		stackName = r + "Stack";
	}
	
	public List<Outputmethod> getOutputmethodList() {
		return outputmethodList;
	}
	
	public void addOutputmethod(Outputmethod outputmethod) {
		outputmethodList.add(outputmethod);
	}
	
	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @return the constructor
	 */
	public Constructor getConstructor() {
		return constructor;
	}

	/**
	 * @param constructor the constructor to set
	 */
	public void setConstructor(Constructor constructor) {
		this.constructor = constructor;
	}

	/**
	 * @return the hasOutputMethod
	 */
	public boolean isHasOutputMethod() {
		return hasOutputMethod;
	}

	/**
	 * @param hasOutputMethod the hasOutputMethod to set
	 */
	public void setHasOutputMethod(boolean hasOutputMethod) {
		this.hasOutputMethod = hasOutputMethod;
	}

	/**
	 * @return the isReferenced
	 */
	public boolean isReferenced() {
		return isReferenced;
	}

	/**
	 * @param isReferenced the isReferenced to set
	 */
	public void setReferenced(boolean isReferenced) {
		this.isReferenced = isReferenced;
	}

	/**
	 * @return the refname
	 */
	public String getRefname() {
		return refname;
	}

	/**
	 * @param refname the refname to set
	 */
	public void setRefname(String refname) {
		this.refname = refname;
	}

	/**
	 * @return the stackName
	 */
	public String getStackName() {
		return stackName;
	}

	/**
	 * @param stackName the stackName to set
	 */
	public void setStackName(String stackName) {
		this.stackName = stackName;
	}
	
	public boolean isConstructorDefined() {
		return constructor != null;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[")
			.append("isReferenced=").append(isReferenced)
			.append(", hasOutputMethod=").append(hasOutputMethod)
			.append(", className=").append(getClassName())
			.append(", constructor=").append(constructor)
			.append(", refname=").append(refname)
			.append(", stackName=").append(stackName)
			.append("]");
		
		return sb.toString();
	}
}
