package dto;

public class Events {

	private String name;
	private String date;
	private String treatment;
	private String gift;

	// コンストラクタ
	public Events() {
	}

	public Events(String name, String date, String treatment, String gift) {
		this.name = name;
		this.date = date;
		this.treatment = treatment;
		this.gift = gift;
	}

	// アクセッサ
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
