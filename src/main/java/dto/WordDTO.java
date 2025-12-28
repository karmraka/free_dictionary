package dto;

import java.sql.Timestamp;

public class WordDTO {
	private int dictionaryId;
	private int wordId;
	private String wordName;
	private String wordDefinition;
	private String wordReference;
	private String tag;
	//private Point wordPoint;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public WordDTO() {}
	
	public WordDTO(int dictionaryId, String wordName, String wordDefinition, String wordReference, String tag) {
		this.dictionaryId = dictionaryId;
		this.wordName = wordName;
		this.wordDefinition = wordDefinition;
		this.wordReference = wordReference;
		this.tag = tag;
	}

	public int getDictionaryId() {
		return dictionaryId;
	}

	public void setDictionaryId(int dictionaryId) {
		this.dictionaryId = dictionaryId;
	}

	public int getWordId() {
		return wordId;
	}

	public void setWordId(int wordId) {
		this.wordId = wordId;
	}

	public String getWordName() {
		return wordName;
	}

	public void setWordName(String wordName) {
		this.wordName = wordName;
	}

	public String getWordDefinition() {
		return wordDefinition;
	}

	public void setWordDefinition(String wordDefinition) {
		this.wordDefinition = wordDefinition;
	}

	public String getWordReference() {
		return wordReference;
	}

	public void setWordReference(String wordReference) {
		this.wordReference = wordReference;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
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
	};
    
	


}
