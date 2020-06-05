package api;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import modelo.bean.Actividad;
import modelo.dao.ModeloActividad;

/**
 * Servlet implementation class ApiUpdateActividad
 */
@WebServlet("/ApiUpdateActividad")
public class ApiUpdateActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiUpdateActividad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String jsonActividad= request.getParameter("actividad");
		JSONObject jsonObject = new JSONObject(jsonActividad);
		
		
		Actividad actividad= new Actividad();
		
		actividad.setId(jsonObject.getInt("id"));
		actividad.setNombre(jsonObject.getString("nombre"));
		
		
		ModeloActividad ma= new ModeloActividad();
		
		ma.Insert(actividad);
		
		
		try {
			
			ma.getConexion().close();
			
		} catch (SQLException e) {
		e.printStackTrace();
		}
		
		response.setHeader("Access-Control-Allow-Origin","*"); //jsonp deia denean ez da behar
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		
	}

}
