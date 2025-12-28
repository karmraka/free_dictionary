package dto;

import java.sql.Timestamp;

public class DictionaryDTO {
	private int id;
	private int dictionaryId;
	private String dictionaryName;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public DictionaryDTO(){}
	
	public DictionaryDTO(int id, String dictionaryName) {
		this.id = id;
		this.dictionaryName = dictionaryName;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDictionaryId() {
		return dictionaryId;
	}

	public void setDictionaryId(int dictionaryId) {
		this.dictionaryId = dictionaryId;
	}

	public String getDictionaryName() {
		return dictionaryName;
	}

	public void setDictionaryName(String dictionaryName) {
		this.dictionaryName = dictionaryName;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

}
