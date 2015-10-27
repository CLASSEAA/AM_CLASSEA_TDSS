package br.com.tdss.am.classea.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tdss.am.classea.bo.ConsumoBO;
import br.com.tdss.am.classea.entity.Consumo;
import br.com.tdss.am.classea.entity.Hospedagem;

/**
 * Servlet implementation class ListaConsumo
 */
@WebServlet("/ListaConsumo")
public class ListaConsumo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaConsumo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idHospedagem = Integer.parseInt(request.getParameter("idHospedagem"));
		Hospedagem hospedagem = new Hospedagem();
		hospedagem.setIdHospedagem(idHospedagem);
		try {
			ConsumoBO consumoBO = new ConsumoBO();
			ArrayList<Consumo> consumo = consumoBO.listarConsumo(hospedagem);
			getServletContext().setAttribute("consumoHospedagem", consumo);
			getServletContext().setAttribute("hospedagem", hospedagem);
			response.sendRedirect("consumo.jsp?hospedagem=true");
		} catch (Exception e) {
			response.sendRedirect("consumo.jsp?hospedagem=false");
		}
	}

}
