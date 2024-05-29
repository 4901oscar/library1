/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;


import Controlador.LibroController;
import Controlador.PrestamoController;
import modelo.Libro;
import modelo.Prestamo;
import modelo.Usuario;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.util.Objects;

import static javax.swing.JOptionPane.*;


public class ViewClientes extends javax.swing.JFrame {

    private Usuario usuarioLogueadoSistema;
    private PrestamoController prestamoController = new PrestamoController();
    private LibroController libroControlador = new LibroController();

    /**
     * Creates new form VistaCliente
     *
     * @param usuarioLogueado
     */
    public ViewClientes(Usuario usuarioLogueado) {
        initComponents();
        Libro.listaDeLibros.clear();
        Libro.listaDeLibros.addAll(libroControlador.list());

        Prestamo.listaDePrestamos.clear();
        Prestamo.listaDePrestamos.addAll(prestamoController.list());

        usuarioLogueadoSistema = usuarioLogueado;
        agregarLibrosATabla();
        agregarPrestamosATabla();
        agregarLibrosDevueltosATabla();
    }

    public ViewClientes() {
    }

    private void agregarLibrosATabla() {
        libroControlador.list().forEach(libro -> {
            ((DefaultTableModel) tableListaLibros.getModel()).addRow(new Object[]{
                libro.getIsbn(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getEditorial(),
                libro.getAnioPublicacion()
            });
        });
    }

    private void agregarPrestamosATabla() {
        Prestamo.listaDePrestamos.stream()
                .filter(prestamo -> Objects.equals(prestamo.getUsuarioID(), usuarioLogueadoSistema.getId()))
                .filter(prestamo -> prestamo.getFechaDevolucion() == null)
                .forEach(prestamo -> {
                    ((DefaultTableModel) tableLibrosPrestados.getModel()).addRow(new Object[]{
                        prestamo.getId(),
                        prestamo.getIsbn(),
                        Libro.listaDeLibros.stream()
                                .filter(libro -> libro.getIsbn() == prestamo.getIsbn())
                                .findFirst()
                                .orElse(null)
                                .getTitulo(),
                        prestamo.getFechaPrestamo(),
                        prestamo.getFechaVencimiento(),
                        prestamo.getMulta()
                    });
                });
    }

    private void agregarLibrosDevueltosATabla() {
        Prestamo.listaDePrestamos.stream()
                .filter(prestamo -> Objects.equals(prestamo.getUsuarioID(), usuarioLogueadoSistema.getId()))
                .filter(prestamo -> prestamo.getFechaDevolucion() != null)
                .forEach(prestamo -> {
                    ((DefaultTableModel) tableLibrosDevueltos.getModel()).addRow(new Object[]{
                        prestamo.getId(),
                        prestamo.getIsbn(),
                        Libro.listaDeLibros.stream()
                                .filter(libro -> libro.getIsbn() == prestamo.getIsbn())
                                .findFirst()
                                .orElse(null)
                                .getTitulo(),
                        prestamo.getFechaPrestamo(),
                        prestamo.getFechaDevolucion(),
                        prestamo.getMulta()
                    });
                });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableListaLibros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtFiltroLibro = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLibrosPrestados = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableLibrosDevueltos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Viner Hand ITC", 0, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        tableListaLibros.setBackground(new java.awt.Color(153, 153, 153));
        tableListaLibros.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableListaLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Titulo", "Autor", "Editorial", "Año Publicacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableListaLibros.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane2.setViewportView(tableListaLibros);

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Viner Hand ITC", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BUSCAR LIBRO");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        txtFiltroLibro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroLibroKeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Viner Hand ITC", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Prestar Libro");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFiltroLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFiltroLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jTabbedPane1.addTab("PRESTAR NUEVO LIBRO", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        tableLibrosPrestados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Libro ISBN", "Titulo", "Fecha Prestamo", "Fecha Vencimiento", "Multa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableLibrosPrestados);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("LIBROS AUN NO DEVUELTOS", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        tableLibrosDevueltos.setBackground(new java.awt.Color(153, 153, 153));
        tableLibrosDevueltos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ISBN", "Titulo", "Fecha Prestamo", "Fecha Devolucion", "Multa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableLibrosDevueltos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jTabbedPane1.addTab("LIBROS DEVUELTOS", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 870, 500));

        jLabel2.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jLabel2.setText("          BIENVENIDO AL SISTEMA BIBLIOTECARIO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("SALIR");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:

        int row = tableListaLibros.getSelectedRow();
        if (row == -1) {
            return;
        }
        int isbn = (int) tableListaLibros.getValueAt(row, 0);
        if (prestamoController.verificarPrestamosTardios(isbn, usuarioLogueadoSistema.getId())) {
            showMessageDialog(this, "No se puede prestar el libro, tiene prestamos pendientes de devolucion");
            return;
        }
        if (libroControlador.cantidadMayorCero(isbn)) {
            Prestamo prestamo = new Prestamo();
            prestamo.setUsuarioID(usuarioLogueadoSistema.getId());
            prestamo.setIsbn(isbn);
            prestamoController.create(prestamo);
            libroControlador.prestamo(isbn);
            Libro.listaDeLibros.clear();
            Libro.listaDeLibros.addAll(libroControlador.list());

            Prestamo.listaDePrestamos.clear();
            Prestamo.listaDePrestamos.addAll(prestamoController.list());
            agregarPrestamosATabla();
            showMessageDialog(this, "Libro prestado con exito");
        } else {
            showMessageDialog(this, "No hay existencias del libro");
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void txtFiltroLibroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroLibroKeyTyped
        // TODO add your handling code here:
        //create the filter should work with any does not matter the column
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableListaLibros.getModel());
        tableListaLibros.setRowSorter(sorter);
        String text = txtFiltroLibro.getText();
        if (text.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }//GEN-LAST:event_txtFiltroLibroKeyTyped

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        LoginAcces loginForm = new LoginAcces();
        loginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(ViewClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tableLibrosDevueltos;
    private javax.swing.JTable tableLibrosPrestados;
    private javax.swing.JTable tableListaLibros;
    private javax.swing.JTextField txtFiltroLibro;
    // End of variables declaration//GEN-END:variables
}