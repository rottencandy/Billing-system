package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.conrtol.cell.PropertyVAlueFactory;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.util.ArrayList;
import java.lang.Math;

public class Controller {
    @FXML
    private TextField customerName;
    @FXML
    private TextField customerNumber;

    @FXML
    private TextField name;
    @FXML
    private TextField quantity;
    @FXML
    private TextField amount;
    @FXML
    private Label totalLabel;

    @FXML
    private ListView nameList;
    @FXML
    private ListView quantityList;
    @FXML
    private ListView amountList;
    @FXML
    private ListView totalList;

    @FXML
    private TableView itemsTable;
    @FXML
    private TableColumn nameColumn;

    ArrayList<Item> itemList = new ArrayList<Item>();

    final ObservableList<Item> l = FXCollections.observableList(itemList);
    itemsTable.setItems(l);
    nameColumn.setProperty(Item.name);

	@FXML
	protected void handleEnterItem(ActionEvent event) {
	    String n = name.getText();
	    int q = Integer.parseInt(quantity.getText());
	    double a = Double.parseDouble(amount.getText());
	    a = (double)Math.round(a * 100d)/100d;

	    Item item = new Item(n, q, a);
        itemList.add(item);
	    double total = item.calcTotal();

        clearFields();
        updateTotal();

	    nameList.getItems().add(n);
	    quantityList.getItems().add(q);
	    amountList.getItems().add(a);
	    totalList.getItems().add(total);
	}

	@FXML
	protected void handleClearItem(ActionEvent event) {
	    clearFields();
	}

	protected void clearFields() {
	    name.clear();
	    quantity.clear();
	    amount.clear();
	    name.requestFocus();
    }

    protected void updateTotal() {
	    double total = 0;
	    for(Item i: itemList) {
	        total += i.getTotal();
        }
        total = (double)Math.round(total * 100d) / 100d;
        totalLabel.setText(String.valueOf(total));
    }
}
