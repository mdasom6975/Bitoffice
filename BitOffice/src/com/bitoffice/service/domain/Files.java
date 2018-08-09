package com.bitoffice.service.domain;

import java.util.Arrays;

public class Files {
    private int id;
    private String filename;
    private String notes;
    private String type;
    private byte[] file;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "Files [id=" + id + ", filename=" + filename + ", notes=" + notes + ", type=" + type + ", file="
				+ Arrays.toString(file) + "]";
	}
 
    
}