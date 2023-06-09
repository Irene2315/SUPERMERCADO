package controladorProductos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Producto;
import modelo.ModeloProducto;

/**
 * Servlet implementation class OrdenDescendente
 */
@WebServlet("/OrdenDescendente")
public class OrdenDescendente extends HttpServlet implements Comparator <Producto>{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdenDescendente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModeloProducto productoM = new ModeloProducto();
		
		productoM.conectar();
		
		ArrayList <Producto> productos =productoM.getProductos();
		
		productos.sort(this);
		
		request.setAttribute("productos", productos);
		
		request.getRequestDispatcher("VerProductos.jsp").forward(request, response);
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public int compare(Producto o1, Producto o2) {
		
		Producto product1 = (Producto) o1;
		Producto product2 = (Producto) o2;
		
		return (product2.getCodigo().compareTo(product1.getCodigo()));
	}

}
