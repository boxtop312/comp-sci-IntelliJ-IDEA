import java.util.Arrays;
public class Horse_barn_quiz {
    public static void main(String[] args) {
        HorseBarn barn = new HorseBarn(5);
        barn.addHorse(0,new Horse("horse", "horse color", "horse weight"));
        barn.addHorse(4,new Horse("horse2", "horse color2", "horse weight2"));
        barn.addHorse(3,new Horse("horse3", "horse color3", "horse weight3"));
        barn.consolidate();
        System.out.println(barn);
    }
}
class Horse{
    //ATTRIBUTES
    private String name;
    private String color;
    private String weight;

    //CONSTRUCTOR
    Horse(String n, String c, String w){
        name = n;
        color = c;
        weight = w;
    }
    //METHODS
    public String getName(){return this.name;}
    public String getColor(){return this.color;}
    public String getWeight(){return this.weight;}
    public void setName(String str){this.name = str;}
    public void setColor(String str){this.color = str;}
    public void setWeight(String str){this.weight = str;}
    public String toString(){
        return "Name: "+this.name+"\nColor: "+this.color+"\nWeight: "+weight;
    }
}
class HorseBarn{
    // ATTRIBIUTES
    private Horse[] spaces;

    // CONSTRUCTOR
    HorseBarn(int horsenum){
        this.spaces = new Horse[horsenum];
    }
    // METHODS
    public void addHorse(int num, Horse hor){
        spaces[num]=hor;
    }
    public int findHorseSpace(String name){
        for(int i=0;i<spaces.length;i++){
            if(spaces[i].getName().contains(name)){
                return i;
            }
        }
        return -1;
    }
    public void consolidate(){
        for(int i=0;i<this.spaces.length;i++){
            if(this.spaces[i]==null){
                for(int ii=i+1;ii<this.spaces.length;ii++){
                    if(this.spaces[ii]!=null){
                        this.spaces[i] = this.spaces[ii];
                        this.spaces[ii]=null;
                        break;
                    }
                }
            } else if(this.spaces[i]!=null){
                this.spaces[i] = this.spaces[i];
            }
        }
    }
    public String toString(){
        StringBuilder tostring = new StringBuilder();
        for(int i=0;i<spaces.length;i++){
            if(spaces[i]==null){
                tostring.append("null ");
            } else{
                tostring.append(spaces[i].getName()).append(" ");
            }

        }
        return String.valueOf(tostring);
    }

    // SETTERS
}
