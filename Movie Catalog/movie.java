import java.util.Scanner;
public class movie {
    Scanner scanner = new Scanner(System.in);
    public double rating = 0.0;
    public String name = "";
    public String genre = "";
    public String placeholder = "";
    public Boolean haveWatched = true;
    public String watchedMovies[] = new String[10];
    {
        System.out.println("What is the name of this movie? ");
        name = scanner.nextLine();
        System.out.println("What is the genre of this movie? ");
        genre = scanner.nextLine();
        System.out.println("Have you seen this movie before");
        placeholder = scanner.nextLine();
        if (placeholder.equalsIgnoreCase ("yes")) {
            haveWatched = true;
            System.out.println("What is your rating of this movie? ");
            rating = scanner.nextDouble();
        }else if (placeholder.equalsIgnoreCase ("no")) {
            haveWatched = false;
            rating = 0.0;
        }else {
            System.out.println("Invalid response");
            haveWatched = false; 
        }



    }
}