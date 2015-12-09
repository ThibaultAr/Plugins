package mocks;

import java.awt.event.ActionEvent;

import plugins.PluginFinder;
import plugins.PluginObserver;

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
