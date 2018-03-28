/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.modelos;

import java.sql.ResultSet;
import mojica.alexander.mvc.Conexion;

/**
 *
 * @author MekakuZero
 */
public class Notas extends Conexion{
    private int id = -1;
    private String nota;
    private int id_nota;

    public Notas() { }

    public Notas(String nota) {
        this.nota = nota;
    }
    
    public Notas(int id, String nota, int id_nota) {
        this.id = id;
        this.nota = nota;
        this.id_nota = id_nota;
    }
    
    public Notas(ResultSet rs) throws Exception {
        this.id = rs.getInt("ID_Nota");
        this.nota = rs.getString("Nota");
        this.id_nota = rs.getInt("ID_Libro");
    }

    public void guardar(int id_libro){
        this.conectar();
        
        this.crearQuery("INSERT INTO nota (Nota, ID_Libro) values (?, ?)");
        
        this.agregarParametro(1, this.nota);
        this.agregarParametro(2, id_libro);
        
        this.ejecutarQuery();
        
        this.desconectar();
    }
    
    @Override
    public boolean guardar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar() {
        this.conectar();
        
        this.crearQuery("delete from nota where ID_Nota = ?");
        
        this.agregarParametro(1, this.id);
        
        boolean repuesta = this.ejecutarQuery() > 0;
        
        this.desconectar();
        
        return repuesta;
    }

    @Override
    public boolean actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return nota;
    }
    
    public boolean isExist(){
        return (this.id != -1);
    }
}
