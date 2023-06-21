package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;
import javafx.stage.Stage;

public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart;
	JPanel createNorth() {
		JPanel north=new JPanel();
		north.setLayout(new BoxLayout(north,BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
		
	}
	JMenuBar createMenuBar() {
		JMenu menu=new JMenu("Options");
		MenuListener mnListen=new MenuListener();
		JMenu smUpdateStore=new JMenu("Update Store");
		JMenuItem jmaddBook=new JMenuItem("Add Book");
		JMenuItem jmaddCD=new JMenuItem("Add CD");
		JMenuItem jmaddDVD=new JMenuItem("Add DVD");
		jmaddBook.addActionListener(mnListen);
		jmaddCD.addActionListener(mnListen);
		jmaddDVD.addActionListener(mnListen);
		smUpdateStore.add(jmaddBook);
		smUpdateStore.add(jmaddCD);
		smUpdateStore.add(jmaddDVD);
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		JMenuItem jmviewCart=new JMenuItem("View cart");
		jmviewCart.addActionListener(mnListen);
		menu.add(jmviewCart);
		
		JMenuBar menuBar=new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	JPanel createHeader() {
		JPanel header=new JPanel();
		header.setLayout(new BoxLayout(header,BoxLayout.X_AXIS));
		
		JLabel title=new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
		title.setForeground(Color.CYAN);
		
		JButton cart=new JButton("View cart");
		cart.setPreferredSize(new Dimension(100,50));
		cart.setMaximumSize(new Dimension(100,50));
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
	}
	JPanel createCenter() {
		JPanel center=new JPanel();
		center.setLayout(new GridLayout(3,3,2,2));
		
		ArrayList<Media> mediaInStore=store.getItemsInStore();
		int a=store.getItemsInStore().size()>9?9:store.getItemsInStore().size();
		for(int i=0;i<a;i++) {
			MediaStore cell=new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		return center;
		
	}
	public class MediaStore extends JPanel{
		private Media media;
		public Media getMedia() {return this.media;}
		public MediaStore(Media media) {
			this.media=media;
			this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			
			JLabel title=new JLabel(media.getTitle());
			title.setFont(new Font(title.getFont().getName(),Font.PLAIN,20));
			title.setAlignmentX(CENTER_ALIGNMENT);
			
			JLabel cost=new JLabel(""+media.getCost()+" $");
			cost.setAlignmentX(CENTER_ALIGNMENT);
			
			JPanel container=new JPanel();
			container.setLayout(new FlowLayout(FlowLayout.CENTER));
			JButton btnaddtoCart=new JButton("Add to cart");
			btnaddtoCart.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                cart.addMedia(media);
	            }
	        });
			container.add(btnaddtoCart);
			if(media instanceof Playable) {
				container.add(new JButton("Play"));
			}
			this.add(Box.createVerticalGlue());
			this.add(title);
			this.add(cost);
			this.add(Box.createVerticalGlue());
			this.add(container);
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}
	

	public StoreScreen(Store store,Cart cart) {
		this.store=store;
		this.cart=cart;
		Container cp=getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(),BorderLayout.NORTH);
		cp.add(createCenter(),BorderLayout.CENTER);
		setVisible(true);
		setTitle("Store");
		setSize(1024,768);
		// TODO Auto-generated constructor stub
	}
	public class MenuListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if (button.equals("Add Book")) {
				dispose();
				new AddBooktoStoreScreen(store,cart);
			}
			else if(button.equals("Add CD")){
				dispose();
				new AddCDtoStoreScreen(store,cart);
			}
			else if (button.equals("Add DVD")) {
				dispose();
				new AddDVDtoStoreScreen(store,cart);
			}
			else if(button.equals("View cart")) {
				dispose();
				new CartScreen(cart,store);
			}
			
		}
	}
	
	
}
