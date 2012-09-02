package net.sf.laja.reflection;

public abstract class AbstractTypelist implements Typelist {
	private static final int UNDEFINED = -1;
	
	private int varargStartIndex = UNDEFINED;

	@Override
	public int getVarargStartIndex() {
		return varargStartIndex;
	}

	@Override
	public Class getVarargType() {
		return getTypes()[varargStartIndex].getComponentType();
	}
	
	@Override
	public boolean isVararg() {
		return varargStartIndex != UNDEFINED;
	}

	@Override
	public void setVarargStartIndex(int startIndex) {
		varargStartIndex = startIndex;
	}
}
