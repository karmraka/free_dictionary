package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UserDTO;

public class UserDAO extends BaseDAO{
	
	//渡されたloginIdをｄｂから探してそのＩＤの他の要素を取得する。それをインスタンス化したDTOにセットする
	public UserDTO selectByLoginId(String loginId) {
		UserDTO dto = null;
		
		Connection conn = getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE login_id = ?");
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getInt("id"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setCreatedAt(rs.getTimestamp("created_at"));
				dto.setUpdatedAt(rs.getTimestamp("updated_at"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	//トランザクションを使ったメソッド　渡されたDTOからのデータをdbへ追加
	public int insert(UserDTO dto) {
		int result = 0;
		Connection conn = getConnection();
		TransactionManager tm = new TransactionManager(conn); //transactionmanagerクラスのコンストラクタへ
		
		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO users(login_id, password, name) VALUES(?,?,?)");
			ps.setString(1, dto.getLoginId());
			ps.setString(2, dto.getPassword());
			ps.setString(3,dto.getName());
			
			result = ps.executeUpdate();//ｄｂにインサート成功回数が返る
			tm.commit();//tranasactionmanagerのcommitメソッド
		}catch(SQLException e) {
			tm.rollback();//transactionmanagerクラスのrollbackメソッド
			e.printStackTrace();
		}
		tm.close();
		return result;
	}
}
