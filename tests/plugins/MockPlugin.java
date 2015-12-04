package plugins;

public class MockPlugin implements Plugin {

	@Override
	public String transform(String s) {
		return "coucou";
	}

	@Override
	public String getLabel() {
		return null;
	}

}
