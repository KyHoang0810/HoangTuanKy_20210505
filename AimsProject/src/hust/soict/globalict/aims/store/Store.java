package hust.soict.globalict.aims.store;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore=new ArrayList<Media>();
	public void addMedia(Media media) {
		if(itemsInStore.contains(media)==false) {
			itemsInStore.add(media);
			itemsInStore.get(itemsInStore.size()-1).setId(itemsInStore.size());
			System.out.println(media.getTitle()+" has been added to the store.");
			}
		else System.out.println(media.getTitle()+" is already in the store.");
		
	}
	public void removeMedia(Media media) {
		if(itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			System.out.println(media.getTitle()+" has been removed from the cart.");
		}
		else System.out.println(media.getTitle()+" is not in the store.");
	}
	public int findMediaIndex(String str) {
		for(int i=0;i<itemsInStore.size();i++) {
			if(str.equals(itemsInStore.get(i).getTitle())){
				return i;
			}
		}
		return -1;
	}
	public Media getMedia(int i) {
		return itemsInStore.get(i);
	}
	public void print() {
		System.out.println("********************Store**************************");
		System.out.println("Ordered items:");
		for (int i=0; i<itemsInStore.size(); i++) {
			System.out.println(i+1 + ". " + itemsInStore.get(i).toString());
		}
		System.out.println("***************************************************");
	}
	
	
	
}




