package olympic.model.dto;

public class SportDTO {
	
	private String sportName;
	private String country;
	private int totalMedal;
	
	public SportDTO() {}
	public SportDTO(String sportName, String country, int totalMedal) {
		super();
		this.sportName = sportName;
		this.country = country;
		this.totalMedal = totalMedal;
	}
	
	public String getSportName() {
		return sportName;
	}
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getTotalMedal() {
		return totalMedal;
	}
	public void setTotalMedal(int totalMedal) {
		this.totalMedal = totalMedal;
	}
	
	@Override
	public String toString() {
		return "SportDTO [sportName=" + sportName + ", country=" + country + ", totalMedal=" + totalMedal + "]";
	}
}