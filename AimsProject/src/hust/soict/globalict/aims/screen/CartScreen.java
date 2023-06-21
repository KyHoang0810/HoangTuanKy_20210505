package hust.soict.globalict.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.store.Store;

public class CartScreen extends JFrame {
	private Cart cart;
	private Store store;
	public CartScreen(Cart cart,Store store) {
		super();
		this.cart=cart;
		JFXPanel fxPanel=new JFXPanel();
		this.add(fxPanel);
		this.setTitle("Cart");
		this.setVisible(true);
		Runnable windowCloser = () -> SwingUtilities.invokeLater(
		        () -> this.setVisible(false)
		    );

		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				try {
					FXMLLoader loader=new FXMLLoader(getClass().getResource("cart.fxml"));
					CartScreenController controller=new CartScreenController(cart,store,windowCloser);
					loader.setController(controller);
					Parent root=loader.load();
					fxPanel.setScene(new Scene(root));
					
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

}
