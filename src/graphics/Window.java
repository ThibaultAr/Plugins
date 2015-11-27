package graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.*;

import plugins.PluginFinder;


public class Window {
	
	protected JFrame window;
	protected JMenuBar menuBar;
	protected List<JMenu> menus = new ArrayList<JMenu>();
	
	
	// utile ? 
	//protected HashMap<JMenu,List<JMenuItem>> menusItem ;
	//pour les items dans les menus
	//protected void createMenusItem() 
	
	//pour rendre le code un peu plus lisible 
	
	protected void createMenus() {
		
		JMenu file = new JMenu("file");
		JMenu tools = new JMenu("Tools");
		// TODO file a passer en parametre
		//tools.addActionListener(new PluginFinder());
		this.menus.add(file);
		this.menus.add(tools);
	}
	
	protected void addMenusToMenuBar() {
		this.menuBar = new JMenuBar();
		for (JMenu menu : this.menus) {
			this.menuBar.add(menu);
		}
	}
	
	protected void addToPanel(JPanel content) {
		content.add(this.menuBar);
		
	}
	
	public Window() {
		this.window = new JFrame("Plugins Project");
		this.window.setSize(200,200);
		this.window.setLocation(100, 100);
		
		JPanel content = new JPanel();
		
		this.createMenus();
		this.addMenusToMenuBar();
		this.addToPanel(content);
		
			
		this.window.setContentPane(content);
		this.window.setVisible(true);
	}
	
	
	//ebauche de la fenetre graphique qui sera affichée 
	public static void main(String[] args) {
		Window app = new Window();
		
		//commandes a executer ? 
	}
}
