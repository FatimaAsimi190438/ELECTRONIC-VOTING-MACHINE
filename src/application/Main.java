package application;
	
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private static Stage st;
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			st=primaryStage;
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void screen(String x) throws IOException {
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource(x));
		Scene scene = new Scene(root,600,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
	    st.setScene(scene);
	    st.show();
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}
}
