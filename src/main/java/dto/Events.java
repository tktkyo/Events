package dto;

public class Events {

	private Integer id;
	private String title;
	private String date;
	private String treatment;
	private String gift;
	
	
	public Events(Integer id, String title, String date, String treatment, String gift) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.treatment = treatment;
		this.gift = gift;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getGift() {
		return gift;
	}
	public void setGift(String gift) {
		this.gift = gift;
	}
	

}
