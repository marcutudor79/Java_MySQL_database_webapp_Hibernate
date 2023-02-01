
package Controller;

import DAO.AnimalsDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Animals;
import DAOImpl.AnimalsDAOImpl;

/**
 *
 * @author vali
 */
public class AnimalsController extends HttpServlet {

	Animals pacient = new Animals();
	AnimalsDAOImpl pacientDaoImpl = new AnimalsDAOImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("adaugaPacient") != null) {
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			pacient.setName(nume);
			pacient.setRegion(prenume);
			pacientDaoImpl.addAnimals(pacient);
			RequestDispatcher rd = request.getRequestDispatcher("add_Animals.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("afiseazaPacienti") != null) {
			List<Animals> listaPacienti = new ArrayList();
			listaPacienti = pacientDaoImpl.returnAnimals();
			request.setAttribute("listaPacienti", listaPacienti);
			RequestDispatcher rd = request.getRequestDispatcher("table_Animals.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("modificaPacient") != null) {
			int id1 = Integer.parseInt(request.getParameter("idpacient"));
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			pacientDaoImpl.modifyAnimals(id1, nume, prenume);
			RequestDispatcher rd = request.getRequestDispatcher("add_Animals.jsp");
			rd.forward(request, response);

		}

		if (request.getParameter("stergePacient") != null) {
			int id2 = Integer.parseInt(request.getParameter("idpacient"));
			pacient.setIdanimals(id2);
			pacientDaoImpl.deleteAnimals(pacient);
			RequestDispatcher rd = request.getRequestDispatcher("add_Animals.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}


