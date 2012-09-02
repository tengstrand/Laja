package net.sf.laja.parser.template;

public class Varclass {
	private boolean isBoolean;
	private String className;
	private String returnInterface;
	private String returnMethod;
	
	public Varclass(boolean isBoolean, String className, String returnInterface, String returnMethod) {
		this.isBoolean = isBoolean;
		this.className = className;
		this.returnInterface = returnInterface;
		this.returnMethod = returnMethod;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the isBoolean
	 */
	public boolean isBoolean() {
		return isBoolean;
	}

	/**
	 * @param isBoolean the isBoolean to set
	 */
	public void setBoolean(boolean isBoolean) {
		this.isBoolean = isBoolean;
	}

	/**
	 * @return the returnInterface
	 */
	public String getReturnInterface() {
		return returnInterface;
	}

	/**
	 * @param returnInterface the returnInterface to set
	 */
	public void setReturnInterface(String returnInterface) {
		this.returnInterface = returnInterface;
	}

	/**
	 * @return the returnMethod
	 */
	public String getReturnMethod() {
		return returnMethod;
	}

	/**
	 * @param returnMethod the returnMethod to set
	 */
	public void setReturnMethod(String returnMethod) {
		this.returnMethod = returnMethod;
	}

	@Override
	public String toString() {
		return "Varclass{className=" + className + ", isBoolean=" + isBoolean
				+ ", returnInterface=" + returnInterface + ", returnMethod="
				+ returnMethod + "}";
	}	
}
