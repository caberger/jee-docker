package at.aberger.tutorial.jee.logging;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.lang.reflect.Member;
import java.util.logging.Logger;

import javax.enterprise.inject.spi.InjectionPoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class LogFactoryTest {
	LogFactory logFactory;
	@Mock
	Member member;

	@Mock
	InjectionPoint injectionPoint;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		logFactory = new LogFactory();
	}
	@Test
	void testCreateLogger() {
		doReturn(LogFactoryTest.class).when(member).getDeclaringClass();
		when(injectionPoint.getMember()).thenReturn(member);
		
		Logger log = logFactory.createLogger(injectionPoint);
		assertNotNull(log);
	}
}
