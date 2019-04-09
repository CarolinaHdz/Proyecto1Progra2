/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domain.Administrative;
import domain.CarDriver;
import domain.HeavyMachinery;
import domain.HeavyMachineryDriver;
import domain.Janitor;
import file.AdministrativeFile;
import file.CarDriveFile;
import file.HeavyMechineryDriverFile;
import file.JanitorFile;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import utility.Path;

public class SeeEmployeeInformation extends javax.swing.JFrame {
    private Vector janitorV;
    private Vector carDriverV;
    private Vector hmDriverV;
    private Vector administrativeV;
    private int choice;
    TableRowSorter trs;
    DefaultTableModel dtmAdm;
    DefaultTableModel dtmJanitor;
    DefaultTableModel dtmCarDriver;
    DefaultTableModel dtmHmDriver;
    Color c= new Color(150,150,255);
    
    public SeeEmployeeInformation() throws IOException, ClassNotFoundException {
        this.carDriverV=(Vector)InsertCarDriver.carDriverVector;
        this.administrativeV=(Vector)InsertAdministrative.administrativeVector;
        this.hmDriverV=(Vector)InsertHeavyMachineryDriver.heavyMachineryDriverVector;
        this.janitorV=(Vector)InsertJanitor.janitorVector;
        
        this.choice=1;
        initComponents();
        this.jtfName.setEditable(false);
        this.jbtShow.setEnabled(false);
        this.setTitle("Information Window");
        setLocationRelativeTo(null);
        setResizable(false);
        
      
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Assets/image4.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());

        this.getContentPane().setBackground(c);
        this.setBackground(Color.BLACK);
    }
    
        public void regTableAdm() throws IOException, ClassNotFoundException {
//llena la tabla con los datos tomados del objeto Aministrative
            this.dtmAdm = new DefaultTableModel();
            this.dtmAdm.addColumn("Name");
            this.dtmAdm.addColumn("Surname");
            this.dtmAdm.addColumn("ID");
            this.dtmAdm.addColumn("Employee Number");
            this.dtmAdm.addColumn("Qualify");
            this.dtmAdm.addColumn("academy Grade");
            this.dtmAdm.addColumn("Category");
            //le da el nombre a las columnas
            
            AdministrativeFile admFile = new AdministrativeFile(Path.my_adm_list_path);
            List<Administrative> admList = admFile.arrays();
            for (int i = 0; i < admList.size(); i++) {
                this.dtmAdm.addRow(new Object[]{admList.get(i).getName(), admList.get(i).getSurnames(),
                    admList.get(i).getId(), admList.get(i).getEmployeeNumber(), admList.get(i).isQualify(),
                    admList.get(i).getAcademyGrade(),admList.get(i).getCategory()});// le da el valor de los archivo a la tabla
            }
            table.setModel(dtmAdm);
    }
    
    public void regTableCarDriver() throws IOException, ClassNotFoundException {
//llena la tabla con los datos tomados del objeto CraDriver
            this.dtmCarDriver = new DefaultTableModel();
            this.dtmCarDriver.addColumn("Name");
            this.dtmCarDriver.addColumn("Surname");
            this.dtmCarDriver.addColumn("ID");
            this.dtmCarDriver.addColumn("Employee Number");
            this.dtmCarDriver.addColumn("Qualify");
            this.dtmCarDriver.addColumn("Type Of License");
            this.dtmCarDriver.addColumn("Hours Worked");
            this.dtmCarDriver.addColumn("Turn");
            this.dtmCarDriver.addColumn("Type Driver");
            //le da el nombre a las columnas
            
            CarDriveFile carFile = new CarDriveFile(Path.my_carDriver_list_path);
            List<CarDriver> carList = carFile.arrays();
            for (int i = 0; i < carList.size(); i++) {
                this.dtmCarDriver.addRow(new Object[]{carList.get(i).getName(), carList.get(i).getSurnames(),
                    carList.get(i).getId(), carList.get(i).getEmployeeNumber(), carList.get(i).isQualify(),
                    carList.get(i).getTypeOfLicense(),carList.get(i).getHoursWorked(),
                    carList.get(i).getTurn(),carList.get(i).getTypeDriver()});// le da el valor de los archivo a la tabla
            }
            table.setModel(dtmCarDriver);
    }//regCarDriver
    
    public void regTableHMDriver() throws ClassNotFoundException, IOException{
            this.dtmHmDriver = new DefaultTableModel();
            this.dtmHmDriver.addColumn("Name");
            this.dtmHmDriver.addColumn("Surname");
            this.dtmHmDriver.addColumn("ID");
            this.dtmHmDriver.addColumn("Employee Number");
            this.dtmHmDriver.addColumn("Qualify");
            this.dtmHmDriver.addColumn("Hours Worked");
            this.dtmHmDriver.addColumn("Turn");
            this.dtmHmDriver.addColumn("Weigth");
            this.dtmHmDriver.addColumn("Age");
            //le da el nombre a las columnas
            
            HeavyMechineryDriverFile hmFile = new HeavyMechineryDriverFile(Path.my_hMDriver_list_path);
            List<HeavyMachineryDriver> hmList = hmFile.arrays();
            for (int i = 0; i < hmList.size(); i++) {
                this.dtmHmDriver.addRow(new Object[]{hmList.get(i).getName(), hmList.get(i).getSurnames(),
                    hmList.get(i).getId(), hmList.get(i).getEmployeeNumber(), hmList.get(i).isQualify(),
                    hmList.get(i).getHoursWorked(),hmList.get(i).getTurn(),hmList.get(i).getHeigth(),hmList.get(i).getAge()});// le da el valor de los archivo a la tabla
            }
            table.setModel(dtmHmDriver);
    }//regTableHMDriver
    
    public void regTableJanitor() throws ClassNotFoundException, IOException{
            this.dtmJanitor = new DefaultTableModel();
            this.dtmJanitor.addColumn("Name");
            this.dtmJanitor.addColumn("Surname");
            this.dtmJanitor.addColumn("ID");
            this.dtmJanitor.addColumn("Employee Number");
            this.dtmJanitor.addColumn("Qualify");
            this.dtmJanitor.addColumn("Extra Hours");
            
            //le da el nombre a las columnas
            
            JanitorFile janitorFile = new JanitorFile(Path.my_janitor_list_path);
            List<Janitor> janitorList = janitorFile.arrays();
            for (int i = 0; i < janitorList.size(); i++) {
                this.dtmJanitor.addRow(new Object[]{janitorList.get(i).getName(), janitorList.get(i).getSurnames(),
                    janitorList.get(i).getId(), janitorList.get(i).getEmployeeNumber(), janitorList.get(i).isQualify(),
                    janitorList.get(i).getExtraHours()});// le da el valor de los archivo a la tabla
            }
            table.setModel(dtmJanitor);
    }//regTableJanitor
    
    
   
    public void janitorInfo(String janitorSearch){
        //esta variable se crea para saber si el elemento que queremos borrar existe
        boolean exist=false;
        Janitor jan=(Janitor)janitorV.elementAt(0);
        String janitorName=jan.getName();
        //se recorre el vector
        for (int i = 0; i <= janitorV.size(); i++) {
            //se pregunta si el elemento por borrar es igual al que esta en esa posicion del vector
            if (janitorName.equalsIgnoreCase(janitorSearch)) {
                exist=true;
                i=janitorV.size();
            } else {
                jan=(Janitor)janitorV.elementAt(i);
                janitorName=(String)jan.getName();
            }
        }
        //se controla el mensaje de salida, si existe el elmento por borrar, lo borra
        if (exist==true) {
            JOptionPane.showMessageDialog(null, "The element was found "+janitorSearch);
            JOptionPane.showMessageDialog(null, jan.toString());
            //si no muestra un mensaje que el elemento que queremos borrar no existe en el vector
        } else {
            JOptionPane.showMessageDialog(null, "The element was not found "+janitorSearch);
        }
    }//metodo que se usa en la parte A del proyecto 
    public void carDriverInfo(String carDriverSearch){
        //esta variable se crea para saber si el elemento que queremos borrar existe
        boolean exist=false;
        CarDriver carD=(CarDriver)carDriverV.elementAt(0);
        String carDName=carD.getName();
        //se recorre el vector
        for (int i = 0; i <= carDriverV.size(); i++) {
            //se pregunta si el elemento por borrar es igual al que esta en esa posicion del vector
            if (carDName.equalsIgnoreCase(carDriverSearch)) {
                exist=true;
                i=carDriverV.size();
            } else {
                carD=(CarDriver)carDriverV.elementAt(i);
                carDName=(String)carD.getName();
            }
        }
        //se controla el mensaje de salida, si existe el elmento por borrar, lo borra
        if (exist==true) {
            JOptionPane.showMessageDialog(null, "The name: "+carDriverSearch+" was found");
            //jTextAreaInfo.setText(carD.toString());
            //si no muestra un mensaje que el elemento que queremos borrar no existe en el vector
        } else {
            JOptionPane.showMessageDialog(null, "There is no name: "+carDriverSearch);
        }
    }//metodo que se usa en la parte A del proyecto
    public void hmDriverInfo(String hmDriverSearch){
        //esta variable se crea para saber si el elemento que queremos borrar existe
        boolean exist=false;
        HeavyMachineryDriver hmDriver=(HeavyMachineryDriver)hmDriverV.elementAt(0);
        String hmName=hmDriver.getName();
        //se recorre el vector
        for (int i = 0; i <= hmDriverV.size(); i++) {
            //se pregunta si el elemento por borrar es igual al que esta en esa posicion del vector
            if (hmName.equalsIgnoreCase(hmDriverSearch)) {
                exist=true;
                i=hmDriverV.size();
            } else {
                hmDriver=(HeavyMachineryDriver)hmDriverV.elementAt(0);
                hmName=(String)hmDriver.getName();
            }
        }
        //se controla el mensaje de salida, si existe el elmento por borrar, lo borra
        if (exist==true) {
            JOptionPane.showMessageDialog(null, "The name: "+hmDriverSearch+" was found");
            //jTextAreaInfo.setText(hmDriver.toString());
            //si no muestra un mensaje que el elemento que queremos borrar no existe en el vector
        } else {
            JOptionPane.showMessageDialog(null, "There is no name: "+hmDriverSearch);
        }
    }//metodo que se usa en la parte A del proyecto
    public void adminInfo(String adminSearch) throws IOException, ClassNotFoundException{
        //esta variable se crea para saber si el elemento que queremos borrar existe
        boolean exist=false;
        Administrative admin=(Administrative)administrativeV.elementAt(0);
        String adminName=admin.getName();
        //se recorre el vector
        for (int i = 0; i <= administrativeV.size(); i++) {
            //se pregunta si el elemento por borrar es igual al que esta en esa posicion del vector
            if (adminName.equalsIgnoreCase(adminSearch)) {
                exist=true;
                i=administrativeV.size();
            } else {
                admin=(Administrative)administrativeV.elementAt(i);
                adminName=(String)admin.getName();
            }
        }
        //se controla el mensaje de salida, si existe el elmento por borrar, lo borra
        if (exist==true) {
            JOptionPane.showMessageDialog(null,"The name: "+adminSearch+" was found");
            regTableAdm();
            //si no muestra un mensaje que el elemento que queremos borrar no existe en el vector
        } else {
            JOptionPane.showMessageDialog(null, "There is no name: : "+adminSearch);
        }
    }//metodo que se usa en la parte A del proyecto
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlName = new javax.swing.JLabel();
        jbtShow = new javax.swing.JButton();
        jbtCancel = new javax.swing.JButton();
        jtfName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jbDelete = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAdmin = new javax.swing.JMenu();
        jMenuItemJanitor = new javax.swing.JMenuItem();
        jMenuItemCarDriver = new javax.swing.JMenuItem();
        jMenuItemHMDriver = new javax.swing.JMenuItem();
        jMenuItemAdminiistrative = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlName.setBackground(new java.awt.Color(0, 0, 0));
        jlName.setForeground(new java.awt.Color(255, 255, 255));
        jlName.setText("Name: ");

        jbtShow.setBackground(new java.awt.Color(0, 0, 0));
        jbtShow.setForeground(new java.awt.Color(255, 255, 255));
        jbtShow.setText("Show Info");
        jbtShow.setBorder(null);
        jbtShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtShowActionPerformed(evt);
            }
        });

        jbtCancel.setBackground(new java.awt.Color(0, 0, 0));
        jbtCancel.setForeground(new java.awt.Color(255, 255, 255));
        jbtCancel.setText("Cancel");
        jbtCancel.setBorder(null);
        jbtCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelActionPerformed(evt);
            }
        });

        jtfName.setBackground(new java.awt.Color(51, 51, 51));
        jtfName.setForeground(new java.awt.Color(255, 255, 255));
        jtfName.setBorder(null);
        jtfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNameActionPerformed(evt);
            }
        });
        jtfName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNameKeyTyped(evt);
            }
        });

        table.setBackground(new java.awt.Color(0, 0, 0));
        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        table.setGridColor(new java.awt.Color(0, 0, 0));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        jbDelete.setBackground(new java.awt.Color(0, 0, 0));
        jbDelete.setForeground(new java.awt.Color(255, 255, 255));
        jbDelete.setText("Delete");
        jbDelete.setBorder(null);
        jbDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        menuAdmin.setBackground(new java.awt.Color(0, 0, 0));
        menuAdmin.setForeground(new java.awt.Color(255, 255, 255));
        menuAdmin.setText("File");

        jMenuItemJanitor.setBackground(new java.awt.Color(0, 0, 0));
        jMenuItemJanitor.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItemJanitor.setText("Janitor");
        jMenuItemJanitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemJanitorActionPerformed(evt);
            }
        });
        menuAdmin.add(jMenuItemJanitor);

        jMenuItemCarDriver.setBackground(new java.awt.Color(0, 0, 0));
        jMenuItemCarDriver.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItemCarDriver.setText("Car Driver");
        jMenuItemCarDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCarDriverActionPerformed(evt);
            }
        });
        menuAdmin.add(jMenuItemCarDriver);

        jMenuItemHMDriver.setBackground(new java.awt.Color(0, 0, 0));
        jMenuItemHMDriver.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItemHMDriver.setText("HM Driver");
        jMenuItemHMDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHMDriverActionPerformed(evt);
            }
        });
        menuAdmin.add(jMenuItemHMDriver);

        jMenuItemAdminiistrative.setBackground(new java.awt.Color(0, 0, 0));
        jMenuItemAdminiistrative.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItemAdminiistrative.setText("Aministrative");
        jMenuItemAdminiistrative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAdminiistrativeActionPerformed(evt);
            }
        });
        menuAdmin.add(jMenuItemAdminiistrative);

        jMenuBar1.add(menuAdmin);

        jMenu2.setBackground(new java.awt.Color(0, 0, 0));
        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlName, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtShow)
                        .addContainerGap(453, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtShow))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jbtCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemJanitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemJanitorActionPerformed
        this.choice=1;
        this.jbtShow.setEnabled(true);
        this.jtfName.setEditable(true);
        
    }//GEN-LAST:event_jMenuItemJanitorActionPerformed

    private void jMenuItemCarDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCarDriverActionPerformed
        this.choice=2;
        this.jbtShow.setEnabled(true);
        this.jtfName.setEditable(true);
        
    }//GEN-LAST:event_jMenuItemCarDriverActionPerformed

    private void jMenuItemHMDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHMDriverActionPerformed
        this.choice=3;
        this.jbtShow.setEnabled(true);
        this.jtfName.setEditable(true);
        
    }//GEN-LAST:event_jMenuItemHMDriverActionPerformed

    private void jMenuItemAdminiistrativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAdminiistrativeActionPerformed
        this.choice=4;
        this.jbtShow.setEnabled(true);
        this.jtfName.setEditable(true);
        
    }//GEN-LAST:event_jMenuItemAdminiistrativeActionPerformed

    private void jbtShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtShowActionPerformed
        switch(this.choice){
            case 1:
        {
            try {
                regTableJanitor();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case 2:
        {
            try {
                regTableCarDriver();
            } catch (IOException ex) {
                Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case 3:
        {
            try {
                regTableHMDriver();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case 4:
        {
            try {
                regTableAdm();
            } catch (IOException ex) {
                Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
                break;
        }
    }//GEN-LAST:event_jbtShowActionPerformed

    private void jbtCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelActionPerformed
         this.dispose();
        EmployeeWindow employee= new EmployeeWindow();
        employee.setVisible(true);
    }//GEN-LAST:event_jbtCancelActionPerformed

    private void jtfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNameActionPerformed

    private void jtfNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNameKeyTyped
        //filtro de Name
        jtfName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + jtfName.getText(),0));

            }

        });
        switch(this.choice){
            case 1:
                trs = new TableRowSorter(dtmJanitor);
                table.setRowSorter(trs);
                break;
            case 2:
                trs = new TableRowSorter(dtmCarDriver);
                table.setRowSorter(trs);
                
                break;
            case 3:
                trs = new TableRowSorter(dtmHmDriver);
                table.setRowSorter(trs);
                break;
            case 4:
                trs = new TableRowSorter(dtmAdm);
                table.setRowSorter(trs);
        
            
        
        
                break;
        }
        
        
    }//GEN-LAST:event_jtfNameKeyTyped

    private void jbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteActionPerformed
        switch(this.choice){
            case 1:
                    JanitorFile janitorFile = new JanitorFile(Path.my_janitor_list_path);
            {
                try {
                    janitorFile.deletedJanitor(jtfName.getText());
                } catch (IOException ex) {
                    Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                        JOptionPane.showMessageDialog(null,"The employee has been removed");
            {
                try {
                    regTableJanitor();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
                
            case 2:
                    CarDriveFile carDFile = new CarDriveFile(Path.my_carDriver_list_path);
            {
                try {
                    carDFile.deletedCarDriver(jtfName.getText());
                } catch (IOException ex) {
                    Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                        JOptionPane.showMessageDialog(null,"The employee has been removed");
            {
                try {
                    regTableCarDriver();
                } catch (IOException ex) {
                    Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
                
            case 3:
                    HeavyMechineryDriverFile hmFile = new HeavyMechineryDriverFile(Path.my_hMDriver_list_path);
            {
                try {
                    hmFile.deleteHMDriver(jtfName.getText());
                } catch (IOException ex) {
                    Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                        JOptionPane.showMessageDialog(null,"The employee has been removed");
            {
                try {
                    regTableHMDriver();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
                
            case 4:
                try {
                    AdministrativeFile admFile = new AdministrativeFile(Path.my_adm_list_path);
                    admFile.deletedAdministrative(jtfName.getText());
                    JOptionPane.showMessageDialog(null,"The employee has been removed");
                    regTableAdm();
                } catch (IOException ex) {
                    Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SeeEmployeeInformation.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
        }//swicth
        
    }//GEN-LAST:event_jbDeleteActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
       int selection = table.rowAtPoint(evt.getPoint());
        jtfName.setText((String) table.getValueAt(selection,0));
    }//GEN-LAST:event_tableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAdminiistrative;
    private javax.swing.JMenuItem jMenuItemCarDriver;
    private javax.swing.JMenuItem jMenuItemHMDriver;
    private javax.swing.JMenuItem jMenuItemJanitor;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbDelete;
    private javax.swing.JButton jbtCancel;
    private javax.swing.JButton jbtShow;
    private javax.swing.JLabel jlName;
    private javax.swing.JTextField jtfName;
    private javax.swing.JMenu menuAdmin;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
