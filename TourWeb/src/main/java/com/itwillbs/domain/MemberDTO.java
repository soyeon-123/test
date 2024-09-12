package com.itwillbs.domain;

import java.sql.Timestamp;

public class MemberDTO {
	// MemberDTO 클래스의 멤버변수 
	// => 중요한 데이터를 담아서 전달하기 위해서 외부에서 접근 못하게 설정
	// => 접근지정자 private 이용해서 클래스에서 만 접근, 다른파일,다른 폴더에서 접근 못하게 설정
	private String id;
	private String pass;
	private String name;
	
	private String phone;
	private String email;
	private String email2;
	private String gender;
	private String agree;
	private String content;
	
	private Timestamp date;


	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", email2=" + email2 + ", gender=" + gender + ", agree=" + agree + ", content=" + content + ", date="
				+ date + "]";
	}



	public String getEmail2() {
		return email2;
	}



	public void setEmail2(String email2) {
		this.email2 = email2;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getAgree() {
		return agree;
	}



	public void setAgree(String agree) {
		this.agree = agree;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	// MemberDTO 클래스의 메서드(멤버함수)
	public void setId(String id) {
//		클래스내에 자기자신 멤버변수 id = 전달받은 id값
		this.id = id;
		return; //리턴값이 없을때 생략가능
	}
	


	public String getId() {
		// 멤버변수 id 를 가져가기 => String id
		return id;
	}

	// 자동완성 alt shift s => r
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
	
	
}
