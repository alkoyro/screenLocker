package by.home.console;

import by.home.console.command.executor.CommandExecutor;

import com.beust.jcommander.JCommander;

public class App {
	public static void main(String[] args) {
		LockerConfiguration configuration = new LockerConfiguration();
		new JCommander(configuration, args);
		CommandExecutor executor = new CommandExecutor();
		executor.execute(configuration);
	}
}
