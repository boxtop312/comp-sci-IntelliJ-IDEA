public class Media_library_Song {
    // ATTRIBUTES - INSTANCE VARIABLES
    // Declaring Instance Variables
    private String title;
    private String artist;
    private int rating;




    // METHODS - behavours and actions of an object
    // CONSTRUCTORS - create objects of the class responsable for carving out space in the computer's memory to store the object
    // Most basic contrctor - simpy carves out space in memeory but does not assing values to instance variables
    // public Song(){}
    // Constructor contain default values
    public Media_library_Song(){
        this.title="";
        this.artist = "";
        this.rating = 0;
    }
    // Constructor in which values are passed in and assigned to the instance variables
    public Media_library_Song(String t, String a, int r){
        title = t;
        artist = a;
        rating = r;
    }



    // Setter Methods
    public void setTitle(String str){title = str;}
    public void setArtist(String str){artist = str;}
    public void setRating(int num){rating = num;}
    // Getter Methods
    public String getTitle(){return title;}
    public String getArtist(){return artist;}
    public int getRating(){return rating;}
    public String toString(){return "\nTitle: "+this.getTitle()+"\nArtist: "+this.getArtist()+"\nRating: "+this.getRating();}
}
