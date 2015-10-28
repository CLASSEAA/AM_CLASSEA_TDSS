package br.com.tdss.am.classea.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tdss.am.classea.bo.HospedagemBO;
import br.com.tdss.am.classea.bo.ReservaBO;
import br.com.tdss.am.classea.entity.Hospedagem;
import br.com.tdss.am.classea.entity.Reserva;
import br.com.tdss.am.classea.utils.Util;

/**
 * Servlet responsavel por Registrar {@link Hospedagem} 
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
			Util util = new Util();
			String data = util.buscarDataAtual();
			Hospedagem hospedagem = new Hospedagem();
			HospedagemBO hospedagemBO = new HospedagemBO();

			// Recebendo idReserva e buscando reserva a partir deste ID recebido
			int idReserva = Integer.parseInt(request.getParameter("idReserva"));
			Reserva reserva = new Reserva();
			reserva.setIdReserva(idReserva);
			ReservaBO reservaBO = new ReservaBO();

			ArrayList<Hospedagem> h = new ArrayList<Hospedagem>();
			for (int i = 0; i < reservaBO.buscarReserva(reserva).getQuartos()
					.size(); i++) {
				hospedagem.setReserva(reservaBO.buscarReserva(reserva));
				hospedagem.setFuncionario(reserva.getFuncionario());
				hospedagem.setQuarto(reservaBO.buscarReserva(reserva)
						.getQuartos().get(i));
				hospedagem.setDataEntrada(data);
				hospedagem.getDataEntrada();
				// Incluir no banco
				hospedagemBO.incluirHospedagem(hospedagem,
						hospedagem.getFuncionario());
				h.add(hospedagemBO.buscarHospedagem(hospedagem.getQuarto()));

			}
			getServletContext().setAttribute("hospedagens", h);
			response.sendRedirect("hospedagem.jsp?hospedagem=true");
		} catch (Exception e) {
			getServletContext().setAttribute("erro", e.getMessage());
			response.sendRedirect("hospedagem.jsp?hospedagem=false");
			e.printStackTrace();
		}
	}

}
