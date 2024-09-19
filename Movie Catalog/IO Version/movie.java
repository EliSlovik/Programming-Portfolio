import java.util.Scanner;
import java.io.Serializable;
public class movie implements Serializable {
    public double rating;
    public String name;
    public String genre;
    public String placeholder;
    public Boolean haveWatched;
    public String watchedMovies[] = new String[10];
 
    public void print(movie i) {
        System.out.println(i.name + ": " + i.genre + ":" + i.rating + "  Watched: " + i.haveWatched);
    }
}
