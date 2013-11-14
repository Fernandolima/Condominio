package br.com.webhomebeta.json;

import java.util.Date;

import org.joda.time.DateTime;

public class CalendarEventJSON {

	private int id;
	private String title;
	private String start;
	private boolean editable;
	
	public CalendarEventJSON(int id, String title, String start,
			boolean editable) {
		super();
		this.id = id;
		this.title = title;
		this.start = start;
		this.editable = editable;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
}
