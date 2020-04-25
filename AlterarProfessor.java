package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Professor;
import service.ProfessorService;


@WebServlet(name = "AlterarProfessor.do", urlPatterns = { "/AlterarProfessor.do" })
public class AlterarProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		   
		 ProfessorService professorService = new ProfessorService();
		 
		 ArrayList<Professor> listaProfessores = null;
		 
		 listaProfessores = professorService.listarProfessores ();
		 
			response.setContentType ("text/html");        
			
			PrintWriter saida = response.getWriter();
			
			saida.println ("<br>  <h3> Alterar Dados Professor </h3> ");
			
			saida.println (" <p>&#128514;</p>");			
			
             saida.println ("<a href='Home.do'>Home</a>");
			   	
				saida.println (" <br>" + " " );	  
				
				saida.println ("<br><a href='Logoff.do'>Sair</a>");
		   	    
			   	saida.println (" <br>" + " " );	  
				
			   	
				
				saida.println ("<br> Digite as alterações: <br>");   
				saida.println (" <br>" + " " );	  
				
				int matricula = Integer.parseInt(request.getParameter("matricula"));
				
				Professor professor = professorService.consultar(matricula);
				
				
				saida.println ("<form action= 'AlterarProfessor.do'  method = 'post'>");
				
			
				saida.println ("Matricula: ");
				saida.println ("<input type=\"text\" name='matricula_professor'  value ='"
						+ professor.getMatricula() + "'> <br>");	
				
				saida.println (" <br>" + " " );	  		
				
				saida.println ("Nome: ");
				saida.println ("<input type=\"text\" name='nome_professor'   value = '"
						+ professor.getNome() + "'> <br>");
				
				saida.println (" <br>" + " " );	  
				
				saida.println ("CPF: ");
				saida.println ("<input type=\"text\"name='cpf_professor'   value ='"
						+ professor.getCpf() + "'> <br>");
				
				saida.println (" <br>" + " " );	  
				
				saida.println ("Endereço: ");
				saida.println ("<input type=\"text\"name='endereco_professor' value ='"
						+ professor.getEndereco() +"'> <br>");
				
				saida.println (" <br>" + " " );	  
				
				
				saida.println ("<input type='submit' value='Alterar'>");
				
				saida.println ("<input type='reset'  value='Limpar'> "); 
			

					
			 	saida.println ("<form action= 'ListarProfessores.do'  method = 'post'>");
				
				   saida.println ("<br>  <h3>Confira a Lista de professores </h3> ");
					
			saida.println ("<html>");
			saida.println ("<body>");
			saida.println ("<table>");
						
			saida.println ("<tr>");
   		
			saida.println ("<th>Nome</th>");
			saida.println ("<th>CPF</th>");
			saida.println ("<th>Matricula</th>");
			saida.println ("<th>Endereço</th>");
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
		    		
		    		saida.println ("<a href='AlterarProfessor.do?matricula="
		    				+ p.getMatricula() + "'>Alterar");
		    		
		    		saida.println ("</tr>");
		    		
		 
		    		
		    	}
		    
		    );
		    saida.println ("</table>");
		   
			saida.println ("</body>");
			
			 saida.println ("</html>");
			 

				
				saida.println (" <p>&#128517;</p>");
				
												         	
			   	saida.println ("<br><a href='Logoff.do'>Sair</a>");
			   	    
			   	saida.println (" <br>" + " " );	   
			   	
	
	}
	
	
	
	
	

	


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String cpf = request.getParameter("cpf_professor");
		String nome = request.getParameter ("nome_professor");
		String endereco = request.getParameter("endereco_professor");
		int matricula = Integer.parseInt(request.getParameter("matricula_professor"));
		
		Professor professor = new Professor ();
		professor.setCpf (cpf);
		professor.setNome(nome);
		professor.setEndereco (endereco);
		professor.setMatricula (matricula);
		
		
		ProfessorService professorService = new ProfessorService ();
		professorService.alterar (professor);
		
		
		
	}

}
