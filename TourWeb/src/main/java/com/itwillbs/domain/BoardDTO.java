package com.itwillbs.domain;

import java.sql.Timestamp;

public class BoardDTO {
//멤버변수 num,name,subject,content,readcount,date 선언
	private int num;
	private String name;
	private String subject;
	private String content;
	private int readcount;
	private Timestamp date;
	
	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", name=" + name + ", subject=" + subject + ", content=" + content
				+ ", readcount=" + readcount + ", date=" + date + "]";
	}
	
	
//	메서드 setter, getter 정의
	

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
}
