package b00394105_comp09044_cw2;

public class Song {
    public String title, artist, genre;
    public Integer releaseYear, songID, listID;
    // Private string variables 'title', 'artist' and 'genre' will be used to connect back to and store data from the main code that are strings
    // Pirvate integer variables 'releaseYear' and 'songID' will be used to connect back to and store data from the main code that are integers
    // 'songID' will specifically be used to identify songs in an album while listID will act as a connection between users and songs
    
    public Song(String title, String artist, String genre, Integer releaseYear, Integer songID, Integer listID){
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.songID = songID;
        this.listID = listID;
    }
    // The variables in this function are used to store the inputs connected in the main code when called upon
    // Additionally they will be used for storing in a list and printing message in the proto-menu
    
    @Override
    public String toString(){
        return "Title: " + this.title + ", Artist: " + this.artist + ", Genre: " + this.genre + ", Year: " + this.releaseYear;
    }
    // Function will return a message containing the stored array data, if there are multiple items in the array then all will be displayed by line
    // This will be worked out of program later in development, so that songs can be specified for printing with the proto-menu
    // Then before being moved onto the UI during program 1.0 development
}
