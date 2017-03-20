package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestEsame {

	public static void main(String[] args) {
		//per testare i metodi di Esame e vedere se tutto funziona correttamente
		//che non ci dia nullPointer, ecc...
		// faccio una Classe a parte invece che mettere un main nella classe Esame
		//perchè cosi posso controllare anche di aver gestito bene private/public
		
		Esame tdp = new Esame("03FYZ", "Tecniche di Programmazione", "Fulvio Corno");
		System.out.println(tdp);
		Esame ami = new Esame("01QZP", "Ambient Intelligence", "Fulvio Corno");
		System.out.println(ami);
		System.out.println(ami.equals(tdp));
		
		tdp.supera(30,  LocalDate.now());
		System.out.println(tdp);
		tdp.supera(18,  LocalDate.now());
	}

}
