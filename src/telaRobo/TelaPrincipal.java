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
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableDoubleValue;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
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
	public List<String> perfis = new ArrayList<>();
	public Scene tarefaScene;
	public Scene telaPrincipal;
	private Stage primaryStage;
	private Tarefas tarefas = new Tarefas();
	private List<CheckBox> checkboxes = new ArrayList<CheckBox>();
	int tamanhoLista = 0; //tamanho da lista de tarefas
	
	
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
		coluna.setPercentWidth(14);
		coluna.setFillWidth(true);
		return coluna;
	}
	
	public ColumnConstraints colunasTarefas(double percentualLargura) {
		ColumnConstraints coluna = new ColumnConstraints();
		coluna.setPercentWidth(percentualLargura);
		coluna.setFillWidth(true);
		return coluna;
	}

	// cria as linhas da grid
	public RowConstraints linhas() {
		RowConstraints linha = new RowConstraints();
		linha.setPercentHeight(10);
		linha.setFillHeight(true);
		linha.setValignment(VPos.CENTER);
		linha.setVgrow(Priority.ALWAYS);
		return linha;
	}
	
	public RowConstraints linhasTarefas(double percentualAltura) {
		RowConstraints linha = new RowConstraints();
		linha.setFillHeight(true);
		linha.setValignment(VPos.CENTER);
		linha.setVgrow(Priority.ALWAYS);
		return linha;
	}

	public void telaPrincipal() {
		// Caixa na vertical (alinha os elementos na vertical)
		HBox tela = new HBox();
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
		/*
		 * BackgroundImage imagemFundoToada = new BackgroundImage(fundo,
		 * BackgroundRepeat.SPACE, null, BackgroundPosition.CENTER, new
		 * BackgroundSize(1000, 650, false, false, false, false));
		 */

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
		telaPrincipal = new Scene(tela, 1000, 700);
		// e depois, eu vinculo a cena ao palco
		primaryStage.setScene(telaPrincipal);

		// Componentes da página
		Button botaoCadastrar = new Button("Iniciar Triagem");
		Label navegadorLabel = new Label("Navegador");
		Label perfilLabel = new Label("Perfil");
		Label tarefasLabel = new Label("Tarefas");
		Label filtrarLabel = new Label("Filtrar");
		perfis = new Perfil().getPerfis();

		ComboBox<String> perfilComboBox = new ComboBox<String>();
		ComboBox<String> navegadorComboBox = new ComboBox<String>();
		Button tarefasButton = new Button("Selecione as tarefas aqui.");
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
		tela.getStylesheets().add(caminhoCss);
		containerInterno.getStylesheets().add(caminhoCss);

		tela.getStyleClass().add("container");
		botaoCadastrar.getStyleClass().addAll("fonteGeral", "botao");
		botaoCadastrar.getStyleClass().add(fonteGeral);
		navegadorLabel.getStyleClass().add("fontLabelAssitant");
		navegadorLabel.getStyleClass().add(fontLabelAssitant);
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
		containerInterno.add(navegadorLabel, 0, 3, 3, 1);// coluna, linha, colspan, rowspan
		containerInterno.add(perfilLabel, 0, 4, 3, 1);
		containerInterno.add(tarefasLabel, 0, 5, 3, 1);
		containerInterno.add(filtrarLabel, 0, 6, 3, 1);

		containerInterno.add(navegadorComboBox, 3, 3, 6, 1);
		containerInterno.add(perfilComboBox, 3, 4, 6, 1);
		containerInterno.add(tarefasButton, 3, 5, 6, 1);
		containerInterno.add(filtrarTextField, 3, 6, 8, 1);

		containerInterno.add(botaoCadastrar, 0, 9, 10, 1);

		tela.getChildren().add(containerInterno);
		tela.setBackground(Background.fill(gradiente(0, 0, 1, 0,
				new Stop[] { new Stop(0, Color.valueOf("#C33764")), new Stop(0.5, Color.CADETBLUE), new Stop(1, Color.valueOf("#1D2671")) })));

		

		containerInterno.setAlignment(Pos.CENTER);
		containerInterno.setHgap(2.0);
		containerInterno.setVgap(3.0);

		// adicionando textos de ajuda para servidores cegos
		filtrarLabel.setAccessibleHelp("Filtrar");
		tarefasLabel.setAccessibleHelp("Tarefas");
		perfilLabel.setAccessibleHelp("Perfil");
		navegadorLabel.setAccessibleHelp("Navegador de Internet");
		tarefasButton.setAccessibleHelp("Selecionar as tarefas com que deseja trabalhar");
		filtrarTextField.setAccessibleHelp("Informe o texto da etiqueta que deseja filtrar.");
		perfilComboBox
				.setAccessibleHelp("Selecione o perfil do usuário usado no PJE para realizar a triagem de processos.");
		botaoCadastrar.setAccessibleHelp("Iniciar Triagem - clique aqui para iniciar a triagem.");

		// --------ESTILIZAÇÃO ---------:
		containerInterno.setBackground(Background.fill(gradiente(0, 1, 1, 0,
				new Stop[] { new Stop(0, Color.valueOf("#3494E6")),  new Stop(1, Color.valueOf("#A7BFE8")) })));

		containerInterno.setBorder(Border.stroke(Paint.valueOf("#0000FF")));
		containerInterno.setMinSize(450.0, 350.0);
		containerInterno.setMaxSize(500.0, 550.0);
		containerInterno.setPadding(new Insets(20, 30, 20, 30));
		containerInterno.setAlignment(Pos.CENTER);

		containerPerfil.setMaxSize(400.0, 100.0);
		containerTarefas.setMaxSize(400.0, 100.0);
		containerFiltrar.setMaxSize(400.0, 100.0);

		double tamanhoIdeal = (containerInterno.getMinWidth() / 10.0) * 6.8;
		System.out.println(tamanhoIdeal);
		// Definindo tamanho mínimo dos componentes pelo tamanho do tamanho do
		// "conteudoInterno"
		navegadorComboBox.setMinWidth(tamanhoIdeal);
		navegadorComboBox.setMaxWidth(tamanhoIdeal);
		perfilComboBox.setMinWidth(tamanhoIdeal);
		perfilComboBox.setMaxWidth(tamanhoIdeal);
		tarefasButton.setMinWidth(tamanhoIdeal);
		tarefasButton.setMaxWidth(tamanhoIdeal);
		botaoCadastrar.setMinWidth(containerInterno.getMinWidth());
		botaoCadastrar.setMaxWidth(containerInterno.getMinWidth());

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
		
		primaryStage.centerOnScreen();
		VBox conteudoGeral = new VBox(20.0);
		conteudoGeral.setPadding(new Insets(5.0,0.0, 30.0,5.0));
		ScrollPane tela = new ScrollPane();
		
		GridPane quadroDeTarefas = new GridPane();
		quadroDeTarefas.setPadding(new Insets(20.0, 10.0, 10.0, 5.0));
		quadroDeTarefas.setAccessibleHelp("Quadro de tarefas");
		quadroDeTarefas.setAccessibleRoleDescription("Quadro de tarefas.");
		quadroDeTarefas
				.setAccessibleText("Clique na tarefa para selecioná-la. Você pode selecionar mais de uma tarefa.");
		quadroDeTarefas.setAlignment(Pos.CENTER);
		//quadroDeTarefas.setMinSize(900.0, 690.0);
		quadroDeTarefas.autosize();
		quadroDeTarefas.layout();
		
		
		//quadroDeTarefas.prefWidthProperty().bind(ObservableValue<Number> primaryStage.getWidth()); 
		//quadroDeTarefas.prefHeightProperty().bind(alturaDaTela);
		
		quadroDeTarefas.getRowConstraints().add(linhasTarefas(30));
		CheckBox selecionarTudo = new CheckBox("Selecionar ou Desmarcar Todas as Tarefas");
		conteudoGeral.getChildren().add(selecionarTudo);
		quadroDeTarefas.setAlignment(Pos.CENTER);


		Button selecionar = new Button("Selecionar");
		selecionar.getStyleClass().add("botao");
		selecionar.getStyleClass().add(fonteGeral);
		Button voltar = new Button("Voltar");
		voltar.getStyleClass().add("botaoCancelar");
		voltar.getStyleClass().add(fonteGeral);

		selecionar.setAccessibleHelp("Concluir seleção de tarefas");
		voltar.setAccessibleHelp("Voltar para a tela inicial");
		
		CheckBox checkInseridoNaTela = new CheckBox();
		checkInseridoNaTela.getStyleClass().add("fontLabelAssitant");
		checkInseridoNaTela.getStyleClass().add(fonteGeral);

		int quantidadeTarefas = tarefas.getTarefas().size();
		// número de linhas e colunas da grid: dividir as tarefas em grupos de 2 + 1coluna para o scroll
		// coluna para o scroll
		int auxiliarPosicaoLinha = 1;
		int auxiliarPosicaoColuna = 0;

		for (int i = 0; i < quantidadeTarefas/2; i++) {
			quadroDeTarefas.getRowConstraints().add(linhasTarefas(10));
		}
		//duas colunas para cada tarefa
		quadroDeTarefas.getColumnConstraints().addAll(colunasTarefas(40), colunasTarefas(40), 
				 colunasTarefas(1));

		// adicionando os nodes (elementos)
		for (String tarefa : tarefas.getTarefas()) {
			  checkInseridoNaTela = null; 
			  checkInseridoNaTela = inserirCombo(tarefa); 
			  quadroDeTarefas.add(checkInseridoNaTela, auxiliarPosicaoColuna, auxiliarPosicaoLinha, 1, 1);
			  checkboxes.add(checkInseridoNaTela);
			  auxiliarPosicaoColuna++;
			  
			  if(auxiliarPosicaoColuna > 1) {
				  auxiliarPosicaoLinha++;
				  auxiliarPosicaoColuna = 0;
			  }
		}
		
		quadroDeTarefas.setGridLinesVisible(true);

		HBox controles = new HBox(100.0);
		controles.getChildren().addAll(voltar, selecionar);
		controles.setAlignment(Pos.BOTTOM_CENTER);

		
		// Importando o css criado para minha classe:
		String caminhoCss = getClass().getResource("/telaRobo/PrimeiroFx.css").toExternalForm();
		quadroDeTarefas.getStylesheets().add(caminhoCss);
		quadroDeTarefas.getStyleClass().add("quadroDeTarefas");
		tela.getStylesheets().add(caminhoCss);
		tela.getStyleClass().add("quadroDeTarefas");
		
		tela.setFitToHeight(true);
		tela.setFitToWidth(true);
		tela.autosize();
		tela.setCenterShape(true);
		conteudoGeral.getChildren().addAll(quadroDeTarefas, controles);
		tela.setContent(conteudoGeral);
		
		
		//Botão voltar
		voltar.setOnAction(e -> {
			primaryStage.setScene(telaPrincipal);
		});
		
		//selecionar/desmarcar tudo
		selecionarTudo.setOnAction(e->{

			if(selecionarTudo.isSelected()) {
				for(CheckBox c: checkboxes) {
					c.setSelected(true);
				}
			}
			if(!selecionarTudo.isSelected()) { 
				for(CheckBox c: checkboxes) {
				    c.setSelected(false); 
				}
			}
				 
			
		});
		

		//botão selecionar tarefas
		selecionar.setOnAction(e -> {
			for (CheckBox c : checkboxes) {
				if (c.isSelected()) {
					tamanhoLista++;
				}
			}
			System.out.println(tamanhoLista);
			int aux = 0;
			String tarefasSelecionadas = "";
			for (CheckBox c : checkboxes) {
				if (c.isSelected()) {
					System.out.println("I: " + aux);
					if (aux < tamanhoLista - 1) {
						tarefasSelecionadas = tarefasSelecionadas.concat("\r\"" + c.getText() + "\" ," + "\r\n");
						System.out.println(tarefasSelecionadas);
					} else {
						tarefasSelecionadas += "\r\"" + c.getText() + "\"";
					}

					aux++;
				}
				try {
					OutputStream os = new FileOutputStream("TriagemInicial.json");
					Writer wr = new OutputStreamWriter(os);
					BufferedWriter br = new BufferedWriter(wr);
					br.write("[\r\n"
							+ "	{\r\n"
							+ "		\"robo\": \"tjma.PAGE.pje215.geral.TriagemInicial_Page\",\r\n"
							+ "		\"qtdRobos\": \"1\", \r\n"
							+ "		\"timeout\": \"3\",\r\n"
							+ "		\"navegador\": \"CHROME\",\r\n"
							+ "		\"url\": \"https://pje2.tjma.jus.br\",\r\n"
							+ "		\"perfis\": [\r\n"
							+ "				\"1ª Turma Recursal Permanente da Comarca da Ilha de São Luís / Gabinete do 1º Cargo da 1ª Turma Recursal Cível e Criminal de São Luis / Assessoria / Assessor\"\r\n"
							+ "\r\n"
							+ "		],\r\n"
							+ "		\"tarefas\": [\r\n"
							+ "          "+tarefasSelecionadas		
							+ "		 ],\r\n"
							+ "		\"filtrarEtiqueta\":\"ISOLDA - ANALISAR\",\r\n"
							+ "		\"deletarArquivo\":\"não\",\r\n"
							+ "		\"fonteDeDados\":\"TAREFA\",\r\n"
							+ "		\"documentosProcesso\":[\r\n"
							+ "								\"Sentença\",\r\n"
							+ "								\"Contrarrazões\",\r\n"
							+ "								\"Ata de audiência\",\r\n"
							+ "								\"Recurso Inominado\" \r\n"
							+ "		],\r\n"
							+ "		\"caminhoDownload\": \"C:/Users/173278/Downloads/\"\r\n"
							+ "	}\r\n"
							+ "]");
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			primaryStage.setScene(telaPrincipal);
		});

		// Preparando a exibição da tela
		tarefaScene = new Scene(tela, primaryStage.getWidth(), primaryStage.getHeight());

	}

	public CheckBox inserirCombo(String tarefa) {
		CheckBox checkbox = new CheckBox(tarefa);
		checkbox.setAccessibleHelp("Selecionar " + tarefa);
		checkbox.setManaged(true);
		checkbox.accessibleHelpProperty().set("Selecionar " + tarefa);
		checkbox.setOnAction(e -> {
			checkbox.setAccessibleHelp("Selecionar " + tarefa);
		});
		return checkbox;

	}
	
}
