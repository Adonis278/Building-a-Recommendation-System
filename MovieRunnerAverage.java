import java.util.*;
/**
 * Write a description of class MovieRunnerAverage here.
 *
 * @author (J'erome Adonis)
 * @version (12/20/2021)
 */
public class MovieRunnerAverage{
    public void printAverageRatings () {
        SecondRatings sr = new SecondRatings ("ratedmoviesfull", "ratings");

        System.out.println("Total number of movies : " + sr.getMovieSize());
        System.out.println("Total number of raters : " + sr.getRaterSize());

        int minRatings = 20;
        ArrayList<Rating> averageRatings = sr.getAverageRatings(minRatings);
        Collections.sort(averageRatings);
        for (Rating r : averageRatings) {
            System.out.println(r.getValue() + " " + sr.getTitle(r.getItem()));
        }
        System.out.println("There are " + averageRatings.size() + " movies with " +
        minRatings + " or more ratings");
    }

    public void getAverageRatingOneMovie () {
        SecondRatings sr = new SecondRatings ("ratedmoviesfull", "ratings");

        String title = "Vacation"; 
        int minRatings = 1; 

        String movieID = sr.getID(title);
        ArrayList<Rating> averageRatings = sr.getAverageRatings(minRatings);
        for (Rating r : averageRatings) {
            if (r.getItem().equals(movieID)) {
                System.out.println("For movie \"" + title + "\" the average rating is " 
                + r.getValue());
            }
        }
    }
}
