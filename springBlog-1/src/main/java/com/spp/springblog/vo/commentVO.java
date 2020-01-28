package com.spp.springblog.vo;

public class commentVO {
	int ino;
	int boardNo;
	String comment;
	String vusername;
	public String getVusername() {
		return vusername;
	}
	public void setVusername(String vusername) {
		this.vusername = vusername;
	}
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
