/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.modelos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mojica.alexander.mvc.Conexion;
import mojica.alexander.mvc.Modelador;
import mojica.alexander.mvc.TableModelo;

/**
 *
 * @author MekakuZero
 */
public class Temas extends Conexion implements Modelador{

    // Informacion sobre el tema
    private int id;
    private String tema;
    private String descripcion;
    
    public Temas(){}
    
    public Temas(ResultSet rs) throws Exception {
        this.id = rs.getInt("ID_tema");
        this.tema = rs.getString("Tema");
        this.descripcion = rs.getString("Descripcion");
    }
    
    public static boolean existenTemas(){
        boolean existencia = false;

        Conexion con = obtenerConexion();
        
        con.conectar();
        
        con.crearQuery("SELECT * FROM tema");
        
        ResultSet rs = con.getResultSet();
        
        try{
            existencia = rs.next();
        } catch(Exception error){ System.out.println("Error: Comprobar existencia del tema"); }
        
        con.desconectar();
        
        return existencia;
    }
    
    public static TableModelo getModelo(List<Temas> excluir){
        String columnas[] = new String[]{"Tema", "Descripcion"};
        
        List<Modelador> modelos = new ArrayList<>();
        List<Temas> lista = obtenerTodosTemas();
        
        for (Temas tema : lista) {
            boolean anadir = true;
            
            for (Temas item : excluir){
                if (tema.equals(item)) {
                    anadir = false;
                    break;
                }
            }
            
            if (anadir)
                modelos.add(tema);
        }
        
        TableModelo modelo = new TableModelo(modelos, columnas);
        
        return modelo;
    }
    
    public static List<Temas> obtenerTodosTemas(){
        List<Temas> temas = new ArrayList<>();

        Conexion con = obtenerConexion();
        
        con.conectar();
        
        con.crearQuery("SELECT * FROM tema");
        
        ResultSet rs = con.getResultSet();
        
        try{
            while(rs.next())
                temas.add(new Temas(rs));
        } catch(Exception error){ System.out.println("Error: Al obtener todos los modelos"); }
        
        con.desconectar();
        
        return temas;
    }
    
    public void guardar(int id_libro){
        this.conectar();
        
        this.crearQuery("INSERT INTO tema_libro (ID_tema, ID_Libro) values (?, ?)");
        
        this.agregarParametro(1, this.id);
        this.agregarParametro(2, id_libro);
        
        this.ejecutarQuery();
        
        this.desconectar();
    }
    
    @Override
    public boolean guardar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean eliminarRelacion(){
        this.conectar();
        
        this.crearQuery("DELETE FROM tema_libro WHERE ID_tema = ?");
        
        this.agregarParametro(1, this.id);
        
        boolean repuesta = this.ejecutarQuery() > 0;
        
        this.desconectar();
        
        return repuesta;
    }
    
    @Override
    public boolean eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] crearFila() {
        return new Object[]{ this.tema, this.descripcion };
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Temas tema = (Temas)obj;
            
            return (this.id == tema.id && tema.tema.equals(this.tema) && this.descripcion.equals(tema.descripcion));
            
        } catch(Exception error){
            return false;
        }
    }

    @Override
    public String toString() {
        return tema + " [" + descripcion + ']';
    }
    
    public boolean isExist(int id){
        this.conectar();
        
        this.crearQuery("SELECT * FROM tema_libro WHERE ID_Libro = ? and ID_tema = ?");
        
        this.agregarParametro(1, id);
        this.agregarParametro(2, this.id);
        
        ResultSet rs = this.getResultSet();
        
        boolean repuesta = false;
        
        try {
            repuesta = rs.next();
        } catch(Exception error) {}
        
        this.desconectar();
        
        return repuesta;
    }
}
