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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.screen.StoreScreen.MediaStore;
import hust.soict.globalict.aims.store.Store;


public class AddBooktoStoreScreen extends AddItemsScreen{
	private TextField bookTitleInput;
	private TextField bookCategoryInput;
	private TextField bookAuthorsInput;
	private TextField bookCostInput;
	private TextField bookTitleOutput;
	private TextField bookCategoryOutput;
	private TextField bookAuthorsOutput;
	private TextField bookCostOutput;
	private List<String> authors= new ArrayList<String>();
	private String title;
	private String category;
	private float cost;
	private Store store;

	public AddBooktoStoreScreen(Store store) {
		this.store=store;
		Container cp=getContentPane();
		cp.setLayout(new BorderLayout());	
		cp.add(createNorth(),BorderLayout.NORTH);
		cp.add(createCenter(),BorderLayout.CENTER);
		cp.add(createSouth(),BorderLayout.SOUTH);
		setVisible(true);
		setTitle("Add Book");
		setSize(1024,768);
		// TODO Auto-generated constructor stub
	}
	JPanel createCenter() {
		JPanel center=new JPanel();
		center.setLayout(new GridLayout(4,3));
		
		center.add(new Label("Enter Book's Title:"));
		bookTitleInput=new TextField(30);
		bookTitleInput.addActionListener(new bookTitleListener());
		center.add(bookTitleInput);
		bookTitleOutput=new TextField(30);
		bookTitleOutput.setEditable(false);
		center.add(bookTitleOutput);
		
		center.add(new Label("Enter Book's Category:"));
		bookCategoryInput=new TextField(30);
		bookCategoryInput.addActionListener(new bookCategoryListener());
		center.add(bookCategoryInput);
		bookCategoryOutput=new TextField(30);
		bookCategoryOutput.setEditable(false);
		center.add(bookCategoryOutput);
		
		center.add(new Label("Enter Book's Author (one at a time):"));
		bookAuthorsInput=new TextField(30);
		bookAuthorsInput.addActionListener(new bookAuthorsListener());
		center.add(bookAuthorsInput);
		bookAuthorsOutput=new TextField(30);
		bookAuthorsOutput.setEditable(false);
		center.add(bookAuthorsOutput);
		
		center.add(new Label("Enter Book's cost:"));
		bookCostInput=new TextField(30);
		bookCostInput.addActionListener(new bookCostListener());
		center.add(bookCostInput);
		bookCostOutput=new TextField(30);
		bookCostOutput.setEditable(false);
		center.add(bookCostOutput);
		
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
	private class bookTitleListener implements ActionListener{
		@Override	
		public void actionPerformed(ActionEvent evt) {
			String BookTitle= bookTitleInput.getText();
			bookTitleInput.setText("");
			bookTitleOutput.setText(BookTitle);
		    title=BookTitle;
		}
		
	}
	private class bookCategoryListener implements ActionListener{
		@Override	
		public void actionPerformed(ActionEvent evt) {
			String BookCategory= bookCategoryInput.getText();
			bookCategoryInput.setText("");
			bookCategoryOutput.setText(BookCategory);
			category=BookCategory;
		}
		
	}
	private class bookAuthorsListener implements ActionListener{
		@Override	
		public void actionPerformed(ActionEvent evt) {
			String BookAuthor= bookAuthorsInput.getText();
			bookAuthorsInput.setText("");
			
			bookAuthorsOutput.setText(bookAuthorsOutput.getText()+"\n"+BookAuthor);;
			authors.add(BookAuthor);
		}
		
	}
	private class bookCostListener implements ActionListener{
		@Override	
		public void actionPerformed(ActionEvent evt) {
			float BookCost= Float.parseFloat(bookCostInput.getText());
			bookCostInput.setText("");
			bookCostOutput.setText(""+BookCost);
			cost=BookCost;
		}
		
	}
	private class ButtonListener implements ActionListener{
		@Override	
		public void actionPerformed(ActionEvent e) {
			String button=e.getActionCommand();
			if(button.equals("Add")) {
				Book book=new Book(title,category,cost,authors);
				store.addMedia(book);
				title=null;
				category=null;
				authors.removeAll(authors);
				cost=0;
				bookTitleOutput.setText("");
				bookCategoryOutput.setText("");
				bookCostOutput.setText("");
				bookAuthorsOutput.setText("");
			}
			else if(button.equals("Clear")) {
				title=null;
				category=null;
				authors.removeAll(authors);
				cost=0;
				bookTitleOutput.setText("");
				bookCategoryOutput.setText("");
				bookCostOutput.setText("");
				bookAuthorsOutput.setText("");
			}
			
		}
	}
	


}
