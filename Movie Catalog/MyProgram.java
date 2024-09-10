import java.util.Scanner;
import java.util.ArrayList;
public class MyProgram {
    public static void main(String[] args) {
        ArrayList<movie> movielist = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean keepadding = true;
        while(keepadding) {
            System.out.println("Welcome to your movie catalog! To add a movie, type 1. To find a movie, type 2. To filter movies, type 3");
            int useroption = scanner.nextInt();
            scanner.nextLine();
            if (useroption == 1) {
            movie newmovie = new movie();
            movielist.add(newmovie);
            }else if (useroption == 2) {
                for (int i =0; i<movielist.size(); i++) {
                    movie x = movielist.get(i);
                    System.out.println(x.name + ": " + x.genre + ":" + x.rating);
                }
            }else if (useroption == 3) {
                //put array in descending rating order
                for (int i = 0; i < movielist.size()-1; i++) {
                    for (int j = 0; j < movielist.size()-1; j++) {
                        movie x = movielist.get(j);
                        movie y = movielist.get(j+1);
                        if (x.rating < y.rating) {
                            //swap x and y
                            movielist.set(j, y);
                            movielist.set(j + 1, x);
                        }
                    }
                }
                System.out.println("what genre would you like to see?");
                String genrefilter = scanner.nextLine();
                for (int i = 0; i<movielist.size(); i++) {
                    //print all movies with the requested genre
                    movie x = movielist.get(i);
                    if (x.genre.equalsIgnoreCase(genrefilter)) {
                        System.out.println("Name: " + x.name + "  Rating: " + x.rating + "  Genre: " + x.genre + "  Watched: " + x.haveWatched);
                    }
                }
            }
        }
    }
}