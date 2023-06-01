package lab_2;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks=new ArrayList<Track>();

	public String getArtist() {
		return artist;
	}
	public CompactDisc(String title, String category, float cost, String director,String artist, List<Track> tracks) {
		super(title,category,cost,director);
		this.artist = artist;
		this.tracks = tracks;
	}

	public void addTrack(Track track) {
		if(tracks.contains(track)==true)
			System.out.println("The track is already in the CD. ");
		else {
			tracks.add(track);
			System.out.println(track.getTitle()+" has been added to the CD.");
		}
	}
	public void removeTrack(Track track) {
		if(tracks.contains(track)==false)
			System.out.println("The track is not in the CD. ");
		else {
			tracks.remove(track);
			System.out.println(track.getTitle()+" has been removed from the CD.");
		}
	}
	@Override
	public int getLength() {
		int cdlength=0;
		for(int i=0;i<tracks.size();i++) {
			cdlength += tracks.get(i).getLength();
			
		}
		return cdlength;
		
	}
	public void play() {
		System.out.println("Playing CD: "+this.getTitle());
		System.out.println("Total length: "+this.getLength());
		for(int i=0;i<tracks.size();i++) {
			System.out.println("Track no."+(i+1));
			tracks.get(i).play();
		}
		
	}
	public String toString() {
		String track="\n";
		for(int i=0;i<tracks.size();i++) {
			track+="Track number "+(i+1)+": "+tracks.get(i).getTitle()+"-"+tracks.get(i).getLength()+"\n";
		}
		return "ID:"+this.getId()+ "-CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getArtist()+ " - " + this.getDirector()  + " - " + this.getLength() + " : " + this.getCost() + " $"+track;
	}
}

