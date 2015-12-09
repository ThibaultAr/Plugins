package plugins.editor;

import plugins.file.PluginFinder;
import plugins.file.PluginInstantiation;
import plugins.file.Tools;

public class MockTools extends Tools {

	public MockTools() {
		super(null);
		this.plugins.put("MockPlugin.class", PluginInstantiation.getPluginInstance(null, "MockPlugin.class"));
	}

	@Override
	public void subscribeAPluginFinder(PluginFinder finder) {
	}

}
