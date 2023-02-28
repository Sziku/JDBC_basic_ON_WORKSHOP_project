package org.example.model;

import lombok.*;
import org.example.model.enums.Rating;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    private int filmId;
    private String title;
    private String description;
    private int releaseYear;
    private int languageId;
    private int rentalDuration;
    private double rentalRate;
    private int length;
    private double replacementCost;
    private Rating rating;
    private Date lastUpdate;
    private List<String> specialFeatures;

    @Override
    public String toString() {
        return "Film: " +
                "filmId: " + filmId +
                ", title: + title +" +
                " description='" + description +
                ", releaseYear=" + releaseYear +
                ", languageId=" + languageId +
                ", rentalDuration=" + rentalDuration +
                ", rentalRate=" + rentalRate +
                ", length=" + length +
                ", replacementCost=" + replacementCost +
                ", rating=" + rating +
                ", lastUpdate=" + lastUpdate +
                ", specialFeatures=" + specialFeatures;
    }
}