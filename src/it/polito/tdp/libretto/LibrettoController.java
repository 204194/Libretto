package it.polito.tdp.libretto;
import it.polito.tdp.libretto.model.*;
/**
 * Sample Skeleton for 'Libretto.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoController {
	
	Model model;

    /**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtCodice"
    private TextField txtCodice; // Value injected by FXMLLoader

    @FXML // fx:id="txtTitolo"
    private TextField txtTitolo; // Value injected by FXMLLoader

    @FXML // fx:id="txtDocente"
    private TextField txtDocente; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerca"
    private Button btnCerca; // Value injected by FXMLLoader

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="txtMessage"
    private TextArea txtMessage; // Value injected by FXMLLoader

    @FXML
    void handleCerca(ActionEvent event) {
    		String codice = txtCodice.getText();
    		
    		if(codice.length()<5) {
    			txtMessage.appendText("Codice corso non valido\n");
    			return;
    		}
    		
    		Esame e = model.trovaEsame(codice);
    		//trovaEsame mi restituisce o l'oggetto esame o null 
    		
    		if(e==null) {
    			txtMessage.appendText("Esame non trovato (CODICE "+codice+" NON TROVATO)\n");	
    		} else {
    			txtMessage.appendText("Codice: "+codice+" trovato\n");
    			txtCodice.setText(e.getCodice());
    			txtTitolo.setText(e.getTitolo());
    			txtDocente.setText(e.getDocente());
    		}
    }

    @FXML
    void handleInserisci(ActionEvent event) {
    	//recupera i dati dalla view
    		String codice = txtCodice.getText();
    		String titolo = txtTitolo.getText();
    		String docente = txtDocente.getText();
    		
    	//verifica la loro validità
    		if(codice.length()<5 || titolo.length()==0 || docente.length()==0){
    			txtMessage.appendText("Dati esame insufficienti\n");
    			return; //mi fermo perchè mi mancano dei dati e non posso andare avanti
    		}
    	
    //chiede al model di effettuare l'operazione -> come fa il controller a conoscere il modello?
    //NON CREO IL MODELLO NEL CONTROLLER!!! 
    	//non creo l'oggetto model ma lo richiamo (vedi sopra)
    	 Esame e = new Esame(codice, titolo, docente);
    	 boolean result = model.addEsame(e);
    	
    	//aggiorna la view con il risultato dell'operazione
    	 //ma devo sapere se l'operazione è andata a buon fine o no 
    	 if(result) {
     		txtMessage.appendText("Esame aggiunto correttamente\n");
     	} else {
     		txtMessage.appendText("Esame NON aggiunto correttamente (CODICE DUPLICATO)\n");
     	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'Libretto.fxml'.";

    }
}
