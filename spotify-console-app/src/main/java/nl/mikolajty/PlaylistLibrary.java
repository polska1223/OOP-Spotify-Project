package nl.mikolajty;

public class PlaylistLibrary {
    public static Playlist[] getAllPlaylists() {
        Playlist playlist1 = new Playlist("Mijn eerste hardcoded playlist");
        playlist1.addSong(new Song("blinding lights", "the weeknd", "pop", 192));
        playlist1.addSong(new Song("kanye yeast", "kanye west", "pop", 213));


        return new Playlist[]{playlist1};
    }
}
