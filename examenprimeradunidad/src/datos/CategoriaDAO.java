package datos;

import java.util.List;

public interface CategoriaDAO<T> {
    public List<T> listar(String texto);
    public List<T> buscar(String texto); //Método de búsqueda
    public boolean insertar(T obj);
    public boolean eliminar(int id);
    public boolean editar(int id); //Método de edición
}
