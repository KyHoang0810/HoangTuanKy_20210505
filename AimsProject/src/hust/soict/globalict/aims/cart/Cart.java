package hust.soict.globalict.aims.cart;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

import hust.soict.globalict.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDER=20;
	private ArrayList<Media> itemsOrdered=new ArrayList<Media>();
	public void addMedia(Media media) {
		if(itemsOrdered.size()<20) {
			itemsOrdered.add(media);
			System.out.println(media.getTitle()+" has been added to the cart.");
			}
		else System.out.println("The cart is full.");
		
	}
	public void removeMedia(Media media) {
		if(itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println(media.getTitle()+" has been removed from the cart.");
		}
		else System.out.println(media.getTitle()+" is not in the cart.");
	}
	
	public float totalCost() {
		float total=0;
		for(int i=0;i<itemsOrdered.size();i++)
			total+=itemsOrdered.get(i).getCost();
		return total;
	}
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered items:");
		for (int i=0; i<itemsOrdered.size(); i++) {
			System.out.println(i+1 + ". " + itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + this.totalCost() + "$");
		System.out.println("***************************************************");
	}
	public int findMediaIndex(String str) {
		for(int i=0;i<itemsOrdered.size();i++) {
			if(str.equals(itemsOrdered.get(i).getTitle())){
				return i;
			}
		}
		return -1;
	}
	public Media getMedia(int i) {
		return itemsOrdered.get(i);
	}
	public void searchID (int id_search) {
		int found=0;
		for (int i=0; i<itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == id_search) {
				System.out.println(itemsOrdered.get(i).toString());
				found=1;
				return;
			}
		}
		if(found==0) System.out.println("Item is not in the cart");
	}
	public void sortByTitleCost() {
		Comparator<Media> compareByTitleCost = Comparator.comparing(Media::getTitle).thenComparing(Media::getCost,Comparator.reverseOrder());
		Collections.sort(itemsOrdered,compareByTitleCost);
		print();
	}
	
	public void sortByCostTitle() {
		Comparator<Media> compareByCostTitle = Comparator.comparing(Media::getCost,Comparator.reverseOrder()).thenComparing(Media::getTitle);
		Collections.sort(itemsOrdered,compareByCostTitle);
		print();
	}
	


}
