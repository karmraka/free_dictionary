package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DictionaryDTO;

public class DictionaryDAO extends BaseDAO{
	
	public DictionaryDTO selectById(int id) {
		DictionaryDTO dto = null;
		
		Connection conn = getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM dictionaries WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new DictionaryDTO();
				dto.setId(rs.getInt("id"));
				dto.setDictionaryId(rs.getInt("dictionary_id"));
				dto.setDictionaryName(rs.getString("dictionary_name"));
				dto.setCreatedAt(rs.getTimestamp("created_at"));
				dto.setUpdatedAt(rs.getTimestamp("updated_at"));
			}
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return dto;
	}
	
	public int insert(DictionaryDTO dto) {
		int result = 0;
		
		Connection conn = getConnection();
		TransactionManager tm = new TransactionManager(conn);
		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO dictionaries(id, dictionary_name)VALUES(?,?)");
			ps.setInt(1, dto.getId());
			ps.setString(2, dto.getDictionaryName());
			
			result = ps.executeUpdate();
			tm.commit();
		}catch(SQLException e) {
			tm.rollback();
			e.printStackTrace();
		}
		tm.close();
		return result;
	}
	
	
	public List<String> selectAllDictionaryNameByUserId(int id){
	    List<String> dictionaryNames = new ArrayList<>();
	    
	    Connection conn = getConnection();
	    try {
	    	PreparedStatement ps = conn.prepareStatement(
	    			"SELECT dictionary_name FROM dictionaries WHERE id = ?");
	    	ps.setInt(1, id);
	    	ResultSet rs = ps.executeQuery();
	    	
	    	while(rs.next()) {
	    		dictionaryNames.add(rs.getString("dictionary_name"));
	    	}
	    }catch(SQLException e) {
	    	    e.printStackTrace();
	    }
	    	return dictionaryNames;
	    }
	
	public DictionaryDTO selectByDictionaryId(int dictionaryId) {
		DictionaryDTO dto = null;
		
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					//"SELECT dictionary_name FROM dictionaries WHERE dictionary_id = ?");//dictionary_idは一意の主キー
					"SELECT * FROM dictionaries WHERE dictionary_id = ?");
			ps.setInt(1, dictionaryId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new DictionaryDTO();
				dto.setId(rs.getInt("id"));
				dto.setDictionaryId(rs.getInt("dictionary_id"));
				dto.setDictionaryName(rs.getString("dictionary_name"));
				dto.setCreatedAt(rs.getTimestamp("created_at"));
				dto.setUpdatedAt(rs.getTimestamp("updated_at"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public int selectLastInsertedIdByUser(int id) {
		int dictionaryId = 0;
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT MAX(dictionary_id) AS dictionary_id FROM dictionaries WHERE id = ?"
					);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dictionaryId = rs.getInt("dictionary_id");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dictionaryId;
	}
	
	public List<DictionaryDTO> selectAllDictionaryInfoByUserId(int id){
		
	    List<DictionaryDTO> dictionaryinfo = new ArrayList<>();
	    
	    Connection conn = getConnection();
	    
	    try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM dictionaries WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				DictionaryDTO dto = new DictionaryDTO();
				dto.setId(rs.getInt("id"));
				dto.setDictionaryId(rs.getInt("dictionary_id"));
				dto.setDictionaryName(rs.getString("dictionary_name"));
				dto.setCreatedAt(rs.getTimestamp("created_at"));
				dto.setUpdatedAt(rs.getTimestamp("updated_at"));
				
				dictionaryinfo.add(dto);
			}
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
		return dictionaryinfo;
	}
	
	public int deleteDictionary(int dictionaryId) {
		Connection conn = getConnection();
		TransactionManager tm = new TransactionManager(conn);
		
		int result = 0;
		
		try {
			PreparedStatement ps1 = conn.prepareStatement(
					"DELETE FROM words WHERE dictionary_id = ?");
			ps1.setInt(1, dictionaryId);
			ps1.executeUpdate();
			
			PreparedStatement ps2 = conn.prepareStatement(
					"DELETE FROM dictionaries WHERE dictionary_id=?");
			ps2.setInt(1, dictionaryId);
			result = ps2.executeUpdate();
			
			tm.commit();
		}catch(SQLException e) {
			tm.rollback();
			e.printStackTrace();
		}finally {
			tm.close();
		}
		return result;
	}
	
	public boolean updateDictionaryName(int dictionaryId, String dictionaryName) {
        int result = 0;
		
		Connection conn = getConnection();
		TransactionManager tm = new TransactionManager(conn);
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE dictionaries SET dictionary_name = ? WHERE dictionary_id = ?");
			ps.setString(1, dictionaryName);
			ps.setInt(2, dictionaryId);
			
			result = ps.executeUpdate();
			tm.commit();
		}catch(SQLException e) {
			tm.rollback();
			e.printStackTrace();
		}
		tm.close();
		return result == 1;
	}
	
}
	    
	    
	    
	   /*try {
	    	PreparedStatement ps = conn.prepareStatement(
	    			"SELECT iddictionary_name FROM dictionaries WHERE id = ?");
	    	ps.setInt(1, id);
	    	ResultSet rs = ps.executeQuery();
	    	
	    	while(rs.next()) {
	    		dictionaryNames.add(rs.getString("dictionary_name"));
	    	}
	    }catch(SQLException e) {
	    	    e.printStackTrace();
	    }
	    	return dictionaryNames;
	    }
		
	}
}*/