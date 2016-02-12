import java.util.Calendar;
import java.util.GregorianCalendar;

public class Gjest extends  Kort{
	private String Navn;
	private final int PIN = 9999;
	private int KortNummer;
	private Calendar sperreDato;
	private Calendar Opprettet;
	private Calendar dagensDato;
	
	public Gjest(String Navn, int PIN){
		super(Navn, PIN);
		this.Navn = Navn;
		this.KortNummer = getKortNummer();
		this.sperreDato = new GregorianCalendar();
		sperreDato.add(Calendar.DAY_OF_MONTH, 7);
		this.Opprettet = new GregorianCalendar();
		this.dagensDato = new GregorianCalendar();
	}
	
	@Override
	public String toString(){
		return "Navn: " + Navn + "\nKortnr: " + KortNummer + "\nPIN: " + PIN + 
				"\nOpprettet: " + Opprettet.getTime() + "\nDagens dato: " + dagensDato.getTime() + "\nSperredato: " + sperreDato.getTime();
	}
	public void toStringDato(){
		System.out.println("Feilårsak: Sperret pga dato.");
	}
	public void toStringFeilPIN(){
		System.out.println("Feilårsak: Feil PIN");
	}
	public void toStringSperretKort(){
		System.out.println("Feilårsak: Kortet er sperret.");
	}
	private void setDagensDato(){
		dagensDato = new GregorianCalendar();
	}
	@Override
	public boolean sjekkPIN(int PIN) {
		setDagensDato();
		if(getPIN() == PIN && sperreDato.compareTo(dagensDato) < 0){
			setSperretKort(true);
			toStringDato();
			return false;
		}
		else if(getPIN() != PIN && isSperret() == false){
			toStringFeilPIN();
			return false;
		}
		else if(isSperret() == true){
			toStringSperretKort();
			return false;
		}
		else return true;
	}
}

