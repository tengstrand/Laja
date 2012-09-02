package net.sf.laja.parser.examples.expression;

import net.sf.laja.parser.examples.expression.ExpressionParser.IExpression;
import net.sf.laja.parser.examples.expression.ExpressionParser.IOneArgumentFunction;

public class OneArgumentFunction implements IOneArgumentFunction, Calculator {
	private Calculator calculator;
	private double argument;
	
	@Override
	public double calculate() {
		return calculator.calculate();
	}	

	@Override
	public void setExpression(IExpression iexpression) {
		argument = ((Calculator)iexpression).calculate();
	}

	@Override
	public void setFunctionAbs() {
		calculator = new Calculator() {
			@Override
			public double calculate() {
				return Math.abs(argument);
			}
		};
	}

	@Override
	public void setFunctionAcos() { 
		calculator = new Calculator() {
			@Override
			public double calculate() {
				return Math.acos(argument);
			}
		};
	}

	@Override
	public void setFunctionAsin() {
		calculator = new Calculator() {
			@Override
			public double calculate() {
				return Math.asin(argument);
			}
		};
	}

	@Override
	public void setFunctionAtan() {
		calculator = new Calculator() {
			@Override
			public double calculate() {
				return Math.atan(argument);
			}
		};
	}

	@Override
	public void setFunctionCeil() {
		calculator = new Calculator() {
			@Override
			public double calculate() {
				return Math.ceil(argument);
			}
		};
	}

	@Override
	public void setFunctionCos() {
		calculator = new Calculator() {
			@Override
			public double calculate() {
				return Math.cos(argument);
			}
		};
	}

	@Override
	public void setFunctionToDegrees() {
		calculator = new Calculator() {
			@Override
			public double calculate() {
				return Math.toDegrees(argument);
			}
		};
	}

	@Override
	public void setFunctionExp() {
		calculator = new Calculator() {
			@Override
			public double calculate() {
				return Math.exp(argument);
			}
		};
	}

	@Override
	public void setFunctionFloor() {
		calculator = new Calculator() {
			@Override
			public double calculate() {
				return Math.floor(argument);
			}
		};
	}

	@Override
	public void setFunctionLog() {
		calculator = new Calculator() {
			@Override
			public double calculate() {
				return Math.log(argument);
			}
		};
	}

	@Override
	public void setFunctionRint() {
		calculator = new Calculator() {
			@Override
			public double calculate() {
				return Math.rint(argument);
			}
		};
	}

	@Override
	public void setFunctionRound() {
		calculator = new Calculator() {
			@Override
			public double calculate() {
				return Math.round(argument);
			}
		};
	}

	@Override
	public void setFunctionSin() {
		calculator = new Calculator() {
			@Override
			public double calculate() {
				return Math.sin(argument);
			}
		};
	}

	@Override
	public void setFunctionSqrt() {
		calculator = new Calculator() {
			@Override
			public double calculate() {
				return Math.sqrt(argument);
			}
		};
	}

	@Override
	public void setFunctionTan() {
		calculator = new Calculator() {
			@Override
			public double calculate() {
				return Math.tan(argument);
			}
		};
	}

	@Override
	public void setFunctionToRadians() {
		calculator = new Calculator() {
			@Override
			public double calculate() {
				return Math.toRadians(argument);
			}
		};
	}
}
