/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.libros;

/**
 *
 * @author MekakuZero
 */
public class JFrmLibro extends javax.swing.JInternalFrame {

    /**
     * Creates new form jfrmNuevoLibro
     */
    public JFrmLibro() {
        initComponents();
        limpiar();
    }

    public void limpiar(){
        this.lblErrorTitulo.setVisible(false);
        this.lblErrorImprenta.setVisible(false);
        this.lblErrorEdicion.setVisible(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        pnlContenedor = new javax.swing.JPanel();
        pnlDatos = new javax.swing.JPanel();
        lblErrorTitulo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        lblAutor = new javax.swing.JLabel();
        cmbAutor = new javax.swing.JComboBox<>();
        lblCategoria = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        lblEdcion = new javax.swing.JLabel();
        txtEdicion = new javax.swing.JTextField();
        lblErrorEdicion = new javax.swing.JLabel();
        lblImprenta = new javax.swing.JLabel();
        txtImprenta = new javax.swing.JTextField();
        lblErrorImprenta = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();
        pnlImg = new javax.swing.JPanel();
        lblImg = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lisNotas = new javax.swing.JList<>();
        lblNotas = new javax.swing.JLabel();
        btnNuevaNota = new javax.swing.JButton();
        pnlSeparacion = new javax.swing.JPanel();
        pnlAcciones = new javax.swing.JPanel();
        btnAccion = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Nuevo libro");

        pnlContenedor.setLayout(new java.awt.BorderLayout());

        pnlDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblErrorTitulo.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/libros/img/cancel.png"))); // NOI18N
        lblErrorTitulo.setText("Error.");
        pnlDatos.add(lblErrorTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 32, 192, -1));

        lblTitulo.setText("Titulo:");
        pnlDatos.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, 52, -1));

        txtTitulo.setMaximumSize(new java.awt.Dimension(6, 20));
        txtTitulo.setName(""); // NOI18N
        pnlDatos.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 11, 192, -1));

        lblAutor.setText("Autor:");
        pnlDatos.add(lblAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 154, 42, -1));

        cmbAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlDatos.add(cmbAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 174, 186, -1));

        lblCategoria.setText("Categoria:");
        pnlDatos.add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 154, 62, -1));

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlDatos.add(cmbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 174, 186, -1));

        lblEdcion.setText("Edicion:");
        pnlDatos.add(lblEdcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 62, 52, -1));

        txtEdicion.setMaximumSize(new java.awt.Dimension(6, 20));
        pnlDatos.add(txtEdicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 59, 192, -1));

        lblErrorEdicion.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorEdicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/libros/img/cancel.png"))); // NOI18N
        lblErrorEdicion.setText("Error.");
        pnlDatos.add(lblErrorEdicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 84, 192, -1));

        lblImprenta.setText("Imprenta:");
        pnlDatos.add(lblImprenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 106, 52, -1));

        txtImprenta.setMaximumSize(new java.awt.Dimension(6, 20));
        pnlDatos.add(txtImprenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 106, 192, -1));

        lblErrorImprenta.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorImprenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/libros/img/cancel.png"))); // NOI18N
        lblErrorImprenta.setText("Error.");
        pnlDatos.add(lblErrorImprenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 132, 192, -1));

        lblDescripcion.setText("Descripcion:");
        pnlDatos.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jScrollPane1.setViewportView(txtDescripcion);

        pnlDatos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 390, 77));

        pnlImg.setMaximumSize(new java.awt.Dimension(68, 60));
        pnlImg.setMinimumSize(new java.awt.Dimension(68, 60));
        pnlImg.setPreferredSize(new java.awt.Dimension(68, 60));
        pnlImg.setLayout(new java.awt.BorderLayout());

        lblImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/libros/img/photo-camera.png"))); // NOI18N
        lblImg.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblImg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblImg.setMaximumSize(new java.awt.Dimension(68, 60));
        lblImg.setMinimumSize(new java.awt.Dimension(68, 60));
        lblImg.setOpaque(true);
        lblImg.setPreferredSize(new java.awt.Dimension(68, 60));
        pnlImg.add(lblImg, java.awt.BorderLayout.CENTER);

        pnlDatos.add(pnlImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 11, 134, 137));

        lisNotas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lisNotas);

        pnlDatos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 323, 390, 99));

        lblNotas.setText("Notas:");
        pnlDatos.add(lblNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 303, -1, -1));

        btnNuevaNota.setText("Añadir nota");
        pnlDatos.add(btnNuevaNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 428, 110, -1));

        javax.swing.GroupLayout pnlSeparacionLayout = new javax.swing.GroupLayout(pnlSeparacion);
        pnlSeparacion.setLayout(pnlSeparacionLayout);
        pnlSeparacionLayout.setHorizontalGroup(
            pnlSeparacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        pnlSeparacionLayout.setVerticalGroup(
            pnlSeparacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        pnlDatos.add(pnlSeparacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 410, 20));

        pnlContenedor.add(pnlDatos, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlContenedor, java.awt.BorderLayout.CENTER);

        pnlAcciones.setBackground(new java.awt.Color(179, 57, 57));
        pnlAcciones.setForeground(new java.awt.Color(255, 255, 255));
        pnlAcciones.setToolTipText("");
        pnlAcciones.setMinimumSize(new java.awt.Dimension(100, 60));
        pnlAcciones.setPreferredSize(new java.awt.Dimension(394, 40));

        btnAccion.setText("Guardar");

        btnLimpiar.setText("Limpiar");

        javax.swing.GroupLayout pnlAccionesLayout = new javax.swing.GroupLayout(pnlAcciones);
        pnlAcciones.setLayout(pnlAccionesLayout);
        pnlAccionesLayout.setHorizontalGroup(
            pnlAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                .addComponent(btnLimpiar)
                .addContainerGap())
        );
        pnlAccionesLayout.setVerticalGroup(
            pnlAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAccion)
                    .addComponent(btnLimpiar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(pnlAcciones, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAccion;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnNuevaNota;
    private javax.swing.JComboBox<String> cmbAutor;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEdcion;
    private javax.swing.JLabel lblErrorEdicion;
    private javax.swing.JLabel lblErrorImprenta;
    private javax.swing.JLabel lblErrorTitulo;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblImprenta;
    private javax.swing.JLabel lblNotas;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<String> lisNotas;
    private javax.swing.JPanel pnlAcciones;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlImg;
    private javax.swing.JPanel pnlSeparacion;
    private javax.swing.JTextPane txtDescripcion;
    private javax.swing.JTextField txtEdicion;
    private javax.swing.JTextField txtImprenta;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration                   
}
