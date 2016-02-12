public abstract class Kort {
	private String Navn;
	private int PIN;
	private int KortNummer;
	private boolean sperretKort;

	public Kort(String Navn, int PIN){
		this.Navn = Navn;
		this.PIN = PIN;
		this.KortNummer = KortNummer();
		this.sperretKort = false;	
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
		return "Navn: " + Navn + "\nKortnr: " + KortNummer + "\nPIN: " + PIN + "\nSperret: " + sperretKort;
	}
	public abstract boolean sjekkPIN(int PIN);
}
