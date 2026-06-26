package nl.mikolajty;

public class Song {
    private String title;
    private String artist;
    private String genre;


    public Song(String title, String artist, String genre){
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public void showInfo() {
        System.out.println("Titel " + title);
        System.out.println("Artiest " + artist);
        System.out.println("genre " + genre);
        System.out.println();
    }
}
