package Cliente1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pelon
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.*;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.OperatingSystem;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.hyperic.sigar.NetInfo;
import org.hyperic.sigar.NetInterfaceConfig;

public class View extends javax.swing.JFrame {
    public final Font defecto = new Font("San Francisco Display", Font.BOLD, 13);
    public final Color defectoColor = Color.WHITE;
    public final JPanel colorLabel1= new JPanel();
    Sigar s = new Sigar();
    OperatingSystem os = OperatingSystem.getInstance();
    File file = new File("c:");
    
    private String[] getAreas(String edificio){
        String[] areas= new String[0];
        
        if(edificio.equalsIgnoreCase("Seleccione Edificio...")){
            areas = new String [0];
        }
        
        if(edificio.equalsIgnoreCase("Edificio A")){
            areas = new String[11];
            areas[0] = "Dirección";
            areas[1] = "Posgrado";
            areas[2] = "Coord. Administrativa";
            areas[3] = "Biblioteca";
            areas[4] = "Secretaría academica";
            areas[5] = "Coord. Sistemas";
            areas[6] = "Coord. Mecatrónica";
            areas[7] = "Coord. Energia";
            areas[8] = "Coord. Civil y admon.";
            areas[9] = "Coord. Mecánica";
            areas[10] = "Coord. Electricista";
        }
        
        if(edificio.equalsIgnoreCase("Edificio B")){
            areas = new String[3];
            areas[0] = "Sala de Actos";
            areas[1] = "PAEI";
            areas[2] = "Sala de maestros";
        }
        
        if(edificio.equalsIgnoreCase("Edificio C")){
            areas = new String[1];
            areas[0] = "Cubículo de maestro";
            
        }
        
        if(edificio.equalsIgnoreCase("Edificio D")){
            areas = new String[4];
            areas[0] = "Lab. Física";
            areas[1] = "Lab. Electricidad";
            areas[2] = "Lab. Manufactura";
            areas[3] = "Lab. Neumatica";
        }
        
        if(edificio.equalsIgnoreCase("Edificio E")){
            areas = new String[1];
            areas[0] = "Lab. Energía";
           
        }
        
        if(edificio.equalsIgnoreCase("Edificio F")){
            areas = new String[3];
            areas[0] = "Lab. Redes";
            areas[1] = "Lab. Aplicaciones Moviles";
            areas[2] = "CIC";
        }
        
        if (edificio.equalsIgnoreCase("Edificio H")) {
            areas = new String[2];
            areas[0] = "CADETRA";
            areas[1] = "Lab. Suelos";
            
        }
        
        if(edificio.equalsIgnoreCase("Edificio I")){
            areas = new String[1];
            areas[0] = "Lab. Estructuras";
            
        }
        
        return areas;
    }
    /**
     * Creates new form View
     */
    public View() {
        initComponents();
        agregarIcono();
        this.getContentPane().setBackground(SeasunColor.GRIS);
        this.setLocationRelativeTo(null);
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
        jLabel7.setFont(defecto);
        jLabel7.setForeground(defectoColor);
        jLabel8.setFont(defecto);
        jLabel8.setForeground(defectoColor);
        jLabel9.setFont(defecto);
        jLabel9.setForeground(defectoColor);
        jLabel10.setFont(defecto);
        jLabel10.setForeground(defectoColor);
        jLabel11.setFont(defecto);
        jLabel11.setForeground(defectoColor);
        jLabel12.setFont(defecto);
        jLabel12.setForeground(defectoColor);
        jLabel13.setFont(defecto);
        jLabel13.setForeground(defectoColor);
        jLabel14.setFont(defecto);
        jLabel14.setForeground(defectoColor);
        jLabel15.setFont(defecto);
        jLabel15.setForeground(defectoColor);
        jLabel16.setFont(defecto);
        jLabel16.setForeground(defectoColor);
        jLabel17.setFont(defecto);
        jLabel17.setForeground(defectoColor);
        jLabel18.setFont(defecto);
        jLabel18.setForeground(defectoColor);
        jLabel19.setFont(defecto);
        jLabel19.setForeground(defectoColor);
        jLabel20.setFont(defecto);
        jLabel20.setForeground(defectoColor);
        jLabel21.setFont(defecto);
        jLabel21.setForeground(defectoColor);
        jButton1.setBackground(SeasunColor.VERDE);
        jButton1.setForeground(defectoColor);
        jButton1.setFont(defecto);
        send.setBackground(SeasunColor.VERDE);
        send.setForeground(defectoColor);
        send.setFont(defecto);
        jButton2.setBackground(SeasunColor.VERDE);
        jButton2.setForeground(defectoColor);
        jButton2.setFont(defecto);
        edificio.setBackground(SeasunColor.AZUL);
        edificio.setForeground(defectoColor);
        edificio.setFont(defecto);
        tipoPc.setBackground(SeasunColor.AZUL);
        tipoPc.setForeground(defectoColor);
        tipoPc.setFont(defecto);
        areas.setBackground(SeasunColor.AZUL);
        areas.setForeground(defectoColor);
        areas.setFont(defecto);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        SODistribuidor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SONombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        SOVersion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        SOarq = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        CPUvendor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        CPUmodel = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        CPUram = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        CPUfreeMem = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        CPUusedMem = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        CPUstorage = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        CPUfreeStorage = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        NetMac = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        NetIp = new javax.swing.JTextField();
        NetHardware = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        NetHostname = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        Responsable = new javax.swing.JTextField();
        send = new javax.swing.JButton();
        tipoPc = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        edificio = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        areas = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Herramienta para inventarios - CLIENTE");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("SISTEMA OPERATIVO");

        jLabel2.setText("INFORMACIÓN CPU");

        jLabel3.setText("RED");

        jLabel4.setText("Distribuidor");

        jLabel5.setText("Nombre");

        jLabel6.setText("Versión");

        jLabel7.setText("Arquitectura");

        jLabel9.setText("Fabricante");

        jLabel10.setText("Modelo");

        CPUmodel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPUmodelActionPerformed(evt);
            }
        });

        jLabel11.setText("Memoria RAM");

        jLabel12.setText("Libre");

        CPUfreeMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPUfreeMemActionPerformed(evt);
            }
        });

        jLabel13.setText("Usada");

        jLabel14.setText("Almacenamiento Total");

        jLabel15.setText("Almacenamiento Libre");

        CPUfreeStorage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPUfreeStorageActionPerformed(evt);
            }
        });

        jLabel16.setText("MAC address");

        jLabel17.setText("IP Address");

        NetIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NetIpActionPerformed(evt);
            }
        });

        jLabel18.setText("Tarjeta de red");

        jLabel19.setText("Hostname");

        jLabel20.setText("Responsable");

        send.setText("Enviar");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        tipoPc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escritorio", "Laptop" }));

        jLabel21.setText("Área");

        edificio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Edificio...","Edificio A", "Edificio B", "Edificio C", "Edificio D", "Edificio E", "Edificio F","Edificio G", "Edificio H", "Edificio I" }));
        edificio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                edificioItemStateChanged(evt);
            }
        });

        jButton2.setText("Otro dispositivo...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        areas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        areas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                areasItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jButton1)
                        .addGap(44, 44, 44)
                        .addComponent(send)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7)
                                .addComponent(SOVersion)
                                .addComponent(jLabel6)
                                .addComponent(SONombre)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(SODistribuidor)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tipoPc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(SOarq, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(CPUfreeStorage, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(CPUfreeMem, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(CPUusedMem, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CPUvendor, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CPUmodel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CPUram, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(31, 31, 31))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel14)
                            .addComponent(CPUstorage, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(146, 146, 146)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(areas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(NetMac)
                                .addComponent(jLabel17)
                                .addComponent(NetIp)
                                .addComponent(NetHardware)
                                .addComponent(jLabel18)
                                .addComponent(jLabel19)
                                .addComponent(NetHostname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16)
                                .addComponent(jLabel21)
                                .addComponent(jLabel20)
                                .addComponent(Responsable)
                                .addComponent(edificio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel3)
                                .addGap(70, 70, 70)))
                        .addGap(82, 82, 82))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SODistribuidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SONombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SOVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SOarq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(tipoPc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NetMac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NetIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NetHardware, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel19))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CPUvendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CPUmodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CPUram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CPUusedMem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CPUfreeMem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CPUstorage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CPUfreeStorage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NetHostname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Responsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edificio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(areas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(send))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            CpuInfo cpu[]=s.getCpuInfoList();
            CpuInfo info=cpu[0]; 
            Mem mem = s.getMem();
            DecimalFormat twoDForm = new DecimalFormat("#.##");
            
            long totalSpace = file.getTotalSpace(); //total disk space in bytes.
            long usableSpace = file.getUsableSpace(); ///unallocated / free disk space in bytes.
           
            
            //SISTEMA OPERATIVO
            SODistribuidor.setText(os.getDescription());
            SONombre.setText(os.getVendorName());
            SOVersion.setText(os.getVersion());
            SOarq.setText(os.getArch());
            
            //CPU
            CPUvendor.setText(info.getVendor());
            CPUmodel.setText(info.getModel());
            CPUram.setText(Long.toString(mem.getRam())+" MBs");
            
            CPUfreeMem.setText(twoDForm.format(mem.getFreePercent())+ "%");
            CPUusedMem.setText(twoDForm.format(mem.getUsedPercent())+ "%");
            CPUstorage.setText(Long.toString(totalSpace /1024 /1024 /1024)+" GBs");
            CPUfreeStorage.setText(Long.toString(usableSpace/1024 /1024 /1024)+" GBs");
            
            
            //RED
            NetInterfaceConfig net = s.getNetInterfaceConfig(null);
            NetInfo netInfo = s.getNetInfo();
            NetMac.setText(net.getHwaddr());
            NetIp.setText(net.getAddress());
            NetHardware.setText(net.getDescription());
            NetHostname.setText(netInfo.getHostName());
            
            //Responsable
            SODistribuidor.setEditable(false);
            SONombre.setEditable(false);
            SOVersion.setEditable(false);
            SOarq.setEditable(false);
            CPUvendor.setEditable(false);
            CPUmodel.setEditable(false);
            CPUram.setEditable(false);
            CPUfreeMem.setEditable(false);
            CPUusedMem.setEditable(false);
            CPUstorage.setEditable(false);
            CPUfreeStorage.setEditable(false);
            NetMac.setEditable(false);
            NetIp.setEditable(false);
            NetHardware.setEditable(false);
            NetHostname.setEditable(false);
            
        } catch (SigarException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CPUmodelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPUmodelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPUmodelActionPerformed

    private void CPUfreeMemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPUfreeMemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPUfreeMemActionPerformed

    private void CPUfreeStorageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPUfreeStorageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPUfreeStorageActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        // TODO add your handling code here:
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Inventario;integratedSecurity=true";
            Connection con = DriverManager.getConnection(url);
            
              PreparedStatement pst1 = con.prepareStatement("SELECT * FROM computadora where macAddress=?");
            pst1.setString(1, NetMac.getText());
            ResultSet rs = pst1.executeQuery();

            if(rs.next()){
                PreparedStatement psDel = con.prepareStatement("DELETE FROM computadora where macAddress=?");
                psDel.setString(1, NetMac.getText());
                psDel.executeUpdate();
                psDel.close();
            }
            pst1.close();
            
            String area = edificio.getSelectedItem().toString() + ", " + areas.getSelectedItem().toString();
            
            String command = "Insert into computadora (macAddress, hostname, distribuidor, nombre, version, arquitectura, fabricante, modelo, ram, almacenamiento, almacenamientoFree, tipoPc, area, responsable) Values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(command);
            pst.setString(1, NetMac.getText());
            pst.setString(2, NetHostname.getText());
            pst.setString(3, SODistribuidor.getText());
            pst.setString(4, SONombre.getText());
            pst.setString(5, SOVersion.getText());
            pst.setString(6, SOarq.getText());
            pst.setString(7, CPUvendor.getText());
            pst.setString(8, CPUmodel.getText());
            pst.setString(9, CPUram.getText());
            pst.setString(10, CPUstorage.getText());
            pst.setString(11, CPUfreeStorage.getText());
            pst.setString(12, tipoPc.getSelectedItem().toString());
            pst.setString(13, area);
            pst.setString(14, Responsable.getText());
            pst.executeUpdate();
            pst.close();
            
            PreparedStatement pst2 = con.prepareStatement("SELECT * FROM computadora where macAddress=?");
            pst2.setString(1, NetMac.getText());
            ResultSet rs1 = pst2.executeQuery();
            
            if(rs1.next()){
                JOptionPane.showMessageDialog(null,"Registro Agregado");
            }else{
                JOptionPane.showMessageDialog(null, "Ocurrio un error");
            }
            pst2.close();
            con.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
    }//GEN-LAST:event_sendActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        others Otro = new others();
        Otro.show();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void areasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_areasItemStateChanged
       
    }//GEN-LAST:event_areasItemStateChanged

    private void edificioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_edificioItemStateChanged
       if(evt.getStateChange() == ItemEvent.SELECTED){
           
          
           if(edificio.getSelectedIndex() > 0){
               areas.setModel(new DefaultComboBoxModel(getAreas(edificio.getSelectedItem().toString())));
           }
       }
    }//GEN-LAST:event_edificioItemStateChanged

    private void NetIpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NetIpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NetIpActionPerformed

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
            lookAndFeel();
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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
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
      public void agregarIcono(){
        try{ 
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("favicon.png")));
        } catch (Exception e){
            e.getMessage();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CPUfreeMem;
    private javax.swing.JTextField CPUfreeStorage;
    private javax.swing.JTextField CPUmodel;
    private javax.swing.JTextField CPUram;
    private javax.swing.JTextField CPUstorage;
    private javax.swing.JTextField CPUusedMem;
    private javax.swing.JTextField CPUvendor;
    private javax.swing.JTextField NetHardware;
    private javax.swing.JTextField NetHostname;
    private javax.swing.JTextField NetIp;
    private javax.swing.JTextField NetMac;
    private javax.swing.JTextField Responsable;
    private javax.swing.JTextField SODistribuidor;
    private javax.swing.JTextField SONombre;
    private javax.swing.JTextField SOVersion;
    private javax.swing.JTextField SOarq;
    private javax.swing.JComboBox<String> areas;
    private javax.swing.JComboBox<String> edificio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton send;
    private javax.swing.JComboBox<String> tipoPc;
    // End of variables declaration//GEN-END:variables
}
