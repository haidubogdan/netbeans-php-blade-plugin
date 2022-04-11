/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2013 Sun Microsystems, Inc.
 */
package org.netbeans.modules.php.blade.editor.ui.customizer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.netbeans.api.project.Project;
import org.netbeans.modules.parsing.api.indexing.IndexingManager;
import org.netbeans.modules.php.blade.api.BladeVersion;
import org.netbeans.modules.php.blade.editor.index.BladeIndexer;
import org.netbeans.modules.php.blade.project.BladeProjectProperties;
import org.netbeans.modules.php.blade.ui.UiOptionsUtils.BladeVersionComboBoxModel;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.filesystems.FileChooserBuilder;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.ChangeSupport;
import org.openide.util.NbBundle;

@NbBundle.Messages("BladePanel.options.keywords.tabTitle=Frameworks & Tools")
@OptionsPanelController.Keywords(
    keywords = {
        "php", "blade"
    },
    location = "Html5",
    tabTitle = "#BladePanel.options.keywords.tabTitle"
)

public final class BladeOptionsPanel extends javax.swing.JPanel {

    private final ChangeSupport changeSupport = new ChangeSupport(this);
    private final Project project;

    BladeOptionsPanel(Project project) {
        assert project != null;
        this.project = project;
        initComponents();
        
        init();
    }
    
    private void init(){
        bladeVersionComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //temporary store data?
                //storeData();
            }
        });
        bladeVersionComboBox.setModel(new BladeVersionComboBoxModel( BladeProjectProperties.getInstance().getDefaultBladeVersion()));
    }
     
    public void storeData(){
        Object selectedItem = bladeVersionComboBox.getModel().getSelectedItem();
        BladeProjectProperties.getInstance().setDefaultBladeVersion((BladeVersion) selectedItem);
        DefaultListModel viewsPathModel = (DefaultListModel) viewsPathList.getModel();
        BladeProjectProperties.getInstance().setViewsPathList(viewsPathModel);
    }
      
    public void addChangeListener(ChangeListener listener) {
        changeSupport.addChangeListener(listener);
    }
    
    void fireChange() {
        changeSupport.fireChange();
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toggleCommentButtonGroup = new javax.swing.ButtonGroup();
        bladeOptionsLabel = new javax.swing.JLabel();
        bladeVersionLabel = new javax.swing.JLabel();
        bladeVersionComboBox = new JComboBox<BladeVersion>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewsPathList = new javax.swing.JList<>();
        addViewFolderButton = new javax.swing.JButton();
        removeViewFolderButton = new javax.swing.JButton();
        reindexViewsButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(bladeOptionsLabel, org.openide.util.NbBundle.getMessage(BladeOptionsPanel.class, "BladeOptionsPanel.bladeOptionsLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(bladeVersionLabel, org.openide.util.NbBundle.getMessage(BladeOptionsPanel.class, "BladeOptionsPanel.bladeVersionLabel.text")); // NOI18N

        bladeVersionComboBox.setToolTipText(org.openide.util.NbBundle.getMessage(BladeOptionsPanel.class, "BladeOptionsPanel.bladeVersionComboBox.toolTipText")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(BladeOptionsPanel.class, "BladeOptionsPanel.jLabel1.text")); // NOI18N
        jLabel1.setToolTipText(org.openide.util.NbBundle.getMessage(BladeOptionsPanel.class, "BladeOptionsPanel.jLabel1.toolTipText")); // NOI18N

        viewsPathList.setModel(org.netbeans.modules.php.blade.project.BladeProjectProperties.getInstance().getModelViewsPathList());
        jScrollPane1.setViewportView(viewsPathList);

        org.openide.awt.Mnemonics.setLocalizedText(addViewFolderButton, org.openide.util.NbBundle.getMessage(BladeOptionsPanel.class, "BladeOptionsPanel.addViewFolderButton.text")); // NOI18N
        addViewFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addViewFolderButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(removeViewFolderButton, org.openide.util.NbBundle.getMessage(BladeOptionsPanel.class, "BladeOptionsPanel.removeViewFolderButton.text")); // NOI18N
        removeViewFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeViewFolderButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(reindexViewsButton, org.openide.util.NbBundle.getMessage(BladeOptionsPanel.class, "BladeOptionsPanel.reindexViewsButton.text")); // NOI18N
        reindexViewsButton.setToolTipText(org.openide.util.NbBundle.getMessage(BladeOptionsPanel.class, "BladeOptionsPanel.reindexViewsButton.toolTipText")); // NOI18N
        reindexViewsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reindexViewsButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(BladeOptionsPanel.class, "BladeOptionsPanel.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(BladeOptionsPanel.class, "BladeOptionsPanel.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(BladeOptionsPanel.class, "BladeOptionsPanel.jLabel4.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(removeViewFolderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addViewFolderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bladeOptionsLabel)
                            .addComponent(jLabel1)
                            .addComponent(reindexViewsButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bladeVersionLabel)
                                .addGap(18, 18, 18)
                                .addComponent(bladeVersionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addComponent(jLabel4))
                        .addGap(0, 53, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bladeOptionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bladeVersionLabel)
                    .addComponent(bladeVersionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addViewFolderButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeViewFolderButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reindexViewsButton)
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addViewFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addViewFolderButtonActionPerformed
        assert EventQueue.isDispatchThread();
        File sources = new FileChooserBuilder(BladeDirectives.class)
                .setDirectoriesOnly(true)
                .setTitle("Select View Folder Path")
                .setDefaultWorkingDirectory(FileUtil.toFile(project.getProjectDirectory()))
                .forceUseOfDefaultWorkingDirectory(true)
                .showOpenDialog();
        if (sources != null) {
            DefaultListModel pathModel = (DefaultListModel) viewsPathList.getModel();
            //TODO validate the path if it has blade files ?
            pathModel.addElement(FileUtil.normalizeFile(sources).getAbsolutePath());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_addViewFolderButtonActionPerformed

    private void removeViewFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeViewFolderButtonActionPerformed
        int index = viewsPathList.getSelectedIndex();
        if (index > -1) {
            DefaultListModel pathModel = (DefaultListModel) viewsPathList.getModel();
            pathModel.remove(index);
        }
    }//GEN-LAST:event_removeViewFolderButtonActionPerformed

    private void reindexViewsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reindexViewsButtonActionPerformed
        // TODO add your handling code here:
        String[] views = BladeProjectProperties.getInstance().getViewsPathList();
        
        if (views.length > 0){
            for (String view : views){
                if (view.length() == 0){
                    continue;
                }
                File viewPath = new File(view);
                if (viewPath.exists()){
                    FileObject fileObj = FileUtil.toFileObject(viewPath);
                    IndexingManager.getDefault().refreshIndex(fileObj.toURL(), null);
                }
            }
        } else {
            //falback
            String projectDir = project.getProjectDirectory().getPath().toString();
            File viewPath = new File(projectDir + "/views");
            if (viewPath.exists()){
                FileObject fileObj = FileUtil.toFileObject(viewPath);
                IndexingManager.getDefault().refreshIndex(fileObj.toURL(), null);
            }
        }
    }//GEN-LAST:event_reindexViewsButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addViewFolderButton;
    private javax.swing.JLabel bladeOptionsLabel;
    private javax.swing.JComboBox<BladeVersion> bladeVersionComboBox;
    private javax.swing.JLabel bladeVersionLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reindexViewsButton;
    private javax.swing.JButton removeViewFolderButton;
    private javax.swing.ButtonGroup toggleCommentButtonGroup;
    private javax.swing.JList<String> viewsPathList;
    // End of variables declaration//GEN-END:variables

}
