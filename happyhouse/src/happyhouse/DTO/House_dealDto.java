package happyhouse.DTO;

// DTO : Data Transfer Object
// VO : Value Object

public class House_dealDto {

	private String AptName;
	private String dealAmount;
	private int dealYear;
	private int dealMonth;
	private int dealday;
	private float area;
	private int type;
	
	public String getAptName() {
		return AptName;
	}
	public void setAptName(String aptName) {
		AptName = aptName;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount (String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public int getDealYear() {
		return dealYear;
	}
	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}
	public int getDealMonth() {
		return dealMonth;
	}
	public void setDealMonth(int dealMonth) {
		this.dealMonth = dealMonth;
	}
	public int getDealday() {
		return dealday;
	}
	public void setDealday(int dealday) {
		this.dealday = dealday;
	}
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "["+AptName + "\t" + dealAmount + "\t" + dealYear
				+ "/" + dealMonth + "/" + dealday + "\t" + area + "\t" + type + "]";
	}
	
	
	
	
	
	

	

}
