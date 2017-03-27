package it.polito.tdp.libretto.model;
import java.util.*;

import it.polito.tdp.libretto.db.EsameDAO;
//classe principale che gestisce oggetti di tipo esame
// il modello deve permettere all'interfaccia utente di inserire un nuovo esame 
// oppure di ricercarne uno già inserito 

public class Model {
	
	//vogliamo trasferire tutto in un DB invece che in una lista 
	//anziche accedere alla lista e ai suoi metodi accedo al DB
	//ma le query dove le metto ? è meglio non averle nel model ma avere tutta la parte della connessione
	//al db e tutto il resto a parte 
	private List<Esame> esami;
	/**
	 * La lista non può essere controllata dal controller
	 * il controller non può agire sulla lista , può usare solo i metodi delegati dal model
	 */
	
	public Model() { //non ho bisogno di passare parametri, creo solo una lista di esami vuota
		this.esami = new ArrayList<Esame>();
		//per il momento non ho bisogno di altro
	}
	
	/** 
	 * aggiunge un nuovo esame all'elenco degli esami presenti
	 * verificando che non ci sia già
	 * se l'esame viene inserito correttamente ritorna true
	 * se l'esame è già presente ritorna false
	 */
	
	public boolean addEsame(Esame e) {
//		if(!esami.contains(e)) { 
//            //contains usa esame.equals -> per questo e' importante specificare il metodo equals
//			//per la classe Esame
//		esami.add(e);
//		return true;
//		} else {
//			/**
//			 * ho diversi modi per gestire le failures
//			 * posso fare una silent failure (la più sconsigliata)
//			 * posso lanciare un'eccezione
//			 * posso mettere un boolean come valore di ritorno al posto di void
//			 */
//			//throw new IllegalStateException("Esame "+e.getCodice()+" già superato");
//			return false;
//		}
		
		EsameDAO dao = new EsameDAO();
		return dao.create(e);
	}
	
	/**
	 * ricerca se esiste un esame col codice specificato.
	 * se esiste lo restituisce altrimenti ritorna null.
	 * @param codice codice dell'esame da ricercare
	 * @return restituisce l'esame trovato, null altrimenti
	 */
	
	public Esame trovaEsame(String codice) {
		/**
		 * ho due metodi della classe lista per cercare un elemento della lista
		 * indexOf -> non posso usarlo perchè ricerca dato l'oggetto, 
		 * non dato un attributo identificativo dell'oggetto
		 * posso usarlo lo stesso creando un oggetto finto di tipo Esame con quel codice
		 * contains -> 
		 */
//		int pos = this.esami.indexOf(new Esame(codice, null, null));
//		//mi permette di rispondere correttamente all'equals -> con una riga di codice ho risolto
//		// mi restituisce la posizione dell'oggetto o -1 se non viene trovato
//		
//		if(pos == -1){
//			//oggetto non trovato
//			return null;
//		} else {
//			//oggetto in quella posizione della lista
//			return esami.get(pos);
//		}
//		
//	}
		
		EsameDAO dao = new EsameDAO();
		Esame e = dao.find(codice);
		return e;
	}
}
