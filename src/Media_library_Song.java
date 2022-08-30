public class Media_library_Song {
    // ATTRIBUTES - INSTANCE VARIABLES
    // Declaring Instance Variables
    private String title;
    private String artist;
    private int rating;
    private double price;
    private boolean favorite;
    private double totalCost;
    private int totalSongs;
    private int totalRatings;



    // METHODS - behavours and actions of an object
    // CONSTRUCTORS - create objects of the class responsable for carving out space in the computer's memory to store the object
    // Most basic contrctor - simpy carves out space in memeory but does not assing values to instance variables
    // public Song(){}
    // Constructor contain default values
    public Media_library_Song(){
        this.title="";
        this.artist = "";
        this.rating = 0;
        totalSongs += 1;
    }
    // Constructor in which values are passed in and assigned to the instance variables
    public Media_library_Song(String t, String a, int r, double p, boolean f){
        title = t;
        artist = a;
        rating = r;
        price = p;
        favorite = f;
        totalSongs += 1;
        totalCost += p;
        totalRatings += r;
    }

    public Media_library_Song(String t, double p){
        title = t;
        price = p;
        totalSongs += 1;
        totalCost += p;
    }

    public Media_library_Song(String t, double p, boolean f){
        title = t;
        price = p;
        favorite = f;
        totalSongs += 1;
        totalCost += p;
    }

    public Media_library_Song(String t, double tc, int ts, int tr){
        title = t;
        totalCost = tc;
        totalRatings = tr;
        totalSongs = ts;
    }


    // Setter Methods
    public void setTitle(String str){title = str;}
    public void setArtist(String str){artist = str;}
    public void setRating(int num){rating = num;}
    public void setPrice(double num){price = num;}
    public void setFavorite(boolean bool){favorite = bool;}
    public void setTotalCost(double num){totalCost = num;}
    public void setTotalSongs(int num){totalSongs = num;}
    public void setTotalRatings(int num){totalRatings = num;}

    // Getter Methods
    public String getTitle(){return title;}
    public String getArtist(){return artist;}
    public int getRating(){return rating;}
    public double getPrice(){return price;}
    public boolean getFavorite(){return favorite;}
    public double getTotalCost(){return totalCost;}
    public int getTotalSongs(){return totalSongs;}
    public int getTotalRatings(){return totalRatings;}

    public String toString(){return "\nTitle: "+this.getTitle()+"\nArtist: "+this.getArtist()+"\nRating: "+this.getRating() + "\nPrice: "+this.getPrice()+"\nFavorite: "+this.getFavorite()+"\nTotal Cost: "+this.getTotalCost()+"\nTotal Songs: "+this.getTotalSongs()+"\nTotal Ratings:"+this.getTotalRatings();}
}
