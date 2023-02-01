package Controller;

import DAO.CharacteristicsDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Characteristics;
import DAOImpl.CharacteristicsDAOImpl;

/**
 *
 * @author vali
 */
public class CharacteristicsController extends HttpServlet {

	Characteristics medic = new Characteristics();
	CharacteristicsDAOImpl medicDaoImpl = new CharacteristicsDAOImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("adaugaMedic") != null) {
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			String sectie = request.getParameter("sectie");
			String kingdom = request.getParameter("kingdom");
			medic.setClas(nume);
			medic.setOrders(prenume);
			medic.setSpecies(sectie);
			medic.setKingdom(kingdom);
			medicDaoImpl.addCharacteristics(medic);
			RequestDispatcher rd = request.getRequestDispatcher("add_Characteristics.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("afiseazaMedici") != null) {
			List<Characteristics> listaMedici = new ArrayList();
			listaMedici = medicDaoImpl.returnCharacteristics();
			request.setAttribute("listaMedici", listaMedici);
			RequestDispatcher rd = request.getRequestDispatcher("table_Characteristics.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("modificaMedic") != null) {
			int id1 = Integer.parseInt(request.getParameter("idmedic"));
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			String sectie = request.getParameter("sectie");
			String kingdom = request.getParameter("kingdom");
			medicDaoImpl.modifyCharacteristics(id1, nume, prenume, sectie, kingdom);
			RequestDispatcher rd = request.getRequestDispatcher("add_Characteristics.jsp");
			rd.forward(request, response);

		}

		if (request.getParameter("stergeMedic") != null) {
			int id2 = Integer.parseInt(request.getParameter("idmedic"));
			medic.setIdcharacteristics(id2);
			medicDaoImpl.deleteCharacteristics(medic);
			RequestDispatcher rd = request.getRequestDispatcher("add_Characteristics.jsp");
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


