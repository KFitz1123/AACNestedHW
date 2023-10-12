import java.io.PrintWriter;


public class Expt {
  public static void main(String[] args){
    PrintWriter pen = new PrintWriter(System.out,true);
    AACMappings AACmap = new AACMappings("~/csc207/assignments/AACNestedHW/AACMappings.txt");
    pen.println(AACmap.map.toString());

  }
}
