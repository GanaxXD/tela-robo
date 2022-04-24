module telaRobo {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	
	//Precisa da abertura de todo o pacote para
	//que o fx possa fazer a reflecion da main
	opens telaRobo;
	opens images;
}