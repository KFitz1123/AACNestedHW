import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class AACMappings {

/*
 * Field
 */
public AssociativeArray<String, AACCategory> map;
private String current;
/*
 * Constructor
 */

public AACMappings(String filename){
  this.current = "";
  File file = new File(filename);                        
  PrintWriter pen = new PrintWriter (System.out,true);   
  Scanner eye = new Scanner(":(");
  try{
pen = new PrintWriter(file);
eye = new Scanner(file);
  } catch (Exception e){
  }

while(eye.hasNextLine()){
  String temp = eye.nextLine();

  pen.println(temp);

  Scanner smalleye = new Scanner(temp);
  String tempimg = smalleye.next();

  pen.println(tempimg);

  String tempname = smalleye.next();

  pen.println(tempname);

  map.set(tempname, new AACCategory(tempname));
  temp = eye.nextLine();
  int i = 0;
while(temp.charAt(0) == '>'){

  temp = eye.nextLine(); 
  i++;
}
  smalleye.close();
}

pen.close();
eye.close();
}

/*
 * Methods
 */


  public String[] getImageLocs() {
    return new String[] { "img/food/icons8-french-fries-96.png", "img/food/icons8-watermelon-96.png" }; // STUB
  } // getImageLocs()

  public String add(String imageLoc, String text) {
    return "television";  // STUB
  }

  public void reset() {
      // STUB
  }

  public String writeToFile(String file) {
    return "television";  // STUB
  }

  public String getText(String imageLoc) {
    return "television";  // STUB
  }

  public String getCurrentCategory() {
    return "food";  // STUB
  }
}
