public class Media_library_Book {
    private String title;
    private String genre;
    private String author;
    public Media_library_Book(String t, String g, String a){
        title = t;
        genre = g;
        author = a;
    }
    public void setTitle(String str){title = str;}
    public void setGenre(String str){genre = str;}
    public void setAuthor(String str){author = str;}
    public String getTitle(){return title;}
    public String getGenre(){return genre;}
    public String getAuthor(){return author;}
    public String toString(){return "\nTitle: "+this.getTitle()+"\nGenre: "+this.getGenre()+"\nAuthor: "+this.getAuthor();}
}
