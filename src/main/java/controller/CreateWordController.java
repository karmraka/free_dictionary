package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DictionaryDAO;
import domain.Word;
import dto.DictionaryDTO;
import service.CreateWordService;
import valodation.Validation;

@WebServlet("/CreateWord")
public class CreateWordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String dictionaryIdStr = request.getParameter("dictionaryId");
		int dictionaryId = Integer.parseInt(dictionaryIdStr);
		
		DictionaryDAO dictDAO = new DictionaryDAO();
		DictionaryDTO dictDTO = dictDAO.selectByDictionaryId(dictionaryId);
		
		request.setAttribute("dictionary", dictDTO);
		request.setAttribute("dictionaryId", dictionaryId);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/createWord.jsp");
		rd.forward(request, response);
	}
	    
		/*String dictionaryId = request.getParameter("dictionaryId");
		if(dictionaryId != null) {
			request.setAttribute("dictionaryId", dictionaryId);
		}*/
		/*String dictionaryIdstr = request.getParameter("dictionaryId");
		int dictionaryId = Integer.parseInt(dictionaryIdstr);*/
		
		/*ArrayList<DictionaryDTO> dictlist = new ArrayList<DictionaryDTO>();
		HttpSession session = request.getSession();
		int maxDictId = 0;
		DictionaryDTO maxDTO = new DictionaryDTO();
		dictlist = (ArrayList<DictionaryDTO>)session.getAttribute("dictionaryinfo");
		for(DictionaryDTO dict : dictlist) {
			if(dict.getDictionaryId() > maxDictId) {
				maxDictId = dict.getDictionaryId();//dictionaryIdの最大値
				maxDTO = dict;//dictionaryIdが最大（最新）のDTOデータ
			}
		}
		int dictionaryId = maxDictId;
		
		
		DictionaryDAO dictDAO = new DictionaryDAO();
		DictionaryDTO dictDTO = dictDAO.selectByDictionaryId(dictionaryId);
		request.setAttribute("dictionary", dictDTO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/createWord.jsp");
		rd.forward(request, response);
	}*/


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
	    String wordName = request.getParameter("wordName");
		String wordDefinition = request.getParameter("wordDefinition");
		String wordReference = request.getParameter("wordReference");
		String tag = request.getParameter("tag");
		int dictionaryId = Integer.parseInt(request.getParameter("dictionaryId"));
		
		
		/*HttpSession session = request.getSession();
		Dictionary dict = (Dictionary)session.getAttribute("dictionary");
		int dictionaryId = dict.getDictionaryId();*/
		
		/*ArrayList<DictionaryDTO> dictlist = new ArrayList<DictionaryDTO>();
		HttpSession session = request.getSession();
		int maxDictId = 0;
		DictionaryDTO maxDTO = new DictionaryDTO();
		dictlist = (ArrayList<DictionaryDTO>)session.getAttribute("dictionaryinfo");
		for(DictionaryDTO dict : dictlist) {
			if(dict.getDictionaryId() > maxDictId) {
				maxDictId = dict.getDictionaryId();//dictionaryIdの最大値
				maxDTO = dict;//dictionaryIdが最大（最新）のDTOデータ
			*/
		//}
			
		//}
		//int dictionaryId = maxDictId;
		
		
		Validation validation = new Validation();
		validation.isBlank("単語名", wordName);
		validation.length("単語名", tag, 1,50);
		validation.length("タグ", tag, 0, 50);
		
		if(validation.hasErrorMsg()) {
			DictionaryDAO dictDAO = new DictionaryDAO();
			DictionaryDTO dictDTO = dictDAO.selectByDictionaryId(dictionaryId);
			
			request.setAttribute("dictionary", dictDTO);
			request.setAttribute("dictionaryId", dictionaryId);
			
			
			request.setAttribute("errorMsg", validation.getErrorMsgList());
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/createWord.jsp");
			rd.forward(request, response);
			return;
			}
		
		Word word = new Word(dictionaryId, wordName, wordDefinition, wordReference, tag);
		CreateWordService cws = new CreateWordService();
		boolean result = cws.wordEntryConfirm(word);
		
		if(result == true) {
			DictionaryDAO dictDAO = new DictionaryDAO();
			DictionaryDTO dictDTO = dictDAO.selectByDictionaryId(dictionaryId);
			
			request.setAttribute("word", word);
			request.setAttribute("dictionary", dictDTO);
			request.setAttribute("dictionaryId", dictionaryId);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/createWordConfirm.jsp");
			rd.forward(request, response);
		}else {
			validation.addErrorMsg(wordName + "は登録済みの単語です");
			request.setAttribute("errorMsg", validation.getErrorMsgList());
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/createWord.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
