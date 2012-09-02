package net.sf.laja.ant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import net.sf.laja.launch.SystemImportsCommand;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public class LajaTask extends Task {
	private SystemImports systemImports;
	private List<Template> templates = new ArrayList<Template>();
	private List<Value> values = new ArrayList<Value>();
	
	public Template createTemplate() {
		Template template = new Template();
		templates.add(template);
		return template;
	}

	public Value createValue() {
		Value value = new Value();
		values.add(value);
		return value;
	}

	public SystemImports createSystemImports() {
		return systemImports = new SystemImports();
	}

	private String getSystemImports() {
		if (systemImports != null) {
			return systemImports.getFilename();
		}
		return null;
	}
	
	public void execute() throws BuildException {
		try {
			launch();
		} catch (Exception e) {
			throw new BuildException(e);
		}
	}

	private void launch() throws IOException {
		String lajaHome = System.getenv().get("LAJA_HOME");

		if (lajaHome == null) {
			throw new IllegalStateException("The environment variable LAJA_HOME must be set");
		}
		String os = System.getProperty("os.name");

		if (os == null) {
			throw new IllegalStateException("Could not get the system property 'os.name'");
		}

		if (os.startsWith("Windows")) {
			launchLajaFromWindows(lajaHome);
		} else {
			launchLajaFromUnix(lajaHome);
		}
	}

	private void launchLajaFromWindows(String lajaHome) {
		try {
			Process process = Runtime.getRuntime().exec(lajaHome + "\\bin\\laja.bat " + getArguments());
			printProcessOutput(process);
			process.waitFor();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	private void launchLajaFromUnix(String lajaHome) throws IOException {
		String[] cmd = { "/bin/sh", "-c", lajaHome + "/bin/laja " + getArguments()};
		Process process = Runtime.getRuntime().exec(cmd);
		printProcessOutput(process);
	}
	
	private void printProcessOutput(Process process) throws IOException {
		String line;
		BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
		
		while ((line = input.readLine()) != null) {
			System.out.println(line);
		}
		input.close();
	}
	
	private String getArguments() {
		String args = "";
		String sep = "";

		if (templates.size() == 0) {
			throw new BuildException("At least one template has to be specified.");
		}

		if (getSystemImports() != null) {
			args = SystemImportsCommand.SYSTEM_IMPORTS_VARIABLE_NAME + "=\"" + getSystemImports() + "\" ";
		}
		
		for (Value value : values) {
			args += sep + value.asArguments();
			sep = " ";
		}
		
		for (Template template : templates) {
			args += sep + template.asArguments();
			sep = " ";
		}
		
		return args;
	}
}
