import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Kort implements Cloneable, Comparable<Kort>{
	private String Navn;
	private int PIN;
	private int KortNummer;
	private boolean sperretKort;
	protected Calendar Opprettet;

	public Kort(String Navn, int PIN){
		this.Navn = Navn;
		this.PIN = PIN;
		this.KortNummer = KortNummer();
		this.sperretKort = false;	
		this.Opprettet = new GregorianCalendar();
	}
	public String getNavn(){
		return Navn;
	}
	public int getKortNummer() {
		return KortNummer;
	}
	private static int KortNummer(){
		return (int)(Math.random() * 9999999 + 1000000);
	}
	public void setSperretKort(boolean sperretKort) {
		this.sperretKort = sperretKort;
	}
	public boolean isSperret(){
		return sperretKort;
	}
	public int getPIN(){
		return PIN;
	}
	public String toString(){
		return "Navn: " + Navn + "\nKortnr: " + KortNummer + "\nPIN: " + PIN + "\nSperret: " + sperretKort + "\nOpprettet: " + Opprettet.getTime();
	}
	public abstract boolean sjekkPIN(int PIN);
	
	// Version 0.4 implements
	@Override
	public Object clone(){
			try {
				return super.clone();
			} 
			catch (CloneNotSupportedException e) {
				return "Ingen kloning er tillatt";
			}
	}
	public int compareTo(Kort k){
		String[] x = Navn.split(" ");
		String[] y = k.Navn.split(" ");
		int LastName = x[x.length -1].compareTo(y[y.length-1]);
		int FirstName = x[0].compareTo(y[0]);
		if(LastName != 0 || FirstName != 0){
			return LastName + FirstName;
		}
		else{
			return 0;
		}	  		 
	}
	
	

}


