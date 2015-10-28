package br.com.tdss.am.classea.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tdss.am.classea.bo.ProdutoServicoBO;
import br.com.tdss.am.classea.entity.ProdutoServico;

/**
 * Servlet responsavel pela Listagem de {@link ProdutoServico}
 */
@WebServlet("/ListaProdutoServico")
public class ListaProdutoServico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaProdutoServico() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<ProdutoServico> produtoServico = new ArrayList<ProdutoServico>();
			ProdutoServicoBO psBO = new ProdutoServicoBO();
			produtoServico = psBO.listarProdutoServico();
			getServletContext().setAttribute("produtoServico", produtoServico);
			response.sendRedirect("consumo.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
