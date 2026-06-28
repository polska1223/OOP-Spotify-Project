package nl.mikolajty;
import java.util.ArrayList;

public class Playlist {
    private String PlaylistNaam;
    private ArrayList<Song> songs = new ArrayList<>();

    public Playlist(String naam)    {
        this.PlaylistNaam = naam;

    }
    public void play() {
        for (Song song : songs) {
            song.play();
        }
    }
    public void addSong(Song song) {
        songs.add(song);

    }
    public void removeSong(Song song) {
        songs.remove(song);

    }
    public void showSongs(){
        for (Song song : songs) {
            song.showInfo();
        }
    }
    public String getNaam() {
        return PlaylistNaam;
    }
}