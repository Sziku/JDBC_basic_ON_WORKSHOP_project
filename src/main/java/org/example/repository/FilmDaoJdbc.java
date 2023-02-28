package org.example.repository;

import org.example.model.Film;
import org.example.model.enums.Rating;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilmDaoJdbc implements FilmDao{

    static final String DB_TYPE = "jdbc:postgresql";

    static final String ADDRESS = "localhost";

    static final int PORT = 5432;

    static final String DB_NAME = "dvdrental";

    static final String DB_URL = DB_TYPE + "://" + ADDRESS + ":" + PORT + "/" + DB_NAME;

    static final String USER = "postgres";

    static final String PASS = "784512";


    @Override
    public List<Film> getAllFilms() {
        final String SQL = "SELECT film_id, title, description, release_year, language_id, rental_duration," +
                "rental_rate, length, replacement_cost, rating, last_update, special_features FROM film;";

        try(Connection con = DriverManager.getConnection(DB_URL, USER, PASS)) {
            PreparedStatement st = con.prepareStatement(SQL);

            ResultSet rs = st.executeQuery();
            List<Film> films = new ArrayList<>();

            while(rs.next()){
                Film film = new Film();

                film.setFilmId(rs.getInt(1));
                film.setTitle(rs.getString(2));
                film.setDescription(rs.getString(3));
                film.setReleaseYear(rs.getInt(4));
                film.setLanguageId(rs.getInt(5));
                film.setRentalDuration(rs.getInt(6));
                film.setRentalRate(rs.getDouble(7));
                film.setLength(rs.getInt(8));
                film.setReplacementCost(rs.getDouble(9));
                film.setRating(getRating(rs.getString(10)));
                film.setLastUpdate(rs.getDate(11));
                film.setSpecialFeatures(getSpecialFeatures(rs.getString(12)));

                films.add(film);
            }

            return films;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private List<String> getSpecialFeatures(String string) {
        return Arrays.asList(string.split(","));
    }

    private Rating getRating(String string) {
        return switch (string){
            case "G" -> Rating.G;
            case "PG" -> Rating.PG;
            case "PG-13" -> Rating.PG13;
            case "NC-17" -> Rating.NC17;
            case "R" -> Rating.R;
            default -> Rating.R;
        };
    }
}
