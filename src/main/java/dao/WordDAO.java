package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Word;
import dto.WordDTO;
public class WordDAO extends BaseDAO {
	
	public WordDTO selectByDictIdAndWordName(int dictionaryId, String wordName){
		WordDTO dto = null;
		
		Connection conn = getConnection();
		
		try {
			PreparedStatement ps 
			= conn.prepareStatement("SELECT * FROM words WHERE dictionary_id = ? AND word_name = ?");
			ps.setInt(1, dictionaryId);
			ps.setString(2, wordName);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto = new WordDTO();
				dto.setWordId(rs.getInt("word_id"));
				dto.setWordName(rs.getString("word_name"));
				dto.setWordDefinition(rs.getString("word_definition"));
				dto.setWordReference(rs.getString("word_reference"));
				dto.setTag(rs.getString("tag"));
				dto.setDictionaryId(rs.getInt("dictionary_id"));
				dto.setCreatedAt(rs.getTimestamp("created_at"));
				dto.setUpdatedAt(rs.getTimestamp("updated_at"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public int insert(WordDTO dto) {
		int result = 0;
		 Connection conn = getConnection();
		 
		 TransactionManager tm = new TransactionManager(conn);
		 
		 try {
			 PreparedStatement ps = conn.prepareStatement("INSERT INTO words(dictionary_id, word_name, word_definition, word_reference, word_tag) VALUES(?,?,?,?,?)");
			 ps.setInt(1, dto.getDictionaryId());
			 ps.setString(2,dto.getWordName());
			 ps.setString(3, dto.getWordDefinition());
			 ps.setString(4, dto.getWordReference());
			 ps.setString(5, dto.getTag());
			 
			 
			 result = ps.executeUpdate();
			 tm.commit();
		 }catch(SQLException e){
			 tm.rollback();
			 e.printStackTrace();
		 }
		 tm.close();
		 return result;
		 }
	public List<WordDTO> selectByDictionaryId(int dictionaryId){
		List<WordDTO> wordlist = new ArrayList<>();
		Connection conn = getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM words WHERE dictionary_id=?");
			ps.setInt(1, dictionaryId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				WordDTO dto = new WordDTO();
				dto.setWordId(rs.getInt("word_id"));
				dto.setWordName(rs.getString("word_name"));
				dto.setWordDefinition(rs.getString("word_definition"));
				dto.setWordReference(rs.getString("word_reference"));
				dto.setTag(rs.getString("word_tag"));
				dto.setDictionaryId(rs.getInt("dictionary_id"));
				dto.setCreatedAt(rs.getTimestamp("created_at"));
				dto.setUpdatedAt(rs.getTimestamp("updated_at"));
				wordlist.add(dto);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return wordlist;
	}
	
	public WordDTO selectByWordId(int wordId) {
		WordDTO dto = null;
		Connection conn = getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM words WHERE word_id=?");
		    ps.setInt(1, wordId);
		    ResultSet rs = ps.executeQuery();
		    if(rs.next()) {
		    	dto = new WordDTO();
		    	dto.setWordId(rs.getInt("word_id"));
				dto.setWordName(rs.getString("word_name"));
				dto.setWordDefinition(rs.getString("word_definition"));
				dto.setWordReference(rs.getString("word_reference"));
				dto.setTag(rs.getString("word_tag"));
				dto.setDictionaryId(rs.getInt("dictionary_id"));
				dto.setCreatedAt(rs.getTimestamp("created_at"));
				dto.setUpdatedAt(rs.getTimestamp("updated_at"));
		    }
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dto;
		
	}
	
	public int deleteWord(int wordId) {
		Connection conn = getConnection();
		TransactionManager tm = new TransactionManager(conn);
		
		int result = 0;
		
		try {
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM words WHERE word_id=?");
			ps.setInt(1, wordId);
			result = ps.executeUpdate();
			
			tm.commit();
		}catch(SQLException e) {
			tm.rollback();
			e.printStackTrace();
		}finally {
			tm.close();
		}
		return result;
	}
	
	public void updatePosition(int wordId, int x, int y) {
		try(Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"UPDATE words SET pos_x=?, pos_y=? WHERE word_id=?"
						)){
			ps.setInt(1, x);
			ps.setInt(2, y);
			ps.setInt(3, wordId);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Word> findAll(){
		List<Word> list = new ArrayList<>();
		try(Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"SELECT * FROM words")
				){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Word w = new Word();
				w.setWordId(rs.getInt("word_id"));
				w.setWordName(rs.getString("word_name"));
				w.setPosX(rs.getInt("pos_x"));
				w.setPosY(rs.getInt("pos_y"));
				list.add(w);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
			
		}
	
	public boolean updateWord(int wordId, String wordName, String wordDefinition, String wordReference, String tag) {
		
		Connection conn = getConnection();
		TransactionManager tm = new TransactionManager(conn);
		int result = 0;
		
		try{
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE words SET word_name=?, word_definition=?, word_reference=?, word_tag=? WHERE word_id=? ");
			ps.setString(1, wordName);
			ps.setString(2, wordDefinition);
			ps.setString(3,wordReference);
			ps.setString(4,tag);
			ps.setInt(5, wordId);
			
			result = ps.executeUpdate();
			tm.commit();
		}catch(SQLException e ) {
			tm.rollback();
			e.printStackTrace();
		}
		tm.close();
		return result > 0;
	}
}

