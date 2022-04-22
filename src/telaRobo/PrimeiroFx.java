package telaRobo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrimeiroFx extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Caixa na vertical (alinha os elementos na vertical)
		VBox container = new VBox();
		
		//Bot�es
		Button botaoCadastrar = new Button("Cadastar");
		
		//Vinculando o bot�o dentro da caixa inicial
		container.getChildren().add(botaoCadastrar);
		//Centralizando
		container.setAlignment(Pos.CENTER);
		
		//Definindo espa�amento entre os elementos
		container.setSpacing(10);
		
		//No Fx, eu tenho dois elementos: O palco (stage) e a Cena (Scene)
		//Sempre que eu quiser mostrar uma cena (um conjunto organizado de componentes),
		//eu devo adicionar � cena o mesmo.
		//O exemplo abaixo faz isso: adiciono a caixa com seus elementos � cena
		//Depois dos elementos vinculados � cena, eu passo o tamanho da tela (w, h)
		Scene cena = new Scene(container, 400, 400);
		
		//Adicionando uma fun��o ao pressionar o bot�o:
		botaoCadastrar.setOnAction(e ->{
			System.exit(0);
		});
		
		//e depois, eu vinculo a cena ao palco
		primaryStage.setScene(cena);
		
		primaryStage.show();
	}

	//para rodar:
	public static void main(String[] args) {
		launch(args);
	}
}
