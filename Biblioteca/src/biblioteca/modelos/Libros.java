/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.modelos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import mojica.alexander.mvc.Conexion;
import static mojica.alexander.mvc.Conexion.obtenerConexion;
import mojica.alexander.mvc.Modelador;
import mojica.alexander.mvc.TableModelo;

/**
 *
 * @author MekakuZero
 */
public class Libros extends Conexion implements Modelador {
    
    // Informacion de los libros
    private int id;
    private String titulo;
    private String edicion;
    private String imprenta;
    private String descripcion;
    private String isbn;
    private byte[] portada;
    private Categorias categoria;
    private Autores autor;
    
    public static Libros getDefault(){
        Libros libro = new Libros();
        
        libro.id = -1;
        libro.titulo = "";
        libro.imprenta = "";
        libro.edicion = "";
        libro.descripcion = "";
        libro.isbn = "";
        libro.autor = Autores.getDefault(0, "");
        libro.categoria = Categorias.getDefault(0, "");
        
        return libro;
    }
    
    public Libros(){}
    
    public Libros(ResultSet rs) throws Exception {
        this.id = rs.getInt("ID_Libro");
        
        this.autor = Autores.encontrar(rs.getInt("Id_Autor"));
        
        this.categoria = Categorias.encontrar(rs.getInt("ID_cat"));
        
        //this.id = rs.getInt("ID_IMG");
        
        this.titulo = rs.getString("Titulo");
        this.edicion = rs.getString("Edicion");
        this.imprenta = rs.getString("Imprenta");
        this.descripcion = rs.getString("Descripcion");
        this.isbn = rs.getString("ISBN");
    }
    
    // Seccion de validaciones /////////////////////////////////////////////////
    public static boolean validarTitulo(String titulo,javax.swing.JLabel lblError){
        if (titulo.isEmpty()) {
            lblError.setText("Error: el campo es obligatorio.");
            lblError.setVisible(true);
            return false;
        }
        
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        Matcher m = patron.matcher(titulo);
        
        if (!m.matches()) {
            lblError.setText("Error: el titulo no acepta numeros.");
            lblError.setVisible(true);
            return false;
        } 
        
        lblError.setVisible(false);
        return true;
    }
    
    public static boolean validarISBN(String isbn, javax.swing.JLabel lblError){
        if (isbn.isEmpty()) {
            lblError.setText("Error: el isbn es obligatorio.");
            lblError.setVisible(true);
            return false;
        }
        
        Pattern patron = Pattern.compile("((978[\\--– ])?[0-9][0-9\\--– ]{10}[\\--– ][0-9xX])|((978)?[0-9]{9}[0-9Xx])");
        Matcher m = patron.matcher(isbn);
        
        if (!m.matches()) {
            lblError.setText("Error: el ISBN no corresponde con el formato.");
            lblError.setVisible(true);
            return false;
        } 
        
        lblError.setVisible(false);
        return true;
    }
    
    public static boolean validarEdicion(String edicion,javax.swing.JLabel lblError){
        if (edicion.isEmpty()) {
            lblError.setText("Error: la edicion es obligatoria.");
            lblError.setVisible(true);
            return false;
        }
        
        lblError.setVisible(false);
        return true;
    }
    
    public static boolean validarImprenta(String imprenta,javax.swing.JLabel lblError){
        if (imprenta.isEmpty()) {
            lblError.setVisible(false);
            return true;
        }
        
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        Matcher m = patron.matcher(imprenta);
        
        if (!m.matches()) {
            lblError.setText("Error: la imprenta no acepta numeros.");
            lblError.setVisible(true);
            return false;
        } 
        
        lblError.setVisible(false);
        return true;
    }
    
    // /////////////////////////////////////////////////////////////////////////
    public int guardarObtenerId(){
        if (guardar()) {
            this.conectar();
            
            this.crearQuery("select ID_Libro from libro order by ID_Libro desc limit 1");
        
            ResultSet rs = this.getResultSet();
            
            try{
                if (rs.next())
                    return rs.getInt("ID_Libro");
                
            } catch(Exception error) { System.out.println("Error: al obtener el ID del libro"); }
            
            this.desconectar();
        }
        
        return -1;
    }
    
    public static TableModelo getModelo(){
        String columnas[] = new String[]{"Titulo", "Autor", "Categoria", "Descripcion"};
        
        List<Modelador> modelos = obtenerTodosLibros();
        
        TableModelo modelo = new TableModelo(modelos, columnas);
        
        return modelo;
    }
    
    public static TableModelo getModelo(int id_autor, int id_categoria, String titulo){
        String columnas[] = new String[]{"Titulo", "Autor", "Categoria", "Descripcion"};
        
        List<Modelador> modelos = obtenerTodosLibros(id_autor, id_categoria, titulo);
        
        TableModelo modelo = new TableModelo(modelos, columnas);
        
        return modelo;
    }
    
    private static List<Modelador> obtenerTodosLibros(int id_autor, int id_categoria, String titulo){
        List<Modelador> libros = new ArrayList<>();

        Conexion con = obtenerConexion();
        
        con.conectar();
        
        String autor_where = (id_autor != -1)? ((id_autor == 0)? " and Id_Autor is null" : " and Id_Autor = ?" ): "";
        String categoria_where = (id_categoria != -1)? " and ID_Cat = ?" : "";
        
        con.crearQuery("SELECT * FROM libro"
                + " WHERE titulo like concat('%', ?, '%')"
                + autor_where 
                + categoria_where);
        
        con.agregarParametro(1, titulo);
        
        int indice = 2;
        
        if (id_autor != -1 && id_autor != 0) {
            con.agregarParametro(indice, id_autor);
            indice++;
        }
        
        if (id_categoria != -1)
            con.agregarParametro(indice, id_categoria);
        
        ResultSet rs = con.getResultSet();
        
        try{
            while(rs.next())
                libros.add(new Libros(rs));
        } catch(Exception error){ System.out.println("Error: Al obtener todos los libros"); }
        
        con.desconectar();
        
        return libros;
    }
    
    private static List<Modelador> obtenerTodosLibros(){
        List<Modelador> libros = new ArrayList<>();

        Conexion con = obtenerConexion();
        
        con.conectar();
        
        con.crearQuery("SELECT * FROM libro");
        
        ResultSet rs = con.getResultSet();
        
        try{
            while(rs.next())
                libros.add(new Libros(rs));
        } catch(Exception error){ System.out.println("Error: Al obtener todos los libros"); }
        
        con.desconectar();
        
        return libros;
    }
    
    @Override
    public boolean guardar() {
        this.conectar();
        
        this.crearQuery("INSERT INTO libro (Id_Autor, ID_cat, Titulo, Edicion, Imprenta, Descripcion, ISBN) values (?, ?, ?, ?, ?, ?, ?, ?)");
        
        if (this.autor != null)
            this.agregarParametro(1, this.autor.getId());
        else
            this.agregarParametroNull(1);
        this.agregarParametro(2, this.categoria.getId());
        
        this.agregarParametro(3, this.titulo);
        this.agregarParametro(4, this.edicion);
        this.agregarParametro(5, this.imprenta);
        this.agregarParametro(6, this.descripcion);
        this.agregarParametro(7, this.isbn);
        
        boolean repuesta = this.ejecutarQuery() > 0;
        
        this.desconectar();
        
        return repuesta;
    }

    @Override
    public boolean eliminar() {
        this.conectar();
        
        this.crearQuery("DELETE FROM libro WHERE ID_Libro = ?");
        
        this.agregarParametro(1, id);
        
        boolean estado = this.ejecutarQuery() > 0;
        
        this.desconectar();
        
        return estado;
    }

    @Override
    public boolean actualizar() {
        this.conectar();
        
        this.crearQuery("UPDATE libro SET Id_Autor = ?, ID_cat = ?, Titulo = ?, Edicion = ?, Imprenta = ?, Descripcion = ?, ISBN = ? WHERE ID_Libro = ?");
        
        if (this.autor != null)
            this.agregarParametro(1, this.autor.getId());
        else
            this.agregarParametroNull(1);
        
        this.agregarParametro(2, this.categoria.getId());
        
        this.agregarParametro(3, this.titulo);
        this.agregarParametro(4, this.edicion);
        this.agregarParametro(5, this.imprenta);
        this.agregarParametro(6, this.descripcion);
        this.agregarParametro(7, this.isbn);
        
        this.agregarParametro(8, this.id);
        
        boolean repuesta = this.ejecutarQuery() > 0;
        
        this.desconectar();
        
        return repuesta;
    }

    // /////////////////////////////////////////////////////////////////////////

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getImprenta() {
        return imprenta;
    }

    public void setImprenta(String imprenta) {
        if (imprenta.isEmpty())
            this.imprenta = null;
        else
            this.imprenta = imprenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion.isEmpty())
            this.descripcion = null;
        else
            this.descripcion = descripcion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public byte[] getPortada() {
        return portada;
    }

    public void setPortada(byte[] portada) {
        this.portada = portada;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }

    @Override
    public Object[] crearFila() {
        return new Object[]{ this.titulo, this.autor.toString(), this.categoria.getCategoria(), this.descripcion };
    }
 
    public List<Temas> getTemas(){
        List<Temas> temas = new ArrayList<>();
        
        this.conectar();
        
        this.crearQuery("SELECT tema.ID_tema, tema.Tema, tema.Descripcion from tema "
                + "inner join tema_libro "
                + "on tema_libro.ID_tema = tema.ID_tema " 
                + "WHERE tema_libro.ID_Libro = ?");
        
        this.agregarParametro(1, id);
        
        ResultSet rs = this.getResultSet();
        
        try {
            while(rs.next())
                temas.add(new Temas(rs));
        } catch(Exception error){ System.out.println("Error: al obtener los temas"); }
        
        this.desconectar();
        
        return temas;
    }
    
    // Obtenemos las notas
    public List<Notas> getNotas(){
        List<Notas> notas = new ArrayList<>();
        
        this.conectar();
        
        this.crearQuery("select * from nota where ID_Libro = ?");
        
        this.agregarParametro(1, this.id);
        
        ResultSet rs = this.getResultSet();
        
        try{
            while(rs.next())
                notas.add(new Notas(rs));
        } catch(Exception error) { System.out.println("Error: al obtener las notas por los libros"); }
        
        this.desconectar();
        
        return notas;
    }
}
