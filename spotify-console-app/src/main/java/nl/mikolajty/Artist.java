package nl.mikolajty;

public class Artist {

    private String name;
    private String album;
    private String single;

    public Artist(String name, String album, String single) {
        this.name = name;
        this.album = album;
        this.single = single;
    }

    public String getName() {
        return name;
    }

    public void showInfo() {
        System.out.println("Artiest: " + name);
        System.out.println("Album: " + album);
        System.out.println("Single: " + single);
        System.out.println();
    }
}