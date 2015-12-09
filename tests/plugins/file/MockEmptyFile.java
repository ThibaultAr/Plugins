package plugins.file;

import java.io.File;

public class MockEmptyFile extends File {

	private static final long serialVersionUID = 5995077664671397517L;

	public MockEmptyFile() {
		super("");
	}

	@Override
	public String[] list() {
		String files[] = {};
		return files;
	}
}
