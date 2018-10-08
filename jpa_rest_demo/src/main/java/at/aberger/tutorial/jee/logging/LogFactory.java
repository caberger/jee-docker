package at.aberger.tutorial.jee.logging;

import javax.enterprise.inject.spi.InjectionPoint;

import org.apache.log4j.Logger;

import javax.enterprise.inject.Produces;

public class LogFactory {
	@Produces
	Logger createLogger(InjectionPoint injectionPoint) {
		String name = injectionPoint.getMember().getDeclaringClass().getName();
		return Logger.getLogger(name);
	}
}