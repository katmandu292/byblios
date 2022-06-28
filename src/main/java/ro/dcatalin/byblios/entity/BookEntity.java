package ro.dcatalin.byblios.entity;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="tbl_books")
public class BookEntity {

/*  
 * an Eclipse Project implementing the Hibernate functionality
 * and demonstration the usage of a personal library management model
 * Version 1.2.9 under Eclipse Neon 1.0
 * the most significant object in this project, the Book, was implemented in version 1.2.8
 * here the initial model was restored
 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="VOLUME_ID")
	private int bookID;

	@Column(name="VOL_TITLE")
	private String bookTitle;

	@Column(name="ISBN")
	private String codeISBN;

	@Column(name="LAUNCH_YEAR")
    private int bookPublYear;

    @Column(name="VOL_INFO")
    private String bookInfo;

	@ManyToOne
    @JoinColumn(name="AUTHOR_ID")
    private AuthorEntity theAuthor;

    @ManyToOne
    @JoinColumn(name="GENRE_ID")
    private NovelGenre novelStyle;

    @ManyToOne
    @JoinColumn(name="LAUNCHED_BY")
    private EditorEntity theEditor;

    @ManyToOne
    @JoinColumn(name = "COLLECT_ID")
    private CollectionEntity bookSeries;

    public BookEntity() {
	}

	public BookEntity(String bookTitle, String codeISBN, int bookPublYear,
			String bookInfo, AuthorEntity theAuthor, NovelGenre novelStyleID,
			EditorEntity theEditor, CollectionEntity bookSeries) {
		this.bookTitle = bookTitle;
		this.codeISBN = codeISBN;
		this.bookPublYear = bookPublYear;
		this.bookInfo = bookInfo;
		this.theAuthor = theAuthor;
		this.novelStyle = novelStyleID;
		this.theEditor = theEditor;
		this.bookSeries = bookSeries;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getCodeISBN() {
		return codeISBN;
	}

	public void setCodeISBN(String codeISBN) {
		this.codeISBN = codeISBN;
	}

	public int getBookPublYear() {
		return bookPublYear;
	}

	public void setBookPublYear(int bookPublYear) {
		this.bookPublYear = bookPublYear;
	}

	public String getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(String bookInfo) {
		this.bookInfo = bookInfo;
	}

	public AuthorEntity getTheAuthor() {
		return theAuthor;
	}

	public void setTheAuthor(AuthorEntity theAuthor) {
		this.theAuthor = theAuthor;
	}

	public NovelGenre getNovelStyle() {
		return novelStyle;
	}

	public void setNovelStyle(NovelGenre bookType) {
		this.novelStyle = bookType;
	}

	public EditorEntity getTheEditor() {
		return theEditor;
	}

	public void setTheEditor(EditorEntity theEditor) {
		this.theEditor = theEditor;
	}

	public CollectionEntity getBookSeries() {
		return bookSeries;
	}

	public void setBookSeries(CollectionEntity bookSeries) {
		this.bookSeries = bookSeries;
	}

	@Override
	public String toString() {
		return "BookID: " + bookID + ", Book Title: " + bookTitle + ", ISBN: " + codeISBN
				+ ", Year: " + bookPublYear + ", About: " + bookInfo + ", by " + theAuthor.getAuthorName()
				+ ", as a \"" + novelStyle.getGenreLabel() + "\" novel, Published By " + theEditor.getEditorName();
	}

}
