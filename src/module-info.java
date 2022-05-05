module telaRobo {
	requires javafx.controls;
	requires javafx.graphics;
	opens com.google.api.apicommon;
	opens com.google.api.client;
	opens com.google.api.client.extensions.appengine;
	opens com.google.api.client.auth;
	opens com.google.api.client.http.apache.v2;
	opens com.google.api.client.json.gson;
	opens com.google.api.client.json.jackson2;
	opens com.google.api.services.storage;
	opens com.google.auth;
	opens com.google.auth.oauth2;
	opens com.google.common;
	opens com.google.errorprone.annotations;
	opens com.google.gson;
	opens com.google.protobuf;
	opens com.google.protobuf.util;
	opens firebase.admin;
	
	
	//Precisa da abertura de todo o pacote para
	//que o fx possa fazer a reflecion da main
	opens telaRobo;
	opens images;
	opens infra;
	
	
}