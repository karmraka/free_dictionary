package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dictionary {
	private int id;
	private int dictionaryId;
	private String dictionaryName;
	private Date createdAt;
	private String createdAtStr;
	private Date updatedAt;
	private String updatedAtStr;
	
	public Dictionary() {}
	
	public Dictionary(int id,  String dictionaryName) {
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
	
	

}
