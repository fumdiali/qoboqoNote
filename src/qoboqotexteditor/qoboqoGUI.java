
package qoboqotexteditor;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

// proper commenting still to come
// more features, as well..

/**
 *
 * @author patrick c diali
 * @version 1.0.0
 */
public class qoboqoGUI extends javax.swing.JFrame {
    String fileName;
    Clipboard clip = getToolkit().getSystemClipboard();
    /**
     * Creates new form qoboqoGUI
     */
    public qoboqoGUI() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        newFIle = new javax.swing.JMenu();
        newFile = new javax.swing.JMenuItem();
        openFile = new javax.swing.JMenuItem();
        saveFile = new javax.swing.JMenuItem();
        exitFile = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        copyFile = new javax.swing.JMenuItem();
        cutFile = new javax.swing.JMenuItem();
        pasteFile = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(700, 700));

        searchButton.setText("Find");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
        );

        newFIle.setText("File");

        newFile.setText("New");
        newFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileActionPerformed(evt);
            }
        });
        newFIle.add(newFile);

        openFile.setText("Open");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        newFIle.add(openFile);

        saveFile.setText("Save");
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });
        newFIle.add(saveFile);

        exitFile.setText("Close");
        exitFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitFileActionPerformed(evt);
            }
        });
        newFIle.add(exitFile);

        jMenuBar1.add(newFIle);

        jMenu2.setText("Edit");

        copyFile.setText("Copy");
        copyFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyFileActionPerformed(evt);
            }
        });
        jMenu2.add(copyFile);

        cutFile.setText("Cut");
        cutFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutFileActionPerformed(evt);
            }
        });
        jMenu2.add(cutFile);

        pasteFile.setText("Paste");
        pasteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteFileActionPerformed(evt);
            }
        });
        jMenu2.add(pasteFile);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void newFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileActionPerformed
        // TODO add your handling code here:
        textArea.setText("");
        setTitle(fileName);
    }//GEN-LAST:event_newFileActionPerformed
     
    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        // opens directory window on user system to select file to open
        FileDialog fd = new FileDialog(qoboqoGUI.this,"Open File",FileDialog.LOAD);
        fd.setVisible(true);
        
        if(fd.getFile() != null){
          fileName = fd.getDirectory()+fd.getFile();
          setTitle(fileName);
        }//end of if statement
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            
            String line = null;
            
            while((line = reader.readLine())!= null){
              sb.append(line + "\n");
              textArea.setText(sb.toString());
            }
            reader.close();
        }catch(IOException e){
          System.out.println("File not found!");
        }
    }//GEN-LAST:event_openFileActionPerformed

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
        FileDialog fd = new FileDialog(qoboqoGUI.this,"Save File",FileDialog.SAVE);
        fd.setVisible(true);
        
        if(fd.getFile() != null){
          fileName = fd.getDirectory() + fd.getFile();
          setTitle(fileName);
          }//end of if statement
        try{
          FileWriter fw = new FileWriter(fileName);
          fw.write(textArea.getText());
          setTitle(fileName);
          fw.close();
        }catch(IOException e){
            System.out.println("File not found!");
        }
    }//GEN-LAST:event_saveFileActionPerformed

    private void exitFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitFileActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitFileActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        searchTextArea(textArea,searchField.getText());
    }//GEN-LAST:event_searchButtonActionPerformed

                                                
    // class for text highlighting
    class myHighlighter extends DefaultHighlighter.DefaultHighlightPainter{

        //constructor
        public myHighlighter(Color c) {
            super(c);
        }
    }//end of myHighlighter class
    //lighter object,for myHighlighter
    DefaultHighlighter.HighlightPainter lighter = new myHighlighter(Color.GREEN);
    
    //custom methods
    public void removeHighlight(JTextComponent tComp){
      Highlighter removeHigh = tComp.getHighlighter();
      Highlighter.Highlight[] remove = removeHigh.getHighlights();
      
      for(int i=0;i<remove.length;i++){
        if(remove[i].getPainter() instanceof myHighlighter){
          removeHigh.removeHighlight(remove[i]);
      }
      }
    }
    public void searchTextArea(JTextComponent tComp,String tString){
        removeHighlight(tComp);
      try{
        Highlighter highlight = tComp.getHighlighter();
        Document doc = tComp.getDocument();
        String text = doc.getText(0, doc.getLength());
        
        int position = 0;
        while((position = text.toUpperCase().indexOf(tString.toUpperCase(),position)) >= 0){
          highlight.addHighlight(position, position+tString.length(), lighter);
          position += tString.length();
        }
      }catch(Exception e){}
    }
    
    private void copyFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyFileActionPerformed
        String copyText = textArea.getSelectedText();
        StringSelection copySelect = new StringSelection(copyText);
        clip.setContents(copySelect, copySelect);
    }//GEN-LAST:event_copyFileActionPerformed

    private void cutFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutFileActionPerformed
        String cutString = textArea.getSelectedText();
        StringSelection cutSelected = new StringSelection(cutString);
        clip.setContents(cutSelected, cutSelected);
        textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());
    }//GEN-LAST:event_cutFileActionPerformed

    private void pasteFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteFileActionPerformed
        try{
            Transferable pasteText = clip.getContents(qoboqoGUI.this);
            String selec = (String) pasteText.getTransferData(DataFlavor.stringFlavor);
            textArea.replaceRange(selec, textArea.getSelectionStart(), textArea.getSelectionEnd());
            
        }catch (Exception e){
          System.out.println("Failed action!");
        }
    }//GEN-LAST:event_pasteFileActionPerformed

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
            java.util.logging.Logger.getLogger(qoboqoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(qoboqoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(qoboqoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(qoboqoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new qoboqoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem copyFile;
    private javax.swing.JMenuItem cutFile;
    private javax.swing.JMenuItem exitFile;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu newFIle;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JMenuItem pasteFile;
    private javax.swing.JMenuItem saveFile;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
