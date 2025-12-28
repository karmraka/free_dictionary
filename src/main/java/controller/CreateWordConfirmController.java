package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Word;
import dto.DictionaryDTO;
import service.CreateWordService;
import dao.DictionaryDAO;

@WebServlet("/CreateWordConfirm")
public class CreateWordConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String wordName = request.getParameter("wordName");
		String wordDefinition = request.getParameter("wordDefinition");
		String wordReference = request.getParameter("wordReference");
		String tag = request.getParameter("tag");
		
		String dictionaryIdStr = request.getParameter("dictionaryId");
		int dictionaryId = Integer.parseInt(dictionaryIdStr);
		
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
			}
		}
		
		int dictionaryId = maxDictId;
		*/
		
		
		Word word = new Word(dictionaryId, wordName,wordDefinition, wordReference, tag);
		
		CreateWordService cws = new CreateWordService();
		boolean result = cws.wordEntryDo(word);
		
		if(result == true) {
			DictionaryDAO dictDAO = new DictionaryDAO();
			DictionaryDTO dictDTO = dictDAO.selectByDictionaryId(dictionaryId);
			
			request.setAttribute("dictionary",dictDTO);
			request.setAttribute("dictionaryId", dictionaryId);
			request.setAttribute("word",word);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/createWordDone.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("wordError", "単語を登録に失敗しました");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/createWord.jsp");
			rd.forward(request, response);
			
		}
	}

}
