package nl.mikolajty;

public class Album {

    private String title;
    private String artist;
    private int songCount;

    public Album(String title, String artist, int songCount) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public void showInfo() {
        System.out.println("Album: " + title);
        System.out.println("Artiest: " + artist);
        System.out.println("Aantal nummers: " + songCount);
        System.out.println();
    }
}