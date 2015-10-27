package br.com.tdss.am.classea.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tdss.am.classea.bo.ConsumoBO;
import br.com.tdss.am.classea.entity.Consumo;
import br.com.tdss.am.classea.entity.Funcionario;
import br.com.tdss.am.classea.entity.Hospedagem;
import br.com.tdss.am.classea.entity.ProdutoServico;
import br.com.tdss.am.classea.utils.Util;

/**
 * Servlet implementation class RegistraConsumo
 */
@WebServlet("/RegistraConsumo")
public class RegistraConsumo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistraConsumo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idHospedagem = Integer.parseInt(request.getParameter("idHospedagem"));
			int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));
			int idProdutoServico = Integer.parseInt(request.getParameter("select-produto"));
			int quantidade = Integer.parseInt(request.getParameter("quantidade"));
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(System.currentTimeMillis());
			
			Hospedagem hospedagem = new Hospedagem();
			hospedagem.setIdHospedagem(idHospedagem);
			Funcionario funcionario = new Funcionario();
			funcionario.setIdPessoa(idFuncionario);
			ProdutoServico produtoServico = new ProdutoServico();
			produtoServico.setIdTipoServico(idProdutoServico);
			
			Consumo consumo = new Consumo();
			consumo.setProdutoServico(produtoServico);
			consumo.setQuantidade(quantidade);
			consumo.setData(Util.converterMilis(calendar));
			
			ArrayList<Consumo> c = new ArrayList<Consumo>();
			c.add(consumo);
			
			
			ConsumoBO consumoBO = new ConsumoBO();
			consumoBO.incluirConsumo(hospedagem, funcionario, c);
			
			
			response.sendRedirect("consumo.jsp?consumo=true");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("consumo.jsp?consumo=false");
		}
	}



}
