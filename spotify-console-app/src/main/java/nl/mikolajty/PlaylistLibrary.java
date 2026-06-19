package nl.mikolajty;

public class PlaylistLibrary {
    public static Playlist[] getAllPlaylists() {
        Playlist playlist1 = new Playlist("Mijn eerste playlist");
        playlist1.addSong(new Song("blinding lights", "the weeknd", "pop", 192));
        playlist1.addSong(new Song("kanye yeast", "kanye west", "pop", 213));

        Playlist playlist2 = new Playlist("Mijn tweede playlist");
        playlist2.addSong(new Song("rubenIJ in paris", "kanye west", "pop", 204));

        return new Playlist[]{playlist1, playlist2};
    }
}
