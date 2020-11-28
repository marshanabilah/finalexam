package net.finalexam.model;

public class login {
	protected int id;
	private String username;
	private String password;
	
	public login() {
	}
	
	public login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public login(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUserName(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}