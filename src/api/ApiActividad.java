package api;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONStringer;

import modelo.bean.Actividad;
import modelo.dao.ModeloActividad;

/**
 * Servlet implementation class ApiActividad
 */
@WebServlet("/ApiActividad")
public class ApiActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiActividad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		int idActividad= Integer.parseInt(request.getParameter("id"));
		ModeloActividad ma= new ModeloActividad();
		Actividad actividad = ma.get(idActividad);
		
	
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		
		String jsonString= JSONStringer.valueToString(actividad);
		
		PrintWriter out= new PrintWriter(new OutputStreamWriter(response.getOutputStream(),"UTF8"),true);
		
		
		out.print(jsonString);
		out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
