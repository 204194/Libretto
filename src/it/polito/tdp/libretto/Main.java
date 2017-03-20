package it.polito.tdp.libretto;
import it.polito.tdp.libretto.model.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//invece di usare un metodo statico creo l'oggetto FXMLLoader 
			//cosi poi chiamo un metodo vero su un oggetto vero
			// abbiamo un oggetto loader su cui richiamare un metodo 
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Libretto.fxml"));
			BorderPane root = (BorderPane)loader.load();
			
			//a questo punto sul loader posso fare un getController -> adesso so chi è il controller
			LibrettoController controller = loader.getController();
			Model model = new Model();
			controller.setModel(model);
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
