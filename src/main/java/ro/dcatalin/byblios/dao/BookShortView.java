package ro.dcatalin.byblios.dao;

/*
 * this particular class of objects is meant to
 * emulate a Data Transfer Object for the BookEntity
 * class of objects 
 */
public class BookShortView {

	private int bookId;

	private String bookTitle;

	private int bookPublYear;

	private AuthorShortView theAuthor;

	private EditorShortView thePublisher;

	private NovelTypeView novelGenre;

	public BookShortView() {
		super();
	}

	public BookShortView(int bookId, String bookTitle, int bookPublYear, AuthorShortView theAuthor,
			EditorShortView thePublisher, NovelTypeView novelGenre) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookPublYear = bookPublYear;
		this.theAuthor = theAuthor;
		this.thePublisher = thePublisher;
		this.novelGenre = novelGenre;
	}

	public int getBookId() {
		return bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public int getBookPublYear() {
		return bookPublYear;
	}

	public AuthorShortView getTheAuthor() {
		return theAuthor;
	}

	public EditorShortView getThePublisher() {
		return thePublisher;
	}

	public NovelTypeView getNovelGenre() {
		return novelGenre;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public void setBookPublYear(int bookPublYear) {
		this.bookPublYear = bookPublYear;
	}

	public void setTheAuthor(AuthorShortView theAuthor) {
		this.theAuthor = theAuthor;
	}

	public void setThePublisher(EditorShortView thePublisher) {
		this.thePublisher = thePublisher;
	}

	public void setNovelGenre(NovelTypeView novelGenre) {
		this.novelGenre = novelGenre;
	}

	@Override
	public String toString() {
		return "BookShortView [bookId=" + bookId + ", bookTitle=" + bookTitle
				+ ", bookPublYear=" + bookPublYear + ", theAuthor="
				+ theAuthor.getFullName() + ", thePublisher="
				+ thePublisher.getEditorName() + ", novelGenre="
				+ novelGenre.getGenreLabel() + "]";
	}

	
}
