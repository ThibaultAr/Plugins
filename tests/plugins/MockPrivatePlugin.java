package plugins;

import plugins.Plugin;

public class MockPrivatePlugin implements Plugin {

	private MockPrivatePlugin() {
	}

	@Override
	public String transform(String s) {
		return null;
	}

	@Override
	public String getLabel() {
		return null;
	}

}
