package service;

import dao.UserDAO;
import domain.User;
import dto.UserDTO;

public class UserRegisterService {
	
	//ユーザードメイン情報から取得したIDがすでに登録されているかチェックするメソッド
	public boolean userEntryConfirm(User user) {
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = userDAO.selectByLoginId(user.getLoginId());//ユーザードメイン情報を取得し、IDから他の情報をdbから取得しDTOに格納
		
		if(userDTO == null) {//IDから取得できない＝データベースになければ新規登録できる、確認画面へ
			return true;
		}else {
			return false; 
		}
	}
	
	//ドメイン情報をDTOにセットしDAOからDBにセットするメソッド
	public boolean userEntryDo(User user) {
		UserDAO userDAO = new UserDAO();
		UserDTO dto = new UserDTO(user.getLoginId(), user.getPassword(),user.getName());
		
		int result = userDAO.insert(dto);
		if(result == 1) {
			return true;
		}else {
			return false;
		}
		
	}
	

}
