package plugins.file;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import plugins.file.PluginFinder;
import plugins.file.PluginObserver;

public abstract class PluginObserverTest {

	public abstract PluginObserver createObserver(PluginFinder finder);

	@Test
	public void testSuscribeAPluginFinderWhenInstanciate() {
		MockPluginFinder finder = new MockPluginFinder();

		assertFalse(finder.passageInSubscription);

		// observer is unused because the subscription is done in the
		// constructor.
		@SuppressWarnings("unused")
		PluginObserver observer = this.createObserver(finder);

		assertTrue(finder.passageInSubscription);
	}

}
