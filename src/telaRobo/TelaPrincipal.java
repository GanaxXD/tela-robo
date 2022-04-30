package telaRobo;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
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
import javafx.scene.layout.FlowPane;
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

public class TelaPrincipal extends Application {

	public String fonteGeral = "https://fonts.googleapis.com/css2?family=Assistant:wght@300&display=swap";
	public String fontLabelAssitant = "https://fonts.googleapis.com/css2?family=Assistant:wght@800&display=swap";
	public Image tjIcon = new Image("images/tjlogo.png");
	public Image toadaIcon = new Image("images/toadaIcon.png");
	public Image fundo = new Image("images/fundo.jpg");
	public List<String> perfis = new ArrayList<>();
	public Scene tarefaScene;
	public Scene telaPrincipal;
	private Stage primaryStage;
	private Tarefas tarefas = new Tarefas();
	private List<CheckBox> checkboxes = new ArrayList<CheckBox>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		telaPrincipal();
		primaryStage.setScene(telaPrincipal);
		primaryStage.show();
	}

	// para rodar:
	public static void main(String[] args) {
		launch(args);
	}

	// cria o gradiente
	public static LinearGradient gradiente(int inicioX, int inicioY, int fimX, int fimY, Stop... cores) {
		Stop[] coresGradiente = cores;
		LinearGradient lg = new LinearGradient(inicioX, inicioY, fimX, fimY, true, CycleMethod.REFLECT, coresGradiente);
		return lg;
	}

	// cria as colunas da grid
	public ColumnConstraints colunas() {
		ColumnConstraints coluna = new ColumnConstraints();
		coluna.setPercentWidth(10);
		coluna.setFillWidth(true);
		return coluna;
	}

	// cria as linhas da grid
	public RowConstraints linhas() {
		RowConstraints linha = new RowConstraints();
		linha.setPercentHeight(10);
		linha.setFillHeight(true);
		linha.setValignment(VPos.CENTER);
		linha.setFillHeight(true);
		return linha;
	}

	public void telaPrincipal() {
		// Caixa na vertical (alinha os elementos na vertical)
		VBox tela = new VBox();
		// VBox containerInterno = new VBox(10.0);
		HBox containerPerfil = new HBox(10.0);
		HBox containerTarefas = new HBox(10.0);
		HBox containerFiltrar = new HBox(10.0);
		HBox containerToada = new HBox(10.0);
		GridPane containerInterno = new GridPane();
		containerInterno.setGridLinesVisible(true);

		// preenchendo a grid com linhas e colunas
		containerInterno.getColumnConstraints().addAll(colunas(), colunas(), colunas(), colunas(), colunas(), colunas(),
				colunas(), colunas(), colunas(), colunas());

		containerInterno.getRowConstraints().addAll(linhas(), linhas(), linhas(), linhas(), linhas(), linhas(),
				linhas(), linhas(), linhas(), linhas());

		// conteudoInterno.setHgap(10.0);
		BackgroundImage imagemFundoToada = new BackgroundImage(fundo, BackgroundRepeat.SPACE, null,
				BackgroundPosition.CENTER, new BackgroundSize(1000, 650, false, false, false, false));

		primaryStage.setTitle("Rôbo Triador - Tela de configuração");
		primaryStage.centerOnScreen();
		primaryStage.getIcons().add(tjIcon);
		primaryStage.setMinHeight(670.0);
		primaryStage.setMinWidth(580.0);

		// tela.setBackground(new Background(imagemFundoToada));
		tela.setBackground(Background.fill(
				gradiente(0, 0, 1, 1, new Stop[] { new Stop(0, Color.ALICEBLUE), new Stop(1, Color.CORNFLOWERBLUE) })));

		// No Fx, eu tenho dois elementos: O palco (stage) e a Cena (Scene)
		// Sempre que eu quiser mostrar uma cena (um conjunto organizado de
		// componentes),
		// eu devo adicionar à cena o mesmo.
		// O exemplo abaixo faz isso: adiciono a caixa com seus elementos à cena
		// Depois dos elementos vinculados à cena, eu passo o tamanho da tela (w, h)
		telaPrincipal = new Scene(tela, 1000, 650);
		// e depois, eu vinculo a cena ao palco
		primaryStage.setScene(telaPrincipal);

		// Componentes da página
		Button botaoCadastrar = new Button("Iniciar Triagem");
		Label navegador = new Label("Navegador");
		Label perfilLabel = new Label("Perfil");
		Label tarefasLabel = new Label("Tarefas");
		Label filtrarLabel = new Label("Filtrar");
		perfis = new Perfil().getPerfis();

		ComboBox<String> perfilComboBox = new ComboBox<String>();
		ComboBox<String> navegadorComboBox = new ComboBox<String>();
		Button tarefasButton = new Button();
		TextField filtrarTextField = new TextField();

		perfilComboBox.setEditable(false);
		navegadorComboBox.setEditable(false);
		for (String p : perfis) {
			perfilComboBox.getItems().add(p);
		}

		navegadorComboBox.getItems().addAll("CHROME", "OPERA", "FIREFOX");


		// adicionando a um elemento as configuraçãos da classe .container definida no
		// css
		// Importando o css criado para minha classe:
		String caminhoCss = getClass().getResource("/telaRobo/PrimeiroFx.css").toExternalForm();
		telaPrincipal.getStylesheets().add(caminhoCss);
		tela.getStyleClass().add("container");
		botaoCadastrar.getStyleClass().addAll("fonteGeral", "botao");
		botaoCadastrar.getStyleClass().add(fonteGeral);
		navegador.getStyleClass().add("fontLabelAssitant");
		navegador.getStyleClass().add(fontLabelAssitant);
		navegadorComboBox.getStyleClass().add("comboBox");
		perfilLabel.getStyleClass().add("fontLabelAssitant");
		perfilLabel.getStyleClass().add(fontLabelAssitant);
		tarefasLabel.getStyleClass().add("fontLabelAssitant");
		tarefasLabel.getStyleClass().add(fontLabelAssitant);
		filtrarLabel.getStyleClass().add("fontLabelAssitant");
		filtrarLabel.getStyleClass().add(fontLabelAssitant);
		filtrarTextField.getStyleClass().add("textfield");
		perfilComboBox.getStyleClass().add("textfield");
		tarefasButton.getStyleClass().add("botaoSelecionarTarefas");

		// Vinculando componentes na tela
		containerPerfil.getChildren().addAll(perfilLabel, perfilComboBox);
		containerTarefas.getChildren().addAll(tarefasLabel, tarefasButton);
		containerFiltrar.getChildren().addAll(filtrarLabel, filtrarTextField);
		// containerInterno.getChildren().addAll(containerPerfil, containerTarefas,
		// containerFiltrar, botaoCadastrar);
		containerInterno.add(navegador, 0, 3, 2, 1);// coluna, linha, colspan, rowspan
		containerInterno.add(perfilLabel, 0, 4, 3, 1);
		containerInterno.add(tarefasLabel, 0, 5, 4, 1);
		containerInterno.add(filtrarLabel, 0, 6, 5, 1);

		containerInterno.add(navegadorComboBox, 2, 3, 8, 1);
		containerInterno.add(perfilComboBox, 2, 4, 8, 1);
		containerInterno.add(tarefasButton, 2, 5, 8, 1);
		containerInterno.add(filtrarTextField, 2, 6, 8, 1);

		containerInterno.add(botaoCadastrar, 0, 9, 9, 1);

		tela.getChildren().add(containerInterno);

		// containerInterno.setAlignment(Pos.CENTER);
		containerInterno.setHgap(2.0);
		GridPane.setFillHeight(botaoCadastrar, true);
		GridPane.setConstraints(botaoCadastrar, 0, 9);

		// adicionando textos de ajuda para servidores cegos
		filtrarLabel.setAccessibleHelp("Filtrar");
		tarefasLabel.setAccessibleHelp("Tarefas");
		perfilLabel.setAccessibleHelp("Perfil");
		navegador.setAccessibleHelp("Navegador de Internet");
		tarefasButton.setAccessibleHelp("Selecionar as tarefas com que deseja trabalhar");
		filtrarTextField.setAccessibleHelp("Informe o texto da etiqueta que deseja filtrar.");
		perfilComboBox
				.setAccessibleHelp("Selecione o perfil do usuário usado no PJE para realizar a triagem de processos.");
		botaoCadastrar.setAccessibleHelp("Iniciar Triagem - clique aqui para iniciar a triagem.");

		// --------ESTILIZAÇÃO ---------:
		containerInterno.setBackground(Background.fill(gradiente(0, 0, 1, 0,
				new Stop[] { new Stop(0, Color.WHITE), new Stop(0.5, Color.CADETBLUE), new Stop(1, Color.BLUE) })));

		containerInterno.setBorder(Border.stroke(Paint.valueOf("#0000FF")));
		containerInterno.setPrefSize(400.0, 600.0);
		containerInterno.setMaxSize(500.0, 650.0);
		containerInterno.setPadding(new Insets(20, 30, 20, 30));
		containerPerfil.setMaxSize(400.0, 100.0);
		containerTarefas.setMaxSize(400.0, 100.0);
		containerFiltrar.setMaxSize(400.0, 100.0);

		// Centralizando e estilizando a página
		tela.setAlignment(Pos.CENTER);

		// Definindo espaçamento entre os elementos
		tela.setSpacing(30.0);

		// Adicionando uma função ao pressionar o botão:
		tarefasButton.setOnAction(e -> {
			telaTarefas();
			primaryStage.setScene(tarefaScene);
		});
		botaoCadastrar.setOnAction(e -> {
			System.exit(0);
		});

	}

	// tela de tarefas
	public void telaTarefas() {
		FlowPane quadroInterno = new FlowPane(10.0, 5.0);
		quadroInterno.setMinSize(775.0, 625.0);
		quadroInterno.setPadding(new Insets(20.0, 10.0, 10.0, 20.0));
		quadroInterno.isResizable();

		Button selecionar = new Button("Selecionar");
		selecionar.getStyleClass().add("botao");
		selecionar.getStyleClass().add(fonteGeral);
		Button voltar = new Button("Voltar");
		voltar.getStyleClass().add("botaoCancelar");
		voltar.getStyleClass().add(fonteGeral);

		selecionar.setAccessibleHelp("Concluir seleção de tarefas");
		voltar.setAccessibleHelp("Voltar para a tela inicial");

		CheckBox check = new CheckBox();
		check.getStyleClass().add("fontLabelAssitant");
		check.getStyleClass().add(fonteGeral);

		// adicionando os nodes (elementos)
		for (String tarefa : tarefas.getTarefas()) {
			check = null;
			check = inserirCombo(tarefa);
			quadroInterno.getChildren().add(check);
			checkboxes.add(check);
		}
		HBox controles = new HBox(25.0);

		controles.getChildren().addAll(voltar, selecionar);
		controles.setAlignment(Pos.BOTTOM_CENTER);
		quadroInterno.getChildren().add(controles);

		// Importando o css criado para minha classe:
		String caminhoCss = getClass().getResource("/telaRobo/PrimeiroFx.css").toExternalForm();
		quadroInterno.getStylesheets().add(caminhoCss);

		voltar.setOnAction(e -> {
			primaryStage.setScene(telaPrincipal);
		});

		selecionar.setOnAction(e -> {
			int tamanhoLista = 0;
			for(CheckBox c : checkboxes) {
				if(c.isSelected()) {
					tamanhoLista++;
				}
			}
			System.out.println(tamanhoLista);
			int aux = 0;
			String tarefasSelecionadas = "";
			for (CheckBox c : checkboxes) {
				if (c.isSelected()) {
					System.out.println("I: "+aux);
					if (aux < tamanhoLista-1) {
						tarefasSelecionadas = tarefasSelecionadas.concat("\r\""+c.getText()+"\" ," +"\r\n");
						System.out.println(tarefasSelecionadas);
					} else {
						tarefasSelecionadas += "\r\""+c.getText()+"\"";
					}

					aux++;
				}
				try {
					OutputStream os = new FileOutputStream("TriagemInicial.json");
					Writer wr = new OutputStreamWriter(os);
					BufferedWriter br = new BufferedWriter(wr);
					br.write("[\r\n" + "	{\r\n"
							+ "		\"robo\": \"tjma.PAGE.pje215.geral.TriagemInicial_Page\",\r\n"
							+ "		\"qtdRobos\": \"1\", \r\n" + "		\"navegador\": \"CHROME\",\r\n"
							+ "		\"url\": \"https://pjeih.tjma.jus.br/pje/login.seam\",\r\n"
							+ "		\"perfis\": [\r\n"
							+ "				\"2ª Vara da Fazenda Pública de São Luís / Secretaria / Diretor de Secretaria\"\r\n"
							+ "\r\n" 
							+ "		],\r\n" 
							+ "		\"tarefas\": [\r\n" 
							+ "				"+tarefasSelecionadas + "\r\n" 
							+ "		 ],\r\n"
							+ "		\"deletarArquivo\":\"não\",\r\n" + "		\"fonteDeDados\":\"TAREFA\",\r\n"
							+ "		\"filtrarEtiqueta\":\"1.\",\r\n" + "		\"documentosProcesso\":[\r\n"
							+ "								\"Selecione\"\r\n" + "		],\r\n"
							+ "		\"caminhoDownload\": \"C:/Users/wcmsodre/Downloads/\",\r\n"
							+ "		\"usuario\":\"67324134300\",\r\n" + "		\"senha\":\"pje123456\"\r\n"
							+ "	}\r\n" + "]");
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			primaryStage.setScene(telaPrincipal);
		});

		// Preparando a exibição da tela
		tarefaScene = new Scene(quadroInterno, 750.0, 650.0);

	}

	public CheckBox inserirCombo(String tarefa) {
		CheckBox checkbox = new CheckBox(tarefa);
		checkbox.setAccessibleHelp("Selecionar " + tarefa);
		checkbox.setOnAction(e -> {
			checkbox.setAccessibleHelp("Selecionar " + tarefa);
		});
		return checkbox;

	}
}
