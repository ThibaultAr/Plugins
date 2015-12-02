package graphics;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


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
		
		JMenu file = new JMenu("File");
		JMenu tools = new JMenu("Tools");
		JMenu help = new JMenu("Help");
		ActionListener action = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// fonction d'affichage des tools ? 
				
			}
		};
		tools.addActionListener(action);
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
	}
	
	protected void addToPanel(JPanel content) {
		content.add(this.menuBar, BorderLayout.NORTH);
		content.add(textAreaScrollPane, BorderLayout.CENTER);
	}
	
	public Window() {
		this.window = new JFrame("Extendable Editor");
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
		this.window.pack();
	}
	
	
	//ebauche de la fenetre graphique qui sera affichée 
	public static void main(String[] args) {
		new Window();
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
