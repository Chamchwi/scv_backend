package kr.smaker.scv.dao;

public class UserData {
	private int idx;
	private String email;
	private String first_name;
	private String last_name;
	private String last_log;
	private int score;
	private int winning_streak;

	public int getIdx() {
		return idx;
	}
	
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirstName() {
		return first_name;
	}
	
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	public String getLastLog() {
		return last_log;
	}
	
	public void setLastLog(String last_log) {
		this.last_log = last_log;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getWS() {
		return winning_streak;
	}
	
	public void setWS(int winning_streak) {
		this.winning_streak = winning_streak;
	}

}
