package plugins.editor;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import plugins.file.PluginFinder;
import plugins.file.Tools;

public class Window {

	protected JFrame window;
	protected JMenuBar menuBar;
	protected JTextArea textArea;
	protected JMenu toolsMenu;

	public Window(String toolsDirectory) {
		JPanel content = this.createContentJPanel(toolsDirectory);
		this.configureWindow(content);
	}

	protected JPanel createContentJPanel(String toolsDirectory) {
		JScrollPane textAreaScrollPane = this.createTextAreaAndScroll();

		this.createMenusToMenuBar(toolsDirectory);

		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		content.add(this.menuBar, BorderLayout.NORTH);
		content.add(textAreaScrollPane, BorderLayout.CENTER);
		return content;
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

	protected void configureWindow(JPanel content) {
		this.window = new JFrame("Extendable Editor");
		this.window.setLocation(0, 0);
		this.window.addWindowListener(new CloseWindowEvent());
		this.window.setContentPane(content);
		this.window.setVisible(true);
		this.window.pack();
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

	public static void main(String[] args) {
		new Window("dropins/plugins");
	}
}
