package nl.mikolajty;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private Scanner scanner;
    private boolean isRunning;
    private User[] users;
    private ArrayList<User> friends;
    

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

public void showAlbumPage(){
    System.out.println("Albums");
    System.out.println("hier komen alle albums te staan");
    pressEnterToContinue();
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