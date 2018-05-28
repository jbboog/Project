package nl.project;

import java.time.LocalDateTime;

public class Demo {

	public static void main(String[] args) {
		System.out.println("Dit werkt.");
		
		Slot slot1 = new Slot(LocalDateTime.of(2018, 5, 24, 8, 0), LocalDateTime.of(2018, 5, 24, 15, 0));
		Slot slot2 = new Slot(LocalDateTime.of(2018, 5, 24, 14, 0), LocalDateTime.of(2018, 5, 24, 22, 0));
		Slot slot3 = new Slot(LocalDateTime.of(2018, 5, 24, 10, 0), LocalDateTime.of(2018, 5, 24, 12, 0));
		Slot slot4 = new Slot(LocalDateTime.of(2018, 5, 24, 7, 0), LocalDateTime.of(2018, 5, 24, 16, 0));
		Slot slot5 = new Slot(LocalDateTime.of(2018, 5, 24, 7, 0), LocalDateTime.of(2018, 5, 24, 10, 0));
		Slot slot6 = new Slot(LocalDateTime.of(2018, 5, 24, 6, 0), LocalDateTime.of(2018, 5, 24, 7, 0));
		Slot slot7 = new Slot(LocalDateTime.of(2018, 5, 24, 16, 0), LocalDateTime.of(2018, 5, 24, 20, 0));
		
		System.out.println("Slot 1: " + slot1.geefInfo());
		System.out.println("Slot 2: " + slot2.geefInfo());
		
		System.out.println();
		
		Werknemer w1 = new Werknemer("Henk", "De Vries");
		
		w1.voegDienstToe(slot1);
		
		System.out.println("nu slot 2:");
		w1.voegDienstToe(slot2);
		System.out.println("nu slot 3:");
		w1.voegDienstToe(slot3);
		System.out.println("nu slot 4:");
		w1.voegDienstToe(slot4);
		System.out.println("nu slot 5:");
		w1.voegDienstToe(slot5);
		System.out.println("nu slot 6:");
		w1.voegDienstToe(slot6);
		System.out.println("nu slot 7:");
		w1.voegDienstToe(slot7);
		
		System.out.println();
		
		w1.geefDienstOverzicht();
	}

}

