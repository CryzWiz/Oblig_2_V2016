import java.util.Calendar;
import java.util.GregorianCalendar;

public class Gjest extends Kort{
	private String Navn;
	private final int PIN = 9999;
	private Calendar sperreDato;
	private Calendar dagensDato;
	
	public Gjest(String Navn, int PIN){
		super(Navn, PIN);
		this.Navn = Navn;
		this.sperreDato = new GregorianCalendar();
		sperreDato.add(Calendar.DAY_OF_MONTH, 7);
		this.dagensDato = new GregorianCalendar();
	}
	
	@Override
	public String toString(){
		return super.toString() + 
				"\n----------------------------------------"
				+ "\nSperredato: " + sperreDato.getTime() + 
				"\n----------------------------------------";
	}
	public void toStringDato(){
		System.out.println("Feilårsak: Sperret pga dato.");
	}
	public void toStringFeilPIN(){
		System.out.println("Feilårsak: Feil PIN.");
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
		if(this.PIN == PIN && sperreDato.compareTo(dagensDato) < 0){
			setSperretKort(true);
			toStringDato();
			return false;
		}
		else if(this.PIN != PIN && isSperret() == false){
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

