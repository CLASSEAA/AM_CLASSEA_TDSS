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
import br.com.tdss.am.classea.entity.Funcionario;
import br.com.tdss.am.classea.entity.Hospedagem;
import br.com.tdss.am.classea.entity.Quarto;
import br.com.tdss.am.classea.entity.Reserva;
import br.com.tdss.am.classea.utils.Util;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

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
			Util util = new Util();
			Hospedagem hospedagem = new Hospedagem();
			
			// Recebendo idReserva e buscando reserva a partir deste ID recebido
			int idReserva = Integer.parseInt(request.getParameter("idReserva"));
			Reserva reserva = new Reserva();
			reserva.setIdReserva(idReserva);
			OracleReservaDAO reservaDAO = new OracleReservaDAO();
			
			for (int i = 0; i < reservaDAO.buscarReservar(reserva).getQuartos()
					.size(); i++) {
				hospedagem.setReserva(reservaDAO.buscarReservar(reserva));
				hospedagem.setFuncionario(reserva.getFuncionario());
				hospedagem.setQuarto(reserva.getQuartos().get(i));
				hospedagem.setDataEntrada(util.buscarDataAtual());
				
			}

			PrintWriter out = response.getWriter();
			out.append("<html><body>");
			// out.append(""+id);
			out.append("</body></html>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}

	public static void main(String[] args) {
		System.out.println("AI VITOR VAI TOMA NO CÚ");
	}

}
