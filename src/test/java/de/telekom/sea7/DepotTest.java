package de.telekom.sea7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DepotTest {
	
	private Depot cut;

	@BeforeEach
	void setup() {
		cut = new Depot();
	}

	@Test
	void Depot_add_test1() {
		var result =cut.size();
		cut.add( new EntityIBAN(1 , "DE12345"));
		var result2 = cut.size();
		assertNotEquals(result , result2);
	}
	
	@Test
	void Depot_add_test2() throws OwnException {
		cut.add( new EntityIBAN(1 , "DE12345"));
		
		assertEquals("DE12345", cut.get(0).getIban());
		assertEquals(1, cut.get(0).getId());
	}

// ErwartetesErgebnis  Error : ArrayIndexOutOfBoundsExceptiom	
	@Test
	void Depot_add_test3() {
		cut.add( new EntityIBAN(1 , "DE12345"));
		cut.add( new EntityIBAN(2 , "DE12346"));
		cut.add( new EntityIBAN(3 , "DE12347"));
		cut.add( new EntityIBAN(4 , "DE12348"));
		cut.add( new EntityIBAN(5 , "DE12349"));
		cut.add( new EntityIBAN(6 , "DE12340"));
		cut.add( new EntityIBAN(7 , "DE12341"));
		cut.add( new EntityIBAN(8 , "DE12342"));
		cut.add( new EntityIBAN(9 , "DE12343"));
//		cut.add( new EntityIBAN(10 , "DE12344"));
		assertThrows(IndexOutOfBoundsException.class,() -> {cut.add( new EntityIBAN(10 , "DE12344"));});
		
		
	}
//Erwartetes Ergebnis: True wird zurückgegen es ist leer	
	@Test
	void Depot_add_test4() throws OwnException {
		cut.add( new EntityIBAN(1 , ""));
		
		assertTrue(cut.get(0).getIban().isEmpty());
		
	}

//Erwartetes Ergebnis: False da es nich leer ist.
	
	@Test
	void Depot_add_test5() throws OwnException {
		cut.add( new EntityIBAN(1 , "DE12345"));
		
		assertFalse(cut.get(0).getIban().isEmpty());
		
	}

// Erwartetes Ergebnis:  Anzahl der Datensetze stimmt mit denen überein die Eingegeben wurden.	
	@Test
	void Depot_sice_Test1() {
		cut.add( new EntityIBAN(1 , "DE12345"));
		cut.add( new EntityIBAN(2 , "DE12346"));
		var result = cut.size();
		assertTrue(result == 2);
	}
	
	@Test
	void Depot_sice_Test2() {
		var result = cut.size();
		assertTrue(result == 0);
	}


// Erwartetes Ergebnis: IBAN des zweiten Datensatz entspricht dem eingegeben.
	@Test
	void Depot_get_test1() throws OwnException {
		cut.add( new EntityIBAN(1 , "DE12345"));
		cut.add( new EntityIBAN(2 , "DE12346"));	
		assertEquals("DE12346", cut.get(1).getIban());
	}

//Erwartetes Ergebnis: IBAN des ersten Datensatz entspricht dem eingegeben.	
	@Test
	void Depot_get_test2() throws OwnException {
		cut.add( new EntityIBAN(1 , "DE12345"));
		cut.add( new EntityIBAN(2 , "DE12346"));	
		assertEquals("DE12345", cut.get(0).getIban());
	}
	
// Erwartetes Ergebnis: Testfall führt zum Fehler, da size nicht negativ sein darf. Size beginnt mit 0.	
	@Test
	void Depot_get_test3() {
//		cut.add( new EntityIBAN(1 , "DE12345"));
//		cut.add( new EntityIBAN(2 , "DE12346"));
		assertThrows(OwnException.class,() -> cut.get(-1));
//		assertEquals("DE12346", cut.get(-1).getIban());
	}
	
// Erwartetes Ergebnis: Testfall führt zum Fehler, da der return Value null ist.	
	@Test
	void Depot_get_test4() {
//		cut.add( new EntityIBAN(1 , "DE12345"));
//		cut.add( new EntityIBAN(2 , "DE12346"));
//		cut.get(3).getIban();
		assertThrows(OwnException.class,() -> cut.get(3).getIban());
//		assertEquals("DE12346", cut.get(3).getIban());
	}
	
	@Test
	void Depot_get_test5() {
//		cut.add( new EntityIBAN(1 , "DE12345"));
//		cut.add( new EntityIBAN(2 , "DE12346"));
//		cut.get(3).getIban();
		assertThrows(OwnException.class,() -> cut.get(3));
//		assertEquals("DE12346", cut.get(3).getIban());
	}
	
	@Test
	void Depot_get_test6() {
		assertThrows(OwnException.class,() -> cut.get(0));
	}



	@AfterEach

	void teardown() {

		cut = null;

	}

}
