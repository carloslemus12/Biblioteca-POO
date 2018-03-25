/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import biblioteca.libros.JIfrmLibro;

/**
 *
 * @author MekakuZero
 */
public class Sistema extends javax.swing.JFrame {

    /**
     * Creates new form Sistema
     */
    public Sistema() {
        initComponents();
        
        this.setExtendedState(MAXIMIZED_BOTH);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        autoresMenu = new javax.swing.JMenu();
        categoriasMenu = new javax.swing.JMenu();
        temasMenu = new javax.swing.JMenu();
        librosMenu = new javax.swing.JMenu();
        nuevoLibroItemMenu = new javax.swing.JMenuItem();
        usuarioMenu = new javax.swing.JMenu();
        OpcionesMenu = new javax.swing.JMenu();
        claveMenuItem = new javax.swing.JMenuItem();
        informacionMenuItem = new javax.swing.JMenuItem();
        CerrarMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control de biblioteca");
        setResizable(false);

        autoresMenu.setText("Autores");
        menuBar.add(autoresMenu);

        categoriasMenu.setText("Categorias");
        menuBar.add(categoriasMenu);

        temasMenu.setText("Temas");
        menuBar.add(temasMenu);

        librosMenu.setText("Libros");

        nuevoLibroItemMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        nuevoLibroItemMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/libros/img/books.png"))); // NOI18N
        nuevoLibroItemMenu.setText("Nuevo libro");
        nuevoLibroItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoLibroItemMenuActionPerformed(evt);
            }
        });
        librosMenu.add(nuevoLibroItemMenu);

        menuBar.add(librosMenu);

        usuarioMenu.setText("Usuarios");
        menuBar.add(usuarioMenu);

        OpcionesMenu.setText("Opciones");

        claveMenuItem.setText("Cambiar clave");
        OpcionesMenu.add(claveMenuItem);

        informacionMenuItem.setText("Cambiar informacion");
        OpcionesMenu.add(informacionMenuItem);

        CerrarMenuItem.setText("Cerrar seccion");
        OpcionesMenu.add(CerrarMenuItem);

        menuBar.add(OpcionesMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoLibroItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoLibroItemMenuActionPerformed
        // TODO add your handling code here:
        JIfrmLibro libro = new JIfrmLibro();
        this.desktopPane.add(libro);
        libro.show();
    }//GEN-LAST:event_nuevoLibroItemMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CerrarMenuItem;
    private javax.swing.JMenu OpcionesMenu;
    private javax.swing.JMenu autoresMenu;
    private javax.swing.JMenu categoriasMenu;
    private javax.swing.JMenuItem claveMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem informacionMenuItem;
    private javax.swing.JMenu librosMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem nuevoLibroItemMenu;
    private javax.swing.JMenu temasMenu;
    private javax.swing.JMenu usuarioMenu;
    // End of variables declaration//GEN-END:variables

}
