package com.spp.springblog.vo;

public class boardVO {
	private int ino;
	private String vtitle;
	private String vcontents;
	private String vtag;
	private String ddatetime;
	private String vfirstimg;
	public String getVfirstimg() {
		return vfirstimg;
	}
	public void setVfirstimg(String vfirstimg) {
		this.vfirstimg = vfirstimg;
	}
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public String getVtitle() {
		return vtitle;
	}
	public void setVtitle(String vtitle) {
		this.vtitle = vtitle;
	}
	public String getVcontents() {
		return vcontents;
	}
	public void setVcontents(String vcontents) {
		this.vcontents = vcontents;
	}
	public String getVtag() {
		return vtag;
	}
	public void setVtag(String vtag) {
		this.vtag = vtag;
	}
	public String getDdatetime() {
		return ddatetime;
	}
	public void setDdatetime(String ddatetime) {
		this.ddatetime = ddatetime;
	}
	
	
}
