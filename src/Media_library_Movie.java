public class Media_library_Movie {
    private String title;
    private String genre;
    private String format;
    public Media_library_Movie(String t, String g, String f){
        title = t;
        genre = g;
        format = f;
    }
    public void setTitle(String str){title = str;}
    public void setGenre(String str){genre = str;}
    public void setFormat(String str){format = str;}
    public String getTitle(){return title;}
    public String getGenre(){return genre;}
    public String getFormat(){return format;}
    public String toString(){return "\nTitle: "+this.getTitle()+"\nGenre: "+this.getGenre()+"\nFormat: "+this.getFormat();}
}
