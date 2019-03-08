package at.aberger.tutorial.jee.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** only to cover constructor */
class EntityManagerProducerTest {
	EntityManagerProducer entityManagerProducer;
	@BeforeEach
	void setUp() throws Exception {
		entityManagerProducer = new EntityManagerProducer();
	}
	@Test
	void test() {
		assertNotNull(entityManagerProducer);
	}
}
