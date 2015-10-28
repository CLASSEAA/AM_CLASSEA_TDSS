package br.com.tdss.am.classea.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tdss.am.classea.bo.ReservaBO;
import br.com.tdss.am.classea.entity.Reserva;

/**
 * Servlet responsavel pela busca de {@link Reserva} utilizando {@link ReservaBO} para validar as regras de negócio
 */
@WebServlet("/BuscaReserva")
public class BuscaReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuscaReserva() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			int idReserva = Integer.parseInt(request.getParameter("idReserva"));
			Reserva reserva = new Reserva();
			ReservaBO reservaBO = new ReservaBO();
			reserva.setIdReserva(idReserva);
			reserva = reservaBO.buscarReserva(reserva);
			if (reserva.getIdReserva() == 0) {
				response.sendRedirect("hospedagem.jsp?reserva=false");
			} else {
				getServletContext().setAttribute("reserva", reserva);
				response.sendRedirect("hospedagem.jsp?reserva=true");
			}
		} catch (Exception e) {
			response.sendRedirect("hospedagem.jsp?reserva=false");
		}
	}

}
