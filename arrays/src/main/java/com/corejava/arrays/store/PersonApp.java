package com.corejava.arrays.store;

public class PersonApp {
	public static void main(String[] args) {
		int maxSize = 100;
		PersonArray personArray = new PersonArray(maxSize);

		personArray.insert("Evans", "Patty", 24);
		personArray.insert("Smith", "Lorraine", 37);
		personArray.insert("Yee", "Tom", 43);
		personArray.insert("Adams", "Henry", 63);
		personArray.insert("Hashimoto", "Sato", 21);
		personArray.insert("Stimson", "Henry", 29);
		personArray.insert("Velasquez", "Jose", 72);
		personArray.insert("Lamare", "Henry", 54);
		personArray.insert("Vanh", "Minh", 22);
		personArray.insert("Creswell", "Lucinda", 18);

		personArray.displayPerson();

		String searchKey = "Stimson";
		Person person = personArray.find(searchKey);
		if (person != null) {
			System.out.println("found " + person);
		} else {
			System.out.println("can't find");
		}

		System.out.println("Deleting Smith, Yee, Creswell");
		personArray.delete("Smith");
		personArray.delete("Yee");
		personArray.delete("Creswell");

		personArray.displayPerson();
	}
}
