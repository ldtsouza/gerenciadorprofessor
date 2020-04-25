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


@WebServlet(name = "CadastrarProfessor.do", urlPatterns = { "/CadastrarProfessor.do" })
public class CadastrarProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CadastrarProfessor() {
        super();
      
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
				
			
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
		professorService.cadastrar(professor);
		
		
		response.setContentType("text/html");
		
		PrintWriter saida = response.getWriter();
		saida.println ("<form action= 'CadastrarProfessor.do'  method = 'post'>");
		
		saida.println ("<br>  <h3> Cadastrar Professor  </h3> <br>");
		
	 	saida.println ("<br><a href='Home.do'>Home</a>");
	   	
		saida.println (" <br>" + " " );	 
      
		
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
		
		saida.println ("<input type='submit'  value='Cadastrar'>");
		
		saida.println (" <input type='reset' value='Limpar'>");
		
	
		
		saida.println ("</form>");
		
			
		
		saida.println ("<br> Cadastro realizado com sucesso!<br>");
		
		saida.println ( "<p>&#128512;</p>");
		

	   	
		saida.println ("<br><a href='Cadastrar.html'>Sair</a>");
		
		saida.println (" <br>" + " " );	  
		
		
		
	
			
	}
      
		
	
	   
	}	
	


