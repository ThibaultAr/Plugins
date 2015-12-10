package plugins.editor;

/**
 * This class launchs the application. 
 * Opens a window with a text area and some plugins in the Tools menu.
 *
 */
public class Main {

	public static void main(String[] args) {
		new PluginFrame("dropins/plugins");
	}
}
