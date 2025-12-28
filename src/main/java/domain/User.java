package domain;

import java.text.SimpleDateFormat;
import java.util.Date;



public class User {
	
	private int id;
	private String loginId;
	private String password;
	private String name;
	private Date createdAt;
	private String createdAtStr;
	private String updatedAtStr;
	private Date updatedAt;
	
	
	public User() {}
	
	public User(String loginId, String password, String name) {
		this.loginId = loginId;
		this.password = password;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
