package jp.co.apsys.excel_api.service.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.apsys.excel_api.model.csv.dao.PersonDAO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jackson.map.ObjectMapper;

public class PersonListAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) throws Exception {

		PersonDAO dao = new PersonDAO();
		
		ObjectMapper mapper = new ObjectMapper();		
		String out = mapper.writeValueAsString(dao.list());

		
		response.setContentType("text/json");
		response.setCharacterEncoding("Shift_JIS");
		PrintWriter writer = response.getWriter();
		writer.print(out);
		writer.close();		
		return null;
	}

}
