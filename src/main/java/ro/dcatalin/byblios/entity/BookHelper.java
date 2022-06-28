package ro.dcatalin.byblios.entity;

public class BookHelper {

	private int bookID;

	private String bookTitle;

	private String codeISBN;

	private int bookPublYear;

	private String bookInfo;

	private int theAuthor;

	private int novelStyle;

	private int theEditor;

	private int bookSeries;

	public BookHelper() {
		super();
	}

	public BookHelper(int bookID, String bookTitle, String codeISBN, int bookPublYear,
			String bookInfo, int theAuthor, int novelStyle,
			int theEditor, int theBookSeries) {
		super();
		this.bookID = bookID;
		this.bookTitle = bookTitle;
		this.codeISBN = codeISBN;
		this.bookPublYear = bookPublYear;
		this.bookInfo = bookInfo;
		this.theAuthor = theAuthor;
		this.novelStyle = novelStyle;
		this.theEditor = theEditor;
		this.bookSeries = theBookSeries;
	}

	public int getBookID() {
		return bookID;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getCodeISBN() {
		return codeISBN;
	}

	public int getBookPublYear() {
		return bookPublYear;
	}

	public String getBookInfo() {
		return bookInfo;
	}

	public int getTheAuthor() {
		return theAuthor;
	}

	public int getNovelStyle() {
		return novelStyle;
	}

	public int getTheEditor() {
		return theEditor;
	}

	public int getBookSeries() {
		return bookSeries;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public void setCodeISBN(String codeISBN) {
		this.codeISBN = codeISBN;
	}

	public void setBookPublYear(int bookPublYear) {
		this.bookPublYear = bookPublYear;
	}

	public void setBookInfo(String bookInfo) {
		this.bookInfo = bookInfo;
	}

	public void setTheAuthor(int theAuthor) {
		this.theAuthor = theAuthor;
	}

	public void setNovelStyle(int novelStyle) {
		this.novelStyle = novelStyle;
	}

	public void setTheEditor(int theEditor) {
		this.theEditor = theEditor;
	}

	public void setBookSeries(int theBookSeries) {
		this.bookSeries = theBookSeries;
	}

	@Override
	public String toString() {
		return "BookHelper [bookID=" + bookID + ", bookTitle=" + bookTitle + ", codeISBN=" + codeISBN
				+ ", bookPublYear=" + bookPublYear + ", theAuthor=" + theAuthor
				+ ", novelStyle=" + novelStyle + ", theEditor=" + theEditor
				+ ", collection=" + bookSeries + "]";
	}

}
