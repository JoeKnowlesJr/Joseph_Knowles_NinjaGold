package com.joeknowles.NinjaGold.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ninja implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 385915102056495703L;
	private String mName;
	private int mGold;
	private List<LogEntry> mHistory;
	
	public Ninja() { this("New Ninja"); }
	public Ninja(String n) { mName = n; mGold = 0; mHistory = new ArrayList<>(); 	}
	
	public String getName() { return mName; }
	public void setName(String mName) { this.mName = mName; }
	public int getGold() { return mGold; }
	public void setGold(int mGold) { this.mGold = mGold; }
	public List<LogEntry> getHistory() { return mHistory; }
	
	public void adjustGold(int g) { mGold += g; }
	public void addLogEntry(LogEntry le) { mHistory.add(le); }
	public void reset() { mGold = 0; addLogEntry(new LogEntry("blue", "--- RESET ---")); }
}
