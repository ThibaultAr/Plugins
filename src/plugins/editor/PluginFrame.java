package plugins.editor;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import plugins.file.PluginFinder;
import plugins.file.Tools;

public class PluginFrame extends JFrame {

	/**
	 * Class version, it is used to check if the server and client have the same
	 * version of this class
	 */
	private static final long serialVersionUID = -1108302002388167877L;

	protected JMenuBar menuBar;
	protected JTextArea textArea;
	protected JMenu toolsMenu;

	public PluginFrame(String toolsDirectory) {
		super("Extendable Editor");
		this.createContentJPanel(toolsDirectory);
		this.configureWindow();
	}

	protected void createContentJPanel(String toolsDirectory) {
		JScrollPane textAreaScrollPane = this.createTextAreaAndScroll();

		this.createMenusToMenuBar(toolsDirectory);

		this.setLayout(new BorderLayout());
		this.setJMenuBar(this.menuBar);
		this.add(textAreaScrollPane, BorderLayout.CENTER);
	}

	/**
	 * do before using the textArea attribute
	 */
	protected JScrollPane createTextAreaAndScroll() {
		this.textArea = new JTextArea("", 25, 50);
		return new JScrollPane(textArea);
	}

	/**
	 * do after createTextAreaAndScroll()
	 */
	protected void createMenusToMenuBar(String toolsDirectory) {
		this.createToolsMenu(toolsDirectory);
		this.menuBar = new JMenuBar();
		this.menuBar.add(new JMenu("File"));
		this.menuBar.add(this.toolsMenu);
		this.menuBar.add(new JMenu("Help"));
	}

	/**
	 * do before using the toolsMenu attribute
	 */
	protected void createToolsMenu(String toolsDirectory) {
		File directory = new File(toolsDirectory);
		PluginFinder pluginFinder = new PluginFinder(directory);
		Tools tools = new Tools(pluginFinder);
		this.toolsMenu = new ToolsMenu(tools, this.textArea);
	}

	protected void configureWindow() {
		this.setLocation(0, 0);
		this.addWindowListener(new CloseWindowEvent());
		this.setVisible(true);
		this.pack();
	}

	/*
	 * Internal Classes
	 */
	class CloseWindowEvent extends WindowAdapter {
		@Override
		public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		}
	}
}
