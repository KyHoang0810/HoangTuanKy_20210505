package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
public class CartScreenController {
	private Store store;
	private Cart cart;
	@FXML
	private TableView<Media> tblMedia;
	@FXML
	private TableColumn<Media,String> colMediaTitle;
	@FXML
	private TableColumn<Media,String> colMediaCategory;
	@FXML
	private TableColumn<Media,String> colMediaCost;
	@FXML
	private Button btnPlay;
	@FXML
	private Button btnRemove;
	@FXML
	private Button btnPlaceOrder;
	@FXML 
	private Label totalCost;
	@FXML
	private MenuItem menuAddBook;
	
	public CartScreenController(Cart cart,Store store) {
		super();
		this.cart=cart;
		this.store=store;
		
	}
	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("Title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("Category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, String>("Cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
		totalCost.setText(this.cart.totalCost()+"$");
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
				@Override
				public void changed(ObservableValue<? extends Media>observable,Media oldValue,Media newValue) {
					if(newValue!=null) {
						updateButtonBar(newValue);
					}
				}
				});
	}
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else btnPlay.setVisible(false);
	}
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media=tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		totalCost.setText(this.cart.totalCost()+"$");
	}
	@FXML
	void btnPlaceOrderPressed(ActionEvent event) {
		Dialog<String> dialog = new Dialog<String>();
	    dialog.setTitle("Notification");
	    dialog.setContentText("An order is created.");
	    dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CLOSE);
	    dialog.showAndWait();
	    tblMedia.getItems().clear();
	}
	@FXML
	void btnPlayPressed(ActionEvent event) {
		Dialog<String> dialog = new Dialog<String>();
	    dialog.setTitle("Notification");
	    Media media=tblMedia.getSelectionModel().getSelectedItem();
	    dialog.setContentText("Playing: "+media.getTitle());
	    dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CLOSE);
	    dialog.showAndWait();

	}
	@FXML
	void menuAddBookPressed(ActionEvent event) {
		new AddBooktoStoreScreen(store);
		Stage stage = (Stage)btnPlaceOrder.getScene().getWindow();
		stage.hide();
	}
	

}
