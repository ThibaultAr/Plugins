package graphics;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.*;

import plugins.PluginFinder;


public class Window {
	
	protected JFrame window;
	protected JMenuBar menuBar;
	protected List<JMenu> menus = new ArrayList<JMenu>();
	protected JTextArea textArea;
	protected JScrollPane textAreaScrollPane;
	
	
	// utile ? 
	//protected HashMap<JMenu,List<JMenuItem>> menusItem ;
	//pour les items dans les menus
	//protected void createMenusItem() 
	
	//pour rendre le code un peu plus lisible 
	
	protected void createMenus() {
		
		JMenu file = new JMenu("file");
		JMenu tools = new JMenu("Tools");
		JMenu help = new JMenu("Help");
		// TODO file a passer en parametre
		//tools.addActionListener(new PluginFinder());
		this.menus.add(file);
		this.menus.add(tools);
		this.menus.add(help);
	}
	
	protected void addMenusToMenuBar() {
		this.menuBar = new JMenuBar();
		for (JMenu menu : this.menus) {
			this.menuBar.add(menu);
		}
	}
	
	protected void createTextAreaAndScroll() {
		this.textArea = new JTextArea("Some text we want to transform",25,100);
		this.textAreaScrollPane = new JScrollPane(textArea);
		this.textAreaScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.textAreaScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	}
	
	protected void addToPanel(JPanel content) {
		content.add(this.menuBar, BorderLayout.NORTH);
		content.add(textAreaScrollPane, BorderLayout.CENTER);
	}
	
	public Window() {
		this.window = new JFrame("Extendable Editor");
		this.window.setSize(400,200);
		this.window.setLocation(100, 100);
		this.window.addWindowListener(new FermeWindowEvent());
		
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		
		this.createMenus();
		this.addMenusToMenuBar();
		this.createTextAreaAndScroll();
		this.addToPanel(content);
					
		this.window.setContentPane(content);
		this.window.setVisible(true);
	}
	
	
	//ebauche de la fenetre graphique qui sera affichée 
	public static void main(String[] args) {
		Window app = new Window();
		
		//commandes a executer ? 
	}
	
	
	/*
	 * Internal Classes
	 */
	
	class FermeWindowEvent extends WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		}
	} 
}
