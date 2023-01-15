package array01.data;

public class Movie {
    private final String name;
    private final float rating;
    private final String[] categories;

    public Movie(String name, float rating, String[] categories) {
        this.name = name;
        this.rating = rating;
        this.categories = categories;
    }
}
