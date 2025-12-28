package valodation;

import java.util.ArrayList;
import java.util.List;

public class Validation {
	private List<String> errorMsgList;
	
	public Validation() {
		this.errorMsgList = new ArrayList<>();
	}
	
	//エラーメッセージがあるかどうか確認するメソッド
	public boolean hasErrorMsg() {
		if(errorMsgList.size() > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	//渡されたテキストが空ならエラーメッセージを返すメソッド
	public void isBlank(String textName, String text) {
		if(text==null || text.isEmpty()) {
			this.errorMsgList.add(textName + "が入力されていません");
		}
	}
	
	//文字数チェック、エラーメッセージ追加メソッド
	public void length(String textName, String text, int min, int max) {
		if(text==null || text.length()<min || text.length()>max) {
			this.errorMsgList.add(textName + "は" + min + "～" + max + "文字以内で入力してください");
		}
	}
	
	//エラーメッセージを追加するメソッド
	public void addErrorMsg(String msg) {
		errorMsgList.add(msg);
	}
	
	//エラーメッセージのリストを返すメソッド
	public List<String> getErrorMsgList(){
		return errorMsgList;
	}

}
