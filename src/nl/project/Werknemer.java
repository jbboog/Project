package nl.project;

import java.util.ArrayList;

public class Werknemer {

	private String voornaam;
	private String achternaam;
	ArrayList<Slot> diensten = new ArrayList<>(); // simulatie van database
	
	Werknemer (String voornaam, String achternaam) {
		this.voornaam = voornaam;
		this.achternaam = achternaam;
	}
	
	void voegDienstToe (Slot slot) {
		
		boolean overlap = false;
		
		for (Slot s : diensten) {
			overlap = isErOverlap(s, slot);
			if (overlap) {
				break;
			}
		}
		
		if (!overlap) {
			diensten.add(slot);
		}
	}
	
	boolean isErOverlap (Slot slot1, Slot slot2) {
		
			if (slot1.getBegin().isAfter(slot2.getBegin()) && slot1.getBegin().isBefore(slot2.getEind())) {
				System.out.println("Overlappende slots door regel 1: ");
				System.out.println("Slot1: " + slot1.geefInfo());
				System.out.println("Slot2: " + slot2.geefInfo());
				return true;
			}
			if (slot1.getBegin().isBefore(slot2.getBegin()) && slot1.getBegin().isBefore(slot2.getEind())) {
				System.out.println("Overlappende slots door regel 2: ");
				System.out.println("Slot1: " + slot1.geefInfo());
				System.out.println("Slot2: " + slot2.geefInfo());
				return true;
			}
			if (slot1.getBegin().isBefore(slot2.getBegin()) && slot1.getEind().isBefore(slot2.getEind())) {
				System.out.println("Overlappende slots door regel 3: ");
				System.out.println("Slot1: " + slot1.geefInfo());
				System.out.println("Slot2: " + slot2.geefInfo());
				return true;
			}
			if (slot1.getBegin().isAfter(slot2.getBegin()) && slot1.getEind().isBefore(slot2.getEind())) {
				System.out.println("Overlappende slots door regel 4: ");
				System.out.println("Slot1: " + slot1.geefInfo());
				System.out.println("Slot2: " + slot2.geefInfo());
				return true;
			}
		
		return false;
	}
	
}
