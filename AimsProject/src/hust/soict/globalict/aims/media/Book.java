package hust.soict.globalict.aims.media;
import java.util.ArrayList;
import java.util.List;


public class Book extends Media {
	private List<String> authors= new ArrayList<String>();
	

	public Book(String name, String category,float cost,List<String> authorlist) {
		// TODO Auto-generated constructor stub
		super(name,category,cost);
		this.authors=authorlist;
	}
	public void addAuthor(String authorname) {
		if (authors.contains(authorname)==false)
				authors.add(authorname);
	}
	public void removeAuthor(String authorname) {
		if(authors.contains(authorname))
			authors.remove(authorname);
	}
	public List<String> getAuthors() {
		return authors;
	}
	public String toString() {
		String author="";
		for(int i=0;i<authors.size();i++)
			author+=authors.get(i)+", ";
		return "ID:"+this.getId()+"-Book - "+this.getTitle()+" - "+this.getCategory()+" - "+author+": "+this.getCost();
	}
	
	
	

}
