package br.com.tdss.am.classea.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.tdss.am.classea.dao.impl.OracleFuncionarioDAO;
import br.com.tdss.am.classea.entity.Funcionario;

/**
 * Servlet responsavel por Validar Login
 */
@WebServlet("/ValidarLogin")
public class ValidarLogin extends HttpServlet {
	private static final long serialVersionUID = 7633293501883840556L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(); // obtem a sessao do
													// usuario, caso exista

		Funcionario user = null;
		String login_form = request.getParameter("login"); // Pega o Login vindo
															// do formulario
		String senha_form = request.getParameter("senha"); // Pega a senha vinda
															// do formulario

		try {
			OracleFuncionarioDAO dao = new OracleFuncionarioDAO(); // cria uma
																	// instancia
																	// do DAO
																	// usuario
			user = dao.getFuncionario(login_form, senha_form);
		} catch (Exception e) {

		}

		// se nao encontrou usuario no banco, redireciona para a pagina de erro!
		if (user == null) {
			session.invalidate();
			request.getRequestDispatcher("erroLogin.jsp").forward(request, response);
		} else {
			// se o dao retornar um usuario, coloca o mesmo na sessao
			session.setAttribute("user", user);
			request.getRequestDispatcher("hospedagem.jsp").forward(request, response);
		}

	}

}
