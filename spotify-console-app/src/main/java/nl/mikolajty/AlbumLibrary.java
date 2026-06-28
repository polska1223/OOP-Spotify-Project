package nl.mikolajty;
public class AlbumLibrary {
    public static Album[] getAllAlbums() {
        Album album1 = new Album("A Million Reasons", "bixby");
        album1.addSong(new Song("A Million Reasons", "bixby", "pop", 89));
        album1.addSong(new Song("Weep", "bixby", "pop", 163));
        album1.addSong(new Song("Gauze", "bixby", "pop", 155));
        album1.addSong(new Song("Feel It", "bixby", "pop", 190));
        album1.addSong(new Song("Run Like Hell", "bixby", "pop", 231));

        Album album2 = new Album("4SHOBOIZ Vol. 2: 4SHOVILLE", "Jay Park, LNGSHOT");
        album2.addSong(new Song("4SHO 4SHO", "Jay Park, LNGSHOT", "hiphop", 241));
        album2.addSong(new Song("YEAH! YEAH!", "Jay Park, LNGSHOT", "hiphop", 184));
        album2.addSong(new Song("NO HI, NO HEY", "Jay Park, LNGSHOT", "hiphop", 180));
        album2.addSong(new Song("RUN IT UP", "Jay Park, LNGSHOT", "hiphop", 179));
        album2.addSong(new Song("GUKBBONG", "Jay Park, LNGSHOT", "hiphop", 224));
        album2.addSong(new Song("MOYA", "Jay Park, LNGSHOT", "hiphop", 251));
        album2.addSong(new Song("THE PURGE 4SHOMIX", "Jay Park, LNGSHOT", "hiphop", 138));
        album2.addSong(new Song("PUBLIC ENEMY 4SHOMIX", "Jay Park, LNGSHOT, DJ Wegun", "hiphop", 212));

        return new Album[]{album1, album2};
    }
}