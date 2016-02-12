import java.util.ArrayList;
import java.util.Scanner;
public class KortTest {
	public static void main(String[] args){
		ArrayList<Kort> reg = new ArrayList<Kort>();
		Kort k1 = new Ansatt("Ole Olsen", 1234);
		Kort k2 = new Gjest("Marit Olsen", 9999);
		reg.add(k1);
		reg.add(k2);
		// add-on
		Scanner input = new Scanner(System.in);
		while (true){
			   System.out.println("Main Menu:");
			   System.out.println("1: Run program check");
			   int choice = input.nextInt();
			   switch (choice){
			   case 1: 
				// add-on
				   // save - beg
				   for(int i = 0; i < reg.size(); i++){
					Kort kort = (Kort)reg.get(i);
					System.out.println(kort);
					System.out.println("Test av kort: " + kort.getKortNummer() + ",med kode 1234 er: " + (kort.sjekkPIN(1234) ? " Gyldig" : " Ugyldig"));
					System.out.println("Test av kort: " + kort.getKortNummer() + ",med kode 9999 er: " + (kort.sjekkPIN(9999) ? " Gyldig" : " Ugyldig"));
					System.out.println("-------------------------------------------------");
					// save - end
				   }
				// add-on
					break;
			   default: System.out.println("That choice doesnt exsist.\nPlease try again.\n\n\n"); 
			    break;
			   }
			// add-on
		}
	}

}
