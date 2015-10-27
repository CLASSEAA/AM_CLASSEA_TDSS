package br.com.tdss.am.classea.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tdss.am.classea.dao.impl.OracleHospedagemDao;
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
			String data = util.buscarDataAtual();
			data = data.replace("/", "");
			Hospedagem hospedagem = new Hospedagem();
			OracleHospedagemDao hospedagemDAO = new OracleHospedagemDao();
			// Recebendo idReserva e buscando reserva a partir deste ID recebido
			int idReserva = Integer.parseInt(request.getParameter("idReserva"));
			Reserva reserva = new Reserva();
			reserva.setIdReserva(idReserva);
			OracleReservaDAO reservaDAO = new OracleReservaDAO();
			
			for (int i = 0; i < reservaDAO.buscarReservar(reserva).getQuartos()
					.size(); i++) {
				hospedagem.setReserva(reservaDAO.buscarReservar(reserva));
				hospedagem.setFuncionario(reserva.getFuncionario());
				hospedagem.setQuarto(reservaDAO.buscarReservar(reserva).getQuartos().get(i));
				hospedagem.setDataEntrada(data);
				
				//Incluir no banco
				hospedagemDAO.incluirHospedagem(hospedagem, hospedagem.getFuncionario());
				
			}
			System.out.println("aee");
			System.out.println("Concluído");
			response.sendRedirect("hospedagem.jsp?hospedagem=true");
		} catch (SQLException e) {
			response.sendRedirect("hospedagem.jsp?hospedagem=false");
			e.printStackTrace();
			}
		}

}
