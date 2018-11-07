/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Header;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author pelon
 */
public class view extends javax.swing.JFrame {

    /**
     * Creates new form view
     */
    public final Font defecto = new Font("San Francisco Display", Font.BOLD, 13);
    public final Color defectoColor = Color.WHITE;
    public final JPanel colorLabel1 = new JPanel();


    
    public void resizeColumnWidth(JTable table) {
    final TableColumnModel columnModel = table.getColumnModel();
    for (int column = 0; column < table.getColumnCount(); column++) {
        int width = 15; // Min width
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer renderer = table.getCellRenderer(row, column);
            Component comp = table.prepareRenderer(renderer, row, column);
            width = Math.max(comp.getPreferredSize().width +1 , width);
        }
        if(width > 300)
            width=300;
        columnModel.getColumn(column).setPreferredWidth(width);
    }
}
    
    public Connection getConnection(){
        Connection con = null;
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String stringCon = getServerIp();
        //String stringCon= "jdbc:sqlserver://localhost:1433;databaseName=Inventario;integratedSecurity=true";
        con = DriverManager.getConnection(stringCon);
    }
    catch(Exception ex){
    JOptionPane.showMessageDialog(null, "Error: " + ex);
    }
        return con;
    }
    
 String getServerIp() throws FileNotFoundException, IOException {
      String cadena = null;
      FileReader f = new FileReader("conexion.txt");
      BufferedReader b = new BufferedReader(f);
      while((cadena = b.readLine())!=null) {
          return cadena;
          
      }
      b.close();
      return cadena;
}
 
    private void tablaComputadora(String comando) throws ClassNotFoundException {
        try {
            Connection con = getConnection();
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(comando);
            ResultSetMetaData rsmetadata = rs.getMetaData();
            int columns = rsmetadata.getColumnCount();

            DefaultTableModel dtm = new DefaultTableModel();

            Vector columns_name = new Vector();
            Vector data_rows = new Vector();

            for (int i = 1; i <= columns; i++) {
                columns_name.addElement(rsmetadata.getColumnName(i));
            }
            dtm.setColumnIdentifiers(columns_name);

            while (rs.next()) {

                data_rows = new Vector();
                for (int j = 1; j <= columns; j++) {
                    data_rows.addElement(rs.getString(j));
                }
                dtm.addRow(data_rows);
            }

            tablaComputadoras.setModel(dtm);
            tablaComputadoras.getColumnModel().getColumn(3).setPreferredWidth(130);
            tablaComputadoras.getColumnModel().getColumn(4).setPreferredWidth(120);
            tablaComputadoras.getColumnModel().getColumn(7).setPreferredWidth(150);
            tablaComputadoras.getColumnModel().getColumn(8).setPreferredWidth(180);
            numPc.setText(String.valueOf(dtm.getRowCount()));
            con.close();
            
            resizeColumnWidth(tablaComputadoras);
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void tablaDispositivo(String comando) throws ClassNotFoundException {
        try {
            Connection con = getConnection();
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(comando);
            ResultSetMetaData rsmetadata = rs.getMetaData();
            int columns = rsmetadata.getColumnCount();

            DefaultTableModel dtm = new DefaultTableModel();

            Vector columns_name = new Vector();
            Vector data_rows = new Vector();

            for (int i = 1; i <= columns; i++) {
                columns_name.addElement(rsmetadata.getColumnName(i));
            }
            dtm.setColumnIdentifiers(columns_name);

            while (rs.next()) {

                data_rows = new Vector();
                for (int j = 1; j <= columns; j++) {
                    data_rows.addElement(rs.getString(j));
                }
                dtm.addRow(data_rows);
            }

            tablaDispositivos.setModel(dtm);
            tablaDispositivos.getColumnModel().getColumn(0).setPreferredWidth(130);
            tablaDispositivos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tablaDispositivos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tablaDispositivos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tablaDispositivos.getColumnModel().getColumn(4).setPreferredWidth(100);
            tablaDispositivos.getColumnModel().getColumn(5).setPreferredWidth(150);
            tablaDispositivos.getColumnModel().getColumn(6).setPreferredWidth(180);
            numDisp.setText(String.valueOf(dtm.getRowCount()));
            con.close();
            
            resizeColumnWidth(tablaDispositivos);
        } catch (SQLException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public view() {

        initComponents();
        botones.add(areaButton);
        botones.add(responsableButton);
        botones.add(tipoButton);
        botones.add(sinFiltro);
        agregarIcono();
        this.getContentPane().setBackground(SeasunColor.GRIS);
        this.setLocationRelativeTo(null);
         numDisp.setFont(defecto);
        numDisp.setForeground(defectoColor);
         numPc.setFont(defecto);
        numPc.setForeground(defectoColor);
        jLabel1.setFont(defecto);
        jLabel1.setForeground(defectoColor);
        jLabel1.setBackground(SeasunColor.AZUL);
        jLabel2.setFont(defecto);
        jLabel2.setForeground(defectoColor);
        jLabel3.setFont(defecto);
        jLabel3.setForeground(defectoColor);
        jLabel4.setFont(defecto);
        jLabel4.setForeground(defectoColor);
        jLabel5.setFont(defecto);
        jLabel5.setForeground(defectoColor);
        jLabel6.setFont(defecto);
        jLabel6.setForeground(defectoColor);
        jButton1.setBackground(SeasunColor.VERDE);
        jButton1.setForeground(defectoColor);
        jButton1.setFont(defecto);
        csvComputadoras.setBackground(SeasunColor.VERDE);
        csvComputadoras.setForeground(defectoColor);
        csvComputadoras.setFont(defecto);
        csvDisp.setBackground(SeasunColor.VERDE);
        csvDisp.setForeground(defectoColor);
        csvDisp.setFont(defecto);
        searchButton.setBackground(SeasunColor.VERDE);
        searchButton.setForeground(defectoColor);
        searchButton.setFont(defecto);
        edificio.setBackground(SeasunColor.AZUL);
        edificio.setForeground(defectoColor);
        edificio.setFont(defecto);
        areas.setBackground(SeasunColor.AZUL);
        areas.setForeground(defectoColor);
        areas.setFont(defecto);
        responsableButton.setBackground(SeasunColor.VERDE);
        responsableButton.setForeground(defectoColor);
        responsableButton.setFont(defecto);
        tipoButton.setBackground(SeasunColor.VERDE);
        tipoButton.setForeground(defectoColor);
        tipoButton.setFont(defecto);
        sinFiltro.setBackground(SeasunColor.VERDE);
        sinFiltro.setForeground(defectoColor);
        sinFiltro.setFont(defecto);
        areaButton.setBackground(SeasunColor.VERDE);
        areaButton.setForeground(defectoColor);
        areaButton.setFont(defecto);
        tablaComputadoras.setAutoResizeMode(0);
        tablaDispositivos.setAutoResizeMode(0);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botones = new javax.swing.ButtonGroup();
        jMenu1 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaComputadoras = new javax.swing.JTable();
        areaButton = new javax.swing.JRadioButton();
        responsableButton = new javax.swing.JRadioButton();
        tipoButton = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDispositivos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sinFiltro = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        numPc = new javax.swing.JLabel();
        numDisp = new javax.swing.JLabel();
        csvComputadoras = new javax.swing.JButton();
        edificio = new javax.swing.JComboBox<>();
        areas = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        csvDisp = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Inventario FIUAC - V1.2");
        setExtendedState(6);

        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel1.setText("Consola Serv. Inventario");

        tablaComputadoras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaComputadoras.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(tablaComputadoras);

        areaButton.setText("Area");
        areaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaButtonActionPerformed(evt);
            }
        });

        responsableButton.setText("Responsable");
        responsableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                responsableButtonActionPerformed(evt);
            }
        });

        tipoButton.setText("Tipo");
        tipoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar por...");

        searchButton.setText("Buscar");
        searchButton.setEnabled(false);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        tablaDispositivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaDispositivos.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tablaDispositivos);

        jLabel3.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel3.setText("Computadoras");

        jLabel4.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel4.setText("Dispositivos");

        sinFiltro.setText("Sin filtro");
        sinFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinFiltroActionPerformed(evt);
            }
        });

        jButton1.setText("Agregar Dispositivos...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        numPc.setText("  ");

        numDisp.setText("  ");

        csvComputadoras.setText("Generar PDF");
        csvComputadoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csvComputadorasActionPerformed(evt);
            }
        });

        edificio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        edificio.setEnabled(false);
        edificio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                edificioItemStateChanged(evt);
            }
        });

        areas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        areas.setEnabled(false);

        jLabel5.setText("Edificio");

        jLabel6.setText("Area");

        csvDisp.setText("Generar PDF");
        csvDisp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csvDispActionPerformed(evt);
            }
        });

        jMenu2.setText("Menu");

        jMenuItem1.setText("Agregar área.");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 936, Short.MAX_VALUE)
                .addComponent(numPc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(csvComputadoras)))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(479, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(615, 615, 615))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(csvDisp)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(sinFiltro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(responsableButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tipoButton)
                .addGap(18, 18, 18)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(searchButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edificio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(areas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areaButton)
                    .addComponent(responsableButton)
                    .addComponent(tipoButton)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(sinFiltro)
                    .addComponent(edificio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(areas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(numPc)
                    .addComponent(csvComputadoras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(csvDisp)
                    .addComponent(numDisp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void areaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaButtonActionPerformed
        // TODO add your handling code here:
        areas.setEnabled(true);
        edificio.setEnabled(true);
        searchButton.setEnabled(true);
        search.setEnabled(false);
        
        
                Statement st;
                ResultSet rs;
            try {
            edificio.removeAllItems();
            Connection con = getConnection();
            st = con.createStatement();
            String command = "select DISTINCT edificio from edificios";
            rs = st.executeQuery(command);
            
            while(rs.next()){
                edificio.addItem(rs.getString(1));
            }
            
            con.close();
                 }
            catch(NullPointerException ex){            
            
        }       catch (SQLException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
    }//GEN-LAST:event_areaButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        try {
            // TODO add your handling code here:

            if (sinFiltro.isSelected()) {

                tablaComputadora("Select * from computadora");
                tablaDispositivo("Select * from dispositivos");
            }

            if (areaButton.isSelected()) {
                String area = areas.getSelectedItem().toString();
                tablaComputadora("Select * from computadora where area like '%" + area + "%'");
                tablaDispositivo("Select * from dispositivos where area like '%" + area + "%'");
            }

            if (responsableButton.isSelected()) {
                tablaComputadora("Select * from computadora where responsable like '%" + search.getText() + "%'");
                tablaDispositivo("Select * from dispositivos where responsable like '%" + search.getText() + "%'");
            }

            if (tipoButton.isSelected()) {
                tablaComputadora("Select * from computadora where tipoPc='" + search.getText() + "'");
                tablaDispositivo("Select * from dispositivos where producto like '" + search.getText() + "'");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_searchButtonActionPerformed

    private void sinFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinFiltroActionPerformed
        // TODO add your handling code here:
        search.setEnabled(false);
        searchButton.setEnabled(true);
        areas.setEnabled(false);
        edificio.setEnabled(false);
    }//GEN-LAST:event_sinFiltroActionPerformed

    private void responsableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_responsableButtonActionPerformed
        // TODO add your handling code here:
        search.setEnabled(true);
        searchButton.setEnabled(true);
        areas.setEnabled(false);
        edificio.setEnabled(false);
    }//GEN-LAST:event_responsableButtonActionPerformed

    private void tipoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoButtonActionPerformed
        // TODO add your handling code here:
        search.setEnabled(true);
        searchButton.setEnabled(true);
        areas.setEnabled(false);
        edificio.setEnabled(false);
    }//GEN-LAST:event_tipoButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        others otro = new others();
        otro.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void csvComputadorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csvComputadorasActionPerformed
        Document document = new Document(PageSize.LEGAL.rotate());
        try {
            java.util.Date date = new java.util.Date();
            DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String impreso = hourdateFormat.format(date);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Computadoras.pdf"));

            document.open();

            document.add(new Paragraph("Realizado el " + impreso + "\n\nInventario de computadoras. Para informacion adicional ver en el sorftware."));

            PdfContentByte cb = writer.getDirectContent();
            cb.saveState();
            Graphics2D g2 = cb.createGraphicsShapes(950, 500);

            Shape oldClip = g2.getClip();
            g2.clipRect(0, 0, 2000, 700);

            tablaComputadoras.print(g2);

            g2.setClip(oldClip);

            g2.dispose();
            cb.restoreState();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        document.close();
        JOptionPane.showMessageDialog(null, "Reporte de Computadoras Creado");
    }//GEN-LAST:event_csvComputadorasActionPerformed

    private void edificioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_edificioItemStateChanged

                
                Statement st;
                ResultSet rs;
                 try {
            areas.removeAllItems();
            Connection con = getConnection();
            st = con.createStatement();
            String command = "select area from edificios where edificio = '"+ edificio.getSelectedItem().toString()+"'";
            rs = st.executeQuery(command);
            
            while(rs.next()){
                areas.addItem(rs.getString(1));
            }
            
            con.close();
                 }
                 catch(NullPointerException ex){            
            
        }       catch (SQLException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_edificioItemStateChanged

    private void csvDispActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csvDispActionPerformed

        Document document = new Document(PageSize.LEGAL.rotate());
        try {
            java.util.Date date = new java.util.Date();
            DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String impreso = hourdateFormat.format(date);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Dispositivos.pdf"));

            document.open();

            document.add(new Paragraph("Realizado el " + impreso + "\n\nInventario de dispositivos. Para informacion adicional ver en el sorftware."));

            PdfContentByte cb = writer.getDirectContent();
            cb.saveState();
            Graphics2D g2 = cb.createGraphicsShapes(950, 500);

            Shape oldClip = g2.getClip();
            g2.clipRect(0, 0, 2000, 700);

            tablaDispositivos.print(g2);

            g2.setClip(oldClip);

            g2.dispose();
            cb.restoreState();
            //document.add(new Paragraph("Realizado: " +hourdateFormat.format(date)));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        document.close();
        JOptionPane.showMessageDialog(null, "Reporte de Dispositivos Creado");

    }//GEN-LAST:event_csvDispActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        agregarArea addArea = new agregarArea();
        addArea.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new view().setVisible(true);

            }
        });
    }

    public static void lookAndFeel() {
        try {
            JFrame.setDefaultLookAndFeelDecorated(false);
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e.getMessage());
        }
    }

    public void agregarIcono() {
        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("favicon.png")));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton areaButton;
    private javax.swing.JComboBox<String> areas;
    private javax.swing.ButtonGroup botones;
    private javax.swing.JButton csvComputadoras;
    private javax.swing.JButton csvDisp;
    private javax.swing.JComboBox<String> edificio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel numDisp;
    private javax.swing.JLabel numPc;
    private javax.swing.JRadioButton responsableButton;
    private javax.swing.JTextField search;
    private javax.swing.JButton searchButton;
    private javax.swing.JRadioButton sinFiltro;
    private javax.swing.JTable tablaComputadoras;
    private javax.swing.JTable tablaDispositivos;
    private javax.swing.JRadioButton tipoButton;
    // End of variables declaration//GEN-END:variables
}
