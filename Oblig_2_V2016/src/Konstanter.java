public interface Konstanter {
	
	public void settFornavn(String Fornavn);
	public String hentForNavn();
	
	public void settEtternavn(String Etternavn);
	public String hentEtterNavn();
	
	public void settFulltNavn(String Fulltnavn);
	public String hentFulltNavn();
	
	public double beregnKreditt();
	// We start with a credit worth 25 times the hourly pay
	final double KredittFaktor = 25;
	
	public double beregnBonus();
	// We start with a bonus worth 1000 for every year 
	final double BonusFaktor = 1000;
	
}
