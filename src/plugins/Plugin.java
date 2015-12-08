package plugins;

/**
 *
 */
public interface Plugin {

	/**
	 * 
	 * @param s
	 * @return
	 */
	public String transform(String s);
	
	/**
	 * 
	 * @return
	 */
	public String getLabel();
}
