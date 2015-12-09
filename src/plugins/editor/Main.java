package plugins.editor;

/**
 * This class launch the application. 
 * Open a window with a text area and some plugins in the Tools menu.
 *
 */
public class Main {

	public static void main(String[] args) {
		new PluginFrame("dropins/plugins");
	}
}
