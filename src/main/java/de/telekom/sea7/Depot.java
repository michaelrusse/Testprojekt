package de.telekom.sea7;



public class Depot {
	
	private EntityIBAN[] depotArray = new EntityIBAN[9];
	private int size;
	
	
	
	// Fügt eine Objectinstanz an der nächsten frei Stelle des Arrays
	 public void add(EntityIBAN entityIBAN) {
		 depotArray[size++] = entityIBAN;
		 
	 }
	 
	 // Gibt das Objekt von der angegebenen Stelle (index) zurück
//	 public EntityIBAN get(int index) {
//		 return depotArray[index];
//	 }
	 
	 public EntityIBAN get(int index) throws OwnException {
		 if (index > size) {
		 throw new OwnException();
		 }
		 if (index < 0) {
		 throw new OwnException();
		 }
		 // if (depotArray[index].getIban() == null) {
		 // throw new OwnException();
		 // }
		 if (index == 0 && size == 0) {
		 throw new OwnException();
		 }

		 else {
		 return depotArray[index];
		 }
		 }
	 
	 
	 
	 //Gibt die Anzahl der belegten Stellen des Array zurück
	 public int size() {
		 return size;
	 }


}
