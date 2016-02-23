import java.util.*;

public class KortTest {
	public static void main(String[] args){
		ArrayList<Kort> reg = new ArrayList<Kort>();
		Kort k1 = new Ansatt("Ole Olsen", 1234);
		Kort k2 = new Gjest("Marit Olsen", 9999);
		Kort k3 = new Gjest("ål åjearn", 9999);
		Kort k4 = new Ansatt("Silje Olsvik", 9875);
		reg.add(k1);reg.add(k2);reg.add(k3);reg.add(k4);
		
		// Collections.sort
		Collections.sort(reg);
		
		// We test the clone(), the PIN control and everything else.
		for(int i = 0; i < reg.size(); i++){
			Kort kort = (Kort)reg.get(i);
			Kort klonen = (Kort)reg.get(i).clone();
			System.out.println(kort);
			System.out.println("Test av kort " + kort.getKortNummer() + ",med kode 1234 er: " + (kort.sjekkPIN(1234) ? " Gyldig" : " Ugyldig"));
			System.out.println("Test av kort " + kort.getKortNummer() + ",med kode 9999 er: " + (kort.sjekkPIN(9999) ? " Gyldig" : " Ugyldig"));
			System.out.println("-------------------------------------------------");
			System.out.println("- - -\t THE CLONE \t- - -");
			System.out.println(klonen);
			System.out.println("Er klonen og kortet samme objekt: " + (klonen == kort ? "Ja" : "Nei"));
			System.out.println("\n\n");
		}
	}
}
