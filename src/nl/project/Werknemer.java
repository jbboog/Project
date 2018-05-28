package nl.project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Werknemer {

	private String voornaam;
	private String achternaam;
	private ArrayList<Slot> diensten = new ArrayList<>(); // simulatie van database
	private static DateTimeFormatter dienstTijdFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy kk:mm");
	
	public Werknemer (String voornaam, String achternaam) {
		this.voornaam = voornaam;
		this.achternaam = achternaam;
	}
	
	public void voegDienstToe (Slot slot) {
		
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
	
	public boolean isErOverlap (Slot slot1, Slot slot2) {
		
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
	
	public void geefDienstOverzicht () {
		System.out.println(voornaam + " " + achternaam + " heeft de volgende diensten:");
		
		int teller = 1;
		for (Slot s : diensten) {
			String afgemaakteDienst = "";
			if (s.getEind().isBefore(LocalDateTime.now())) {
				afgemaakteDienst = " (afgemaakt)";
			}
			System.out.println("Dienst " + teller + afgemaakteDienst+ ": van: " + s.getBegin().format(dienstTijdFormat) + " tot: " + s.getEind().format(dienstTijdFormat));
			teller++;
		}
		
	}
	
	public String getVoornaam () {
		return voornaam;
	}
	
	public String getAchternaam () {
		return achternaam;
	}
	
	public String getNaam () {
		return voornaam + " " + achternaam;
	}
}
