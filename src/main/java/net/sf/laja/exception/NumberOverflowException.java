package net.sf.laja.exception;

public class NumberOverflowException extends LajaException {
	public NumberOverflowException(String number, double min, double max) {
		super("Number overflow: " + number + ". Valid range: " + min + " to " + max + ".");
	}
}
