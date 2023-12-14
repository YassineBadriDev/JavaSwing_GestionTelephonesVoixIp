
import BDD.BDD;
import BDD.Parameter;
import BDD.ResultSetTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;
import net.proteanit.sql.DbUtils;
import sun.util.calendar.LocalGregorianCalendar.Date;


/**
 *
 * @author yassine
 */
public class Affectation extends javax.swing.JFrame {

    Statement stat=null;
    MysqlConnect  maConnexion=new MysqlConnect();
    Connection conn;
    PreparedStatement pst=null;
    //ResultSet rs=null;
    ResultSet rs;
    BDD db;
  

    
     public Affectation() {
        setTitle("Affectation");
        initComponents();
        db = new BDD(new Parameter().HOST_DB, new Parameter().USERNAME_DB, new Parameter().PASSWORD_DB, new Parameter().IPHOST, new Parameter().PORT);
        getContentPane().setBackground(Color.white);
       
        
        
   DefaultTableModel model= new DefaultTableModel();
   model.addColumn("idS2");
   model.addColumn("type");
   model.addColumn("Ns");
   model.addColumn("addMac");
   model.addColumn("titulaire");
   model.addColumn("zone");
   model.addColumn("DateAffectation");
   model.addColumn("NumTel");
   
   TableAffectation.setModel(model);
   
   String requette="select * from affectation";
   try{
       
        stat=MysqlConnect.ConnectDB().createStatement();
        ResultSet rs=stat.executeQuery(requette);
        while(rs.next()){
        model.addRow(new Object[]{rs.getInt("idS2"),rs.getString("type"),rs.getString("Ns"),rs.getString("addMac"),rs.getString("titulaire"),rs.getString("zone"),rs.getDate("DateAffectation"),rs.getInt("NumTel")} );
        }
         
   }catch(SQLException ex){
       JOptionPane.showMessageDialog(null, ex);
    };

    
    }
    
    
 public void table() {
        String t[] = {"idS2","type","Ns","addMac","titulaire","zone","DateAffectation","NumTel"};
        rs = db.querySelect(t, "affectation");
        TableAffectation.setModel(new ResultSetTableModel(rs));
    }
     void actualiser() {
        txt_idtel.setText("");
        txt_type.setText("");
        txt_ns.setText("");
        txt_am.setText("");  
        txt_titulaire.setText("");
        txt_zone.setText("");
       // txt_DA1.setText("");
        txt_numTel.setText("");
   
     
     
     
    
             }
             
        
    
    public void toExcel(JTable table, File file){
		try{
			TableModel model = table.getModel();
			FileWriter excel = new FileWriter(file);

			for(int i = 0; i < model.getColumnCount(); i++){
				excel.write(model.getColumnName(i) + "\t");
			}

			excel.write("\n");

			for(int i=0; i< model.getRowCount(); i++) {
				for(int j=0; j < model.getColumnCount(); j++) {
					excel.write(model.getValueAt(i,j).toString()+"\t");
				}
				excel.write("\n");
			}

			excel.close();
		}catch(IOException e){ System.out.println(e); }
	}

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableAffectation = new javax.swing.JTable();
        btn_exporter = new javax.swing.JButton();
        btn_modifier = new javax.swing.JButton();
        btn_Ajouterr1 = new javax.swing.JButton();
        btn_report = new javax.swing.JButton();
        btn_ToAffecte = new javax.swing.JButton();
        btn_serveur = new javax.swing.JButton();
        btn_Taffe = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        typeT1 = new javax.swing.JLabel();
        txt_type = new javax.swing.JTextField();
        txt_numTel = new javax.swing.JTextField();
        titulaire = new javax.swing.JLabel();
        laNumTel = new javax.swing.JLabel();
        DateAff = new javax.swing.JLabel();
        txt_idtel = new javax.swing.JTextField();
        laZone = new javax.swing.JLabel();
        txt_zone = new javax.swing.JTextField();
        txt_DA1 = new com.toedter.calendar.JDateChooser();
        txt_am = new javax.swing.JTextField();
        ns = new javax.swing.JLabel();
        txt_ns = new javax.swing.JTextField();
        addM = new javax.swing.JLabel();
        txt_titulaire = new javax.swing.JTextField();
        laIds = new javax.swing.JLabel();
        btn_modifier1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(67, 174, 76));
        jLabel1.setText("Affectation");

        TableAffectation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "candigo", "description", "precio", "Title 4"
            }
        ));
        TableAffectation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableAffectationMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableAffectation);

        btn_exporter.setBackground(new java.awt.Color(67, 174, 76));
        btn_exporter.setIcon(new javax.swing.ImageIcon("C:\\Program Files\\NetBeans 8.0.2\\icons\\Excel2.png")); // NOI18N
        btn_exporter.setText("Exporter Excel");
        btn_exporter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exporterActionPerformed(evt);
            }
        });

        btn_modifier.setBackground(new java.awt.Color(67, 174, 76));
        btn_modifier.setIcon(new javax.swing.ImageIcon("C:\\Program Files\\NetBeans 8.0.2\\icons\\editer.png")); // NOI18N
        btn_modifier.setText("Modifier");
        btn_modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifierActionPerformed(evt);
            }
        });

        btn_Ajouterr1.setBackground(new java.awt.Color(67, 174, 76));
        btn_Ajouterr1.setIcon(new javax.swing.ImageIcon("C:\\Program Files\\NetBeans 8.0.2\\icons\\Ajouter.png")); // NOI18N
        btn_Ajouterr1.setText("Ajouter");
        btn_Ajouterr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Ajouterr1ActionPerformed(evt);
            }
        });

        btn_report.setBackground(new java.awt.Color(67, 174, 76));
        btn_report.setIcon(new javax.swing.ImageIcon("C:\\Program Files\\NetBeans 8.0.2\\icons\\PDF.png")); // NOI18N
        btn_report.setText("Imprimer Etat");
        btn_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportActionPerformed(evt);
            }
        });

        btn_ToAffecte.setBackground(new java.awt.Color(67, 174, 76));
        btn_ToAffecte.setIcon(new javax.swing.ImageIcon("C:\\Program Files\\NetBeans 8.0.2\\icons\\transfrer.png")); // NOI18N
        btn_ToAffecte.setText("Affecter  Tél");
        btn_ToAffecte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ToAffecteActionPerformed(evt);
            }
        });

        btn_serveur.setBackground(new java.awt.Color(67, 174, 76));
        btn_serveur.setIcon(new javax.swing.ImageIcon("C:\\Program Files\\NetBeans 8.0.2\\icons\\Masse.png")); // NOI18N
        btn_serveur.setText("ToServeur");
        btn_serveur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_serveurActionPerformed(evt);
            }
        });

        btn_Taffe.setBackground(new java.awt.Color(67, 174, 76));
        btn_Taffe.setIcon(new javax.swing.ImageIcon("C:\\Program Files\\NetBeans 8.0.2\\icons\\Home-.png")); // NOI18N
        btn_Taffe.setText("Accueil");
        btn_Taffe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TaffeActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(67, 174, 76), 2));

        typeT1.setText("Type");

        titulaire.setText("Titulaire");

        laNumTel.setText("Num Tel");

        DateAff.setText("Date D'affectation");

        txt_idtel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));

        laZone.setText("Zone");

        txt_DA1.setDateFormatString("yyyy-MM-dd");

        txt_am.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amActionPerformed(evt);
            }
        });

        ns.setText("NumSerie");

        addM.setText("Addresse Mac");

        laIds.setText("idTel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ns)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(typeT1)
                                .addComponent(laIds)))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_idtel)
                            .addComponent(txt_type)
                            .addComponent(txt_ns, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addM)
                        .addGap(18, 18, 18)
                        .addComponent(txt_am, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulaire)
                            .addComponent(laZone)))
                    .addComponent(DateAff)
                    .addComponent(laNumTel))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_zone)
                    .addComponent(txt_titulaire)
                    .addComponent(txt_numTel)
                    .addComponent(txt_DA1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_idtel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(laIds))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(typeT1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_type, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ns, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ns))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_am, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addM)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(titulaire)
                            .addComponent(txt_titulaire, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_zone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(laZone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DateAff)
                            .addComponent(txt_DA1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(laNumTel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_numTel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        btn_modifier1.setBackground(new java.awt.Color(67, 174, 76));
        btn_modifier1.setIcon(new javax.swing.ImageIcon("C:\\Program Files\\NetBeans 8.0.2\\icons\\editer.png")); // NOI18N
        btn_modifier1.setText("Modifier");
        btn_modifier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifier1ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(337, 337, 337)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btn_Ajouterr1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_modifier1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_report)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ToAffecte)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_exporter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_serveur)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Taffe, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_report, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exporter, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ToAffecte, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_serveur, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Taffe, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Ajouterr1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modifier1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1025, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exporterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exporterActionPerformed
        
     JFileChooser fc = new JFileChooser();
                int option = fc.showSaveDialog(Affectation.this);
                if(option == JFileChooser.APPROVE_OPTION){
                    String filename = fc.getSelectedFile().getName(); 
                    String path = fc.getSelectedFile().getParentFile().getPath();

					int len = filename.length();
					String ext = "";
					String file = "";

					if(len > 4){
						ext = filename.substring(len-4, len);
					}

					if(ext.equals(".xls")){
						file = path + "\\" + filename; 
					}else{
						file = path + "\\" + filename + ".xls"; 
					}
					toExcel(TableAffectation, new File(file));
                                        JOptionPane.showMessageDialog(null, "Enregistré avec succés à"+path+" ");
				}
                
    }//GEN-LAST:event_btn_exporterActionPerformed

    private void txt_amActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_amActionPerformed

    private void btn_Ajouterr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Ajouterr1ActionPerformed
 
          if (txt_idtel.getText().equals("") ||txt_type.getText().equals("") || txt_ns.getText().equals("")
                || txt_am.getText().equals("") 
                ||((JTextField)txt_DA1.getDateEditor().getUiComponent()).getText().equals("")||
                  txt_numTel.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Veuillez Remplir tous les champs");
        } else {
            String[] colon = {"idS2","type","Ns","addMac","addMac","titulaire","zone","DateAffectation","NumTel"};
            String[] inf = {txt_idtel.getText(), txt_type.getText(), txt_ns.getText(),txt_am.getText(),((JTextField)txt_DA1.getDateEditor().getUiComponent()).getText(),txt_numTel.getText()};
            System.out.println(db.queryInsert("affectation", colon, inf));
            JOptionPane.showMessageDialog(this, "Ajout avec succes");
            table();
            actualiser();
        }
    }//GEN-LAST:event_btn_Ajouterr1ActionPerformed

    private void btn_modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifierActionPerformed
      try{
           String tel=txt_idtel.getText();
             String type=txt_type.getText();
             String ns=txt_ns.getText();
             String am=txt_am.getText();
             String titulaire=txt_titulaire.getText();
             String zone=txt_zone.getText();
            // String DA=txt_DA1.getText();
              String numT=txt_numTel.getText();
       
             //object
             String sql="update affectation set idS2 =?,type=?,Ns=?, addMac=?,titulaire=?,zone=?,DateAffectation=?,NumTel=? where idS2=?";
    pst = conn.prepareStatement(sql);
    pst.execute();
    pst.setString(1, tel);
    pst.setString(2, type);
    pst.setString(3, ns);
    pst.setString(4, am); // <--- une java.sql.Date
    pst.setString(5, titulaire);
    pst.setString(6, zone);
    pst.setString(7, DA);
    pst.setString(8, numT);
    pst.setString(9, tel);
    
    pst.executeUpdate();
          JOptionPane.showMessageDialog(null, "Modification avec succes Inchallah");
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null, "erreur Modofication--->"+ex+"");
          System.out.println(ex);
          
          
      };
          
    }//GEN-LAST:event_btn_modifierActionPerformed

    private void btn_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportActionPerformed
        
        
        try{ 
           
           String idTel=txt_idtel.getText();
           String type=txt_type.getText();
           String ns=txt_ns.getText();
           String am=txt_am.getText();
           String titulaire=txt_titulaire.getText();
           String zone=txt_zone.getText();
           String date=txt_numTel.getText();
           
           
           Document doc=new Document();
        PdfWriter.getInstance(doc,new FileOutputStream("d:\\doc.pdf"));
        Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 19,Font.BOLD);
        Font catFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.ITALIC);
        doc.open();
        Calendar cal=new GregorianCalendar();
           int month=cal.get(Calendar.MONTH);
           int year =cal.get(Calendar.YEAR);
           int day=cal.get(Calendar.DAY_OF_MONTH);
           Font myContentStyle=new Font(); 
            myContentStyle.setStyle("italic");
        Image img=Image.getInstance("d:\\logo_ocp.png");
        doc.add(img);
        doc.add(new Paragraph("le  "+year+"/"+month+"/"+day+""));
       
        doc.add(new Paragraph("INK/GE/T"));
         doc.add(new Paragraph("\n"));
           doc.add(new Paragraph("\n"));
             doc.add(new Paragraph("\n"));
        doc.add(new Paragraph("                                      Décharge                                       ",catFont));
      
             doc.add(new Phrase("je soussigné M. "));
             
             doc.add(new Phrase(""+txt_titulaire.getText()+"",catFont1));
             doc.add(new Paragraph("\n"));
       
             doc.add(new Phrase("Confirme avoir recu un appareil Téléphonique IP: "));
             doc.add(new Phrase(""+txt_type.getText()+"",catFont1));
            doc.add(new Paragraph("\n"));
        
             doc.add(new Phrase("De marque CISCO et de type IP PHONE :"));
             doc.add(new Phrase(""+txt_type.getText()+"",catFont1));
             doc.add(new Paragraph("\n"));
       
             doc.add(new Phrase("N de Série: "));
             doc.add(new Phrase(""+txt_ns.getText()+"",catFont1));
             doc.add(new Phrase(" \n"));
             doc.add(new Phrase("Adresse Mac: "));
             doc.add(new Phrase(""+txt_am.getText()+"",catFont1));
             doc.add(new Paragraph("\n"));
             doc.add(new Paragraph("\n"));
             doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("Cédant:                                                                                 Tenant:"));
           
             
        doc.close();
        JOptionPane.showMessageDialog(null, "rapport pdf à été enregister avec succes");
       }catch(Exception e){
        
        
        JOptionPane.showMessageDialog(null, "pdf non exproté une erreur a été suurvenuee->"+e+"");
        }
    }//GEN-LAST:event_btn_reportActionPerformed

    private void TableAffectationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAffectationMouseClicked
         txt_idtel.setText(String.valueOf(TableAffectation.getValueAt(TableAffectation.getSelectedRow(),0)));
         txt_type.setText(String.valueOf(TableAffectation.getValueAt(TableAffectation.getSelectedRow(),1)));
         txt_ns.setText(String.valueOf(TableAffectation.getValueAt(TableAffectation.getSelectedRow(),2)));
         txt_am.setText(String.valueOf(TableAffectation.getValueAt(TableAffectation.getSelectedRow(),3)));
         txt_titulaire.setText(String.valueOf(TableAffectation.getValueAt(TableAffectation.getSelectedRow(),4)));
         txt_zone.setText(String.valueOf(TableAffectation.getValueAt(TableAffectation.getSelectedRow(),5)));
         txt_DA1.setDate(Date.valueOf(TableAffectation.getValueAt(TableAffectation.getSelectedRow(),6)));
         txt_numTel.setText(String.valueOf(TableAffectation.getValueAt(TableAffectation.getSelectedRow(),7)));
           
        
    }//GEN-LAST:event_TableAffectationMouseClicked

    private void btn_ToAffecteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ToAffecteActionPerformed
        try {
             //object
             String tel=txt_idtel.getText();
             String type=txt_type.getText();
             String ns=txt_ns.getText();
             String am=txt_am.getText();
             String titulaire=txt_titulaire.getText();
             String zone=txt_zone.getText();
              String DA=txt_DA1.getText();
              String numT=txt_numTel.getText();
             String requette="insert into affectation values('"+tel+"','"+type+"','"+ns+"','"+am+"','"+titulaire+"','"+zone+"','"+DA+"','"+numT+"')";
             int rs=stat.executeUpdate(requette);
             JOptionPane.showMessageDialog(null, "insertion avec succés");
             update_table();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, " Erreur insertion ->"+ex+"");
             Logger.getLogger(AncienStock.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_btn_ToAffecteActionPerformed

    private void btn_serveurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_serveurActionPerformed
      Serveur t= new Serveur();
       t.setVisible(true);
       this.setVisible(false);
        
       Serveur.txt_AM.setText(txt_titulaire.getText());
       /*Serveur.txt_AM.setText(txt_am.getText());
       Serveur.txt_AN.setText(txt_titulaire.getText());
       Serveur.txt_Ass.setText(txt_titulaire.getText());
       Serveur.txt_AssD.setText(txt_titulaire.getText());
       Serveur.txt_AssL.setText(txt_titulaire.getText()); 
       Serveur.txt_D1.setText(txt_titulaire.getText());
       Serveur.txt_DN.setText(txt_titulaire.getText());
       Serveur.txt_LT1.setText(txt_titulaire.getText());
      */
               
           
               
               
      
      
    }//GEN-LAST:event_btn_serveurActionPerformed

    private void btn_TaffeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TaffeActionPerformed
        Fonct AF= new Fonct();
        AF.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btn_TaffeActionPerformed

    private void btn_modifier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifier1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modifier1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
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
            java.util.logging.Logger.getLogger(Affectation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Affectation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Affectation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Affectation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Affectation().setVisible(true);
            }
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateAff;
    private javax.swing.JTable TableAffectation;
    private javax.swing.JLabel addM;
    private javax.swing.JButton btn_Ajouterr1;
    private javax.swing.JButton btn_Taffe;
    private javax.swing.JButton btn_ToAffecte;
    private javax.swing.JButton btn_exporter;
    private javax.swing.JButton btn_modifier;
    private javax.swing.JButton btn_modifier1;
    private javax.swing.JButton btn_report;
    private javax.swing.JButton btn_serveur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel laIds;
    private javax.swing.JLabel laNumTel;
    private javax.swing.JLabel laZone;
    private javax.swing.JLabel ns;
    private javax.swing.JLabel titulaire;
    private com.toedter.calendar.JDateChooser txt_DA1;
    public static javax.swing.JTextField txt_am;
    public static javax.swing.JTextField txt_idtel;
    public static javax.swing.JTextField txt_ns;
    public static javax.swing.JTextField txt_numTel;
    public static javax.swing.JTextField txt_titulaire;
    public static javax.swing.JTextField txt_type;
    public static javax.swing.JTextField txt_zone;
    private javax.swing.JLabel typeT1;
    // End of variables declaration//GEN-END:variables

   

