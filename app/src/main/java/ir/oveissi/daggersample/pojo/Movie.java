package ir.oveissi.daggersample.pojo;

/**
 * Created by Abbas on 25/05/2016.
 */
public class Movie {
    public Integer id;
    public String title;
    public String poster;
    public String year;
    public String imdb_rating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImdb_rating() {
        return imdb_rating;
    }

    public void setImdb_rating(String imdb_rating) {
        this.imdb_rating = imdb_rating;
    }
}
