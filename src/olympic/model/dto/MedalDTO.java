package olympic.model.dto;

public class MedalDTO {
	
	private String medalId ;
	private String country;
	private String sportName;
	private  int GMedal;
	private  int SMedal;
	private  int BMedal;
	
	
	public MedalDTO() {	}
	public MedalDTO(String medalId, String country, String sportName, int gMedal, int sMedal, int bMedal) {
		super();
		this.medalId = medalId;
		this.country = country;
		this.sportName = sportName;
		GMedal = gMedal;
		SMedal = sMedal;
		BMedal = bMedal;
	}
	
	public String getMedalId() {
		return medalId;
	}
	public void setMedalId(String medalId) {
		this.medalId = medalId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getSportName() {
		return sportName;
	}
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	public int getGMedal() {
		return GMedal;
	}
	public void setGMedal(int gMedal) {
		GMedal = gMedal;
	}
	public int getSMedal() {
		return SMedal;
	}
	public void setSMedal(int sMedal) {
		SMedal = sMedal;
	}
	public int getBMedal() {
		return BMedal;
	}
	public void setBMedal(int bMedal) {
		BMedal = bMedal;
	}
	
	@Override
	public String toString() {
		return "MedalDTO [medalId=" + medalId + ", country=" + country + ", sportName=" + sportName + ", GMedal="
				+ GMedal + ", SMedal=" + SMedal + ", BMedal=" + BMedal + "]";
	}
	
}
