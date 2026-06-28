package nl.mikolajty;

import java.util.ArrayList;

public class Album {
    private String naam;
    private String artiest;
    private ArrayList<Song> songs = new ArrayList<>();

    public Album(String naam, String artiest) {
        this.naam = naam;
        this.artiest = artiest;
    }

    public void play() {
        for (Song song : songs) {
            song.play();
        }
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void showSongs() {
        for (Song song : songs) {
            song.showInfo();
        }
    }

    public String getNaam() {
        return naam;
    }

    public String getArtiest() {
        return artiest;
    }
}