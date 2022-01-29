
public class MinutesFilter implements Filter {
    private int minMinutes;
    private int maxMinutes;
    
    public MinutesFilter(int minMin, int maxMin) {
        minMinutes = minMin;
        maxMinutes = maxMin;
    }
    
    @Override
    public boolean satisfies(String id) {
        return ((MovieDatabase.getMinutes(id) >= minMinutes) &&
        (MovieDatabase.getMinutes(id) <= maxMinutes));
    }

}
