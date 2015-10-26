package br.com.tdss.am.classea.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tdss.am.classea.dao.impl.OracleReservaDAO;
import br.com.tdss.am.classea.entity.Reserva;

/**
 * Servlet implementation class RegistraHospedagem
 */
@WebServlet("/RegistraHospedagem")
public class RegistraHospedagem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			// Recebendo idReserva e buscando reserva a partir deste ID recebido
			int idReserva = Integer.parseInt(request.getParameter("idReserva"));
			Reserva reserva = new Reserva();
			reserva.setIdReserva(idReserva);
			OracleReservaDAO reservaDAO = new OracleReservaDAO();
			
			reserva = reservaDAO.buscarReservar(reserva);
			
			//Funcionario funcionario = new Funcionario();
			
			
			PrintWriter out = response.getWriter();
			out.append("<html><body>");
			// out.append(""+id);
			out.append("</body></html>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
