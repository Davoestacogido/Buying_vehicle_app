/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui;

import Model.ControladorServicio;
import static Model.ControladorServicio.getClienteActual;
import Model.Extra;
import Model.Modelo;
import Model.Pedido;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author adria
 */
public class Pedidos extends javax.swing.JFrame {

    /**
     * Creates new form Pedidos
     */
    public Pedidos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        modelList = new java.awt.List();
        extraList = new java.awt.List();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pedidosList = new java.awt.List();
        jLabel4 = new javax.swing.JLabel();
        crearPedidoButton = new javax.swing.JButton();
        descripcionExtra = new java.awt.List();
        finalPrice = new java.awt.List();
        añadirExtraButton = new javax.swing.JButton();
        listaExtrasSeleccionados = new java.awt.List();
        eliminarExtraButton = new javax.swing.JButton();
        buscadorTextBox = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Cancelar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        modelList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelListActionPerformed(evt);
            }
        });
        jPanel1.add(modelList, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 129, 217));

        extraList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extraListActionPerformed(evt);
            }
        });
        jPanel1.add(extraList, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 40, 93, 158));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Modelos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 10, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Historial de precio");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 211, 100, -1));

        pedidosList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidosListActionPerformed(evt);
            }
        });
        jPanel1.add(pedidosList, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 186, 190, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Pedidos existentes:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 111, -1));

        crearPedidoButton.setText("Crear pedido");
        crearPedidoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearPedidoButtonActionPerformed(evt);
            }
        });
        jPanel1.add(crearPedidoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, -1));

        descripcionExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripcionExtraActionPerformed(evt);
            }
        });
        jPanel1.add(descripcionExtra, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 178, 38));
        jPanel1.add(finalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 231, 93, 26));

        añadirExtraButton.setText("Añadir extra");
        añadirExtraButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirExtraButtonActionPerformed(evt);
            }
        });
        jPanel1.add(añadirExtraButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 110, -1));
        jPanel1.add(listaExtrasSeleccionados, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 180, 50));

        eliminarExtraButton.setText("Eliminar extra");
        eliminarExtraButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarExtraButtonActionPerformed(evt);
            }
        });
        jPanel1.add(eliminarExtraButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, 100, -1));
        jPanel1.add(buscadorTextBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 93, -1));

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Model.Modelo modeloSeleccionado;
    private ArrayList<Model.Extra> extrasSeleccionados = new ArrayList();
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AppConcesionarioUI interfaz = new AppConcesionarioUI();
        interfaz.LoggedIn();
        interfaz.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void modelListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelListActionPerformed
        showModelExtras(ControladorServicio.getModelos().get(modelList.getSelectedIndex()));
        setModeloSeleccionado(modelList.getSelectedIndex());
        showPrecioFinal();
        extrasSeleccionados.clear();
    }//GEN-LAST:event_modelListActionPerformed

    private void crearPedidoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearPedidoButtonActionPerformed
        // TODO add your handling code here:
        Model.Pedido.Estado estado  = Model.Pedido.Estado.enCamino ;
        Pedido pedido = ControladorServicio.crearNuevoPedido(ControladorServicio.getClienteActual()
                , modeloSeleccionado,getExtrasSeleccionados(),estado);
        showPedidosExistentes();
        showModelList();
        if(pedido.equals(null)){
            noStock noStock = new noStock();
            noStock.setVisible(true);
        };
    }//GEN-LAST:event_crearPedidoButtonActionPerformed

    private void extraListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extraListActionPerformed
        // TODO add your handling code here:
        showExtraDescription(extraList.getSelectedIndex());
    }//GEN-LAST:event_extraListActionPerformed

    private void descripcionExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripcionExtraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descripcionExtraActionPerformed

    private void añadirExtraButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirExtraButtonActionPerformed
        // TODO add your handling code here:
        setExtrasSeleccionados(extraList.getSelectedIndexes());
        showPrecioFinal();
    }//GEN-LAST:event_añadirExtraButtonActionPerformed

    private void eliminarExtraButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarExtraButtonActionPerformed
        // TODO add your handling code here:
        removeExtraSeleccionado(listaExtrasSeleccionados.getSelectedIndex());
        showPrecioFinal();
    }//GEN-LAST:event_eliminarExtraButtonActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        String filtro = buscadorTextBox.getText();
        if(filtro.equals("")) {
            showModelList();
            return;
        }
        modelList.removeAll();
        for(int i=0;i < ControladorServicio.getModelos().size();i++){
           String objetivo = ControladorServicio.getModelos().get(i).getNombre();
           if(filtro.equals(objetivo) || objetivo.contains(filtro)){
               modelList.add(objetivo);
           }
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void pedidosListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pedidosListActionPerformed

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
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton añadirExtraButton;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JTextField buscadorTextBox;
    private javax.swing.JButton crearPedidoButton;
    private java.awt.List descripcionExtra;
    private javax.swing.JButton eliminarExtraButton;
    private java.awt.List extraList;
    private java.awt.List finalPrice;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private java.awt.List listaExtrasSeleccionados;
    private java.awt.List modelList;
    private java.awt.List pedidosList;
    // End of variables declaration//GEN-END:variables

    void showModelList() {
        modelList.removeAll();
        for (Modelo modelo : ControladorServicio.getModelos()) {
            if(modelo.isAnyCars() == null)continue;
            else modelList.add(modelo.getNombre());
        }
    }

    private void showModelExtras(Modelo modelo) {
        int i;
        extraList.removeAll();
        extrasSeleccionados.clear();
        listaExtrasSeleccionados.removeAll();
        for(i = 0; i< modelo.getExtras().size();i++)
           extraList.add(modelo.getExtras().get(i).getNombre());
    }

    private void showExtraDescription(int selectedIndex) {
       descripcionExtra.removeAll();
       descripcionExtra.add(getModeloSeleccionado().getExtras().get(selectedIndex).getDescripcion());
        
    }

    public Modelo getModeloSeleccionado() {
        return modeloSeleccionado;
    }

    public void setModeloSeleccionado(int selectedIndex) {
        this.modeloSeleccionado = ControladorServicio.getModelos().get(selectedIndex);
    }

    public ArrayList<Extra> getExtrasSeleccionados() {
        return extrasSeleccionados;
    }

    public void setExtrasSeleccionados(int[] indicesSeleccionados){
        for(int i = 0; i < indicesSeleccionados.length ;i++){
            extrasSeleccionados.add(
                    getModeloSeleccionado().getExtras().get(indicesSeleccionados[i]));
            listaExtrasSeleccionados.add(getModeloSeleccionado().getExtras().get(indicesSeleccionados[i]).getNombre());
        }
            
        this.extrasSeleccionados = extrasSeleccionados;
    }

    private void showPrecioFinal() {
        int price = this.modeloSeleccionado.getPrecioBase();
        for(int i = 0; i < this.extrasSeleccionados.size(); i++ )
            price += this.extrasSeleccionados.get(i).getPrecioAñadido();
        String sprice = String.valueOf(price);
        finalPrice.add(sprice);
    }
    
    void showPedidosExistentes(){
        pedidosList.removeAll();
        for(Pedido pedido : ControladorServicio.getClienteActual().getPedidos()){
            pedidosList.add(pedido.toString());
        }
    }

    private void removeExtraSeleccionado(int selectedIndex) {
      extrasSeleccionados.remove(selectedIndex);
      listaExtrasSeleccionados.remove(selectedIndex);
    }
    
}