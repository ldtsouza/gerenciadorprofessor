package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet(name = "Home.do", urlPatterns = { "/Home.do" })
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

		response.getWriter().append("Served at: ").append(request.getContextPath());
   
	
		 
		
		 
	
	response.setContentType ("text/html");        

    HttpSession sessao = request.getSession ();
   
    String conta = (String) sessao.getAttribute ("conta");
   
    PrintWriter saida = response.getWriter();

          
    if (conta == null ) {
    saida.println("Faça o login primeiro" );
    saida.println ("teste");
    response.sendRedirect ("Login.do");
 
    }else {
    	
            
	 saida.println (" <h1> Gerenciador de Professores </h1>");

	 saida.println("Seja Bem vindo, " + ""+ conta + "<br>");
	  
	 
	 saida.println ( " <br><a href='ListarProfessores.do'>Listar</a> <br>");
	 
		
	 saida.println ( " <br><a href='ExcluirProfessor.do'>Excluir</a> <br>");
		
	 saida.println (" <br>" + " " );	  
			      
	  
   	saida.println ("<br><a href='Logoff.do'>Sair</a>");
   	    

    }
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
