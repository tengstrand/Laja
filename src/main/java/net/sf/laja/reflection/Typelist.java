package net.sf.laja.reflection;

public interface Typelist {
	public boolean isVararg();
	public Class getVarargType();
	public int getVarargStartIndex();
	void setVarargStartIndex(int startIndex);
	public Class[] getTypes();
}
