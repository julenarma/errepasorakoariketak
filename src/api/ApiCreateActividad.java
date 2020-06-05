package api;

import java.io.IOException;
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
 * Servlet implementation class ApiCreateActividad
 */
@WebServlet("/ApiCreateActividad")
public class ApiCreateActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApiCreateActividad() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String jsonActividad = request.getParameter("id");

		JSONObject jsonObject = new JSONObject();

		Actividad actividad = new Actividad();

		actividad.setId(jsonObject.getInt("id"));
		actividad.setMax_participantes(jsonObject.getInt("max_participantes"));

		ModeloActividad ma = new ModeloActividad();

		ma.Insert(actividad);

		try {

			ma.getConexion().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("json/application");
		response.setCharacterEncoding("UTF8");

	}

}
