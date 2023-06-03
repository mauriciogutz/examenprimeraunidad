package negocio;

import dominio.Propiedades;
import datos.CategoriaDAO;
import datos.impl.CategoriaDAOImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CategoriaControl {
    private final CategoriaDAO DATOS;
    private final Propiedades obj;
    
    public CategoriaControl(){
        this.DATOS=new CategoriaDAOImpl();
        this.obj=new Propiedades();
    }
    
    private DefaultTableModel modeloTabla;
    
    public DefaultTableModel listar(String texto){
        List<Propiedades> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        
        //Establecemos la columna del tableModel         
        String[] titulos = {"ID", "NOMBRE"};
        
        //Declaramos un vector que será el que agreguemos como registro al DefaultTableModel         
        String[] registro = new String[2];
        
        //agrego los títulos al DefaultTableModel         
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
         //Recorrer toda mi lista y la pasare al DefaultTableModel         
         for (Propiedades item : lista) {             
             registro[0] = Integer.toString(item.getId());             
             registro[1] = item.getNombre();             
             this.modeloTabla.addRow(registro);         
         }
         
         return this.modeloTabla; 
    }
}
