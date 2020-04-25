package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Professor;
import service.ProfessorService;




@WebServlet(name = "Consulta.do", urlPatterns = { "/Consulta.do" })
public class Consulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		response.setContentType("text/html;charset=UTF-8");
		 
		
		
	    int matricula = Integer.parseInt (request.getParameter("matricula_professor"));
	    
		Professor professor  = new Professor();
	
            professor.setMatricula(matricula);
          
			
			
		ProfessorService professorService = new ProfessorService ();
		professorService.alterar (professor);
		
		PrintWriter saida = response.getWriter();
		
		saida.println ("<br>  <h3> Consultar Professor  </h3> <br>");
		
		saida.println ("<br> Consulta realizada com sucesso!<br>");   
		

		saida.println (" <br>" + " " );	  
		

	   	saida.println ("<br><a href='Home.do'>Home</a>");
	   	
		saida.println (" <br>" + " " );	  
				      
		         	
	   	saida.println ("<br><a href='Logoff.do'>Sair</a>");
	   	    
	   	saida.println (" <br>" + " " );	  
	 
	   
	 
	    
	}


   }
