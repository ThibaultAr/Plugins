package plugins;

import java.io.File;
import java.util.Set;

public class MockPluginObserver extends PluginObserver{
	
	protected boolean passageInUpdateAddition = false;
	protected boolean passageInUpdateDeletion = false;	
	
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
