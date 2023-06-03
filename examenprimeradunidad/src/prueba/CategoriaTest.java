package prueba;

import datos.impl.CategoriaDAOImpl;
import dominio.Propiedades;

public class CategoriaTest {
    
    public static void main(String[] args) {
        insertarPropiedad("id");
        insertarPropiedad("Nombre");
        insertarPropiedad("Dirección");
        insertarPropiedad("Características");
        insertarPropiedad("Estado");
        insertarPropiedad("Precio Alquiler");
        insertarPropiedad("created_at");
        insertarPropiedad("updated_at");
    }
    private static void insertarPropiedad(String nombre){
        Propiedades obj=new Propiedades();
        CategoriaDAOImpl datos =new CategoriaDAOImpl();
        obj.setNombre(nombre);
        boolean resp;
        resp=datos.insertar(obj);
        System.out.println("Insetado: "+resp);
    }
}
