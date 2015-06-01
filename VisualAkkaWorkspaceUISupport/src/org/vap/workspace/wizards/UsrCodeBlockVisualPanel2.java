/* 
 */
package org.vap.workspace.wizards;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;
import org.openide.WizardDescriptor;
import org.openide.util.HelpCtx;
import org.vap.core.model.micro.Argument;
import org.vap.core.model.micro.Method;
import org.vap.core.model.micro.Result;

public final class UsrCodeBlockVisualPanel2 extends JPanel {
    
    private Method m = null;

    /**
     * Creates new form UsrCodeBlockVisualPanel2
     */
    public UsrCodeBlockVisualPanel2() {
        initComponents();
        jList2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {
                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    Argument a = m.getArguments().get(index);
                    NewArgumentPane nap = new NewArgumentPane(a.getName(), a.getType(), a.isIsMainArg());
                    int result = JOptionPane.showConfirmDialog(null, nap,
                            "New argument", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        a.setName(nap.getName());
                        a.setType(nap.getType());
                        if (!a.isIsMainArg()) {
                            a.setFixed(nap.isFixed());
                            a.setDefaultValue(nap.getDefVal());
                        } else {
                            m.setName(a.getName());
                        }
                        loadItems();
                    }
                }
            }
        });
        jList1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {
                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    Result a = m.getResults().get(index);
                    NewOutputPane nap = new NewOutputPane(a.getName(), a.getType());
                    int result = JOptionPane.showConfirmDialog(null, nap,
                            "New output", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        a.setName(nap.getName());
                        a.setType(nap.getType());
                        loadItems();
                    }
                }
            }
        });
    }
    
    @Override
    public String getName() {
        return "Block fields";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jButton3 = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(UsrCodeBlockVisualPanel2.class, "UsrCodeBlockVisualPanel2.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton2, org.openide.util.NbBundle.getMessage(UsrCodeBlockVisualPanel2.class, "UsrCodeBlockVisualPanel2.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(UsrCodeBlockVisualPanel2.class, "UsrCodeBlockVisualPanel2.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(UsrCodeBlockVisualPanel2.class, "UsrCodeBlockVisualPanel2.jLabel2.text")); // NOI18N

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        org.openide.awt.Mnemonics.setLocalizedText(jButton3, org.openide.util.NbBundle.getMessage(UsrCodeBlockVisualPanel2.class, "UsrCodeBlockVisualPanel2.jButton3.text")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(35, 35, 35)
                        .addComponent(jButton2)
                        .addGap(28, 28, 28)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        NewArgumentPane nap = new NewArgumentPane();
        int result = JOptionPane.showConfirmDialog(null, nap,
                "New argument", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Argument a = new Argument(nap.getName(), nap.getType());
            a.setFixed(nap.isFixed());
            a.setDefaultValue(nap.getDefVal());
            m.addParameter(a);
            loadItems();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int[] idx = jList1.getSelectedIndices();
        for (int i = idx.length - 1; i >= 0; i--) {
            if (!m.getArguments().get(i).isIsMainArg()) {
                m.getArguments().remove(i);
            }
        }
        idx = jList2.getSelectedIndices();
        for (int i = idx.length - 1; i >= 0; i--) {
            m.getResults().remove(i);
        }
        loadItems();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        NewOutputPane nap = new NewOutputPane();
        int result = JOptionPane.showConfirmDialog(null, nap,
                "New argument", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Result a = new Result(nap.getName(), nap.getType());
            m.addParameter(a);
            loadItems();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    public void updateSettings(Method m) {
        this.m = m;
        loadItems();
//        Result r = m.getResults().get(0);
//        this.jTextField1.setText(r.getName());
//        this.jTextField2.setText(r.getType());
    }
    
//    public void saveSettings() {
//        m.getResults().get(0).setName(jTextField1.getText());
//        m.getResults().get(0).setType(jTextField2.getText());
//    }
    
    public void loadItems() {
        String[] items = new String[m.getArguments().size()];
        for (int i = 0; i < items.length; i++) {
            Argument a = m.getArguments().get(i);
            String s = a.getName() + ":" + a.getType();
            if (a.isIsMainArg()) {
                s = "*" + s;
            }
            if (a.isFixed()) {
                s = s + " (" + a.getDefaultValue() + ")";
            }
            items[i] = s;
        }
        jList2.setListData(items);
        String[] items1 = new String[m.getResults().size()];
        for (int i = 0; i < items1.length; i++) {
            Result a = m.getResults().get(i);
            String s = a.getName() + ":" + a.getType();
            items1[i] = s;
        }
        jList1.setListData(items1);
    }
}
