package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller {
	@FXML
	protected void handleEnterItem(ActionEvent event) {
		System.out.println("Button pressed.");
	}

	@FXML
	protected void handleClearItem(ActionEvent event) {
		System.out.println("Clear pressed.");
	}
}
