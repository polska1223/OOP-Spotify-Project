package nl.mikolajty;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private Scanner scanner;
    private boolean isRunning;
    private User[] users;
    private ArrayList<User> friends;
    private ArrayList<Playlist> playlists = new ArrayList<>();

    public Client() {
        this.scanner = new Scanner(System.in);
        isRunning = true;

        users = new User[]{
            new User("Mikolaj"),
            new User("Ty"),
            new User("Lucas"),
            new User("Erik"),
        };

        friends = new ArrayList<>();
        for (Playlist playlist : PlaylistLibrary.getAllPlaylists()) {
            playlists.add(playlist);
        }
        }

    public void start() {
  while (isRunning) {
    showHomepage();
    handleMenuChoice();
    
}
   }
   public void showHomepage() {
      System.out.println();
      System.out.println("    Homepage Spotify console app     ");
      System.out.println();
      System.out.println("Welkom bij onze spotify applicatie!");
      System.out.println();
      System.out.println("Wat wil je doen?");
      System.out.println();
      System.out.println("1. Nummers bekijken");
      System.out.println("2. Afspeellijsten bekijken");
      System.out.println("3. Albums bekijken");
      System.out.println("4. Artiesten bekijken");
      System.out.println("5. Gebruiksersprofiel bekijken");
      System.out.println();
      System.out.println();
    }

public void handleMenuChoice() {
    String choice = scanner.nextLine();

    if (choice.equals("1")) {
        showSongsPage();
    }
    else if (choice.equals("2")) {
        showPlaylistPage();
    }
    else if (choice.equals("3")) {
        showAlbumPage();
    }
    else if (choice.equals("4")) {
        showArtistPage();
    }
    else if (choice.equals("5")) {
        showUsersPage();
    }
    else if (choice.equals("0")) {
        stopApplication();
    }
    else {
        System.out.println("Ongeldig invoer. Probeer opnieuw");
        pressEnterToContinue();
    }
}


public void showSongsPage() {
    System.out.println("Nummers");
    Song[] songs = SongLibrary.getAllSongs();

    System.out.println();
    System.out.println("=== Nummers bekijken ===");
    System.out.println();

    for (Song song : songs) {
        song.showInfo();
    }

    System.out.println("type de titel van de nummer in om het nummer aftespelen");
    String choiceSong = scanner.nextLine();
    Song selectedSong = null;

    for (Song song : songs) {
        if (choiceSong.equals(song.getTitle())) {
            selectedSong = song;
            song.play();
        }
    }
    if (selectedSong == null) {
        System.out.println("Nummer niet gevonden, probeer opnieuw");
        pressEnterToContinue();
    } else {
        boolean isPlayling = true;
        while (isPlayling) {
            System.out.println("druk 1 om verder te gaan, 2 om te pauzeren, 3 om te skippen of 4 om te stoppen");
            int choiceAction = scanner.nextInt();
            scanner.nextLine();

            if (choiceAction == 1){
                pressEnterToContinue();
                isPlayling = false;
            }
            else if (choiceAction == 2){
                selectedSong.pauze();
                System.out.println("druk 1 om te hervatten");
                int resumeChoice = scanner.nextInt();
                scanner.nextLine();
                if (resumeChoice == 1){
                    selectedSong.play();
                }
            }
            else if (choiceAction == 3)
            {
                selectedSong.skip();
            }
            else {
                selectedSong.stop();
                isPlayling = false;
                pressEnterToContinue();
            }
        }
    }

}

public void showPlaylistPage() {
    Song[] songs = SongLibrary.getAllSongs();
    System.out.println("Playlists");
    System.out.println("typ 1 voor jouw playlisten bekijken, 2 om een afspeellijst te maken en 3 om weg te gaan");
    int choiceAction = scanner.nextInt();
    scanner.nextLine();
    if (choiceAction == 1){
        for (int i = 0; i < playlists.size(); i++) {
            System.out.println((i + 1) + ". " + playlists.get(i).getNaam());
        }

        System.out.println("Kies een playlist:");
        int choicePlaylist =  scanner.nextInt();
        scanner.nextLine();
        if (choicePlaylist < 1 || choicePlaylist > playlists.size()) {
            System.out.println("Ongeldige keuze");
            showPlaylistPage();
            return;
        }

        Playlist selectedPlaylist = playlists.get(choicePlaylist - 1);

        System.out.println("1. Bekijken");
        System.out.println("2. Afspelen");
        System.out.println("3. Aanpassen");
        int choicePlaylistAction = scanner.nextInt();
        scanner.nextLine();

        if (choicePlaylistAction == 1){
            selectedPlaylist.showSongs();
        }
        else if (choicePlaylistAction == 2){
            selectedPlaylist.play();
        }
        else if (choicePlaylistAction == 3) {
            selectedPlaylist.showSongs();
            System.out.println("wil je een nummer toevoegen? druk 1");
            System.out.println("wil je een nummer verwijderen? druk 2");
            int playlistAanpassAction = scanner.nextInt();
            scanner.nextLine();
            if (playlistAanpassAction == 1) {
                System.out.println("welke nummer wil je toevoegen?");
                for (int i = 0; i < songs.length; i++) {
                    System.out.println((i + 1) + ". " + songs[i].getTitle());
                }
                int choiceSong = scanner.nextInt();
                scanner.nextLine();

                if (choiceSong < 1 || choiceSong > songs.length) {
                    System.out.println("Ongeldige keuze");
                    showPlaylistPage();
                    return;
                }

                Song selectedSong = songs[choiceSong - 1];
                selectedPlaylist.addSong(selectedSong);
                System.out.println(selectedSong.getTitle() + " is toegevoegd aan de playlist!");
           showPlaylistPage();
            }

            else if (playlistAanpassAction == 2) {
                for (int i = 0; i < selectedPlaylist.getSongs().size(); i++) {
                    System.out.println((i + 1) + ". " + selectedPlaylist.getSongs().get(i).getTitle());
                }
                System.out.println("welk nummer wil je verwijderen?");
                int choiceSong = scanner.nextInt();
                scanner.nextLine();

                selectedPlaylist.removeSongByIndex(choiceSong - 1);
                System.out.println("Nummer verwijderd!");
                pressEnterToContinue();
            }
        }
        else {
            System.out.println("mm jou input lijkt vekeerd te zijn, druk enter om verder te gaan");
            scanner.nextLine();
            showPlaylistPage();
        }
        showPlaylistPage();
    }
    else if (choiceAction == 2){
        System.out.println("Welkom bij de playlist maker!");
        System.out.println("hoe wil je dat je playlist heet? type cancel123 om het te stoppen");
        String playListNaam = scanner.nextLine();
        if (playListNaam.equals("cancel123")){
            showPlaylistPage();
        }
        else{
            Playlist nieuwePlaylist = new Playlist(playListNaam);
            playlists.add(nieuwePlaylist);
            System.out.println(playListNaam + "... wat een interessante naam voor een playlist! ");
            System.out.println("Maar je nieuwe playlist is aangemaakt! druk enter om verder te gaan");
            scanner.nextLine();
            showPlaylistPage();
        }
    }
    else if (choiceAction == 3) {
       pressEnterToContinue();
    }
    else  {
        System.out.println("er was een fout in de input, je word terug gestuurd naar de playlisten, druk enter om verder te gaan");
        scanner.nextLine();
        showPlaylistPage();
    }


}

    public void showAlbumPage() {
        Album[] albums = AlbumLibrary.getAllAlbums();

        System.out.println("Welkom bij albums");


        for (int i = 0; i < albums.length; i++) {
            System.out.println((i + 1) + ". " + albums[i].getNaam() + " - " + albums[i].getArtiest());
        }

        System.out.println("0. Terug naar hoofdmenu");
        System.out.println("Kies een album:");
        int choiceAlbum = scanner.nextInt();
        scanner.nextLine();
        if (choiceAlbum == 0) {
            return;
        }
        else if (choiceAlbum < 1 || choiceAlbum > albums.length) {
            System.out.println("Ongeldige keuze");
            showAlbumPage();
            return;
        }


        Album selectedAlbum = albums[choiceAlbum - 1];

        System.out.println("1. Bekijken");
        System.out.println("2. Afspelen");
        int choiceAction = scanner.nextInt();
        scanner.nextLine();
        if (choiceAction == 1) {
            selectedAlbum.showSongs();
        }
        else if (choiceAction == 2) {
            selectedAlbum.play();
        }
        else {
            System.out.println("Ongeldige keuze");
        }
        System.out.println("wil je terug naar het hoofdmenu? druk dan 1. wil je verder gaan met albums? druk dan 2");
        int choiceFinish = scanner.nextInt();
        scanner.nextLine();

        if (choiceFinish == 1) {
            pressEnterToContinue();
        }
        else if (choiceFinish == 2) {
            showAlbumPage();
        }
        else {
            System.out.println("Ongeldige keuze");
            showAlbumPage();

        }
    }
public void showArtistPage(){
    System.out.println("Artist");
    System.out.println("hier komen alle albums te staan");
    pressEnterToContinue();
}

public void showProfilePage(){
    System.out.println("Profile");
    System.out.println("hier komt de profile page te staan");
    pressEnterToContinue();
}
public void pressEnterToContinue(){
    System.out.println("druk op enter om terug keren naar de homepagina");
    scanner.nextLine();
}

public void stopApplication(){
    System.out.println("applicatie wordt afgesloten");
    isRunning = false;
    scanner.close();
}

public void showUsersPage(){
    System.out.println();
    System.out.println("GEBRUIKERS");
    System.out.println("1. Bekijk alle gebruikers");
    System.out.println("2. Voeg vriend toe");
    System.out.println("3. Verwijder vriend");
    System.out.println("4. Bekijk vrienden");
    System.out.println("5. Playlist van vriend overnemen");
    System.out.println("0. terug");
    System.out.print("Maak een keuze: ");

    String choice = scanner.nextLine();

    if (choice.equals("1")) {
        showAllUsers();
    }
    else if (choice.equals("2")) {
        addFriend();
    }
    else if (choice.equals("3")) {
        removeFriend();
    }
    else if (choice.equals("4")) {
        showFriends();
    }
    else if (choice.equals("5")) {
        copyFriendPlaylist();
    }
    else if (choice.equals("0")){
        return;
    }
    else {

        System.out.println("Ongeldige invoer.");
        pressEnterToContinue();}

}

public void showAllUsers(){
    System.out.println();
    System.out.println("Alle gebruikers");

    for (int i = 0; i < users.length; i++){
        System.out.println((i + 1) + ". " + users[i].getUsername());
    }

    pressEnterToContinue();
}


public void addFriend(){
System.out.println();
System.out.println("welke gebruiker wil je toevoegen als vriend");

for (int i = 0; i < users.length; i++){
    System.out.println((i + 1) + ". " + users[i].getUsername());
}

System.out.println("maak een keuze");
int choice = Integer.parseInt(scanner.nextLine());

if (choice >= 1 && choice <= users.length) {
    User selectedUser = users[choice - 1];
    friends.add(selectedUser);
    System.out.println(selectedUser.getUsername() + " is toegevoegd als vriend");
} else {
    System.out.println("ongeldige keuze");
}

pressEnterToContinue();

}

public void removeFriend(){
if (friends.isEmpty()){
    System.out.println("je hebt geen vrienden");
    pressEnterToContinue();
    return;
}

System.out.println();
System.out.println("welke vriend wil je verwijderen?");

for (int i = 0; i < friends.size(); i++){
    System.out.println((i + 1) + ". " + friends.get(i).getUsername());
}

System.out.println("maak een keuze");
int choice = Integer.parseInt(scanner.nextLine());


if (choice >= 1 && choice <= friends.size()) {
    User removedFriend = friends.remove(choice - 1);
    System.out.println(removedFriend.getUsername() + " is verwijderd."); 

} else {
    System.out.println("ongeldige keuze ");
}

 pressEnterToContinue();
}

public void showFriends(){
System.out.println();
System.out.println("mijn vrienden:");

if (friends.isEmpty()) {
    System.out.println("je hebt nog geen vrienden");
} else {
    for (int i = 0; i < friends.size(); i++){
        System.out.println((i + 1) + ". " + friends.get(i).getUsername());
    }
}

pressEnterToContinue();
}

public void copyFriendPlaylist(){
    if (friends.isEmpty()) {
        System.out.println("je hebt geen vrienden");
        pressEnterToContinue();
        return;
    }

    System.out.println();
    System.out.println("van welke vriend wil je de playlist overnemen?");

    for( int i = 0; i < friends.size(); i++){

        System.out.println((i + 1) + ". " + friends.get(i).getUsername());
    }

    System.out.println("maak een keuze");
    
    int choice = Integer.parseInt(scanner.nextLine());

    if (choice >= 1 && choice <= friends.size()) {
        User friend = friends.get(choice - 1);
        System.out.println();
    
    System.out.println("Playlist '" + friend.getPlaylistName() + " is overgenomen");
    
    }
}






}