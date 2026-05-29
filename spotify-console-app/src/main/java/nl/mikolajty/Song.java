package nl.mikolajty;

public class Song {
    private String title;
    private String artist;
    private String genre;
    private boolean isPlaying;
    private int duration;


    public Song(String title, String artist, String genre,int duration ){
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
    }

    public void showInfo() {
        System.out.println("Titel " + title);
        System.out.println("Artiest " + artist);
        System.out.println("genre " + genre);
        System.out.println(duration / 60 + ":" + String.format("%02d", duration % 60));
        System.out.println(isPlaying);
        System.out.println();
    }
    public void play()
    {
        isPlaying = true;
        System.out.println("Nu aan het spelen: " + title + ", Gemaakt door" + artist + ", " + duration / 60 + ":" + String.format("%02d", duration % 60));
    }
}
