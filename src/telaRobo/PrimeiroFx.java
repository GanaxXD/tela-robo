package telaRobo;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class PrimeiroFx extends Application{
	
	public String fonteAssistent = "https://fonts.googleapis.com/css2?family=Assistant:wght@300&display=swap";
	public String fonteAssistentLabel = "https://fonts.googleapis.com/css2?family=Assistant:wght@700;800&display=swap";
	public Image tjIcon = new Image("images/tjlogo.png");
	public Image toadaIcon = new Image("images/ToadaLab.png");
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Robô Triador - Tela de Configuração");
		primaryStage.centerOnScreen();
		primaryStage.getIcons().add(tjIcon);
		
		//Caixa na vertical (alinha os elementos na vertical)
		VBox containerExterno = new VBox(50.0);
		VBox containerInterno = new VBox(10.0);
		HBox perfil = new HBox();
		HBox tarefas = new HBox();
		
		perfil.setMaxSize(600, 120);
		tarefas.setMaxSize(600, 200);
		
		
		//Botões
		Button botaoCadastrar = new Button("Cadastar");
		
		Label labelPerfil = new Label("Perfil");
		Label labelTarefas = new Label("Tarefas");
		Label labelFiltro = new Label("Filtrar?");
		TextField inputPerfil = new TextField();
		TextField inputTarefas = new TextField();
		
		
		//Vinculando o botão dentro da caixa inicial
		containerInterno.getChildren()
			.addAll(perfil, tarefas);
		
		containerExterno.getChildren().add(containerInterno);
		
		Stop[] cores = new Stop[] {new Stop(0, Color.WHITE), new Stop(0.5, Color.AQUAMARINE), new Stop(1, Color.CADETBLUE)};
		LinearGradient gradiente = new LinearGradient(0, 0, 1, 0, true,CycleMethod.NO_CYCLE, cores);
		
		//Centralizando
		containerExterno.setAlignment(Pos.CENTER);
		//Adicionando cores
		containerInterno.setBackground(Background.fill(
				gradiente
			//Paint.valueOf("linear-gradient(from 0% 0% to 100% 100%, red  -10% , blue 38%,  black 0%)")
			)
		);
		
		
		//Definindo espaçamento entre os elementos
		containerExterno.setSpacing(60);
		
		//No Fx, eu tenho dois elementos: O palco (stage) e a Cena (Scene)
		//Sempre que eu quiser mostrar uma cena (um conjunto organizado de componentes),
		//eu devo adicionar à cena o mesmo.
		//O exemplo abaixo faz isso: adiciono a caixa com seus elementos à cena
		//Depois dos elementos vinculados à cena, eu passo o tamanho da tela (w, h)
		Scene cena = new Scene(containerExterno, 1300, 760);
		
		//Adicionando uma função ao pressionar o botão:
		botaoCadastrar.setOnAction(e ->{
			System.exit(0);
		});
		
		
		//Importando o css criado para minha classe:
		String caminhoCss = getClass()
				.getResource("/telaRobo/PrimeiroFx.css")
				.toExternalForm();
		
		cena.getStylesheets().add(caminhoCss);
		
		inputPerfil.setMaxSize(450.0, 80.0);
		inputTarefas.setMaxSize(450.0, 80.0);
		inputPerfil.getStyleClass().add("input");
		inputTarefas.getStyleClass().add("input");
		
		
		perfil.getChildren().addAll(labelPerfil, inputPerfil);
		tarefas.getChildren().addAll(labelTarefas, inputTarefas);
		

		containerInterno.getStyleClass().add("containerInterno");
		containerInterno.setAlignment(Pos.CENTER);
		containerInterno.setMaxWidth(650.0);
		containerInterno.setMaxHeight(500);
		containerInterno.setSpacing(20);
		
		
		
		
		//adicionando a um elemento as configuraçãos da classe .container definida no css
		//containerExterno.getStyleClass().add("container");
		
		botaoCadastrar.getStyleClass().addAll("fonteGeral", "botao");
		botaoCadastrar.getStyleClass().add(fonteAssistent);
		
		labelPerfil.getStyleClass().add(fonteAssistentLabel);
		labelTarefas.getStyleClass().add(fonteAssistentLabel);
		labelFiltro.getStyleClass().add(fonteAssistentLabel);
		labelPerfil.getStyleClass().add("fonteLabel");
		labelTarefas.getStyleClass().add("fonteLabel");
		labelFiltro.getStyleClass().add("fonteLabel");
		
		//e depois, eu vinculo a cena ao palco
		primaryStage.setScene(cena);
		
		primaryStage.show();
	}

	//para rodar:
	public static void main(String[] args) {
		launch(args);
	}
}
