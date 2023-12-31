
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yassine
 */
public class Affectation2 extends javax.swing.JFrame {

    
    Statement stat=null;
    MysqlConnect  maConnexion=new MysqlConnect();
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    /**
     * Creates new form Affectation2
     */
    public Affectation2() {
        initComponents();
        
        setTitle("Affectation");
        initComponents();
        Serveur s= new Serveur();
        s.setVisible(true);
        this.setVisible(false);
        
        
   DefaultTableModel model1= new DefaultTableModel();
   model1.addColumn("idS2");
   model1.addColumn("type");
   model1.addColumn("Ns");
   model1.addColumn("addMac");
   model1.addColumn("titulaire");
   model1.addColumn("zone");
   model1.addColumn("DateAffectation");
   model1.addColumn("NumTel");
   
   TableAffectation2.setModel(model1);
   
          
   
   String requette="select * from affectation";
   
   try{
       
        stat=MysqlConnect.ConnectDB().createStatement();
        ResultSet rs=stat.executeQuery(requette);
        while(rs.next()){
        model1.addRow(new Object[]{rs.getInt("idS2"),rs.getString("type"),rs.getString("Ns"),rs.getString("addMac"),rs.getString("titulaire"),rs.getString("zone"),rs.getDate("DateAffectation"),rs.getInt("NumTel")} );
        }
         System.out.println("avce suscces");
   }catch(SQLException e){
       JOptionPane.showMessageDialog(null, e);
    };
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableAffectation2 = new javax.swing.JTable();
        laNumTel = new javax.swing.JLabel();
        laZone = new javax.swing.JLabel();
        addM = new javax.swing.JLabel();
        txt_idtel = new javax.swing.JTextField();
        txt_type = new javax.swing.JTextField();
        txt_ns = new javax.swing.JTextField();
        txt_titulaire = new javax.swing.JTextField();
        txt_zone = new javax.swing.JTextField();
        txt_numTel = new javax.swing.JTextField();
        DateAff = new javax.swing.JLabel();
        titulaire = new javax.swing.JLabel();
        txt_am = new javax.swing.JTextField();
        laIds = new javax.swing.JLabel();
        ns = new javax.swing.JLabel();
        typeT = new javax.swing.JLabel();
        btn_ToAffecte = new javax.swing.JButton();
        btn_serveur = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btn_exporter = new javax.swing.JButton();
        btn_modifier = new javax.swing.JButton();
        btn_inserer1 = new javax.swing.JButton();
        btn_report = new javax.swing.JButton();
        txt_DA1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableAffectation2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TableAffectation2);

        laNumTel.setText("Num Tel");

        laZone.setText("Zone");

        addM.setText("Addresse Mac");

        DateAff.setText("Date D'affectation");

        titulaire.setText("Titulaire");

        txt_am.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amActionPerformed(evt);
            }
        });

        laIds.setText("idTel");

        ns.setText("NumSerie");

        typeT.setText("Type");

        btn_ToAffecte.setText("Affecter un Tél");
        btn_ToAffecte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ToAffecteActionPerformed(evt);
            }
        });

        btn_serveur.setText("ToServeur");
        btn_serveur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_serveurActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_exporter.setText("Exporter Excel");
        btn_exporter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exporterActionPerformed(evt);
            }
        });

        btn_modifier.setText("Modifier");
        btn_modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifierActionPerformed(evt);
            }
        });

        btn_inserer1.setText("inserer");
        btn_inserer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inserer1ActionPerformed(evt);
            }
        });

        btn_report.setText("Imprimer un Etat");
        btn_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(addM)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ns)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(typeT)
                                .addComponent(laIds))
                            .addComponent(titulaire)
                            .addComponent(laZone)))
                    .addComponent(DateAff)
                    .addComponent(laNumTel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_zone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_titulaire, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_am, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_idtel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_type, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ns, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_numTel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_DA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btn_report)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_exporter)
                .addGap(42, 42, 42)
                .addComponent(btn_modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btn_ToAffecte)
                .addGap(18, 18, 18)
                .addComponent(btn_inserer1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_serveur, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(168, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_idtel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(laIds))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(typeT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_type, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ns, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ns))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_am, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addM))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_titulaire, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titulaire))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_zone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(laZone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DateAff)
                            .addComponent(txt_DA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_numTel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(laNumTel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_report, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exporter, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ToAffecte, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_inserer1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_serveur, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_amActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_amActionPerformed

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
               Serveur s= new Serveur();
        s.setVisible(true);
        this.setVisible(false);

        Serveur.txt_Desp.setText(txt_titulaire.getText());
        Serveur.txt_AM.setText(txt_am.getText());
        Serveur.txt_AN.setText(txt_titulaire.getText());
        Serveur.txt_Ass.setText(txt_titulaire.getText());
        Serveur.txt_AssD.setText(txt_titulaire.getText());
        Serveur.txt_AssL.setText(txt_titulaire.getText());
        Serveur.txt_D1.setText(txt_titulaire.getText());
        Serveur.txt_DN.setText(txt_titulaire.getText());
        Serveur.txt_LT1.setText(txt_titulaire.getText());

        
    }//GEN-LAST:event_btn_serveurActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            // TODO add your handling code here:
            MessageFormat header=new  MessageFormat("page header");
            MessageFormat footer=new  MessageFormat("page{number.interger]");

            TableAffectation2.print(JTable.PrintMode.NORMAL, header,footer);
        } catch (PrinterException ex) {
            Logger.getLogger(Affectation2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_exporterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exporterActionPerformed

          JFileChooser fc = new JFileChooser();
        int option = fc.showSaveDialog(Affectation2.this);
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
            toExcel(TableAffectation2, new File(file));
            JOptionPane.showMessageDialog(null, "Enregistré avec succés à"+path+" ");
        }

    }//GEN-LAST:event_btn_exporterActionPerformed

    private void btn_modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifierActionPerformed
         try{
            String idTel=txt_idtel.getText();
            String type=txt_type.getText();
            String ns=txt_ns.getText();
            String am=txt_am.getText();
            String titulaire=txt_titulaire.getText();
            String zone=txt_zone.getText();
            String date=txt_DA1.getText();
            String numT= txt_numTel.getText();

            String requette="update affectation set idS2='"+idTel+"',type='"+type+"', NS='"+ns+"' ,addMac='"+am+"', titulaire='"+titulaire+"' ,zone='"+zone+"', DateAffection='"+date+"', NumTel='"+numT+"'  WHERE='"+idTel+"'";
            pst=conn.prepareStatement(requette);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modification avec succés");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, " Erreur Modification ->+"+e+"");
        }
        /*
        String tel=txt_idtel.getText();
        String type=txt_type.getText();
        String ns=txt_ns.getText();
        String am=txt_am.getText();
        String titulaire=txt_titulaire.getText();
        String zone=txt_zone.getText();
        String DA=txt_DA1.getText();
        String numT=txt_numTel.getText();
        try {
            //object

            pst = conn.prepareStatement("update affectation set idS2 =?, nom=?, type=?, Ns=?, addMac=?, titulaire=?, zone=?, DateAffectation=?,NumTel=? where idS2=?");
            pst.setString(1, tel);
            pst.setString(2, type);
            pst.setString(3, ns);
            pst.setString(4, am); // <--- une java.sql.Date
            pst.setString(5, titulaire);
            pst.setString(6, zone);
            pst.setString(7, DA);
            pst.setString(8, numT);
            pst.executeUpdate();
            /*   String requette="UPDATE  affectation  SET idS2='"+tel+"',type='"+type+"',Ns='"+ns+"',addMac='"+am+"',titulaire='"+titulaire+"',zone='"+zone+"',DateAffectation='"+DA+"',NumTel='"+numT+"' WHERE idS2='"+tel+"'";
            int rs=stat.executeUpdate(requette);
            JOptionPane.showMessageDialog(null, "insertion avec succés");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Erreur insertion ->"+ex+"");
            Logger.getLogger(AncienStock.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            update_table();
        } catch (SQLException ex) {
            Logger.getLogger(Affectation.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_btn_modifierActionPerformed

    private void btn_inserer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inserer1ActionPerformed
        /*      try {
            Object tel=txt_idTel.getText();
            Object type=txt_typeA.getText();
            Object num=txt_numS.getText();
            Object add=txt_addM.getText();

            String requette="insert into ancienstock values('"+tel+"','"+type+"','"+num+"','"+add+"')";
            int rs=stat.executeUpdate(requette);
            update_table();
        } catch (SQLException ex) {
            Logger.getLogger(AncienStock.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_btn_inserer1ActionPerformed

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
private  void update_table ()throws SQLException{
      rs=stat.executeQuery("select * from affectation");
       TableAffectation2.setModel(DbUtils.resultSetToTableModel(rs));

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
            java.util.logging.Logger.getLogger(Affectation2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Affectation2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Affectation2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Affectation2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Affectation2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateAff;
    private javax.swing.JTable TableAffectation2;
    private javax.swing.JLabel addM;
    private javax.swing.JButton btn_ToAffecte;
    private javax.swing.JButton btn_exporter;
    private javax.swing.JButton btn_inserer1;
    private javax.swing.JButton btn_modifier;
    private javax.swing.JButton btn_report;
    private javax.swing.JButton btn_serveur;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
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
    private javax.swing.JLabel typeT;
    // End of variables declaration//GEN-END:variables
}
