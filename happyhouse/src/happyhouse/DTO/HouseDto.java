package happyhouse.DTO;

// DTO : Data Transfer Object
// VO : Value Object

public class HouseDto {

	private String dong;
	private String AptName;
	private int guguncode;
	private int buildYear;
	private double lat;
	private double lng;
	
	
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getAptName() {
		return AptName;
	}

	public void setAptName(String aptName) {
		AptName = aptName;
	}
	public int getGuguncode() {
		return guguncode;
	}
	public void setGuguncode(int guguncode) {
		this.guguncode = guguncode;
	}
	public int getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	
	
	@Override
	public String toString() {
		return "[" + dong + "\t" + AptName + "\t" + guguncode + "\t"
				+ buildYear + "\t" + lat + "\t" + lng + "]";
	}

	

}
