package com.bank;

public class User {
String email;
String acc_num ;
public User(String email, String acc_num, String temp_pass) {
	super();
	this.email = email;
	this.acc_num = acc_num;
	this.temp_pass = temp_pass;
}
String temp_pass;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAcc_num() {
	return acc_num;
}
public void setAcc_num(String acc_num) {
	this.acc_num = acc_num;
}
public String getTemp_pass() {
	return temp_pass;
}
public void setTemp_pass(String temp_pass) {
	this.temp_pass = temp_pass;
}
}
