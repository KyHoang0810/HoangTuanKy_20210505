package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title,category,cost,length,director);
	}
	
	public String toString() {
		return "ID:"+this.getId()+"-DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " : " + this.getCost() + " $";
	}

	public void play() throws PlayerException { 
		if(this.getLength()>0) {

		System.out.println("Playing DVD: " + this.getTitle()); 

		System.out.println("DVD length: " + this.getLength()); 
		}
		else throw new PlayerException("ERROR: Track length is non-positive!");
	} 

}
