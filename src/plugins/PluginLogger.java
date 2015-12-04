package plugins;

import java.io.File;
import java.util.Set;

public class PluginLogger extends PluginObserver {

	public PluginLogger(PluginFinder pluginFinder) {
		super(pluginFinder);
	}

	@Override
	public void updateOnAddition(File dir, Set<String> added) {
		for(String add : added)
			System.out.println(add + " added.");
	}

	@Override
	public void updateOnDeletion(File dir, Set<String> deleted) {
		for(String delete : deleted)
			System.out.println(delete + " deleted.");
	}

	public static void main(String[] args) {
		File directory = new File("dropins");
		PluginFinder pluginFinder = new PluginFinder(directory);
		new PluginLogger(pluginFinder);
		while (true) {
		}
	}
}
