package nl.mikolajty;

import java.util.Scanner;

public class Client {
    private Scanner scanner;
    private boolean isRunning;

    public Client() {
        this.scanner = new Scanner(System.in);
        isRunning = true;
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
        showProfilePage();
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
    Song song1 = new Song(" blinding lights", " the weeknd", " pop");
    Song song2 = new Song(" kanye yeast", " kanye west", " pop");
    Song song3 = new Song(" Niggers in paris", " kanye west", " pop");

    System.out.println();
    System.out.println("=== Nummers bekijken ===");
    System.out.println();

    song1.showInfo();
    song2.showInfo();
    song3.showInfo();
    pressEnterToContinue();
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

}