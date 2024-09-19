import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.Serializable;
public class MyProgram {
	@SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<movie> movielist = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean keepadding = true;
		String filename = "movies.txt";
        while(keepadding) {
            System.out.println("Welcome to your movie catalog! To add a movie, type 1. To find a movie, type 2. To filter movies, type 3");
            int useroption = scanner.nextInt();
            scanner.nextLine();
            if (useroption == 1) {
            movie newmovie = new movie();
            System.out.println("What is the name of this movie? ");
            newmovie.name = scanner.nextLine();
            System.out.println("What is the genre of this movie? ");
            newmovie.genre = scanner.nextLine();
            System.out.println("Have you seen this movie before");
            newmovie.placeholder = scanner.nextLine();
            if (newmovie.placeholder.equalsIgnoreCase ("yes")) {
                newmovie.haveWatched = true;
                System.out.println("What is your rating of this movie? ");
                newmovie.rating = scanner.nextDouble();
            }else if (newmovie.placeholder.equalsIgnoreCase ("no")) {
                newmovie.haveWatched = false;
                newmovie.rating = 0.0;
            }else {
                System.out.println("Invalid response");
                newmovie.haveWatched = false; 
            }
            movielist.add(newmovie);
            try (FileOutputStream fileOut = new FileOutputStream(filename);
                 ObjectOutputStream out = new ObjectOutputStream(fileOut))
                {
                    out.writeObject(movielist);
                    System.out.println("Movie saved successfully.");
                }
            catch(IOException ioe) {
              System.out.println("Error saving to file");
            }
            }else if (useroption == 2) {
                // while(filescan.hasNextLine()) {
                //     String data = filescan.nextLine();
                //     System.out.println(data);
                // }
                ArrayList<movie>  e;
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename)))
                {
					e = (ArrayList<movie>) input.readObject(); 
					for (int i = 0; i<e.size(); i++) {
						movie j = e.get(i);
						j.print(j);
					}
					input.close();
                }catch(IOException ioe) {
                    System.out.println("error reading file");
                }catch(ClassNotFoundException CNFE) {
                    System.out.println("Object is not a movie");
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
                        x.print(x);
                    }
                }
            }
        }
    }
}
