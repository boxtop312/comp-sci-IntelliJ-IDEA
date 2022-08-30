public class Media_library {
    public static void main(String[] args) {
        System.out.println("Wellcome to my media libarby!");

        // instantiate our first Song object
        Media_library_Song first = new Media_library_Song();
        Media_library_Song second = new Media_library_Song("Dreamsicle", "Jason Isbell and the 400 Unit", 4);
        Media_library_Song third = new Media_library_Song("Ocean Between", "The War on Drugs", 5);
        Media_library_Movie fourth = new Media_library_Movie("Star Wars: A New Hope", "Scifi", "Video8");
        Media_library_Movie fifth = new Media_library_Movie("James Bond: Moonraker", "Spy", "Lazerdisc");
        Media_library_Movie sixth = new Media_library_Movie("Oceans 11", "Heist", "DVD");
        Media_library_Book seventh = new Media_library_Book("Harry Potter and the Chamber of Secrets", "Fantasy", "J.K. Rowling");
        Media_library_Book eighth = new Media_library_Book("The Hunger Games", "Dystopian YA", "Suzane Collins");
        Media_library_Book ninth = new Media_library_Book("Great Expectations", "Drama", "Charles Dickens");
        // prints the memory location for the song object
        first.setTitle("Walking at a Downtown Pace");
        first.setArtist("Parquet Courts");
        first.setRating(5);
        System.out.println("\nTitle: "+ first.getTitle()+"\nArtist: "+ first.getArtist()+"\nRating: "+first.getRating());
        System.out.println("\nTitle: "+ second.getTitle()+"\nArtist: "+ second.getArtist()+"\nRating: "+second.getRating());
        System.out.println(third);
        System.out.println(fourth);
        System.out.println(fifth);
        System.out.println(sixth);
        System.out.println(seventh);
        System.out.println(eighth);
        System.out.println(ninth);
    }
}
