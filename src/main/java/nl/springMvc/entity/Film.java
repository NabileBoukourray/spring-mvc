package nl.springMvc.entity;

import nl.springMvc.Utils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="film_id")
    private int film_id;
    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;
    @Column(name="special_features")
    private String special_features;
    @Column(name="rating")
    private String rating;
    @Column(name="length")
    private int length;
    @Column(name="release_year")
    private int release_year;
    @Column(name="last_update")
    private Date last_update;
    @Column(name="rental_rate")
    private double rental_rate;
    @Column(name="replacement_cost")
    private double replacement_cost;
    @Column(name="rental_duration")
    private int rental_duration;
    @Column(name="language_id")
    private int language_id;
    @Column(name="original_language_id")
    private int original_language_id;

    public Film() {}

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getLast_update() {
        return Utils.parseDateDMY(last_update);
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public double getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(double rental_rate) {
        this.rental_rate = rental_rate;
    }

    public double getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(double replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    public int getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(int rental_duration) {
        this.rental_duration = rental_duration;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public int getOriginal_language_id() {
        return original_language_id;
    }

    public void setOriginal_language_id(int original_language_id) {
        this.original_language_id = original_language_id;
    }

    @Override
    public String toString() {
        return "Film{" +
                "film_id=" + film_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", special_features='" + special_features + '\'' +
                ", rating='" + rating + '\'' +
                ", length=" + length +
                ", release_year=" + release_year +
                ", last_update=" + last_update +
                ", rental_rate=" + rental_rate +
                ", replacement_cost=" + replacement_cost +
                ", rental_duration=" + rental_duration +
                ", language_id=" + language_id +
                ", original_language_id=" + original_language_id +
                '}';
    }
}
