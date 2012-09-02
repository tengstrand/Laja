package net.sf.laja.parser.grammar.element;

import java.util.ArrayList;
import java.util.List;

import net.sf.laja.parser.GrammarParser.IConstructor;
import net.sf.laja.parser.GrammarParser.IOmarg;
import net.sf.laja.parser.GrammarParser.IOutputmethod;
import net.sf.laja.parser.grammar.Omarg;
import net.sf.laja.parser.grammar.Row;

public class Outputmethod implements IOutputmethod {
	public static final int OUTPUT_DEFAULT = 0;
	public static final int OUTPUT_PHASE1 = 1;
	public static final int OUTPUT_PHASE2 = 2;
	public static final int OUTPUT_NOT_DECLARED = 3;

	private int row;
	private boolean isVariableSetter = false;
	private boolean isClassDefinition = false;
	private Boolean referenced;
	private boolean shareOutput = false;
	private boolean isVoid = false;
	private boolean isStr = false;
	private boolean isIndex = false;
	private boolean isClass = false;
	private String className;
	private String refName;
	private String origArgName;
	private String methodName;
	private String argClass;
	private String cargName;
	private String argName;
	private String argNameClassName = null;
	private String outputClassName = null;
	private String outputVarName = null;
	private String classRef;
	private String identifier;
	private Constructor constructor;

	private List<Omarg> omargList = new ArrayList<Omarg>();

	public Outputmethod() {
	}

	public Outputmethod(Row row) {
		this.row = row.getRow();
	}

	public int getRow() {
		return row;
	}

	/*
	 * om.isVariableSetter() is true if the method i marked with a "$"-sign.
	 */
	public boolean isVariableSetter() {
		return isVariableSetter;
	}

	@Override
	public void setVariableSetter() {
		isVariableSetter = true;
	}

	public void setReferenced() {
		if (referenced == null || (referenced != null && !referenced)) {
			referenced = shareOutput = true;
		}
	}

	public boolean isReferenced() {
		if (referenced == null) {
			return false;
		}
		return referenced;
	}

	public boolean isShareOutput() {
		return shareOutput;
	}

	public void setShareOutput() {
		shareOutput = true;
	}

	public String getClassName() {
		return className;
	}
	
	@Override
	public void setConstructor(IConstructor iconstructor) {
		constructor = (Constructor) iconstructor;
	}

	public Constructor getConstructor() {
		return constructor;
	}

	public String getRefname() {
		return refName;
	}

	public String getMethodName() {
		return methodName;
	}

	public String getArgName() {
		return argName;
	}

	public String getOrigArgName() {
		return origArgName == null ? argName : origArgName;
	}

	public String getOutputArgName() {
		if (argName.equals("*")) {
			return cargName;
		}

		return argName;
	}

	public boolean isStr() {
		return isStr;
	}

	public boolean isIndex() {
		return isIndex;
	}

	public boolean isVoid() {
		return isVoid;
	}

	public boolean isClass() {
		return isClass;
	}

	@Override
	public void setClass(String c) {
		className = c;
		isClassDefinition = true;
	}

	public void setClassDefinition(String c) {
		className = c;
	}

	@Override
	public void setRef(String ref) {
		refName = cargName = ref;
	}

	@Override
	public void setMethod(String method) {
		methodName = method;
	}

	@Override
	public void setStr() {
		isStr = true;
	}

	@Override
	public void setIndex() {
		isIndex = true;
	}

	@Override
	public void setArgClass(String ac) {
		argClass = ac;
		isClass = true;
	}

	public String getArgClass() {
		return argClass;
	}

	@Override
	public void setCarg(String carg) {
		cargName = carg;
	}

	@Override
	public void setArg(String arg) {
		argName = arg;
	}

	@Override
	public void setVoid() {
		isVoid = true;
	}

	@Override
	public void setOmarg(IOmarg omarg) {
		omargList.add((Omarg) omarg);
	}

	public String getCargName() {
		return cargName;
	}

	public String getOutputClassName() {
		if (outputClassName == null) {
			outputClassName = getFirstUpper(refName) + getFirstUpper(cargName) + getArgNameClassName();
		}
		return outputClassName;
	}

	private String getArgNameClassName() {
		if (argNameClassName == null) {
			if (getArgName().equals("*")) {
				return "";
			}
			argNameClassName = getFirstUpper(getArgName());
		}
		return argNameClassName;
	}

	public String getOutputVarName() {
		if (outputVarName == null) {
			outputVarName = getFirstLower(getOutputClassName());
		}
		return outputVarName;
	}

	public List<Omarg> getOmargList() {
		return omargList;
	}

	private String getFirstLower(String s) {
		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}

	private String getFirstUpper(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	public String getArgumentSignature() {
		return getMethodSignature(true);
	}

	public String getMethodSignature() {
		return getMethodSignature(false);
	}

	private String getMethodSignature(boolean argumentSignature) {
		String signature = argumentSignature ? refName + "#" : methodName + "#";
		if (isVoid) {
		} else if (isStr) {
			signature += "String";
		} else if (isIndex) {
			signature += "Index";
		} else {
			signature += argClass;
		}
		if (argumentSignature) {
			signature += "#" + cargName + "." + argName;
		}

		if (omargList != null) {
			for (Omarg omarg : omargList) {
				if (omarg.isStr()) {
					signature += "#String";
				} else if (omarg.isIndex()) {
					signature += "#Index";
				}
				if (argumentSignature) {
					signature += "#" + argName;
				}
			}
		}

		return signature;
	}

	public boolean isClassDefinition() {
		return isClassDefinition;
	}

	public boolean isDefined() {
		return methodName != null;
	}

	public boolean isSameOutputclass(Outputmethod om) {
		return (getCargName() != null && getArgName() != null && om.getCargName() != null && om.getArgName() != null && om.getCargName().equals(getCargName()) && om.getArgName().equals(getArgName()));
	}

	public String getArgs() {
		String args = "";
		String comma = isVoid() ? "" : ", ";
		for (Omarg omarg : omargList) {
			if (omarg.isStr()) {
				args += comma + "source.get(bookmark)";
			} else if (omarg.isIndex()) {
				args += comma + "source.getIndex(bookmark)";
			}
			comma = ", ";
		}
		return args;
	}

	public void setClassRef(String classRef) {
		this.classRef = classRef;
	}

	public boolean isClassRef() {
		return classRef != null;
	}

	public String getClassRef() {
		return classRef;
	}

	public void setIdentifier(String id) {
		identifier = id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setOrigArgName(String origArgName) {
		this.origArgName = origArgName;
	}

	public String getStatement() {
		String s = "";
		if (isClassDefinition) {
			s = className + " ";
		}
		if (isVariableSetter) {
			s += "$ ";
		}
		s += refName + "." + (methodName == null ? "?" : methodName) + "(";

		String carg = "";
		if (cargName != null && !cargName.equals(refName)) {
			carg += cargName + ".";
		}

		if (isVoid()) {
			s += "void " + carg + argName;
		} else {
			if (isStr) {
				s += "String " + carg + argName;
				;
			} else if (isIndex) {
				s += "Index " + carg + argName;
			} else {
				s += argClass + " " + carg + argName;
				;
			}
			if (omargList != null) {
				for (Omarg omarg : omargList) {
					s += ", " + omarg;
				}
			}
		}

		s += ");";

		return s;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder(1000);
		sb.append("[row=").append(row)
			.append(", isVariableSetter=").append(isVariableSetter)
			.append(", isClassDefinition=").append(isClassDefinition)
			.append(", referenced=").append(referenced)
			.append(", shareOutput=").append(shareOutput)
			.append(", isVoid=").append(isVoid)
			.append(", isStr=").append(isStr)
			.append(", isIndex=").append(isIndex)
			.append(", isClass=").append(isClass)
			.append(", className=").append(className)
			.append(", refName=").append(refName)
			.append(", origArgName=").append(origArgName)
			.append(", methodName=").append(methodName)
			.append(", argClass=").append(argClass)
			.append(", cargName=").append(cargName)
			.append(", argName=").append(argName)
			.append(", argNameClassName=").append(argNameClassName)
			.append(", outputClassName=").append(outputClassName)
			.append(", outputVarName=").append(outputVarName)
			.append(", classRef=").append(classRef)
			.append(", identifier=").append(identifier)
			.append(", constructor=").append(constructor)
			.append(", omargList=").append(omargList)
			.append("]");
		return sb.toString();
	}
}
