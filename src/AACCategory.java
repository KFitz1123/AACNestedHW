

public class AACCategory {
  private AssociativeArray<String,String> imgs;
  private String name;

  public AACCategory(String name){
    this.imgs = new AssociativeArray<String,String>();
    this.name = name;
  }

  public void	addItem​(String imageLoc,String text){
    this.imgs.set(imageLoc, text);
  }

  public String getCategory​(){
   return name; 
  }

  public String[] getImages​(){
    return new String[]{"one","two","three"}; //STUB
   }

   public String getText​(String imageLoc){
    try{
      return this.imgs.get(imageLoc);
    } catch(Exception e){
    return "invalid image";
   } 
  }
   
   public Boolean hasImage(String imageLoc){
    return this.imgs.hasKey(imageLoc);
   }
}
