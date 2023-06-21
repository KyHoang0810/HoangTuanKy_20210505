package hust.soict.globalict.aims.media;
import hust.soict.globalict.aims.exception.PlayerException;
public class Track implements Playable{
	private String title;
	private int length;

	public Track(String title, int length) {
		// TODO Auto-generated constructor stub
		this.title=title;
		this.length=length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	public void play() throws PlayerException { 
		if(this.getLength()>0) {
			System.out.println("Playing Track: " + this.getTitle()); 
			System.out.println("Track length: " + this.getLength()); 
		}
		else {
			throw new PlayerException("ERROR: Track length is non-positive!");
		}
	}
	@Override
	public boolean equals (Object o) {
		if (!(o instanceof Track)) {
			return false;
		}
		Track a = (Track) o;
		return (this.title == a.title && this.length == a.length);
	}

}
