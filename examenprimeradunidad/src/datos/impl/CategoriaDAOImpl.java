package datos.impl;

import database.Conexion;
import datos.CategoriaDAO;
import dominio.Propiedades;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOImpl implements CategoriaDAO<Propiedades> {

    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public CategoriaDAOImpl() {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<Propiedades> listar(String texto) {
        List<Propiedades> registros = new ArrayList<>();

        try {
            ps = CON.conectar().prepareStatement("SELECT id, nombre FROM propiedades WHERE nombre LIKE ?");
            ps.setString(1, "%" + texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Propiedades(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Propiedades obj) {
        resp = false;

        try {
            ps = CON.conectar().prepareStatement("INSERT INTO categorias (nombre) VALUES (?)");
            ps.setString(1, obj.getNombre());
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            ps = null;
            CON.desconectar();
        }
        return resp;
    }


    @Override
    public boolean eliminar(int id) {
        resp = false;

        try {
            ps = CON.conectar().prepareStatement("DELETE FROM categorias WHERE id = ?");
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            ps = null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public List<Propiedades> buscar(String texto) {
        List<Propiedades> registros = new ArrayList<>();

        try {
            ps = CON.conectar().prepareStatement("SELECT id, nombre FROM categorias WHERE nombre LIKE ?");
            ps.setString(1, "%" + texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Propiedades(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean editar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}