package nl.mikolajty;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private Scanner scanner;
    private boolean isRunning;
    private User[] users;
    private ArrayList<User> friends;
    private Album[] albums;
    private Artist[] artists;
    

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
        
           albums = new Album[]{
    new Album("After Hours", "The Weeknd", 14),
    new Album("Graduation", "Kanye West", 13),
    new Album("Divide", "Ed Sheeran", 16)
};

    artists = new Artist[]{
    new Artist("The Weeknd", "After Hours", "Blinding Lights"),
    new Artist("Kanye West", "Graduation", "Stronger"),
    new Artist("Ed Sheeran", "Divide", "Shape of You")
};

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
    Song[] songs = {
            new Song("blinding lights", "the weeknd", "pop", 192),
            new Song("kanye yeast", "kanye west", "pop", 213),
            new Song("niggers in paris", "kanye west", "pop", 204)
    };


    System.out.println();
    System.out.println(" Nummers bekijken ");
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

public void showPlaylistPage() {
    System.out.println("Playlists");
    System.out.println("hier komen alle playlists te staan");
    pressEnterToContinue();
}

public void showAlbumPage() {

    while (true) {

        System.out.println();
        System.out.println("=== ALBUMS ===");

        for (int i = 0; i < albums.length; i++) {
            System.out.println((i + 1) + ". " + albums[i].getTitle());
        }

        System.out.println("0. Terug naar homepage");
        System.out.print("Kies een album: ");

        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 0) {
            return;
        }

        if (choice >= 1 && choice <= albums.length) {

            Album selectedAlbum = albums[choice - 1];

            while (true) {

                System.out.println();
                selectedAlbum.showInfo();

                System.out.println("1. Album afspelen");
                System.out.println("2. Nummer opslaan in playlist");
                System.out.println("0. Terug naar album overzicht");
                System.out.print("Maak een keuze: ");

                String option = scanner.nextLine();

                if (option.equals("1")) {

                    System.out.println(
                            selectedAlbum.getTitle()
                                    + " wordt afgespeeld.");

                } else if (option.equals("2")) {

                    System.out.println(
                            "Nummer opgeslagen vanuit album "
                                    + selectedAlbum.getTitle());

                } else if (option.equals("0")) {

                    break;
                } else {

                    System.out.println("Ongeldige keuze.");
                }
            }
        }
    }
}

public void showArtistPage() {

    while (true) {

        System.out.println();
        System.out.println(" ARTIESTEN");

        for (int i = 0; i < artists.length; i++) {
            System.out.println((i + 1) + ". " + artists[i].getName());
        }

        System.out.println("0. Terug naar homepage");
        System.out.print("Kies een artiest: ");

        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 0) {
            return;
        }

        if (choice >= 1 && choice <= artists.length) {

            Artist selectedArtist = artists[choice - 1];

            while (true) {

                System.out.println();
                selectedArtist.showInfo();

                System.out.println("0. Terug naar artiesten overzicht");
                System.out.print("Maak een keuze: ");

                String option = scanner.nextLine();

                if (option.equals("0")) {
                    break;
                } else {
                    System.out.println("Ongeldige keuze.");
                }
            }
        } else {
            System.out.println("Ongeldige keuze.");
        }
    }
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

public void showUsersPage() {

    while (true) {

        System.out.println();
        System.out.println("GEBRUIKERS");
        System.out.println("1. Bekijk alle gebruikers");
        System.out.println("2. Voeg vriend toe");
        System.out.println("3. Verwijder vriend");
        System.out.println("4. Bekijk vrienden");
        System.out.println("5. Playlist van vriend overnemen");
        System.out.println("0. Terug naar homepage");
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
        else if (choice.equals("0")) {
            return;
        }
    }
}

public void showAllUsers() {

    while (true) {

        System.out.println();
        System.out.println("ALLE GEBRUIKERS");

        for (int i = 0; i < users.length; i++) {
            System.out.println((i + 1) + ". " + users[i].getUsername());
        }

        System.out.println();
        System.out.println("0. Terug naar gebruikersmenu");
        System.out.print("Maak een keuze: ");

        String choice = scanner.nextLine();

        if (choice.equals("0")) {
            return;
        }
    }
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

System.out.println();
System.out.println("0. Terug naar gebruikersmenu");
scanner.nextLine();

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

System.out.println();
System.out.println("0. Terug naar gebruikersmenu");
scanner.nextLine();
}

public void showFriends() {

    while (true) {

        System.out.println();
        System.out.println("MIJN VRIENDEN");

        if (friends.isEmpty()) {
            System.out.println("Je hebt nog geen vrienden");
        } else {

            for (int i = 0; i < friends.size(); i++) {
                System.out.println((i + 1) + ". " + friends.get(i).getUsername());
            }
        }

        System.out.println();
        System.out.println("0. Terug naar gebruikersmenu");
        System.out.print("Maak een keuze: ");

        String choice = scanner.nextLine();

        if (choice.equals("0")) {
            return;
        }
    }
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
System.out.println();
System.out.println("0. Terug naar gebruikersmenu");
scanner.nextLine();

}






}