/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.CadastroFabricanteController;
import controller.helper.CadastroFabricanteHelper;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Marcos Antonio
 */
public class TelaCadastroFabricante extends javax.swing.JFrame {

    //criando campo controller
    private final CadastroFabricanteController controller;
    
    //criando campo helper
    private final CadastroFabricanteHelper helper;
    
    public TelaCadastroFabricante() {
        initComponents();
        
        this.setResizable(false);
        
        //controller esta passando view como parametro
        controller = new CadastroFabricanteController(this);
        
        //helper esta passando view como parametro
        helper = new CadastroFabricanteHelper(this);          
        
        //inicia essa tela no centro
        this.setLocationRelativeTo(null);
        
        //chama o metodo iniciar
        this.iniciar();           
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVoltar1 = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaFabricante = new javax.swing.JTable();
        lblID = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtFabricante = new javax.swing.JTextField();
        lblFabricantenome = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalvar.setBackground(new java.awt.Color(30, 129, 176));
        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 240, 110, 40));

        btnExcluir.setBackground(new java.awt.Color(30, 129, 176));
        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 240, 110, 40));

        btnVoltar1.setBackground(new java.awt.Color(30, 129, 176));
        btnVoltar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVoltar1.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar1.setText("VOLTAR");
        btnVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 240, 110, 40));

        btnPesquisar.setBackground(new java.awt.Color(30, 129, 176));
        btnPesquisar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setText("PESQUISAR");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 180, 110, 40));

        btnEditar.setBackground(new java.awt.Color(30, 129, 176));
        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 180, 110, 40));

        btnNovo.setBackground(new java.awt.Color(30, 129, 176));
        btnNovo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 180, 110, 40));

        jTabelaFabricante.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTabelaFabricante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "fabricantenome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaFabricante.setAutoscrolls(false);
        jTabelaFabricante.setFocusable(false);
        jTabelaFabricante.setRequestFocusEnabled(false);
        jTabelaFabricante.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTabelaFabricante.getTableHeader().setReorderingAllowed(false);
        jTabelaFabricante.setUpdateSelectionOnSort(false);
        jTabelaFabricante.setVerifyInputWhenFocusTarget(false);
        jTabelaFabricante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaFabricanteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaFabricante);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 1250, 360));

        lblID.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setText("ID:");
        getContentPane().add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, 30));

        txtId.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtId.setEnabled(false);
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 100, -1));

        txtFabricante.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        getContentPane().add(txtFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 180, -1));

        lblFabricantenome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblFabricantenome.setForeground(new java.awt.Color(255, 255, 255));
        lblFabricantenome.setText("FABRICANTENOME:");
        getContentPane().add(lblFabricantenome, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, 30));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("CADASTRO DE FABRICANTE");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, -1, -1));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/PARTE INTERNA2.png"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabelaFabricanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaFabricanteMouseClicked
        // TODO add your handling code here:
        helper.setModelo();
    }//GEN-LAST:event_jTabelaFabricanteMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        //controller chama metodo salvar fabricante
        controller.salvarFabricante();
        
        iniciar();

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        //controller chama metodo deletar fabricante
        controller.deletar();

        iniciar();

        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar1ActionPerformed
        //tente chamar a tela cadastro equipamento
        try
        {

            this.dispose();

            TelaCadastroEquipamento telacadequipamento = new TelaCadastroEquipamento();
            telacadequipamento.setVisible(true);

        }
        //se não conseguir pegue a excesão e mostre a mensagem na tela junto com a excesão
        catch(Exception ex)
        {

            JOptionPane.showMessageDialog(null, "Error ao chamar a tela cadastro equipamento!" + ex);

        }
    }//GEN-LAST:event_btnVoltar1ActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        //controller chama metodo update fabricante
        controller.updateFabricante();
        
        iniciar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        //ao clickar chama o helper em novo seta todos os campos como true
        helper.desbloquearCampos(); 
    }//GEN-LAST:event_btnNovoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroFabricante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFabricante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFabricante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFabricante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroFabricante().setVisible(true);
            }
        });
    }

    //getters e setters
    public static JButton getBtnEditar() {
        return btnEditar;
    }

    public static void setBtnEditar(JButton btnEditar) {
        TelaCadastroFabricante.btnEditar = btnEditar;
    }

    public static JButton getBtnExcluir() {
        return btnExcluir;
    }

    public static void setBtnExcluir(JButton btnExcluir) {
        TelaCadastroFabricante.btnExcluir = btnExcluir;
    }

    public static JButton getBtnNovo() {
        return btnNovo;
    }

    public static void setBtnNovo(JButton btnNovo) {
        TelaCadastroFabricante.btnNovo = btnNovo;
    }

    public static JButton getBtnPesquisar() {
        return btnPesquisar;
    }

    public static void setBtnPesquisar(JButton btnPesquisar) {
        TelaCadastroFabricante.btnPesquisar = btnPesquisar;
    }

    public static JButton getBtnSalvar() {
        return btnSalvar;
    }

    public static void setBtnSalvar(JButton btnSalvar) {
        TelaCadastroFabricante.btnSalvar = btnSalvar;
    }

    public static JButton getBtnVoltar1() {
        return btnVoltar1;
    }

    public static void setBtnVoltar1(JButton btnVoltar1) {
        TelaCadastroFabricante.btnVoltar1 = btnVoltar1;
    }

    public static JTable getjTabelaFornecedor() {
        return jTabelaFabricante;
    }

    public static void setjTabelaFornecedor(JTable jTabelaFornecedor) {
        TelaCadastroFabricante.jTabelaFabricante = jTabelaFornecedor;
    }

    public static JTextField getTxtFabricante() {
        return txtFabricante;
    }

    public static void setTxtFabricante(JTextField txtFabricante) {
        TelaCadastroFabricante.txtFabricante = txtFabricante;
    }

    public static JTextField getTxtId() {
        return txtId;
    }

    public static void setTxtId(JTextField txtId) {
        TelaCadastroFabricante.txtId = txtId;
    }
    
    public void iniciar()
    {
        
            //impede o usuario de mover as colunas para reoodena-las
            jTabelaFabricante.getTableHeader().setReorderingAllowed(false);
            
            //chama este metodo do controller
            controller.tabelaFabricantes();
            
            jTabelaFabricante.setRowSelectionAllowed(true);
            
            //impessa o jtable de se auto redimensionar
            jTabelaFabricante.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
            //as linhas abaixo define o tamanho das colunas da tabela
            //tabela pegue o modelo de coluna, pegue a coluna zero e sete a largura
            jTabelaFabricante.getColumnModel().getColumn(0).setPreferredWidth(622);
            jTabelaFabricante.getColumnModel().getColumn(1).setPreferredWidth(622);            
        
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnEditar;
    public static javax.swing.JButton btnExcluir;
    public static javax.swing.JButton btnNovo;
    public static javax.swing.JButton btnPesquisar;
    public static javax.swing.JButton btnSalvar;
    public static javax.swing.JButton btnVoltar1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTabelaFabricante;
    private javax.swing.JLabel lblFabricantenome;
    public static javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblTitulo;
    public static javax.swing.JTextField txtFabricante;
    public static javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}