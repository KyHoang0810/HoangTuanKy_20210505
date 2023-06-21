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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.screen.StoreScreen.MediaStore;
import hust.soict.globalict.aims.store.Store;
public class AddCDtoStoreScreen extends JFrame{
	private TextField CDTitleInput;
	private TextField CDCategoryInput;
	private TextField CDDirectorInput;
	private TextField CDArtistInput;
	private TextField CDTrackInput;
	private TextField CDCostInput;
	private TextField CDTitleOutput;
	private TextField CDCategoryOutput;
	private TextField CDDirectorOutput;
	private TextField CDArtistOutput;
	private TextField CDTrackOutput;
	private TextField CDCostOutput;
	private List<Track> tracks= new ArrayList<Track>();
	private String title;
	private String category;
	private float cost;
	private String director;
	private String artist;
	private Store store;
	private Cart cart;
	

	public AddCDtoStoreScreen(Store store,Cart cart) {
		this.cart=cart;
		this.store=store;
		Container cp=getContentPane();
		cp.setLayout(new BorderLayout());	
		cp.add(createNorth(),BorderLayout.NORTH);
		cp.add(createCenter(),BorderLayout.CENTER);
		cp.add(createSouth(),BorderLayout.SOUTH);
		setVisible(true);
		setTitle("Add CD");
		setSize(1024,768);
		// TODO Auto-generated constructor stub
	}
	JPanel createCenter() {
		JPanel center=new JPanel();
		center.setLayout(new GridLayout(6,3));
		
		center.add(new Label("Enter CD's Title:"));
		CDTitleInput=new TextField(30);
		CDTitleInput.addActionListener(new CDTitleListener());
		center.add(CDTitleInput);
		CDTitleOutput=new TextField(30);
		CDTitleOutput.setEditable(false);
		center.add(CDTitleOutput);
		
		center.add(new Label("Enter CD's Category:"));
		CDCategoryInput=new TextField(30);
		CDCategoryInput.addActionListener(new CDCategoryListener());
		center.add(CDCategoryInput);
		CDCategoryOutput=new TextField(30);
		CDCategoryOutput.setEditable(false);
		center.add(CDCategoryOutput);
		
		center.add(new Label("Enter CD's cost:"));
		CDCostInput=new TextField(30);
		CDCostInput.addActionListener(new CDCostListener());
		center.add(CDCostInput);
		CDCostOutput=new TextField(30);
		CDCostOutput.setEditable(false);
		center.add(CDCostOutput);
		
		center.add(new Label("Enter CD's Director:"));
		CDDirectorInput=new TextField(30);
		CDDirectorInput.addActionListener(new CDDirectorListener());
		center.add(CDDirectorInput);
		CDDirectorOutput=new TextField(30);
		CDDirectorOutput.setEditable(false);
		center.add(CDDirectorOutput);
		
		center.add(new Label("Enter CD's Artist:"));
		CDArtistInput=new TextField(30);
		CDArtistInput.addActionListener(new CDArtistListener());
		center.add(CDArtistInput);
		CDArtistOutput=new TextField(30);
		CDArtistOutput.setEditable(false);
		center.add(CDArtistOutput);
		
		center.add(new Label("Enter CD's Track(1 at a time, title and time split by:):"));
		CDTrackInput=new TextField(30);
		CDTrackInput.addActionListener(new CDTrackListener());
		center.add(CDTrackInput);
		CDTrackOutput=new TextField(30);
		CDTrackOutput.setEditable(false);
		center.add(CDTrackOutput);
		
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
	private class CDTitleListener implements ActionListener{
		@Override	
		public void actionPerformed(ActionEvent evt) {
			String CDTitle= CDTitleInput.getText();
			CDTitleInput.setText("");
			CDTitleOutput.setText(CDTitle);
		    title=CDTitle;
		    CDTitleInput.setEditable(false);
		}
		
	}
	private class CDCategoryListener implements ActionListener{
		@Override	
		public void actionPerformed(ActionEvent evt) {
			String CDCategory= CDCategoryInput.getText();
			CDCategoryInput.setText("");
			CDCategoryOutput.setText(CDCategory);
			category=CDCategory;
			CDCategoryInput.setEditable(false);
		}
		
	}
	private class CDDirectorListener implements ActionListener{
		@Override	
		public void actionPerformed(ActionEvent evt) {
			String CDDirector= CDDirectorInput.getText();
			CDDirectorInput.setText("");
			
			CDDirectorOutput.setText(CDDirector);
			director=CDDirector;
			CDDirectorInput.setEditable(false);
		}
		
	}
	private class CDArtistListener implements ActionListener{
		@Override	
		public void actionPerformed(ActionEvent evt) {
			String CDArtist= CDArtistInput.getText();
			CDArtistInput.setText("");
			CDArtistOutput.setText(CDArtist);
			artist=CDArtist;
			CDArtistInput.setEditable(false);
		}
		
	}
	private class CDTrackListener implements ActionListener{
		@Override	
		public void actionPerformed(ActionEvent evt) {
			String trackinfo= CDTrackInput.getText();
			CDTrackInput.setText("");
			CDTrackOutput.setText(CDTrackOutput.getText()+"\n"+trackinfo);
			String[] split=trackinfo.split(":");
			Track track=new Track(split[0],Integer.parseInt(split[1]));
			tracks.add(track);
		}
		
	}
	private class CDCostListener implements ActionListener{
		@Override	
		public void actionPerformed(ActionEvent evt) {
			Float CDCost= Float.parseFloat(CDCostInput.getText());
			CDCostInput.setText("");
			CDCostOutput.setText(""+CDCost);
			cost=CDCost;
			CDCostInput.setEditable(false);
		}
		
	}
	private class ButtonListener implements ActionListener{
		@Override	
		public void actionPerformed(ActionEvent e) {
			String button=e.getActionCommand();
			if(button.equals("Add")) {
				CompactDisc cd=new CompactDisc(title,category,cost,director,artist,tracks);
				store.addMedia(cd);
				title=null;
				category=null;
				tracks.removeAll(tracks);
				cost=0;
				director=null;
				artist=null;
				CDTitleOutput.setText("");
				CDCategoryOutput.setText("");
				CDCostOutput.setText("");
				CDDirectorOutput.setText("");
				CDArtistOutput.setText("");
				CDTrackOutput.setText("");
			}
			else if(button.equals("Clear")) {
				title=null;
				category=null;
				tracks.removeAll(tracks);
				cost=0;
				director=null;
				artist=null;
				CDTitleOutput.setText("");
				CDCategoryOutput.setText("");
				CDCostOutput.setText("");
				CDDirectorOutput.setText("");
				CDArtistOutput.setText("");
				CDTrackOutput.setText("");
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
