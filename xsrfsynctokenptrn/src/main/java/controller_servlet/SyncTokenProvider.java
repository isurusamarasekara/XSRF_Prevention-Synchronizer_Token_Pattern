package controller_servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import pojo_model.SyncTokenStore;

/**
 *
 *
 */
public class SyncTokenProvider extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession userSession = request.getSession(false);

		if (userSession != null) {
			response.setStatus(200);

			Map<String, String> returnMap = new HashMap<String, String>();
			returnMap.put("syncToken", SyncTokenStore.getRelevantToken(userSession.getId()));
			String json = new Gson().toJson(returnMap);
			response.setContentType("application/json");
			response.getWriter().write(json);
	    }
	}

	/**
	 *
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
