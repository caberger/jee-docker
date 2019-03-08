package at.aberger.tutorial.jee.logging;

import javax.enterprise.inject.spi.InjectionPoint;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;

public class LogFactory {
	@Produces
	public Logger createLogger(InjectionPoint injectionPoint) {
		String name = injectionPoint.getMember().getDeclaringClass().getName();
		return Logger.getLogger(name);
	}
}