package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProfessorService;
import model.Professor;


@WebServlet(name = "ListarProfessores.do", urlPatterns = { "/ListarProfessores.do" })

public class ListarProfessores extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
   
		 ProfessorService professorService = new ProfessorService();
		 
		 ArrayList<Professor> listaProfessores = null;
		 
		 listaProfessores = professorService.listarProfessores ();
		 
			response.setContentType ("text/html");        
			
			PrintWriter saida = response.getWriter();
			
			saida.println ("<br>  <h3> Lista de Professores </h3> ");
			
			
              saida.println ("<br><a href='Home.do'>Home</a>");
			   	
				saida.println (" <br>" + " " );	  
		 
			saida.println ("<html>");
			saida.println ("<body>");
			saida.println ("<table>");
						
			saida.println ("<tr>");
    		
			saida.println ("<th>Nome</th>");
			saida.println ("<th>CPF</th>");
			saida.println ("<th>Matricula</th>");
			saida.println ("<th>Endereço</th>");
			saida.println ("<th>Excluir</th>");
			saida.println ("<th>Alterar</th>");
			
			saida.println ("</tr>");
		
			
			
		    listaProfessores.forEach (
		    	p ->{
		    		
		    		    		
		    		saida.println ("<tr>");
		    	
		    		
		      		saida.println ("<td>" );
		    		
		    		saida.println(p.getNome());
		    		
		    		saida.println ("</td>");
		    		
		    		
		    		
		    		saida.println ("<td>");
		    		saida.println(p.getCpf());
		    		saida.println ("</td>");
		    		
		    		
		    		
		    			    		
		    		saida.println ("<td>");
		    		saida.println(p.getMatricula());
		    		saida.println ("</td>");
		    		
		    		
		    		saida.println ("<td>");
		    		saida.println(p.getEndereco());
		    		saida.println ("</td>");
		    		
		    		
		    		saida.println ("<td>");
		    		saida.println("<a href= 'ExcluirProfessor.do?matricula="
		    				       + p.getMatricula() + " ' > Excluir </a>");
		    		
		    		saida.println ("</td>");
		    		
		    		
		    		saida.println ("<td>");
		    		
		    		saida.println ("<a href='AlterarProfessor.do?matricula="
		    				+ p.getMatricula() + "'>Alterar");
		    		
		    		saida.println ("</tr>");
		    		
		 
		       		
		    		
		    	}
		    
		    );
		    saida.println ("</table>");
		   
			saida.println ("</body>");
			
			 saida.println ("</html>");
			 
	
				
						
				
				saida.println ("<br> Lista concluída com sucesso!");   
				
				saida.println (" <p>&#128517;</p>");
				
			
			   	saida.println ("<a href='Logoff.do'>Sair</a>");
			   	    
			   	saida.println (" <br>" + " " );	  
	
	}
	
	

}
