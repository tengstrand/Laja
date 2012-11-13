package net.sf.laja.launch;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class InargsParser {
	private Settings settings;
	private List<String> arguments;

	private ViewInfoCommand viewInfoCommand;
	private SystemImportsCommand systemImportsCommand;
	private List<PrepareGenerateCommand> prepareGenerateCommands = new ArrayList<PrepareGenerateCommand>();
	private List<GenerateCommand> generateCommands = new ArrayList<GenerateCommand>();

	public InargsParser(Settings settings, String... arguments) throws InargumentException {
		this(settings, Arrays.asList(arguments));
	}
	
	public InargsParser(Settings settings, List<String> arguments) {
		this.settings = settings;
		this.arguments = arguments;
		parse();
	}

	public ViewInfoCommand getViewInfoCommand() {
		return viewInfoCommand;
	}

	public SystemImportsCommand getSystemImportsCommand() {
		return systemImportsCommand;
	}
	
	public List<PrepareGenerateCommand> getPrepareGenerateCommands() {
		return prepareGenerateCommands;
	}
	
	public List<GenerateCommand> getGenerateCommands() {
		return generateCommands;
	}

	private void parse() {
		try {
			parseArguments();
		} catch (InargumentException e) {
			viewInfoCommand = new ViewExceptionCommand(e);
		}
	}
	
	private void parseArguments() throws InargumentException {
		Iterator<String> iterator = arguments.iterator();
		
		while (iterator.hasNext()) {
			String argument = iterator.next();
			
			if (argument.equals("-version")) {
				viewInfoCommand = new VersionCommand();
				return;
			} else if (argument.equals("-?") || argument.equals("-help")) {
				viewInfoCommand = new HelpCommand();
				return;
			} else if (argument.contains("=")) {
				int eqIndex = argument.indexOf("=");
				String variable = argument.substring(0, eqIndex);
				String value = argument.substring(eqIndex + 1);
				if (variable.equals(SystemImportsCommand.SYSTEM_IMPORTS_VARIABLE_NAME)) {
					systemImportsCommand = new SystemImportsCommand(variable, value, settings);
				} else {
					prepareGenerateCommands.add(new SetCommand(variable, value, settings));
				}
			} else if (argument.startsWith("-")) {
				prepareGenerateCommands.add(new SingleParameterCommand(argument, settings));
			} else {
				generateCommands.add(new GenerateCommand(settings, argument));
			}
		}
		if (generateCommands.size() == 0) {
			File file = new File(Settings.DEFULT_TEMPLATE_FILE);
			if (file.exists()) {
				generateCommands.add(new GenerateCommand(settings, Settings.DEFULT_TEMPLATE_FILE));
			} else {
				viewInfoCommand = new DefaultTemplateNotFoundCommand();
			}
		}
	}
}
