package api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import modelo.bean.Actividad;
import modelo.dao.ModeloActividad;

/**
 * Servlet implementation class ApiCreateActividadesValidados
 */
@WebServlet("/ApiCreateActividadesValidados")
public class ApiCreateActividadesValidados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiCreateActividadesValidados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String jsonActividad= request.getParameter("actividad");
		
		JSONArray jsonArray = new JSONArray();
		ModeloActividad ma = new ModeloActividad();
		for (int i = 0; i < jsonArray.length(); i++) {
			
		JSONObject jsonObject = new JSONObject(i);
			
		Actividad actividad= new Actividad();
		
		actividad.setId(jsonObject.getInt("id"));
		actividad.setNombre(jsonObject.getString("nombre"));
		actividad.setFecha_inicio(jsonObject.getDate("fecha_inicio"));
		actividad.setDias_semana(jsonObject.getString("dias_semana"));
		actividad.setHoras(jsonObject.getInt("horas"));
		actividad.setMax_participantes(jsonObject.getInt("max_participantes"));
		actividad.setPrecio(jsonObject.getDouble("precio"));
			
            ma.Insert(actividad);
		
			
		}
		
		try {
			
			ma.getConexion().close();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		

		response.setHeader("Access-Control-Allow-Origin","*"); //jsonp deia denean ez da behar
		response.setCharacterEncoding("UTF-8");
		
		
	}

}
