package domain;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Word {
	private int dictionaryId;
	private int wordId;
	private String wordName;
	private String wordDefinition;
	private String wordReference;
	private String tag;
	
	private Date createdAt;
	private String createdAtStr;
	private Date updatedAt;
	private String updatedAtStr;
	
	private int posX;
	private int posY;
	
	public  Word() {};
	
	public  Word(int dictionaryId, String wordName, String wordDefinition, String wordReference, String tag) {
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



	public Date getCreatedAt() {
		return createdAt;
	}
    
	//作成日時はデータベースの作成時にdefaultで作成される
	public void setCreatedAt(Date createdAt) {
		//Date date = new Date();
		this.createdAt = createdAt;
		this.createdAtStr = new SimpleDateFormat("yyyy年 MM月 dd日 hh時 mm分").format(createdAt);
	}

	public String getCreatedAtStr() {
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy年 MM月 dd日 hh時 mm分");
		String str = sdf.format(createdAt);
		this.createdAtStr = str;*/
		return createdAtStr;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		this.updatedAtStr = new SimpleDateFormat("yyyy年 MM月 dd日 hh時 mm分").format(updatedAt);
	}
	
	public String getUpdatedAtStr() {
		return updatedAtStr;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosX() {
		return posX;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getPosY() {
		return posY;
	}
}
