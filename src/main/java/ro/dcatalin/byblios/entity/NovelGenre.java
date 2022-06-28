package ro.dcatalin.byblios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_genres")
public class NovelGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="GENRE_ID")
    private int genreID;

    @Column(name="GENRE_LABEL")
    private String genreLabel;

    @Column(name="GENRE_DESCR")
    private String genreInfo;

    public NovelGenre() {
    }

    public NovelGenre(String genreLabel, String genreInfo) {
        this.genreLabel = genreLabel;
        this.genreInfo = genreInfo;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    public String getGenreLabel() {
        return genreLabel;
    }

    public void setGenreLabel(String genreLabel) {
        this.genreLabel = genreLabel;
    }

    public String getGenreInfo() {
        return genreInfo;
    }

    public void setGenreInfo(String genreInfo) {
        this.genreInfo = genreInfo;
    }

    @Override
    public String toString() {
        return "NovelGenre{" +
                "GENRE_ID: " + genreID +
                ", BOOK_TYPE: '" + genreLabel + '\'' +
                ", SHORT_DESCR: '" + genreInfo + '\'' +
                '}';
    }
}
