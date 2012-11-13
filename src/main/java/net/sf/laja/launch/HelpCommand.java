package net.sf.laja.launch;

public class HelpCommand implements ViewInfoCommand {
	
	public void execute() {
		System.out.println("Usage: laja [option(s)] [templatefile(s)]");
		System.out.println();
		System.out.println("where option include:");
		System.out.println("   -help | -?             display this help.");
		System.out.println("   -version               display version information.");
		System.out.println("   <variable>=<value>     sets a value to default ($) namespace");
		System.out.println("   <namespace>.<variable>=<value>");
		System.out.println("                          sets a value to specified namespace.");
		System.out.println("Example:");
		System.out.println("   laja                   reads default template 'generate.laja'.");
		System.out.println("   laja mytemplate        reads template file 'mytemplate.laja'.");
		System.out.println("   laja t1 t2             reads template files 't1.laja' and 't2.laja'.");
		System.out.println("   laja var=123           set the value 123 (datatype=java.lang.Integer) for");
		System.out.println("                          variable 'var' in the default namespace and reads 'generate.laja'.");
		System.out.println("   laja a='A' $x.b=\"B\" t1 t2");
		System.out.println("                          sets the variable 'a' to A in default namespace and 'b' to B");
		System.out.println("                          in namespace x and generates 't1.laja' and 't2.laja'");
        System.out.println("   laja -a -b             set the value true for the variables '_a' and '_b' and reads");
        System.out.println("                          the template file 'generate.laja'");
        System.out.println("   laja -i mytemplate     set the value true for variable '_i' and reads");
        System.out.println("                          the template file 'mytemplate.laja'");
        System.out.println("   laja sysimp=./system-imports.laja");
		System.out.println("                          overrides the location of LAJA_HOME/template/system-imports.laja.");
		System.out.println("   laja sysimp=\"c:\\Program Files\\mytemplates\\my-system-imports.laja\"");
		System.out.println("                          surround with \" if the path contains spaces.");
		System.out.println();
		System.out.println("Project: http://laja.sf.net");
	}
}
