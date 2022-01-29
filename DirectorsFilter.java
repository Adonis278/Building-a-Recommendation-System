import java.util.*;
public class DirectorsFilter implements Filter {
    private String directors;
    
    public DirectorsFilter(String mydirector) {
        directors = mydirector;
    }
    
    @Override
    public boolean satisfies(String id) {
        List<String> myDirectors = Arrays.asList(directors.split(","));
        boolean director = false;
        for (String DirectorFromTheList : myDirectors){
            director = director || MovieDatabase.getDirector(id).contains(DirectorFromTheList);
        }
        return director;
    }

}
