import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
/**
 * Write a description of class FirstRatings here.
 *
 * @author (J'erome Adonis)
 * @version (12/23/2021)
 */

    public class FirstRatings {
    public ArrayList<Movie> loadMovies (String filename) {
        FileResource fr = new FileResource("data/ratedmoviesfull.csv");
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        for(CSVRecord record  : fr.getCSVParser()){
            String currID = record.get(0);
            String currTitle = record.get(1);
            String currYear = record.get(2);
            String currCountry = record.get(3);
            String currGenre = record.get(4);
            String currDirector = record.get(5);
            int currMinutes = Integer.parseInt(record.get(6));
            String currPoster = record.get(7);
            
            Movie ml = new Movie(currID, currTitle, currYear, currGenre, currDirector, 
            currCountry, currPoster, currMinutes);
            
            movieList.add(ml);
            
        }
        return movieList;
    }

    public ArrayList<Rater> loadRaters (String filename) {
        ArrayList<Rater> ratersData = new ArrayList<Rater> ();
        ArrayList<String> listOfIDs = new ArrayList<String> ();

        FileResource fr = new FileResource("data/ratings.csv");
        CSVParser parser = fr.getCSVParser();

        for (CSVRecord record : parser) {
            String currentRaterID = record.get(0);
            String currentMovieID = record.get(1);
            double currentMovieRating = Double.parseDouble(record.get(2));

            if (! listOfIDs.contains(currentRaterID)) {
                //Rater currentRater = new PlainRater(currentRaterID);
                Rater currentRater = new EfficientRater(currentRaterID);
                ratersData.add(currentRater);
                currentRater.addRating(currentMovieID, currentMovieRating);

            } else {
                for (int k=0; k < ratersData.size(); k++) {
                    if (ratersData.get(k).getID().equals(currentRaterID)) {
                        ratersData.get(k).addRating(currentMovieID, currentMovieRating);
                    }
                }
            }

            listOfIDs.add(currentRaterID);
        }

        return ratersData;
    }
}





