package nl.project;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Slot {
	
	private LocalDateTime slotBegin;
	private LocalDateTime slotEind;
	private Duration tijdsduur;
	private static DateTimeFormatter tijdFormat = DateTimeFormatter.ofPattern("kk:mm");
	
	
	Slot (LocalDateTime begin, LocalDateTime eind) {
		slotBegin = begin;
		slotEind = eind;
		tijdsduur = Duration.between(slotBegin, slotEind);
	}
	
	int aantalUur () {
		return (int) tijdsduur.getSeconds()/3600;
	}
	
	String geefInfo () {
		return "Begint op " + slotBegin.format(tijdFormat) + ", eindigt op " 
				+ slotEind.format(tijdFormat) + ". Dit slot duurt " + this.aantalUur() + " uur.";
	}
	
	LocalDateTime getBegin() {
		return slotBegin;
	}
	
	LocalDateTime getEind() {
		return slotEind;
	}
	
}
