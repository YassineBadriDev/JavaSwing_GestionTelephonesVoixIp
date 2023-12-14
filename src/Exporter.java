
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JTable;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yassine
 */
public class Exporter {
    private File file;
    private List<JTable> table;
    private List<String> nomFiles;

    public Exporter(File file, List<JTable> table, List<String> nom_files) throws Exception{
        this.file = file;
        this.table = table;
        this.nomFiles = nomFiles;
       
   
 if(nomFiles.size()!=table.size()) {


  throw new Exception("error");
   }
 }
    
public boolean export(){
try{


DataOutputStream  out =new DataOutputStream(new FileOutputStream(file));
WritableWorkbook w=Workbook.createWorkbook(out);
for(int index=0;index<table.size();index++){
JTable jtable=table.get(index);
WritableSheet s=w.createSheet(nomFiles.get(index),0);

for(int i=0;index<jtable.getColumnCount();i++){
for(int j=0;j<jtable.getRowCount();j++){
Object object=jtable.getValueAt(j, i);
   s.addCell(new Label(i,j,String.valueOf(object)));

}
}
}
w.write();
w.close();
return true;
}catch(Exception e){


return false;


}

  }

    private void Exception(String error) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
     
     
     
     
    
}
