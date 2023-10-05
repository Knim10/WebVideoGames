package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.User;
import model.VideoGame;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditListDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ListDetailsHelper ldh = new ListDetailsHelper();
		VideoGameHelper vgh = new VideoGameHelper();
		UserHelper uh = new UserHelper();

		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = ldh.searchForListDetailsById(tempId);

		String newListName = request.getParameter("listName");

		String userName = request.getParameter("userName");
		User newUserName = uh.findUser(userName);

		try {
			String[] selectedGames = request.getParameterValues("allItemsToAdd");
			List<VideoGame> selectedGamesInList = new ArrayList<VideoGame>();

			for (int i = 0; i < selectedGames.length; i++) {
				System.out.println(selectedGames[i]);
				VideoGame v = vgh.searchForGameById(Integer.parseInt(selectedGames[i]));
				selectedGamesInList.add(v);
			}
			listToUpdate.setListOfGames(selectedGamesInList);
		} catch (NullPointerException ex) {
			List<VideoGame> selectedGamesInList = new ArrayList<VideoGame>();
			listToUpdate.setListOfGames(selectedGamesInList);
		}
		listToUpdate.setListName(newListName);
		listToUpdate.setUserName(newUserName);

		ldh.updateList(listToUpdate);

		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
