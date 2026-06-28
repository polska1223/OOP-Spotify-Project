package nl.mikolajty;

public class SongLibrary {
    public static Song[] getAllSongs() {
        return new Song[] {
                new Song("blinding lights", "the weeknd", "pop", 192),
                new Song("kanye yeast", "kanye west", "pop", 213),
                new Song("rubenIJ in paris", "kanye west", "pop", 204)
        };
    }
}