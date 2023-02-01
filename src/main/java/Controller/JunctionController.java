package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Animals;
import pojo.Characteristics;
import pojo.Junction;
import DAOImpl.JunctionDAOImpl;
import DAOImpl.HibernateUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author vali
 */
public class JunctionController extends HttpServlet {

	Junction consultatie = new Junction();
	JunctionDAOImpl consultatieDaoImpl = new JunctionDAOImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("adaugaConsultatie") != null) {
			// preluarea parametrilor de interes
			Integer idpacient = java.lang.Integer.parseInt(request.getParameter("idpacient"));
			Integer idmedic = java.lang.Integer.parseInt(request.getParameter("idmedic"));
			Session session = HibernateUtil.getSessionFactory().openSession();
			Animals pacient = (Animals) session.get(Animals.class, idpacient);
			Characteristics medic = (Characteristics) session.get(Characteristics.class, idmedic);
			consultatie.setAnimals(pacient);
			consultatie.setCharacteristics(medic);
			consultatieDaoImpl.addJunction(consultatie);
			RequestDispatcher rd = request.getRequestDispatcher("add_Junction.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("afiseazaConsultatie") != null) {
			List<Junction> listaConsultatie = new ArrayList();
			listaConsultatie = consultatieDaoImpl.returnJunction();
			request.setAttribute("listaConsultatie", listaConsultatie);
			RequestDispatcher rd = request.getRequestDispatcher("table_Junction.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("modificaConsultatie") != null) {
			Integer id1 = Integer.parseInt(request.getParameter("idconsultatie"));
			// preluarea parametrilor de interes
			Integer idpacient = java.lang.Integer.parseInt(request.getParameter("idpacient"));
			Integer idmedic = java.lang.Integer.parseInt(request.getParameter("idmedic"));
			Session session = HibernateUtil.getSessionFactory().openSession();
			Animals pacient = (Animals) session.get(Animals.class, idpacient);
			Characteristics medic = (Characteristics) session.get(Characteristics.class, idmedic);

			consultatieDaoImpl.modifyJunction(id1, pacient, medic);
			RequestDispatcher rd = request.getRequestDispatcher("add_Junction.jsp");
			rd.forward(request, response);

		}

		if (request.getParameter("stergeConsultatie") != null) {
			Integer id2 = Integer.parseInt(request.getParameter("idconsultatie"));
			consultatie.setIdjunction(id2);
			consultatieDaoImpl.deleteJunction(consultatie);
			RequestDispatcher rd = request.getRequestDispatcher("add_Junction.jsp");
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


