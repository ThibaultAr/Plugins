package graphics;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import plugins.PluginFinder;
import plugins.Tools;

public class Window {
	
	protected JFrame window;
	protected JMenuBar menuBar;
	protected List<JMenu> menus;
	protected static JTextArea textArea;
	protected JScrollPane textAreaScrollPane;
	protected JMenu toolsMenu;
	
	// utile ? 
	//protected HashMap<JMenu,List<JMenuItem>> menusItem ;
	//pour les items dans les menus
	//protected void createMenusItem() 
	
	public Window(ToolsMenu toolsMenu) {
		this.toolsMenu = toolsMenu;
		
		this.menus = new ArrayList<JMenu>();
		
		this.window = new JFrame("Extendable Editor");
		this.window.setLocation(0, 0);
		this.window.addWindowListener(new FermeWindowEvent());
		
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		
		this.createMenus();
		this.addMenusToMenuBar();
		this.createTextAreaAndScroll();
		this.addToPanel(content);
					
		this.window.setContentPane(content);
		this.window.setVisible(true);
		this.window.pack();
	}

	//pour rendre le code un peu plus lisible 
	
	protected void createMenus() {
		
		JMenu file = new JMenu("File");
		JMenu help = new JMenu("Help");
		this.menus.add(file);
		this.menus.add(this.toolsMenu);
		this.menus.add(help);
	}

	protected void addMenusToMenuBar() {
		this.menuBar = new JMenuBar();
		for (JMenu menu : this.menus) {
			this.menuBar.add(menu);
		}
	}
	
	protected void createTextAreaAndScroll() {
		Window.textArea = new JTextArea("", 25, 50);
		this.textAreaScrollPane = new JScrollPane(textArea);
	}
	
	protected void addToPanel(JPanel content) {
		content.add(this.menuBar, BorderLayout.NORTH);
		content.add(textAreaScrollPane, BorderLayout.CENTER);
	}
	
	/*
	 * Internal Classes
	 */
	class FermeWindowEvent extends WindowAdapter {
		@Override
		public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		}
	}

	// ebauche de la fenetre graphique qui sera affichée
	public static void main(String[] args) {
		File directory = new File("dropins");
		PluginFinder pluginFinder = new PluginFinder(directory);
		Tools tools = new Tools(pluginFinder);
		ToolsMenu toolsMenu = new ToolsMenu(tools);
		new Window(toolsMenu);
	}
}
