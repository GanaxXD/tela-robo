package telaRobo;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
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
	private List<CheckBox> checkboxes = new ArrayList<CheckBox>();
	

	@Override
	public void start(Stage primaryStage) throws Exception {
						
		primaryStage.setTitle("Selecione as tarefas");
		primaryStage.centerOnScreen();
		primaryStage.setMinHeight(650.0);
		primaryStage.setMinWidth(800.0);
		
		FlowPane quadroInterno = new FlowPane(10.0, 5.0);
		quadroInterno.setMinSize(775.0, 625.0);
		quadroInterno.setPadding(new Insets(20.0, 10.0, 10.0, 20.0));
		
		Button selecionar = new Button("Selecionar");
		selecionar.getStyleClass().add("botao");
		selecionar.getStyleClass().add(fonteGeral);
		Button voltar = new Button("Voltar");
		voltar.getStyleClass().add("botaoCancelar");
		voltar.getStyleClass().add(fonteGeral);
		
		selecionar.setAccessibleHelp("Concluir seleção de tarefas");
		voltar.setAccessibleHelp("Voltar para a tela inicial");
		
		CheckBox check = new CheckBox();
		//adicionando os nodes (elementos)
		for(String tarefa : tarefas) {
			check = null;
			check = inserirCombo(tarefa);
			quadroInterno.getChildren().add(check);
			checkboxes.add(check);
		}
		HBox controles = new HBox(25.0);
		
		controles.getChildren().addAll(voltar, selecionar);
		controles.setAlignment(Pos.BOTTOM_CENTER);
		quadroInterno.getChildren().add(controles);
				
		voltar.setOnAction(e ->{
			
		});
		
		selecionar.setOnAction(e->{
			int tamanhoLista = checkboxes.size();
			int i = 0;
			for(CheckBox c:checkboxes) {
				if(c.isSelected()) {
					try {
						OutputStream os = new FileOutputStream("TriagemInicial.json");
						Writer wr = new OutputStreamWriter(os);
						BufferedWriter br = new BufferedWriter(wr);
						String tarefa = i<tamanhoLista ? c.getText()+"," : c.getText();
						br.write("[\r\n"
								+ "	{\r\n"
								+ "		\"robo\": \"tjma.PAGE.pje215.geral.TriagemInicial_Page\",\r\n"
								+ "		\"qtdRobos\": \"1\", \r\n"
								+ "		\"navegador\": \"CHROME\",\r\n"
								+ "		\"url\": \"https://pjeih.tjma.jus.br/pje/login.seam\",\r\n"
								+ "		\"perfis\": [\r\n"
								+ "				\"2ª Vara da Fazenda Pública de São Luís / Secretaria / Diretor de Secretaria\"\r\n"
								+ "\r\n"
								+ "		],\r\n"
								+ "		\"tarefas\": [\r\n"
								+ "				\"" + tarefa + "\"\r\n"
								+ "		 ],\r\n"
								+ "		\"deletarArquivo\":\"não\",\r\n"
								+ "		\"fonteDeDados\":\"TAREFA\",\r\n"
								+ "		\"filtrarEtiqueta\":\"1.\",\r\n"
								+ "		\"documentosProcesso\":[\r\n"
								+ "								\"Selecione\"\r\n"
								+ "		],\r\n"
								+ "		\"caminhoDownload\": \"C:/Users/wcmsodre/Downloads/\",\r\n"
								+ "		\"usuario\":\"67324134300\",\r\n"
								+ "		\"senha\":\"pje123456\"\r\n"
								+ "	}\r\n"
								+ "]");
						i++;
				        br.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		//Preparando a exibição da tela
		Scene cena = new Scene(quadroInterno,750.0, 650.0);
		//adicionando a um elemento as configuraçãos da classe .container definida no css
		//Importando o css criado para minha classe:
		String caminhoCss = getClass()
				.getResource("/telaRobo/PrimeiroFx.css")
				.toExternalForm();
		cena.getStylesheets().add(caminhoCss);
		primaryStage.setScene(cena);
		primaryStage.show();		
	}
	
	public CheckBox inserirCombo(String tarefa) {
		CheckBox checkbox = new CheckBox(tarefa);
		checkbox.setAccessibleHelp("Selecionar "+tarefa);
		return checkbox;
	}
	
	//para rodar:
	public static void main(String[] args) {
		launch(args);
	}

}
