package lab_2;

public class DigitalVideoDisc extends Disc implements Playable {
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title,category,cost,length,director);
	}
	
	public String toString() {
		return "ID:"+this.getId()+"-DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " : " + this.getCost() + " $";
	}

	public void play() { 

		System.out.println("Playing DVD: " + this.getTitle()); 

		System.out.println("DVD length: " + this.getLength()); 
	}

}
