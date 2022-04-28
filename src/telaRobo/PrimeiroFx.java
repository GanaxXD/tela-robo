package telaRobo;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class PrimeiroFx extends Application{
	
	public String fonteGeral = "https://fonts.googleapis.com/css2?family=Assistant:wght@300&display=swap";
	public String fontLabelAssitant = "https://fonts.googleapis.com/css2?family=Assistant:wght@800&display=swap";
	public Image tjIcon = new Image("images/tjlogo.png");
	public Image toadaIcon = new Image("images/toadaIcon.png");
	public Image fundo = new Image("images/fundo.jpg");
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Caixa na vertical (alinha os elementos na vertical)
		VBox tela = new VBox();
		//VBox containerInterno = new VBox(10.0);
		HBox containerPerfil = new HBox(10.0);
		HBox containerTarefas = new HBox(10.0);
		HBox containerFiltrar = new HBox(10.0);
		HBox containerToada = new HBox(10.0);
		GridPane containerInterno = new GridPane();
		containerInterno.setGridLinesVisible(true);
		
		//preenchendo a grid com linhas e colunas
		containerInterno.getColumnConstraints()
			.addAll(
					colunas(), colunas(), 
					colunas(), colunas(), 
					colunas(), colunas(), 
					colunas(), colunas(),
					colunas(), colunas());
		
		containerInterno.getRowConstraints()
		.addAll(
				linhas(), linhas(), 
				linhas(), linhas(), 
				linhas(), linhas(), 
				linhas(), linhas(),
				linhas(), linhas());
		
		
		
		//conteudoInterno.setHgap(10.0);
		BackgroundImage imagemFundoToada = new BackgroundImage(
				fundo, 
				BackgroundRepeat.SPACE,
				null,
				BackgroundPosition.CENTER,
				new BackgroundSize(1000, 650, false, false, false, false));
				
		primaryStage.setTitle("Rôbo Triador - Tela de configuração");
		primaryStage.centerOnScreen();
		primaryStage.getIcons().add(tjIcon);
		primaryStage.setMinHeight(654.0);
		primaryStage.setMinWidth(546.0);
		
		//tela.setBackground(new Background(imagemFundoToada));
		tela.setBackground(Background.fill(
				gradiente(0, 0, 1, 1, new Stop[] {
						new Stop(0, Color.ALICEBLUE),
						new Stop(1, Color.CORNFLOWERBLUE)
				}))
		);
		
		
		//No Fx, eu tenho dois elementos: O palco (stage) e a Cena (Scene)
		//Sempre que eu quiser mostrar uma cena (um conjunto organizado de componentes),
		//eu devo adicionar à cena o mesmo.
		//O exemplo abaixo faz isso: adiciono a caixa com seus elementos à cena
		//Depois dos elementos vinculados à cena, eu passo o tamanho da tela (w, h)
		Scene cena = new Scene(tela, 1000, 650);
		//e depois, eu vinculo a cena ao palco
		primaryStage.setScene(cena);
		
		//Componentes da página
		Button botaoCadastrar = new Button("Iniciar Triagem");
		Label perfilLabel = new Label("Perfil");
		Label tarefasLabel = new Label("Tarefas");
		Label filtrarLabel = new Label("Filtrar");
		
		TextField perfilTextField = new TextField();
		TextField tarefasTextField = new TextField();
		TextField filtrarTextField = new TextField();
		
		botaoCadastrar.setMinWidth(400.0);
		botaoCadastrar.setPrefWidth(	00.0);
		
		//adicionando a um elemento as configuraçãos da classe .container definida no css
		//Importando o css criado para minha classe:
		String caminhoCss = getClass()
				.getResource("/telaRobo/PrimeiroFx.css")
				.toExternalForm();
		cena.getStylesheets().add(caminhoCss);
		tela.getStyleClass().add("container");
		botaoCadastrar.getStyleClass().addAll("fonteGeral", "botao");
		botaoCadastrar.getStyleClass().add(fonteGeral);
		perfilLabel.getStyleClass().add("fontLabelAssitant");
		perfilLabel.getStyleClass().add(fontLabelAssitant);
		tarefasLabel.getStyleClass().add("fontLabelAssitant");
		tarefasLabel.getStyleClass().add(fontLabelAssitant);
		filtrarLabel.getStyleClass().add("fontLabelAssitant");
		filtrarLabel.getStyleClass().add(fontLabelAssitant);
		filtrarTextField.getStyleClass().add("textfield");
		perfilTextField.getStyleClass().add("textfield");
		tarefasTextField.getStyleClass().add("textfield");
		
		//Vinculando componentes na tela
		containerPerfil.getChildren().addAll(perfilLabel, perfilTextField);
		containerTarefas.getChildren().addAll(tarefasLabel, tarefasTextField);
		containerFiltrar.getChildren().addAll(filtrarLabel, filtrarTextField);
		//containerInterno.getChildren().addAll(containerPerfil, containerTarefas, containerFiltrar, botaoCadastrar);
		containerInterno.add(perfilLabel, 0, 3, 3, 1);
		containerInterno.add(tarefasLabel, 0, 4, 4, 1);
		containerInterno.add(filtrarLabel, 0, 5, 5, 1);
		
		containerInterno.add(perfilTextField, 2, 3, 8, 1);
		containerInterno.add(tarefasTextField, 2, 4, 8, 1);
		containerInterno.add(filtrarTextField, 2, 5, 8, 1);
		
		containerInterno.add(botaoCadastrar, 0, 9, 9, 1);
		
		tela.getChildren().add(containerInterno);
		
		//containerInterno.setAlignment(Pos.CENTER);
		containerInterno.setHgap(2.0);
		containerInterno.setFillHeight(botaoCadastrar, true);
		containerInterno.setConstraints(botaoCadastrar, 0, 9);
		
		//adicionando textos de ajuda para servidores cegos
		filtrarLabel.setAccessibleHelp("Filtrar");
		tarefasLabel.setAccessibleHelp("Tarefas");
		perfilLabel.setAccessibleHelp("Perfil");
		tarefasTextField.setAccessibleHelp("Informe as tarefas separadas por vírgulas");
		filtrarTextField.setAccessibleHelp("Informe o texto da etiqueta que deseja filtrar.");
		perfilTextField.setAccessibleHelp("Informe o perfil do usuário usado no PJE para realizar a triagem de processos.");
		botaoCadastrar.setAccessibleHelp("Iniciar Triagem - clique aqui para iniciar a triagem.");
		
		//--------ESTILIZAÇÃO ---------:
		containerInterno.setBackground(Background.fill(
			gradiente(0, 0, 1, 0, new Stop[] {
				new Stop(0, Color.WHITE),
				new Stop(0.5, Color.CADETBLUE),
				new Stop(1, Color.BLUE)
			})
			)
		);
		
		containerInterno.setBorder(Border.stroke(Paint.valueOf("#0000FF")));
		containerInterno.setPrefSize(400.0, 600.0);
		containerInterno.setMaxSize(500.0, 650.0);
		containerInterno.setPadding(new Insets(20, 30, 20, 30));
		containerPerfil.setMaxSize(400.0, 100.0);
		containerTarefas.setMaxSize(400.0, 100.0);
		containerFiltrar.setMaxSize(400.0, 100.0);
		
		//Centralizando e estilizando a página
		tela.setAlignment(Pos.CENTER);
		
		//Definindo espaçamento entre os elementos
		tela.setSpacing(30.0);
		
		
		//Adicionando uma função ao pressionar o botão:
		botaoCadastrar.setOnAction(e ->{
			System.exit(0);
		});
		
		
		primaryStage.show();
	}

	//para rodar:
	public static void main(String[] args) {
		launch(args);
	}
	
	//cria o gradiente
	public static LinearGradient gradiente(int inicioX, int inicioY, int fimX, int fimY, Stop... cores) {
		Stop[] coresGradiente = cores;
		LinearGradient lg = new LinearGradient(inicioX, inicioY, fimX, fimY, true,CycleMethod.REFLECT, coresGradiente);
		return lg;
	}
	
	//cria as colunas da grid
	public ColumnConstraints colunas() {
		ColumnConstraints coluna = new ColumnConstraints();
		coluna.setPercentWidth(10);
		coluna.setFillWidth(true);
		return coluna;
	}
	//cria as linhas da grid
	public RowConstraints linhas() {
		RowConstraints linha = new RowConstraints();
		linha.setPercentHeight(10);
		linha.setFillHeight(true);
		linha.setValignment(VPos.CENTER);
		linha.setFillHeight(true);
		return linha;
	}
}
