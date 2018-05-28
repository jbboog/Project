package nl.project;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Slot {
	
	private LocalDateTime slotBegin;
	private LocalDateTime slotEind;
	private Duration tijdsduur;
	private static DateTimeFormatter tijdFormat = DateTimeFormatter.ofPattern("kk:mm");
	
	
	public Slot (LocalDateTime begin, LocalDateTime eind) {
		slotBegin = begin;
		slotEind = eind;
		tijdsduur = Duration.between(slotBegin, slotEind);
	}
	
	public int aantalUur () {
		return (int) tijdsduur.getSeconds()/3600;
	}
	
	public String geefInfo () {
		return "Begint op " + slotBegin.format(tijdFormat) + ", eindigt op " 
				+ slotEind.format(tijdFormat) + ". Dit slot duurt " + this.aantalUur() + " uur.";
	}
	
	public LocalDateTime getBegin() {
		return slotBegin;
	}
	
	public LocalDateTime getEind() {
		return slotEind;
	}
	
}
