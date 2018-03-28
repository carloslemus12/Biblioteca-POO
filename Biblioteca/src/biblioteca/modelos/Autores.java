/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.modelos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JComboBox;
import mojica.alexander.mvc.Conexion;
import mojica.alexander.mvc.Item;

/**
 *
 * @author MekakuZero
 */
public class Autores extends Conexion implements Item{

    private int id;
    private String nombre;
    private String apellido;
    private String seudonimo;
    
    public Autores(){}
    
    public static Autores getDefault(){
        Autores autor = new Autores();
        
        autor.id = 0;
        autor.nombre = "Anonimo";
        autor.apellido = "";
        autor.seudonimo = null;
        
        return autor;
    }
    
    public static Autores getDefault(String val){
        Autores autor = new Autores();
        
        autor.id = -1;
        autor.nombre = val;
        autor.apellido = "";
        autor.seudonimo = null;
        
        return autor;
    }
    
    public static Autores getDefault(int id, String val){
        Autores autor = new Autores();
        
        autor.id = id;
        autor.nombre = val;
        autor.apellido = "";
        autor.seudonimo = null;
        
        return autor;
    }
    
    private Autores(ResultSet rs) throws Exception{
        this.id = rs.getInt("ID_Autor");
        this.nombre = rs.getString("Nombre");
        this.apellido = rs.getString("Apellido");
        this.seudonimo = rs.getString("Seudonimo");
        
        if (this.nombre == null) this.nombre = "";
        if (this.apellido == null) this.apellido = "";
        if (this.seudonimo == null) this.seudonimo = "";
    }
    
    // JComboBox
    public void seleccionarItem(JComboBox cmb){
        int indice = 0;
        boolean estado = false;
        
        for (int i = 0; i < cmb.getItemCount(); i++) {
            Autores autor = (Autores)cmb.getItemAt(i);
            if (autor.equals(this)) {
                indice = i;
                estado = true;
                break;
            }
        }
        
        if (estado)
            cmb.setSelectedIndex(indice);
    }
    
    public static Autores encontrar(int id){
        if (id == 0)
            return getDefault();
        
        Conexion con = obtenerConexion();
        
        con.conectar();
        
        con.crearQuery("SELECT * FROM autor where ID_Autor = ?");
        
        con.agregarParametro(1, id);
        
        ResultSet rs = con.getResultSet();
        
        try{
            if(rs.next())
                return new Autores(rs);
        } catch(Exception ex){ System.out.println("Error: al obtener los autores"); }
        
        con.desconectar();
        
        return getDefault();
    }
    
    // Constructor
    public static List<Autores> obtenerTodosAutores(){
        List<Autores> autores = new ArrayList<>();
        
        Conexion con = obtenerConexion();
        
        con.conectar();
        
        con.crearQuery("SELECT * FROM autor");
        
        ResultSet rs = con.getResultSet();
        
        try{
            while(rs.next())
                autores.add(new Autores(rs));
        } catch(Exception ex){ System.out.println("Error: al obtener los autores"); }
        
        con.desconectar();
        
        return autores;
    }
    
    @Override
    public boolean guardar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public String getName() {
        return (nombre + " " + apellido + ((seudonimo == null || seudonimo.isEmpty())? "" : " (" + seudonimo + ")")).trim() ;
    }

    @Override
    public int getValue() {
        return id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSeudonimo() {
        return seudonimo;
    }

    public void setSeudonimo(String seudonimo) {
        this.seudonimo = seudonimo;
    }

    @Override
    public String toString() {
        return (nombre + " " + apellido + ((seudonimo == null || seudonimo.isEmpty())? "" : " (" + seudonimo + ")")).trim() ;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autores other = (Autores) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.seudonimo, other.seudonimo)) {
            return false;
        }
        return true;
    }
    
}
