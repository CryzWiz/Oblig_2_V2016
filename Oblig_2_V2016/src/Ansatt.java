import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ansatt extends Kort{
	private String Navn;
	private int PIN;
	private int WhatHour;
	
	public Ansatt(String Navn, int PIN){
		super(Navn, PIN);
		this.Navn = Navn;
		this.PIN = PIN;
		this.WhatHour = getHour();
	}
	public int getHour(){
		Calendar x = new GregorianCalendar();
		WhatHour = x.get(Calendar.HOUR_OF_DAY);
		//Just for testing cases outside of office hours
		//WhatHour = 3;
		return WhatHour;
	}
	public void toStringOfficeHours(){
		System.out.println("Ingen PIN nødvendig eller sjekkes da klokken er mellom 07 - 17.");
	}
	public void toStringFeilPIN(){
		System.out.println("Feil PIN");
	}
	public void toStringSperretKort(){
		System.out.println("Kortet er sperret.");
	}
	@Override
	public boolean sjekkPIN(int PIN) {
		if(WhatHour <= 17 && WhatHour >= 7 && isSperret() == false){
			toStringOfficeHours();
			return true;
		}
		else if(this.PIN == PIN && isSperret() == false){
			return true;
		}
		else if(isSperret() == true){
			toStringSperretKort();
			return false;
		}
		else {
			toStringFeilPIN();
			return false;
		}
	}
}


