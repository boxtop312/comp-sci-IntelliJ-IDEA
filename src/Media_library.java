public class Media_library {
    public static void main(String[] args) {
        System.out.println("Wellcome to my media libarby!");

        // instantiate our first Song object
        Media_library_Song first = new Media_library_Song();
        Media_library_Song second = new Media_library_Song("Dreamsicle", "Jason Isbell and the 400 Unit", 4);
        Media_library_Song third = new Media_library_Song("Ocean Between", "The War on Drugs", 5);
        // prints the memory location for the song object
        first.setTitle("Walking at a Downtown Pace");
        first.setArtist("Parquet Courts");
        first.setRating(5);
        System.out.println("\nTitle: "+ first.getTitle()+"\nArtist: "+ first.getArtist()+"\nRating: "+first.getRating());
        System.out.println("\nTitle: "+ second.getTitle()+"\nArtist: "+ second.getArtist()+"\nRating: "+second.getRating());
        System.out.println(third);
    }
}
