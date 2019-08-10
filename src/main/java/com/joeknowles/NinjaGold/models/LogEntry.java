package com.joeknowles.NinjaGold.models;
import java.io.Serializable;

public class LogEntry implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6457078278741370468L;
	private String mColor;
	private String mText;
	
	public LogEntry() { mColor = "gray"; mText = "No message."; }
	public LogEntry(String c, String t) { mColor = c; mText = t; }
	
	public String getColor() { return mColor; }
	public void setColor(String color) { this.mColor = color; }
	public String getText() { return mText; }
	public void setText(String text) { this.mText = text; }
	@Override public String toString() { return mText; }
}
