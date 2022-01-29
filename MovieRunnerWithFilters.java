//import java.util.*;
/**
 * Write a description of class MovieRunnerWithFilters here.
 *
 * @author (J'erome Adonis)
 * @version (01/06/22)
 */

    import java.util.*;

public class MovieRunnerWithFilters {
    public void printAverageRatings () {
        ThirdRatings tr = new ThirdRatings ("ratings");
        MovieDatabase.initialize("ratedmoviesfull");

        System.out.println("Read data for " + tr.getRaterSize() + " raters");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        int minRatings = 35;
        ArrayList<Rating> averageRatings = tr.getAverageRatings(minRatings);
        System.out.println("There are " + averageRatings.size() + " movies with " +
        minRatings + " or more rating(s) :");

        Collections.sort(averageRatings);
        for (Rating rating : averageRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printAverageRatingsByYearAfter () {
        ThirdRatings tr = new ThirdRatings ("data/ratings.csv");
        MovieDatabase.initialize("data/ratedmoviesfull.csv");

        System.out.println("Read data for " + tr.getRaterSize() + " raters");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        int year = 2000; 
        YearAfterFilter yaf = new YearAfterFilter (year);

        int minRatings = 20; 
        ArrayList<Rating> averageRatings = tr.getAverageRatingsByFilter(minRatings, yaf);
        System.out.println("There are " + averageRatings.size() + " movies released after "
        + year + " with " + minRatings + " or more rating(s) : ");

        Collections.sort(averageRatings);
        for (Rating rating : averageRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getYear(rating.getItem())
            + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printAverageRatingsByGenre () {
        ThirdRatings tr = new ThirdRatings ("data/ratings.csv");
        MovieDatabase.initialize("data/ratedmoviesfull.csv");

        System.out.println("Read data for " + tr.getRaterSize() + " raters");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        String genre = "Comedy"; 
        GenreFilter gf = new GenreFilter (genre);

        int minRatings = 20; 
        ArrayList<Rating> averageRatings = tr.getAverageRatingsByFilter(minRatings, gf);
        System.out.println("There are " + averageRatings.size() + " movies  in genre of \""
        + genre + "\" with " + minRatings + " or more rating(s) :");

        Collections.sort(averageRatings);
        for (Rating rating : averageRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("Genre(s) : " + MovieDatabase.getGenres(rating.getItem()));
        }
    }

    public void printAverageRatingsByMinutes () {
        ThirdRatings tr = new ThirdRatings ("data/ratings.csv");
        MovieDatabase.initialize("data/ratedmoviesfull.csv");

        System.out.println("Read data for " + tr.getRaterSize() + " raters");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        int minMinutes = 105; 
        int maxMinutes = 135; 
        MinutesFilter mf = new MinutesFilter (minMinutes, maxMinutes);

        int minRatings = 5; 
        ArrayList<Rating> averageRatings = tr.getAverageRatingsByFilter(minRatings, mf);
        System.out.println("There are " + averageRatings.size() + " movies that are between " 
        + minMinutes + " and " + maxMinutes + " length with " + minRatings + " or more rating(s) :");

        Collections.sort(averageRatings);
        for (Rating rating : averageRatings) {
            System.out.println(rating.getValue() + " Time: " + MovieDatabase.getMinutes(rating.getItem())
            + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printAverageRatingsByDirectors () {
        ThirdRatings tr = new ThirdRatings ("data/ratings.csv");
        MovieDatabase.initialize("data/ratedmoviesfull.csv");

        System.out.println("Read data for " + tr.getRaterSize() + " raters");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        String directorsList = "Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack"; 
        DirectorsFilter df = new DirectorsFilter (directorsList);

        int minRatings = 4;  
        ArrayList<Rating> averageRatings = tr.getAverageRatingsByFilter(minRatings, df);
        System.out.println("There are " + averageRatings.size() + " movies that were directed " 
        + "by either of those directors : " +  directorsList + ", with " + minRatings 
        + " or more rating(s) :");

        Collections.sort(averageRatings);
        for (Rating rating : averageRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("Directed by : " + MovieDatabase.getDirector(rating.getItem()));
        }
    }

    public void printAverageRatingsByYearAfterAndGenre () {
        ThirdRatings tr = new ThirdRatings ("data/ratings.csv");
        MovieDatabase.initialize("data/ratedmoviesfull.csv");

        System.out.println("Read data for " + tr.getRaterSize() + " raters");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        int year = 1990; 
        YearAfterFilter yaf = new YearAfterFilter (year);

        String genre = "Drama";
        GenreFilter gf = new GenreFilter (genre);

        AllFilters af = new AllFilters();
        af.addFilter(yaf);
        af.addFilter(gf);

        int minRatings = 8; 
        ArrayList<Rating> avgRatings = tr.getAverageRatingsByFilter(minRatings, af);
        System.out.println("There is(are) " + avgRatings.size() + " movie(s)  in genre of \""
        + genre + "\" that was(were) directed after " + year + " with " + minRatings 
        + " or more rating(s) :");

        Collections.sort(avgRatings);
        for (Rating rating : avgRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getYear(rating.getItem())
            + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("Genre : " + MovieDatabase.getGenres(rating.getItem()));
        }
    }

    public void printAverageRatingsByDirectorsAndMinutes () {
        ThirdRatings tr = new ThirdRatings ("data/ratings.csv");
        MovieDatabase.initialize("data/ratedmoviesfull.csv");

        System.out.println("Read data for " + tr.getRaterSize() + " raters");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        String directorsList = "Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack"; // variable
        DirectorsFilter df = new DirectorsFilter (directorsList);

        int minMinutes = 90; 
        int maxMinutes = 180; 
        MinutesFilter mf = new MinutesFilter (minMinutes, maxMinutes);

        AllFilters af = new AllFilters();
        af.addFilter(df);
        af.addFilter(mf);

        int minRatings = 3; 
        ArrayList<Rating> avgRatings = tr.getAverageRatingsByFilter(minRatings, af);
        System.out.println("There is(are) " + avgRatings.size() + " movie(s) that were filmed by"
        + " either one of these directors : " + directorsList + "; and between " 
        + minMinutes + " and " + maxMinutes + " in length, with " + minRatings
        + " or more rating(s) :"); 

        Collections.sort(avgRatings);
        for (Rating rating : avgRatings) {
            System.out.println(rating.getValue() + " Time: " + MovieDatabase.getMinutes(rating.getItem())
            + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("Directed by : " + MovieDatabase.getDirector(rating.getItem()));
        }
    }
}

