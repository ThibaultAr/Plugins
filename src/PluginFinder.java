import java.io.File;

public class PluginFinder {

	protected PluginFilter filter = new PluginFilter();
	protected File directory;

	public PluginFinder(File directory) {
		this.directory = directory;
	}

	public String[] acceptedFiles() {
		return this.directory.list(this.filter);
	}
}