package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Login.do", urlPatterns = { "/Login.do" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Login() {
        super();
       
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 String conta = request.getParameter("conta");

		 String senha = request.getParameter("senha");


		 if(conta.equals("Jose") && senha.equals("1234")) {

		 HttpSession sessao = request.getSession ();
		 
		 sessao.setAttribute("conta", conta);
		 
	       

		 response.sendRedirect ("Home.do");


		 }
		 else {

			 
			    response.setContentType("text/html");
				
				PrintWriter saida = response.getWriter();
				
				request.getRequestDispatcher("index.html").include (request, response);
				
						
				HttpSession sessao = request.getSession ();
				
				sessao.invalidate();
				
				saida.println ("<br>Usuário e/ou Senha Inválido! Por Favor, Tente novamente!<br>");      
		        	 
			
		           }
		 }
		
	
		
		
	}
