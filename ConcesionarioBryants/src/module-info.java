module ConcesionarioBryants {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.controls, javafx.fxml;
	opens controller to javafx.fxml;
}
