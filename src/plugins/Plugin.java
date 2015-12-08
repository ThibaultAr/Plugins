package plugins;

/**
 * Plugin Interface. A plugin is an action caracterized by a label. It
 * transforms the text by applying some effects, for instance, turning all the
 * caracters into upper case.
 */
public interface Plugin {

	/**
	 * changes the String passed as a parameter with the effect of the plugin
	 * 
	 * @param s
	 *            what needs to be transformed by the plugin
	 * @return the result of the plugin on the String s
	 */
	public String transform(String s);

	/**
	 * 
	 * @return the plugin's name
	 */
	public String getLabel();
}
