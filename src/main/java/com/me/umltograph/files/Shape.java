package com.me.umltograph.files;

public class Shape {
	private String text;
	private int id;
	private Integer from;
	private Integer to;
	private int type;

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFrom() {
		return from;
	}
	public void setFrom(Integer from) {
		this.from = from;
	}
	public Integer getTo() {
		return to;
	}
	public void setTo(Integer to) {
		this.to = to;
	}
	public int getType() {
		return type;
	}
	public void setType(int weight) {
		this.type = weight;
	}
}
