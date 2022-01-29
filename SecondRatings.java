import java.util.ArrayList;
import java.util.*;
import edu.duke.*;

/**
 * Write a description of class SecondRatings here.
 *
 * @author (J'erome Adonis)
 * @version (12/30/2021)
 */
public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        this("data/ratedmoviesfull.csv", "data/ratings.csv");
    }
    public SecondRatings(String movieFile,String ratingsFile){
        FirstRatings fr = new FirstRatings();
        myMovies = fr.loadMovies(movieFile);
        myRaters = fr.loadRaters(ratingsFile);
    }
    public int getMovieSize(){
        return myMovies.size();
    }
    public int getRaterSize(){
        return myRaters.size();
    }
    public double getAverageByID(String id, int minimalRaters){
        double totalRatings = 0.0;
        int cnt = 0;
        for(Rater r : myRaters){
            if(r.hasRating(id)){
                totalRatings += r.getRating(id);
                cnt += 1;
            }
        }
        if(totalRatings >= minimalRaters){
            return totalRatings/cnt;
        }
        else{
            return 0.0;
        }
    }
    public ArrayList<Rating>getAverageRatings(int minimalRaters){
        ArrayList<Rating> movieRatings = new ArrayList<Rating>();
        for(Movie  m : myMovies){
            String movID = m.getID();
            double averageRating = getAverageByID(movID, minimalRaters);
            if (averageRating > 0.0 ){
                Rating r = new Rating(movID, averageRating);
                movieRatings.add(r);
            }
        }
        return movieRatings;
    }
    public String getTitle(String id){
        String theMovie = null;
        for(Movie m : myMovies){
            if(m.getID().equals(id)){
                theMovie = m.getTitle();
            }
        }
        if (theMovie != null){
            return theMovie;
        }
        else{
            return "ID was not found.";
        }
    }
    public String getID(String title){
        String movID = null;
        for (Movie m :myMovies){
            if(m.getTitle().equals(title)){
                movID = m.getID();
            }
        }
        if(movID != null){
            return movID;
        }
        else{
            return "NO SUCH TITLE.";
        }
    }
    
    
}