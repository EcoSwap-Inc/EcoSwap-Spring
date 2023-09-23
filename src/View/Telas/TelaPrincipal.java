package View.Telas;

import Model.JInternalFrameBasic;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Font;

public class TelaPrincipal extends javax.swing.JFrame {
    public TelaPrincipal() {
        initComponents();
        
        jDesktopPane1.requestFocus();
        this.TrocarTela(new TelaInicial());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTelaInicial = new javax.swing.JButton();
        btnTelaMidia = new javax.swing.JButton();
        btnTelaColecionaveis = new javax.swing.JButton();
        btnTelaJardinagem = new javax.swing.JButton();
        btnTelaLivros = new javax.swing.JButton();
        btnTelaInformatica = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButton7 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 728));

        btnTelaInicial.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTelaInicial.setText("Inicial");
        btnTelaInicial.setBorderPainted(false);
        btnTelaInicial.setContentAreaFilled(false);
        btnTelaInicial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTelaInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkClick(evt);
            }
        });

        btnTelaMidia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTelaMidia.setText("Mídia");
        btnTelaMidia.setBorderPainted(false);
        btnTelaMidia.setContentAreaFilled(false);
        btnTelaMidia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTelaMidia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkClick(evt);
            }
        });

        btnTelaColecionaveis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTelaColecionaveis.setText("Colecionáveis");
        btnTelaColecionaveis.setBorderPainted(false);
        btnTelaColecionaveis.setContentAreaFilled(false);
        btnTelaColecionaveis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTelaColecionaveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkClick(evt);
            }
        });

        btnTelaJardinagem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTelaJardinagem.setText("Jardinagem");
        btnTelaJardinagem.setBorderPainted(false);
        btnTelaJardinagem.setContentAreaFilled(false);
        btnTelaJardinagem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTelaJardinagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkClick(evt);
            }
        });

        btnTelaLivros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTelaLivros.setText("Livros e HQs");
        btnTelaLivros.setBorderPainted(false);
        btnTelaLivros.setContentAreaFilled(false);
        btnTelaLivros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTelaLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkClick(evt);
            }
        });

        btnTelaInformatica.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTelaInformatica.setText("Informática");
        btnTelaInformatica.setBorderPainted(false);
        btnTelaInformatica.setContentAreaFilled(false);
        btnTelaInformatica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTelaInformatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkClick(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("EcoSwap");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jButton7.setText("Botao perfil");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTelaInicial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTelaMidia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTelaColecionaveis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTelaJardinagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTelaLivros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTelaInformatica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)))
                .addGap(32, 32, 32))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTelaInicial)
                    .addComponent(btnTelaMidia)
                    .addComponent(btnTelaColecionaveis)
                    .addComponent(btnTelaJardinagem)
                    .addComponent(btnTelaLivros)
                    .addComponent(btnTelaInformatica)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jDesktopPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetNavBarBtns() {
        Font normal = new Font("Segoe UI", 0, 14);
        btnTelaColecionaveis.setFont(normal);
        btnTelaInformatica.setFont(normal);
        btnTelaInicial.setFont(normal);
        btnTelaJardinagem.setFont(normal);
        btnTelaLivros.setFont(normal);
        btnTelaMidia.setFont(normal);
    }
    
    private void TrocarTela(JInternalFrameBasic tela) {
        jDesktopPane1.add(tela);
        tela.setVisible(true);
        tela.setSize(jDesktopPane1.getWidth(), jDesktopPane1.getHeight());
    }
    
    private void linkClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkClick
        jDesktopPane1.removeAll();
        this.resetNavBarBtns();
        
        javax.swing.JButton botaoClicado = (javax.swing.JButton)evt.getSource();
        botaoClicado.setFont(new Font("Segoe UI", 1, 14));
        if (botaoClicado.equals(btnTelaInicial)) {
            TelaInicial tela = new TelaInicial();
            
            this.TrocarTela(tela);
        }
        else {
            TelaCatalogo tela = new TelaCatalogo();
            tela.setCategoria(botaoClicado.getText());
            
            this.TrocarTela(tela);
        }
    }//GEN-LAST:event_linkClick

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTelaColecionaveis;
    private javax.swing.JButton btnTelaInformatica;
    private javax.swing.JButton btnTelaInicial;
    private javax.swing.JButton btnTelaJardinagem;
    private javax.swing.JButton btnTelaLivros;
    private javax.swing.JButton btnTelaMidia;
    private javax.swing.JButton jButton7;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
