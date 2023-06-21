package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class AddDVDtoStoreScreen extends JFrame{

	private TextField DVDTitleInput;
	private TextField DVDCategoryInput;
	private TextField DVDDirectorInput;
	private TextField DVDLengthInput;
	private TextField DVDCostInput;
	private TextField DVDTitleOutput;
	private TextField DVDCategoryOutput;
	private TextField DVDDirectorOutput;
	private TextField DVDLengthOutput;
	private TextField DVDCostOutput;
	private String title;
	private String category;
	private float cost;
	private String director;
	private int length;
	private Store store;
	private Cart cart;
	public AddDVDtoStoreScreen(Store store,Cart cart) {
		this.store=store;
		Container cp=getContentPane();
		cp.setLayout(new BorderLayout());	
		cp.add(createNorth(),BorderLayout.NORTH);
		cp.add(createCenter(),BorderLayout.CENTER);
		cp.add(createSouth(),BorderLayout.SOUTH);
		setVisible(true);
		setTitle("Add DVD");
		setSize(1024,768);

	}
	JPanel createCenter() {
		JPanel center=new JPanel();
		center.setLayout(new GridLayout(6,3));
		
		center.add(new Label("Enter DVD's Title:"));
		DVDTitleInput=new TextField(30);
		DVDTitleInput.addActionListener(new DVDTitleListener());
		center.add(DVDTitleInput);
		DVDTitleOutput=new TextField(30);
		DVDTitleOutput.setEditable(false);
		center.add(DVDTitleOutput);
		
		center.add(new Label("Enter DVD's Category:"));
		DVDCategoryInput=new TextField(30);
		DVDCategoryInput.addActionListener(new DVDCategoryListener());
		center.add(DVDCategoryInput);
		DVDCategoryOutput=new TextField(30);
		DVDCategoryOutput.setEditable(false);
		center.add(DVDCategoryOutput);
		
		center.add(new Label("Enter DVD's cost:"));
		DVDCostInput=new TextField(30);
		DVDCostInput.addActionListener(new DVDCostListener());
		center.add(DVDCostInput);
		DVDCostOutput=new TextField(30);
		DVDCostOutput.setEditable(false);
		center.add(DVDCostOutput);
		
		center.add(new Label("Enter DVD's Director:"));
		DVDDirectorInput=new TextField(30);
		DVDDirectorInput.addActionListener(new DVDDirectorListener());
		center.add(DVDDirectorInput);
		DVDDirectorOutput=new TextField(30);
		DVDDirectorOutput.setEditable(false);
		center.add(DVDDirectorOutput);
		
		center.add(new Label("Enter DVD's Length:"));
		DVDLengthInput=new TextField(30);
		DVDLengthInput.addActionListener(new DVDLengthListener());
		center.add(DVDLengthInput);
		DVDLengthOutput=new TextField(30);
		DVDLengthOutput.setEditable(false);
		center.add(DVDLengthOutput);
		
		
		return center;
		
	}
	JPanel createSouth() {
		JPanel south=new JPanel();
		JButton add=new JButton("Add");
		JButton clear=new JButton("Clear");
		ButtonListener btnaddListener=new ButtonListener();
		add.addActionListener(btnaddListener);
		add.setPreferredSize(new Dimension(100,50));
		add.setMaximumSize(new Dimension(100,50));
		south.add(Box.createHorizontalGlue());
		south.add(add);
		clear.addActionListener(btnaddListener);
		clear.setPreferredSize(new Dimension(100,50));
		clear.setMaximumSize(new Dimension(100,50));
		south.add(Box.createHorizontalGlue());
		south.add(clear);
		return south;
	}
	private class DVDTitleListener implements ActionListener{
		@Override	
		public void actionPerformed(ActionEvent evt) {
			String DVDTitle= DVDTitleInput.getText();
			DVDTitleInput.setText("");
			DVDTitleOutput.setText(DVDTitle);
		    title=DVDTitle;
		    DVDTitleInput.setEditable(false);
		}
		
	}
	private class DVDCategoryListener implements ActionListener{
		@Override	
		public void actionPerformed(ActionEvent evt) {
			String DVDCategory= DVDCategoryInput.getText();
			DVDCategoryInput.setText("");
			DVDCategoryOutput.setText(DVDCategory);
			category=DVDCategory;
			DVDCategoryInput.setEditable(false);
		}
		
	}
	private class DVDDirectorListener implements ActionListener{
		@Override	
		public void actionPerformed(ActionEvent evt) {
			String DVDDirector= DVDDirectorInput.getText();
			DVDDirectorInput.setText("");
			
			DVDDirectorOutput.setText(DVDDirector);
			director=DVDDirector;
			DVDDirectorInput.setEditable(false);
		}
		
	}
	private class DVDLengthListener implements ActionListener{
		@Override	
		public void actionPerformed(ActionEvent evt) {
			int DVDLength= Integer.parseInt(DVDLengthInput.getText());
			DVDLengthInput.setText("");
			DVDLengthOutput.setText(""+DVDLength);
			length=DVDLength;
			DVDLengthInput.setEditable(false);
		}
		
	}
	private class DVDCostListener implements ActionListener{
		@Override	
		public void actionPerformed(ActionEvent evt) {
			float DVDCost= Float.parseFloat(DVDCostInput.getText());
			DVDCostInput.setText("");
			DVDCostOutput.setText(""+DVDCost);
			cost=DVDCost;
			DVDCostInput.setEditable(false);
		}
		
	}
	private class ButtonListener implements ActionListener{
		@Override	
		public void actionPerformed(ActionEvent e) {
			String button=e.getActionCommand();
			if(button.equals("Add")) {
				DigitalVideoDisc DVD=new DigitalVideoDisc(title,category,director,length,cost);
				store.addMedia(DVD);
				title=null;
				category=null;
				length=0;
				cost=0;
				director=null;
				
				DVDTitleOutput.setText("");
				DVDCategoryOutput.setText("");
				DVDCostOutput.setText("");
				DVDDirectorOutput.setText("");
				DVDLengthOutput.setText("");
			}
			else if(button.equals("Clear")) {
				title=null;
				category=null;
				cost=0;
				director=null;
				length=0;
				DVDTitleOutput.setText("");
				DVDCategoryOutput.setText("");
				DVDCostOutput.setText("");
				DVDDirectorOutput.setText("");
				DVDLengthOutput.setText("");
			
			}
			
		}
	}
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
		JMenuItem jmviewStore=new JMenuItem("View store");
		jmviewStore.addActionListener(mnListen);
		menu.add(jmviewStore);
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
		
		JLabel title=new JLabel("Add Items:");
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
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
			else if(button.equals("Add DVD")){
				dispose();
				new AddDVDtoStoreScreen(store,cart);
			}
			else if(button.equals("View store")) {
				dispose();
				new StoreScreen(store,cart);
			}
			else if(button.equals("View cart")){dispose();new CartScreen(cart,store);}
			
		}
	}

}
