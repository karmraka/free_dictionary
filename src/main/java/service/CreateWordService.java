package service;

import dao.WordDAO;
import domain.Word;
import dto.WordDTO;

public class CreateWordService {
	
	public boolean wordEntryConfirm(Word word){
		
		WordDAO wordDAO = new WordDAO();
		WordDTO wordDTO = wordDAO.selectByDictIdAndWordName(word.getDictionaryId(),word.getWordName()); //主キーはwordId。wordtableに同じdictionaryIdの中で同名のwordがないかチェック
	    
		if(wordDTO == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean wordEntryDo(Word word) {
		
		WordDAO wordDAO = new WordDAO();
		WordDTO dto = new WordDTO(word.getDictionaryId(),word.getWordName(),word.getWordDefinition(),word.getWordReference(), word.getTag());
		
		int result = wordDAO.insert(dto);
		if(result == 1) {
			return true;
		}else {
			return false;
		}
	}
}