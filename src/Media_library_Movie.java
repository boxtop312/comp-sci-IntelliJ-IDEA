public class Media_library_Movie {
    private String title;
    private String genre;
    private String format;
    private int length;

    public Media_library_Movie(String t, String g, String f, int l){
        title = t;
        genre = g;
        format = f;
        length = l;
    }
    public void setTitle(String str){title = str;}
    public void setGenre(String str){genre = str;}
    public void setFormat(String str){format = str;}
    public void setLength(int num){length = num;}
    public String getTitle(){return title;}
    public String getGenre(){return genre;}
    public String getFormat(){return format;}
    public int getLength(){return length;}
    public String toString(){return "\nTitle: "+this.getTitle()+"\nGenre: "+this.getGenre()+"\nFormat: "+this.getFormat()+"\nLength(Min): "+this.getLength();}
}
