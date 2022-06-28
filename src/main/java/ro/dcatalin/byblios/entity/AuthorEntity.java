package ro.dcatalin.byblios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_authors")
public class AuthorEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PERS_ID")
    private int authorID;

	@Column(name="AUTH_NAME")
    private String authorName;

	@Column(name="BIRTH_YEAR")
    private int authorBirthYear;

	@Column(name="AUTH_BIO")
    private String authorBiography;

    public AuthorEntity() {}

    public AuthorEntity(String authorName, int authorBirthYear, String authorBiography) {
        this.authorName = authorName;
        this.authorBirthYear = authorBirthYear;
        this.authorBiography = authorBiography;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getAuthorBirthYear() {
        return authorBirthYear;
    }

    public void setAuthorBirthYear(int authorBirthYear) {
        this.authorBirthYear = authorBirthYear;
    }

    public String getAuthorBiography() {
        return authorBiography;
    }

    public void setAuthorBiography(String authorBiography) {
        this.authorBiography = authorBiography;
    }

    @Override
    public String toString() {
        return "AuthorEntity{" +
                "authorID: " + authorID +
                ", Name: '" + authorName + '\'' +
                ", Born in: " + authorBirthYear +
                ", Known for: '" + authorBiography + '\'' +
                '}';
    }

}
