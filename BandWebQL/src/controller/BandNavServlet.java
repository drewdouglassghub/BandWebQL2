package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Band;

/**
 * Servlet implementation class BandNavServlet
 */
@WebServlet("/BandNavServlet")
public class BandNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BandNavServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String act = request.getParameter("doThisToBand");
		BandHelper dao = new BandHelper();

		
		if (act == null) {
		 //no button has been selected
		getServletContext().getRequestDispatcher("/ViewAllItemsServlet").forward(request, response);
		} else if (act.equals("delete")) {		
			
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Band bandToDelete = dao.searchForBandById(tempId);
			dao.deleteBand(bandToDelete);
			getServletContext().getRequestDispatcher("/ViewAllBandsServlet").forward(request, response);		
			}
			catch (NumberFormatException e) {
				System.out.println("Forgot to click a button.");
			} 
			finally {				
				getServletContext().getRequestDispatcher("/ViewAllBandsServlet").forward(request, response);
				
			}
	
		} else if (act.equals("edit")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Band bandToEdit = dao.searchForBandById(tempId);
				request.setAttribute("bandToEdit", bandToEdit);
				getServletContext().getRequestDispatcher("/EditBand.jsp").forward(request, response);
				 } catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/ViewAllBandsServlet").
				forward(request, response);
				 }
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/AddBand.jsp").forward(request, response);
		}
	}

}
