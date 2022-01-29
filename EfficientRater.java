
/**
 * Write a description of class Rater here.
 * 
 * @author (J'erome Adonis) 
 * @version (12/23/2021)
 */
import java.util.*;

public class EfficientRater implements Rater{
    private String myID;
    private HashMap<String,Rating> myRatings;

    public EfficientRater(String id) {
        myID = id;
        myRatings = new HashMap<String,Rating>();
    }

    public void addRating(String item, double rating) {
        myRatings.put(item,(new Rating(item,rating)));
    }

    public boolean hasRating(String item) {
        //old method without hashmap
        //no reason to return false since it is type boolean, 
        //so i searched item using my hashmap key
        /*/for(int k=0; k < myRatings.size(); k++){
            if (myRatings.get(k).getItem().equals(item)){
                return true;
            }
        }*/
        
        return myRatings.containsKey(item);
    }

    public String getID() {
        return myID;
    }

    public double getRating(String item) {
        //old metho used loop, now we map rating to a certain key.
        /*for(int k=0; k < myRatings.size(); k++){
 
            return myRatings.get(k).getValue();
         }*/
         if(hasRating(item)){
            return myRatings.get(item).getValue();
        }
        else{
            return -1;
        }
    }
    
    public int numRatings() {
        return myRatings.size();
    }

    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>();
        for(int k=0; k < myRatings.size(); k++){
            list.add(myRatings.get(k).getItem());
        }
        
        return list;
    }
}
