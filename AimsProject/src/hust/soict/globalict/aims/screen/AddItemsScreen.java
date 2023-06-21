package hust.soict.globalict.aims.screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.screen.StoreScreen.MediaStore;
import hust.soict.globalict.aims.store.Store;

public class AddItemsScreen extends JFrame{
	private Store store;
	
	JPanel createNorth() {
		JPanel north=new JPanel();
		north.setLayout(new BoxLayout(north,BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
		
	}
	JMenuBar createMenuBar() {
		JMenu menu=new JMenu("Options");
		
		JMenu smUpdateStore=new JMenu("Update Store");
		smUpdateStore.add(new JMenu("Add Book"));
		smUpdateStore.add(new JMenu("Add CD"));
		smUpdateStore.add(new JMenu("Add DVD"));
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		menu.add(new JMenuItem("View cart"));
		
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
	
	
	

}
