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
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateNewListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VideoGameHelper vgh = new VideoGameHelper();
		String listName = request.getParameter("listName");
		System.out.println(listName);

		String game = request.getParameter("game");
		String user = request.getParameter("userName");
		String price = request.getParameter("price");

		String[] selectedGames = request.getParameterValues("allItemsToAdd");
		List<VideoGame> selectedGamesInList = new ArrayList<VideoGame>();
		if (selectedGames != null && selectedGames.length > 0) {
			for (int i = 0; i < selectedGames.length; i++) {
				System.out.println(selectedGames[i]);
				VideoGame v = vgh.searchForGameById(Integer.parseInt(selectedGames[i]));
				selectedGamesInList.add(v);
			}
		}

		User userName = new User(user);
		ListDetails sld = new ListDetails(listName, userName);
		sld.setListOfGames(selectedGamesInList);
		ListDetailsHelper slh = new ListDetailsHelper();
		slh.insertNewListDetails(sld);

		System.out.println("Success!");
		System.out.println(sld.toString());

		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
