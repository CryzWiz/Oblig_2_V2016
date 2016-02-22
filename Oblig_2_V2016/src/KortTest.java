import java.util.ArrayList;

public class KortTest {
	public static void main(String[] args){
		ArrayList<Kort> reg = new ArrayList<Kort>();
		Kort k1 = new Ansatt("Ole Olsen", 1234);
		Kort k2 = new Gjest("Marit Olsen", 9999);
		Kort k3 = new Gjest("ål åjearn", 9999);
		reg.add(k1);
		reg.add(k2);
		reg.add(k3);

		for(int i = 0; i < reg.size(); i++){
			Kort kort = (Kort)reg.get(i);
			System.out.println(kort);
			System.out.println("Test av kort " + kort.getKortNummer() + ",med kode 1234 er: " + (kort.sjekkPIN(1234) ? " Gyldig" : " Ugyldig"));
			System.out.println("Test av kort " + kort.getKortNummer() + ",med kode 9999 er: " + (kort.sjekkPIN(9999) ? " Gyldig" : " Ugyldig"));
			System.out.println("-------------------------------------------------");
		}
	}
}
