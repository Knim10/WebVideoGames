package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.VideoGame;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String store = request.getParameter("store");
		String game = request.getParameter("game");
		Double price = Double.parseDouble(request.getParameter("price"));
		VideoGame vg = new VideoGame(store, game, price);
		VideoGameHelper vgh = new VideoGameHelper();
		vgh.insertItem(vg);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
