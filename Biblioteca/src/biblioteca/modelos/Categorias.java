/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.modelos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import mojica.alexander.mvc.Conexion;
import mojica.alexander.mvc.Item;

/**
 *
 * @author MekakuZero
 */
public class Categorias extends Conexion implements Item{

    private int id;
    private String categoria;
    private String descripcion;
    
    public static Categorias getDefault(String val){
        Categorias categoria = new Categorias();
        
        categoria.id = -1;
        categoria.categoria = val;
        categoria.descripcion = "";
        
        return categoria;
    }
    
    public static Categorias getDefault(int id, String val){
        Categorias categoria = new Categorias();
        
        categoria.id = id;
        categoria.categoria = val;
        categoria.descripcion = "";
        
        return categoria;
    }
    
    // Constructores
    public Categorias(){}
    
    public Categorias(ResultSet rs) throws Exception
    {
        this.id = rs.getInt("ID_Cat");
        this.categoria = rs.getString("Categoria");
        this.descripcion = rs.getString("Descripcion");
    }
    
    public static Categorias encontrar(int id){
        Conexion con = obtenerConexion();
        
        con.conectar();
        
        con.crearQuery("SELECT * FROM categoria where ID_Cat = ?");
        
        con.agregarParametro(1, id);
        
        ResultSet rs = con.getResultSet();
        
        try{
            if(rs.next())
                return new Categorias(rs);
        } catch(Exception ex){ System.out.println("Error: al obtener los autores"); }
        
        con.desconectar();
        
        return null;
    }
    
    // JComboBox
    public void seleccionarItem(JComboBox cmb){
        int indice = 0;
        boolean estado = false;
        
        for (int i = 0; i < cmb.getItemCount(); i++) {
            Categorias categoria = (Categorias)cmb.getItemAt(i);
            if (categoria.equals(this)) {
                indice = i;
                estado = true;
                break;
            }
        }
        
        if (estado)
            cmb.setSelectedIndex(indice);
    }
    
    // Comprobamos que hayan categotias
    public static List<Categorias> obtenerTodasCategorias(){
        List<Categorias> categorias = new ArrayList<>();
        
        Conexion con = Conexion.obtenerConexion();
        
        con.conectar();
        
        con.crearQuery("SELECT * FROM categoria");
        
        ResultSet rs = con.getResultSet();
        
        try{
            while(rs.next())
                categorias.add(new Categorias(rs));
        }
        catch(Exception error) { System.out.println("Error: Obtener categorias"); }
        
        con.desconectar();
        
        return categorias;
    }
    
    public static boolean existenCategoria(){
        Conexion con = Conexion.obtenerConexion();
        
        con.conectar();
        
        con.crearQuery("SELECT * FROM categoria");
        
        ResultSet rs = con.getResultSet();
        
        boolean existencia = false;
        
        try{
           existencia = rs.next();
        } catch(Exception error) { System.out.println("Error: Comprobar existencia categoria"); }
        
        con.desconectar();
        
        return existencia;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String getName() {
        return categoria;
    }

    @Override
    public int getValue() {
        return id;
    }
}
