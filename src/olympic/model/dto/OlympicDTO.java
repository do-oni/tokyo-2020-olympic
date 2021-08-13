package olympic.model.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import olympic.model.util.DBUtil;

public class OlympicDTO {
	
	private int olympicId;
	private String country;
	private String sportName;
	private int playerNumber;
	private String medalId;
	
	public OlympicDTO() {}
	public OlympicDTO(int olympicId, String country, String sportName, int playerNumber, String medalId) {
		super();
		this.olympicId = olympicId;
		this.country = country;
		this.sportName = sportName;
		this.playerNumber = playerNumber;
		this.medalId = medalId;
	}

	public int getOlympicId() {
		return olympicId;
	}
	public void setOlympicId(int olympicId) {
		this.olympicId = olympicId;
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
	public int getPlayerNumber() {
		return playerNumber;
	}
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	public String getMedalId() {
		return medalId;
	}
	public void setMedalId(String medalId) {
		this.medalId = medalId;
	}

	@Override
	public String toString() {
		return "OlympicDTO [olympicId=" + olympicId + ", country=" + country + ", sportName=" + sportName
				+ ", playerNumber=" + playerNumber + ", medalId=" + medalId + "]";
	}
}