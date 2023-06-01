package lab_2;

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

	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public Media(String title, String category) {
		super();
		this.title = title;
		this.category = category;
	}

	public Media(String title) {
		super();
		this.title = title;
	}
	@Override
	public boolean equals ( Object o) {
		if (!(o instanceof Media)) {
			return false;
		}
		Media a = (Media) o;
		return (this.title == a.title);
	}

	
	
	
}

