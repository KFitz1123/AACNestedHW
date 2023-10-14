import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class AACMappings {

/*
 * Field
 */
private AssociativeArray<String, AACCategory> map;
private String current;
/*
 * Constructor
 * Its Awful, but it takes from the give filename and creates a mapping of them in the form of a nested 
 */

public AACMappings(String filename){
  this.map = new AssociativeArray<String,AACCategory>();
  this.current = "";
  File file = new File(filename);                        
  Scanner eye = new Scanner(":(");
  try{
    eye.close();
    eye = new Scanner(file);
    } catch (Exception e){
  }//try to open scanner to file
  String temp = eye.nextLine();
  Scanner smalleye;
while(eye.hasNextLine()){
  smalleye = new Scanner(temp);
  String tempimg = smalleye.next();
  String tempname = smalleye.nextLine();
  tempname = tempname.substring(1,tempname.length());
  smalleye.close();
  temp = eye.nextLine(); 
  this.map.set(tempimg, new AACCategory(tempname));
  while(temp.charAt(0) == '>' && eye.hasNextLine()){
    temp = temp.substring(1, temp.length());
    smalleye = new Scanner(temp);
    String imgloc = smalleye.next();
    String objname = smalleye.nextLine();
    objname = objname.substring(1,objname.length());
    this.map.pairs[this.map.size()-1].value.addItem​(imgloc, objname); 
    smalleye.close();
    temp = eye.nextLine(); 
      } //While (temp.charAt(0) == >)
   }//While (eye.hasNext)
  temp = temp.substring(1, temp.length());
  smalleye = new Scanner(temp);
  String imgloc = smalleye.next();
  String objname = smalleye.nextLine();
  objname = objname.substring(1,objname.length());
  this.map.pairs[this.map.size()-1].value.addItem​(imgloc, objname); 
  smalleye.close();
  eye.close();// to account for the last line
}// AACMappings Constructor

/*
 * Methods
 */


  public String[] getImageLocs() {
    String[] locs = new String[1];
    if(this.current == ""){
      locs = this.map.getKeys();
    }
    else{
      try{
      locs = this.map.pairs[this.map.find(current)].value.getImages​(); 
    }catch (Exception e){
    }//try to getimages at current
    }
    return locs; 
  } // getImageLocs()

  public void add(String imageLoc, String text) {
     this.map.set(imageLoc, new AACCategory(text));
  }// add

  public void reset() {
      this.current = "";
  }//reset

  public void writeToFile(String file) {
    PrintWriter pen = new PrintWriter(System.out,true);
    PrintWriter pen2 = new PrintWriter(System.out,true);
    try{
    pen = new PrintWriter(file);
    }catch(Exception e){
     try{ new File(file).createNewFile();
      pen = new PrintWriter(file);
     }catch (Exception f){
     }//try to create new file
    }//try to create file and pen

    for(int i = 0; i < this.map.size(); i++){
      pen.println(this.map.pairs[i].key + " " + this.map.pairs[i].value.getCategory​());
      pen2.println(this.map.pairs[i].key + " " + this.map.pairs[i].value.getCategory​());
      pen.flush();
      pen2.flush();
      for(int j = 0; j < this.map.pairs[i].value.getImages​().length; j++){
        pen.println(">" + this.map.pairs[i].value.getImages​()[j] + " " + this.map.pairs[i].value.getText​(this.map.pairs[i].value.getImages​()[j]));
        pen2.println(">" + this.map.pairs[i].value.getImages​()[j] + " " + this.map.pairs[i].value.getText​(this.map.pairs[i].value.getImages​()[j]));
        pen.flush();
        pen2.flush();
      }//for all imgs within cat
    }//for all cat in home
    pen.close();
    pen2.close();
  }//writeToFile

  public String getText(String imageLoc) {
String text = "image not found";
try{
    if(this.current == ""){
      this.current = this.map.pairs[this.map.find(imageLoc)].key;
      return this.map.pairs[this.map.find(imageLoc)].value.getCategory​();
    }//if current is home screen
    else{
        return this.map.pairs[this.map.find(current)].value.getText​(imageLoc);
  }
}catch(Exception e){
  }
return text;
}//getText

  public String getCurrentCategory() {
    return this.current;  
  }//getCurrentCategory
}
