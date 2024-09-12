package com.itwillbs.domain;

import java.sql.Timestamp;
import java.util.Date;

public class BoardDTO {
//멤버변수 num,name,subject,content,readcount,date 선언
	private int num;
	private String name;
	private String subject;
	private String content;
	private int readcount;
	private Timestamp date;
	private Date startDate;
	private Date endDate;
	private String file;
	

	
	
	
	
	

	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", name=" + name + ", subject=" + subject + ", content=" + content
				+ ", readcount=" + readcount + ", date=" + date + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", file=" + file + "]";
	}

//	메서드 setter, getter 정의



	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}




	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}




	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}




	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}




	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}




	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}




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
