package endri.agung.listfilm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

public class Movie implements Serializable {

        public String title;
        public String description;
        public double rating;
        public int year;

        public Movie(String title,String description, double rating, int year){
            this.title = title;
            this.description = description;
            this.rating =rating;
            this.year=year;
        }
        public String toString(){return this.title;}
    }

