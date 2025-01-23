package dto;

public class Events {

	private String title;
	private String date;
	private String treatment;
	private String gift;

	// コンストラクタ
	public Events() {
	}

	public Events(String title, String date, String treatment, String gift) {
		this.title = title;
		this.date = date;
		this.treatment = treatment;
		this.gift = gift;
	}

	// アクセッサ
	public String geTitle() {
		return date;
	}

	public void setTitle(String Title) {
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
