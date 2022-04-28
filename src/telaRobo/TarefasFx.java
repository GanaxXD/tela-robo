package telaRobo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TarefasFx extends Application{
	
	public String fonteGeral = "https://fonts.googleapis.com/css2?family=Assistant:wght@300&display=swap";
	public String fontLabelAssitant = "https://fonts.googleapis.com/css2?family=Assistant:wght@800&display=swap";
	public Image tjIcon = new Image("images/tjlogo.png");
	private List<String> tarefas = Arrays.asList(
			"tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", 
			"tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", 
			"tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", 
			"tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", 
			"tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", 
			"tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", 
			"tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", 
			"tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", 
			"tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", 
			"tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", 
			"tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", 
			"tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", 
			"tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", 
			"tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", 
			"tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", 
			"tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", 
			"tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", 
			"tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", 
			"tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", 
			"tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2", "tarefa 1", "tarefa 2"
	);

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Selecione as tarefas");
		primaryStage.centerOnScreen();
		primaryStage.setMinHeight(650.0);
		primaryStage.setMinWidth(800.0);
		
		FlowPane quadroInterno = new FlowPane(10.0, 5.0);
		quadroInterno.setMinSize(775.0, 625.0);
		
		Button selecionar = new Button("Selecionar");
		selecionar.getStyleClass().addAll("botao", fonteGeral);
		
		HBox controles = new HBox();
		
		//adicionando os nodes (elementos)
		for(String tarefa : tarefas) {
			quadroInterno.getChildren().add(inserirCombo(tarefa));
		}
		
		
		//Preparando a exibição da tela
		Scene cena = new Scene(quadroInterno,750.0, 650.0);
		primaryStage.setScene(cena);
		primaryStage.show();		
	}
	
	public CheckBox inserirCombo(String tarefa) {
		CheckBox checkbox = new CheckBox(tarefa);
		return checkbox;
	}
	
	//para rodar:
	public static void main(String[] args) {
		launch(args);
	}

}
