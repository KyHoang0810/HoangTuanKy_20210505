package hust.soict.globalict.javafx;

import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class PainterController {
	@FXML
	private Pane drawingAreaPane;
	@FXML
	private RadioButton rbpen;
	@FXML
	void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();
	}
	@FXML
	void drawingAreaMouseDragged(MouseEvent event) {
		if(rbpen.isSelected()) {
			Circle newCircle=new Circle(event.getX(),event.getY(), 4, Color.BLACK);
			drawingAreaPane.getChildren().add(newCircle);
		}
		else {
			Circle newCircle=new Circle(event.getX(),event.getY(), 4, Color.WHITE);
			drawingAreaPane.getChildren().add(newCircle);
		}
		
	}

}
