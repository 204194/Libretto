package it.polito.tdp.libretto.model;
import java.time.*;
//oggetto semplice che contiene i dati relativi a un singolo esame
// POJO - plain old java object
//all'interno ha dati privati (attributi) , costruttore e tutti i metodi getter&setter,
// metodi di servizio -> equals, toString, hashCode, compareTo(eventualmente), ecc...
//i metodi di servizio ci devono essere SEMPRE

public class Esame {
	private String codice;
	private String titolo;
	private String docente; 
	//oppure
	// private Docente docente -> in un'applicazione un po' articolata avrei sicuramente 
	//una lista di docenti, con una lista di corsi 
	//a differenza di codice e titolo non docente non è un attributo , un'etichetta che mi def il corso
	//ma e' un oggetto a sè stante che ha a che fare con Esame
	//in questo caso però ci possiamo accontentare di String docente (per ora)
	
	private boolean superato;
	private int voto;
	private LocalDate dataSuperamento;
	
	// occhio al costruttore : quali attributi sono fondamentali per creare il nuovo oggetto?
	// nuovo esame -> non sappiamo ancora se sia stato superato
	
	public Esame(String codice, String titolo, String docente) {
		this.codice = codice;
		this.titolo = titolo;
		this.docente = docente;
		
		this.superato = false; // lo metto io per sapere che ancora non e' stato superato
	}
	
	// getters&setters -> quali sono le proprieta' che dall'esterno devono essere lette?
	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * @return the docente
	 */
	public String getDocente() {
		return docente;
	}

	/**
	 * @param docente the docente to set
	 */
	public void setDocente(String docente) {
		this.docente = docente;
	}

	/**
	 * @return the superato
	 */
	public boolean isSuperato() {
		return superato;
	}

	/**
	 * @param superato the superato to set
	 */
	private void setSuperato(boolean superato) {
		this.superato = superato;					//ha senso mettere setSuperato senza specificare il voto?
	}

	/**
	 * @return the voto solo se l'esame e' stato superato , altrimenti eccezione
	 */
	public int getVoto() {
		if(this.superato) {
		return voto;
		}
		else {
			throw new IllegalStateException("Esame "+this.codice+" non ancora superato");
		}
	}

	/**
	 * @param voto the voto to set
	 */
	private void setVoto(int voto) {			//se c'è un voto vuol dire che l'esame e' superato
		this.voto = voto;
	}

	/**
	 * @return the dataSuperamento
	 */
	public LocalDate getDataSuperamento() {
		if(this.superato) {
			return dataSuperamento;
			}
		else {
			throw new IllegalStateException("Esame "+this.codice+" non ancora superato");
		}
	}

	/**
	 * @param dataSuperamento the dataSuperamento to set
	 */
	private void setDataSuperamento(LocalDate dataSuperamento) {
		this.dataSuperamento = dataSuperamento;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	//quali altri metodi aggiungere ? 
	@Override
	public String toString() {
		return "Esame [codice=" + codice + ", titolo=" + titolo + ", docente=" + docente + ", superato=" + superato
				+ ", voto=" + voto + ", dataSuperamento=" + dataSuperamento + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	// mi interessa solo il codice che è la chiave primaria dell'oggetto esame
	//il codice identifica l'esame (non possono esserci due esami con lo stesso codice)
	// specifico il metodo equals per l'oggetto esame
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}
	/**
	 * se l'esame non e' ancora superato, lo considera superato con il voto e la data
	 * specificati.
	 * se invece l'esame era già superato , genera un'eccezione
	 * 
	 * @param voto
	 * @param data
	 */
	public void supera(int voto, LocalDate data) {
		if(!this.superato) {
			this.superato = true; 
			this.voto = voto;
			this.dataSuperamento = data;
		} else {
			throw new IllegalStateException("Esame "+this.codice+" già superato");
		}
	}
	
	
	
	
	
	
	

}
