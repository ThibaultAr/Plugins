package plugins;

public class MockPlugin implements Plugin {

	@Override
	public String transform(String s) {
		return "Mock plugin";
	}

	@Override
	public String getLabel() {
		return "Mock plugin";
	}

}
