public class Media_library {
    public static void main(String[] args) {
        System.out.println("Wellcome to my media libarby!");

        // instantiate our first Song object
        Media_library_Song zeroth = new Media_library_Song("Songs Totals",0.0, 0, 0);
        Media_library_Song first = new Media_library_Song();
        Media_library_Song second = new Media_library_Song("Dreamsicle", "Jason Isbell and the 400 Unit", 4, 1.29, false);
        Media_library_Song third = new Media_library_Song("Ocean Between", "The War on Drugs", 5, 0.99, false);
        Media_library_Movie fourth = new Media_library_Movie("Star Wars: A New Hope", "Scifi", "Hi8",121);
        Media_library_Movie fifth = new Media_library_Movie("James Bond: Moonraker", "Spy", "Lazerdisc",126);
        Media_library_Movie sixth = new Media_library_Movie("Oceans 11", "Heist", "DVD", 116);
        Media_library_Book seventh = new Media_library_Book("Harry Potter and the Chamber of Secrets", "Fantasy", "J.K. Rowling");
        Media_library_Book eighth = new Media_library_Book("The Hunger Games", "Dystopian YA", "Suzane Collins");
        Media_library_Book ninth = new Media_library_Book("Great Expectations", "Drama", "Charles Dickens");
        Media_library_Song tenth = new Media_library_Song("ABBA Gold", 7.99);
        Media_library_Song eleventh = new Media_library_Song("WALL-E (Original Motion Picture Soundtrack)", 10.00, true);
        // prints the memory location for the song object
        first.setTitle("Walking at a Downtown Pace");
        first.setArtist("Parquet Courts");
        first.setRating(5);
        zeroth.setTotalCost(second.getTotalCost()+third.getTotalCost()+tenth.getTotalCost()+eleventh.getTotalCost());
        zeroth.setTotalRatings(second.getTotalRatings()+ first.getRating()+third.getTotalRatings());
        zeroth.setTotalSongs(first.getTotalSongs()+second.getTotalSongs()+third.getTotalSongs()+ tenth.getTotalSongs()+ eleventh.getTotalSongs());
        System.out.println("\nTitle: "+ first.getTitle()+"\nArtist: "+ first.getArtist()+"\nRating: "+first.getRating());
        System.out.println(second);
        System.out.println(third);
        System.out.println(fourth);
        System.out.println(fifth);
        System.out.println(sixth);
        System.out.println(seventh);
        System.out.println(eighth);
        System.out.println(ninth);
        System.out.println(tenth);
        System.out.println(eleventh);
        System.out.println(zeroth);
    }
}
