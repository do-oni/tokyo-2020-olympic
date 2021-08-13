package olympic.model.dto;

public class PlayerDTO {
	
	private int playerNum;
	private String name;
	private int age;
	private String country;
	private String sportName;
	
	public PlayerDTO() {}
	public PlayerDTO(int playerNum, String name, int age, String country, String sportName) {
		super();
		this.playerNum = playerNum;
		this.name = name;
		this.age = age;
		this.country = country;
		this.sportName = sportName;
	}
	
	public int getPlayerNum() {
		return playerNum;
	}
	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	
	@Override
	public String toString() {
		return "PlayerDTO [playerNum=" + playerNum + ", name=" + name + ", age=" + age + ", country=" + country
				+ ", sportName=" + sportName + "]";
	}
}