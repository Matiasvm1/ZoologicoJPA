
package View;
import Presenters.PresentadorAltaMamifero;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ViewAltaMamifero extends javax.swing.JFrame {
    PresentadorAltaMamifero presentMamifero;
   
    public ViewAltaMamifero() {
        presentMamifero = new PresentadorAltaMamifero();
        presentMamifero.setVistaAlta(this);
        initComponents();
        setCmbEspecies();
        setCmbPaises();
        
    }

 

    public JComboBox getCmbEspecie() {
        return cmbEspecie;
    }

    public JComboBox getCmbPais() {
        return cmbPais;
    }

    public JComboBox getCmbSectores() {
        return cmbSectores;
    }
   // ------SETEAN LOS JCOMBOBOX------
    private void setCmbEspecies(){
        presentMamifero.setCmbEspecies();
    }
    private void setCmbPaises() {
          presentMamifero.setCmbPaises();
      }
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtEdad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbSectores = new javax.swing.JComboBox();
        btnConfirmarMamifero = new javax.swing.JButton();
        cmbPais = new javax.swing.JComboBox();
        especieAnimal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbEspecie = new javax.swing.JComboBox();
        txtValorHerbivoro = new javax.swing.JTextField();
        Jlabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });

        jLabel1.setText("Pais :");

        jLabel2.setText("Peso :");

        txtPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoActionPerformed(evt);
            }
        });

        jLabel3.setText("Sector :");

        btnConfirmarMamifero.setText("Confirmar");
        btnConfirmarMamifero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarMamiferoActionPerformed(evt);
            }
        });

        especieAnimal.setText("Especie :");

        jLabel4.setText("Valor Herbivoro:");

        cmbEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEspecieActionPerformed(evt);
            }
        });
        cmbEspecie.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbEspeciePropertyChange(evt);
            }
        });

        txtValorHerbivoro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorHerbivoroActionPerformed(evt);
            }
        });
        txtValorHerbivoro.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtValorHerbivoroPropertyChange(evt);
            }
        });

        Jlabel.setText("Edad :");

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Alta Mamifero");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(especieAnimal)
                                    .addComponent(Jlabel)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorHerbivoro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(cmbSectores, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel5))
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(btnConfirmarMamifero)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel5)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbSectores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(especieAnimal)
                    .addComponent(cmbEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jlabel)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtValorHerbivoro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnConfirmarMamifero)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesoActionPerformed

    private void btnConfirmarMamiferoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarMamiferoActionPerformed
        try {
            presentMamifero.createMamifero(cmbEspecie.getSelectedItem(),txtEdad.getText(),cmbPais.getSelectedItem(),txtPeso.getText(),cmbSectores.getSelectedItem(),txtValorHerbivoro.getText());
        } catch (Exception ex) {
            Logger.getLogger(ViewAltaMamifero.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnConfirmarMamiferoActionPerformed

    private void cmbEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEspecieActionPerformed
        presentMamifero.limitarEspecie(cmbEspecie.getSelectedItem());
    }//GEN-LAST:event_cmbEspecieActionPerformed

    private void cmbEspeciePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbEspeciePropertyChange

    }//GEN-LAST:event_cmbEspeciePropertyChange

    private void txtValorHerbivoroPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtValorHerbivoroPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorHerbivoroPropertyChange

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    private void txtValorHerbivoroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorHerbivoroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorHerbivoroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jlabel;
    private javax.swing.JButton btnConfirmarMamifero;
    private javax.swing.JComboBox cmbEspecie;
    private javax.swing.JComboBox cmbPais;
    private javax.swing.JComboBox cmbSectores;
    private javax.swing.JLabel especieAnimal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtValorHerbivoro;
    // End of variables declaration//GEN-END:variables

    public JTextField getTxtValorHerbivoro() {
        return txtValorHerbivoro;
    }

    public void setTxtValorHerbivoro(JTextField txtValorHerbivoro) {
        this.txtValorHerbivoro = txtValorHerbivoro;
    }

   

  
}
