

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
  }// getCategory
  
  public String[] getImages​(){
    String[] imgarr = new String[this.imgs.size()];
    for(int i = 0; i < this.imgs.size(); i++){
      imgarr[i] = this.imgs.pairs[i].key;
    }
    return imgarr; 
   }

   public String getText​(String imageLoc){
    try{
      return this.imgs.get(imageLoc);
    } catch(Exception e){
    return "mistake";
   } 
  }
   
   public Boolean hasImage(String imageLoc){
    return this.imgs.hasKey(imageLoc);
   }
}
