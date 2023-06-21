package hust.soict.globalict.aims.media;

public class Media {
	private int id;
	private String title;
	private String category;
	private float cost;

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Media() {
		// TODO Auto-generated constructor stub
	}

	
	public Media(String name, String category, float cost) {
		// TODO Auto-generated constructor stub
		this.title=name;
		this.category=category;
		this.cost=cost;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Media otherMedia = (Media) obj;
	    try {
	        return title.equals(otherMedia.title);
	    } catch (NullPointerException e) {
	        return false;
	    } catch (ClassCastException e) {
	        return false;
	    }
	}

	
	
	
}

