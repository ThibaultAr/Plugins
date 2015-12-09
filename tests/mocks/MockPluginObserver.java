package mocks;

import java.io.File;
import java.util.Set;

import plugins.PluginFinder;
import plugins.PluginObserver;

public class MockPluginObserver extends PluginObserver {

	public boolean passageInUpdateAddition = false;
	public boolean passageInUpdateDeletion = false;

	public MockPluginObserver(PluginFinder pluginFinder) {
		super(pluginFinder);
	}

	@Override
	public void updateOnAddition(File dir, Set<String> added) {
		this.passageInUpdateAddition = true;
	}

	@Override
	public void updateOnDeletion(File dir, Set<String> deleted) {
		this.passageInUpdateDeletion = true;
	}
}
