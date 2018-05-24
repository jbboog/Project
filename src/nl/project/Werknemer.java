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
				System.out.println("overlap gevonden, dienst wordt niet toegevoegd");
				break;
			}
		}
		
		if (!overlap) {
			System.out.println("geen overlap, dienst toegevoegd");
			diensten.add(slot);
		}
	}
	
	boolean isErOverlap (Slot slot1, Slot slot2) {
		
			if (slot2.getEind().isBefore(slot1.getBegin())) {
				System.out.println("mag wel");
				return false;
			}
			if (slot2.getBegin().isAfter(slot1.getEind())) {
				System.out.println("mag wel");
				return false;
			}
		System.out.println("mag niet");
		return true;
	}
	
}
