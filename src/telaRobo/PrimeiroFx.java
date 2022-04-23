package telaRobo;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PrimeiroFx extends Application{
	
	public String fonteAssistent = "https://fonts.googleapis.com/css2?family=Assistant:wght@300&display=swap";
	public String fonteAssistentLabel = "https://fonts.googleapis.com/css2?family=Assistant:wght@700;800&display=swap";

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Rob� Triador - Tela de Configura��o");
		
		//Caixa na vertical (alinha os elementos na vertical)
		VBox containerExterno = new VBox(50.0);
		VBox containerInterno = new VBox(10.0);
		
		containerInterno.getStyleClass().add("containerInterno");
		containerInterno.setAlignment(Pos.BASELINE_CENTER);
		containerInterno.setMaxWidth(650.0);
		containerInterno.setMaxHeight(500);
		containerInterno.setSpacing(20);
		
		//Bot�es
		Button botaoCadastrar = new Button("Cadastar");
		
		Label labelPerfil = new Label("Perfil");
		Label labelTarefas = new Label("Tarefas");
		Label labelFiltro = new Label("Filtrar?");
		TextField inputPerfil = new TextField();
		TextField inputTarefas = new TextField();
		
		inputPerfil.setMaxSize(450.0, 80.0);
		inputTarefas.setMaxSize(450.0, 80.0);
		
		
		//Vinculando o bot�o dentro da caixa inicial
		containerInterno.getChildren()
			.addAll(labelPerfil, inputPerfil,
					labelTarefas, inputTarefas,
					labelFiltro, botaoCadastrar);
		containerExterno.getChildren().add(containerInterno);
		
		//Centralizando
		containerExterno.setAlignment(Pos.CENTER);
		
		//Definindo espa�amento entre os elementos
		containerExterno.setSpacing(60);
		
		//No Fx, eu tenho dois elementos: O palco (stage) e a Cena (Scene)
		//Sempre que eu quiser mostrar uma cena (um conjunto organizado de componentes),
		//eu devo adicionar � cena o mesmo.
		//O exemplo abaixo faz isso: adiciono a caixa com seus elementos � cena
		//Depois dos elementos vinculados � cena, eu passo o tamanho da tela (w, h)
		Scene cena = new Scene(containerExterno, 1300, 760);
		
		//Adicionando uma fun��o ao pressionar o bot�o:
		botaoCadastrar.setOnAction(e ->{
			System.exit(0);
		});
		
		
		//Importando o css criado para minha classe:
		String caminhoCss = getClass()
				.getResource("/telaRobo/PrimeiroFx.css")
				.toExternalForm();
		
		cena.getStylesheets().add(caminhoCss);
		
		//adicionando a um elemento as configura��os da classe .container definida no css
		containerExterno.getStyleClass().add("container");
		
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
