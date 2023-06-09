package controladorProductos;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Producto;
import clases.Seccion;
import clases.Supermercado;
import modelo.ModeloProSuper;
import modelo.ModeloProducto;
import modelo.ModeloSeccion;
import modelo.ModeloSupermercado;

/**
 * Servlet implementation class ModificarProducto
 */
@WebServlet("/ModificarProducto")
public class ModificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Producto producto = new Producto();
		ArrayList <Seccion> secciones = new ArrayList<>();
		
		ModeloProducto productoM = new ModeloProducto();
		
		ModeloSeccion seccionM = new ModeloSeccion();
		
		ModeloProSuper prosupM = new ModeloProSuper();
		
		ModeloSupermercado superM = new ModeloSupermercado();
		productoM.conectar();
		
		producto=productoM.getProductoId(id);
		
		productoM.cerrar();
		
		seccionM.conectar();
		secciones=seccionM.getSecciones();
		seccionM.cerrar();
		
		
		superM.conectar();
		
		ArrayList<Supermercado> supermercados = superM.getSupermercados();
		
		superM.cerrar();
		
		prosupM.conectar();
		boolean productoSupermercado = prosupM.productoEnSupermercados(id);
		
		if (productoSupermercado) {
			ArrayList<Integer> supermercadosDeProducto = prosupM.ListaDeSupermercadosDeProducto(id);

			request.setAttribute("SupermercadosDeProducto", supermercadosDeProducto);
		}
		prosupM.cerrar();
		
		request.setAttribute("supermercados", supermercados);
		request.setAttribute("producto", producto);
		request.setAttribute("secciones", secciones);
		request.getRequestDispatcher("ModificarProducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		double precio = Double.parseDouble(request.getParameter("precio"));
		
		SimpleDateFormat spd = new SimpleDateFormat("yyyy-MM-dd");
		Date caducidad = new Date();
		
		
		try {
			caducidad = spd.parse(request.getParameter("caducidad"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int idSeccion = Integer.parseInt(request.getParameter("seccion"));
		
		String[] supermercados = request.getParameterValues("supermercados"); 
		
		Producto producto = new Producto();
		
		producto.setId(id);
		producto.setCodigo(codigo);
		producto.setNombre(nombre);
		producto.setCantidad(cantidad);
		producto.setPrecio(precio);
		producto.setCaducidad(caducidad);
		
		
		
		
		Seccion seccion = new Seccion();
		seccion.setId(idSeccion);
		producto.setIdSeccion(seccion);
		
		
		ModeloProducto mProducto = new ModeloProducto();
		
		mProducto.conectar();
		
		mProducto.modificarProducto(producto);
		
		mProducto.cerrar();
		
		ModeloProSuper proSupM = new ModeloProSuper();
		proSupM.conectar();
		proSupM.eliminarRelacionSuper(id);
		for (String supermercado : supermercados) {
			
		    int idSupermercado = Integer.parseInt(supermercado);
		    proSupM.registrarSuperProducto(id, idSupermercado);
		
		}
		proSupM.cerrar();
		
		proSupM.cerrar();
		
		
		response.sendRedirect("VerProductos");
		
		
	 
		
	}

}
