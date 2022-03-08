package de.telekom.sea7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EntityIBANTest {

//	private final EntityIBAN cut;
	private EntityIBAN cut;

	@BeforeEach
	void setup() {
		cut = new EntityIBAN();
	}

	@Test
	void getIBAN_test() {
		// Arrange
		cut.setIban("DE123456");

		// Act
		var result = cut.getIban();

		// Assert
		assertEquals("DE123456", result);
	}

	@Test
	void setIBAN_test() {
		// Arrange
		cut.setIban("DE123456");

		// Act
		var result = cut.getIban();
		

		// Assert
		assertNotNull(result);
	}

	@Test
	void getID_test() {
		// Arrange
		cut.setId(2);

		// Act
		var result = cut.getId();

		// Assert
		assertEquals(2, result);
	}

	@AfterEach

	void teardown() {

		cut = null;

	}
}
