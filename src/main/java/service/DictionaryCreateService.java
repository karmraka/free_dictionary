package service;

import java.util.List;

import dao.DictionaryDAO;
import domain.Dictionary;
import dto.DictionaryDTO;

public class DictionaryCreateService {
	
	public boolean dictionaryCreateConfirm(Dictionary dictionary) {
		DictionaryDAO dictionaryDAO = new DictionaryDAO();
		
		List<String> existingName = dictionaryDAO.selectAllDictionaryNameByUserId(dictionary.getId());
		
		String newName = dictionary.getDictionaryName().trim();//trim()先頭と末尾の空白を削除
		for(String name: existingName) {
			if(name.equals(newName)) {
				return false;
			}
		}
		return true;
		}
	
	
	public boolean dictionaryEntryDo(Dictionary dictionary) {
		DictionaryDAO dictionaryDAO = new DictionaryDAO();
		DictionaryDTO dto = new DictionaryDTO(dictionary.getId(), dictionary.getDictionaryName());
		
		int result = dictionaryDAO.insert(dto);
		if(result == 1) {
			/*int newId = dictionaryDAO.selectLastInsertedIdByUser(dto.getId());
			dto.setDictionaryId(newId);*/
			
			return true;
		}else {
			return false;
		}
		
	}

	
	
	
	
	

}
