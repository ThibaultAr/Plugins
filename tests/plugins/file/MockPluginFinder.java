package plugins.file;

import java.awt.event.ActionEvent;

import plugins.file.PluginFinder;
import plugins.file.PluginObserver;

public class MockPluginFinder extends PluginFinder{

	public boolean passageInSubscription = false;
	
	public MockPluginFinder() {
		super(null);
		this.plugins.add("MockPlugin.class");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void subscribeAnObserver(PluginObserver observer){
		this.passageInSubscription = true;
	}
}
