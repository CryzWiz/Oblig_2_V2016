import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ansatt extends Kort implements Konstanter{
	private String Navn;
	private int PIN;
	private int WhatHour;
	private String Fornavn;
	private String Etternavn;
	private String Fulltnavn;
	
	public Ansatt(String Navn, int PIN){
		super(Navn, PIN);
		this.Navn = Navn;
		this.PIN = PIN;
		this.WhatHour = getHour();
		settFulltNavn(this.Navn);
	}
	public int getHour(){
		Calendar x = new GregorianCalendar();
		WhatHour = x.get(Calendar.HOUR_OF_DAY);
		//Just for testing cases outside of office hours
		//WhatHour = 3;
		//WhatHour = 13;
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
	//Fast - implements
	public void settFornavn(String Fornavn) {
		this.Fornavn = Fornavn;
	}
	public String hentForNavn() {
		return Fornavn;
	}
	
	public void settEtternavn(String Etternavn) {
		this.Etternavn = Etternavn;
	}
	public String hentEtterNavn() {
		return Etternavn;
	}
	
	public void settFulltNavn(String navn) {
		String[] x = navn.split(" ");
		String Fnavn = "";
		String Enavn = "";
		Fnavn += x[0];
		for(int i = 1; i < x.length; i++){
			Enavn += x[i] + " ";
		}
		settFornavn(Fnavn);
		settEtternavn(Enavn);
	}
	public String hentFulltNavn() {
		return Fornavn + " " + Etternavn;
	}
}


