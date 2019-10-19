package org.worldbuild.project.listner;

import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleListener;
import org.apache.log4j.Logger;

public class ApplicationListner implements LifecycleListener {

	private static final Logger LOGGER = Logger.getLogger(ApplicationListner.class);

	private static int counter;

	@Override
	public void lifecycleEvent(LifecycleEvent arg0) {
		String event = arg0.getType();
		switch (TomcatEvent.valueOf(event)) {
		case INIT_EVENT:
			LOGGER.info("Hey  Saurabh I've initalized");
		case AFTER_STOP_EVENT:
			LOGGER.info("Hey  Saurabh I've stopped");
			break;
		case AFTER_START_EVENT:
			LOGGER.info("Hey  Saurabh I've started");
			break;
		default :
			LOGGER.info("Tomcat Envents : " + event);
			break;

		}
	}

	private enum TomcatEvent {
		INIT_EVENT, AFTER_START_EVENT, AFTER_STOP_EVENT, BEFORE_START_EVENT, BEFORE_STOP_EVENT, DESTROY_EVENT,
		PERIODIC_EVENT, START_EVENT, STOP_EVENT;

	}

}