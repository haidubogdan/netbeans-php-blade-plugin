/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.php.blade.editor.ui.customizer;

import java.awt.EventQueue;
import java.io.File;
import javax.swing.event.ChangeListener;
import org.netbeans.api.project.Project;
import org.netbeans.modules.php.blade.editor.indexing.IndexManager;
import org.netbeans.modules.php.blade.editor.path.BladePathUtils;
import org.netbeans.modules.php.blade.project.BladeProjectProperties;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.filesystems.*;
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

public final class BladeViewsFoldersPanel extends javax.swing.JPanel {

    private final ChangeSupport changeSupport = new ChangeSupport(this);
    private final Project project;
    BladeProjectProperties bladeProperties;

    BladeViewsFoldersPanel(Project project) {
        assert project != null;
        this.project = project;
        bladeProperties = BladeProjectProperties.forProject(project);
        initComponents();
        init();
    }
    
    private void init(){
        viewsPathList.setModel(bladeProperties.getModelViewsPathList());
        nonLaravelViewDeclFinder.setSelected(bladeProperties.getNonLaravelDeclFinderFlag());
    }
     
    public void storeData(){
        bladeProperties.storeViewsPaths();
        bladeProperties.storeNonLaravelDeclFinderFlag(nonLaravelViewDeclFinder.isSelected());
    }
      
    public void addChangeListener(ChangeListener listener) {
        changeSupport.addChangeListener(listener);
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewsPathList = new javax.swing.JList<>();
        addViewFolderButton = new javax.swing.JButton();
        removeViewFolderButton = new javax.swing.JButton();
        reindexViewsButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        reindexViewFolderButton = new javax.swing.JButton();
        nonLaravelViewDeclFinder = new javax.swing.JCheckBox();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(BladeViewsFoldersPanel.class, "BladeViewsFoldersPanel.jLabel1.text")); // NOI18N
        jLabel1.setToolTipText(org.openide.util.NbBundle.getMessage(BladeViewsFoldersPanel.class, "BladeViewsFoldersPanel.jLabel1.toolTipText")); // NOI18N

        jScrollPane1.setViewportView(viewsPathList);

        org.openide.awt.Mnemonics.setLocalizedText(addViewFolderButton, org.openide.util.NbBundle.getMessage(BladeViewsFoldersPanel.class, "BladeViewsFoldersPanel.addViewFolderButton.text")); // NOI18N
        addViewFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addViewFolderButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(removeViewFolderButton, org.openide.util.NbBundle.getMessage(BladeViewsFoldersPanel.class, "BladeViewsFoldersPanel.removeViewFolderButton.text")); // NOI18N
        removeViewFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeViewFolderButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(reindexViewsButton, org.openide.util.NbBundle.getMessage(BladeViewsFoldersPanel.class, "BladeViewsFoldersPanel.reindexViewsButton.text")); // NOI18N
        reindexViewsButton.setToolTipText(org.openide.util.NbBundle.getMessage(BladeViewsFoldersPanel.class, "BladeViewsFoldersPanel.reindexViewsButton.toolTipText")); // NOI18N
        reindexViewsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reindexViewsButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(BladeViewsFoldersPanel.class, "BladeViewsFoldersPanel.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(BladeViewsFoldersPanel.class, "BladeViewsFoldersPanel.jLabel4.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(reindexViewFolderButton, org.openide.util.NbBundle.getMessage(BladeViewsFoldersPanel.class, "BladeViewsFoldersPanel.reindexViewFolderButton.text")); // NOI18N
        reindexViewFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reindexViewFolderButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(nonLaravelViewDeclFinder, org.openide.util.NbBundle.getMessage(BladeViewsFoldersPanel.class, "BladeViewsFoldersPanel.nonLaravelViewDeclFinder.text")); // NOI18N

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
                            .addComponent(addViewFolderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reindexViewFolderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(reindexViewsButton)
                            .addComponent(jLabel4)
                            .addComponent(nonLaravelViewDeclFinder))
                        .addGap(0, 83, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addViewFolderButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeViewFolderButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reindexViewFolderButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reindexViewsButton)
                .addGap(18, 18, 18)
                .addComponent(nonLaravelViewDeclFinder)
                .addContainerGap(144, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addViewFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addViewFolderButtonActionPerformed
        assert EventQueue.isDispatchThread();
        File source = new FileChooserBuilder(BladeDirectives.class)
                .setDirectoriesOnly(true)
                .setTitle("Select View Folder Path") // NOI18N
                .setDefaultWorkingDirectory(FileUtil.toFile(project.getProjectDirectory()))
                .forceUseOfDefaultWorkingDirectory(true)
                .showOpenDialog();
        if (source != null) {
            String relativePath = BladePathUtils.relativeFilePath(source, project.getProjectDirectory());
            bladeProperties.addViewsPath(relativePath);
        }
    }//GEN-LAST:event_addViewFolderButtonActionPerformed

    private void removeViewFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeViewFolderButtonActionPerformed
        int index = viewsPathList.getSelectedIndex();
        if (index > -1) {
            bladeProperties.removeViewsPath(index);
        }
    }//GEN-LAST:event_removeViewFolderButtonActionPerformed

    private void reindexViewsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reindexViewsButtonActionPerformed
        IndexManager.reindexProjectViews(project);
    }//GEN-LAST:event_reindexViewsButtonActionPerformed

    private void reindexViewFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reindexViewFolderButtonActionPerformed
        String path = viewsPathList.getSelectedValue();
        if (path != null && path.length() > 0) {
            File viewPath = new File(path);
            if (viewPath.exists()) {
                IndexManager.reindexFolder(viewPath);
            }
        }
    }//GEN-LAST:event_reindexViewFolderButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addViewFolderButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox nonLaravelViewDeclFinder;
    private javax.swing.JButton reindexViewFolderButton;
    private javax.swing.JButton reindexViewsButton;
    private javax.swing.JButton removeViewFolderButton;
    private javax.swing.JList<String> viewsPathList;
    // End of variables declaration//GEN-END:variables

}
