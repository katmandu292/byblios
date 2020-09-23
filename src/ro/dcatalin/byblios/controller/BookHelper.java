package ro.dcatalin.byblios.controller;

public class BookHelper {
	/*
	 * an Eclipse Project implementing the Hibernate functionality and demonstration
	 * the usage of a personal library management model Version 1.2.9 under Eclipse
	 * Neon 1.0 the most significant object in this project, the Book, was
	 * implemented in version 1.2.8 here the initial model is enriched with a Simple
	 * Book class for handling the JSP requests towards the AllMightyController
	 */
	private int bookID;

	private String bookTitle;

	private String codeISBN;

	private int bookPublYear;

	private String bookInfo;

	private int theAuthor;

	private int novelStyle;

	private int theEditor;

	private int theCollection;

	public BookHelper() {
		super();
	}

	public BookHelper(int bookID, String bookTitle, String codeISBN, int bookPublYear, String bookInfo, int theAuthor,
			int novelStyle, int theEditor) {
		super();
		this.bookID = bookID;
		this.bookTitle = bookTitle;
		this.codeISBN = codeISBN;
		this.bookPublYear = bookPublYear;
		this.bookInfo = bookInfo;
		this.theAuthor = theAuthor;
		this.novelStyle = novelStyle;
		this.theEditor = theEditor;
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

	public int getTheAuthor() {
		return theAuthor;
	}

	public void setTheAuthor(int theAuthor) {
		this.theAuthor = theAuthor;
	}

	public int getNovelStyle() {
		return novelStyle;
	}

	public void setNovelStyle(int novelStyle) {
		this.novelStyle = novelStyle;
	}

	public int getTheEditor() {
		return theEditor;
	}

	public void setTheEditor(int theEditor) {
		this.theEditor = theEditor;
	}

	public int getTheCollection() {
		return theCollection;
	}

	public void setTheCollection(int theCollection) {
		this.theCollection = theCollection;
	}

	@Override
	public String toString() {
		return "BookSimple [bookID: " + bookID + ", bookTitle: " + bookTitle + ", codeISBN: " + codeISBN
				+ ", bookPublYear: " + bookPublYear + ", bookInfo: " + this.getBookInfo().substring(1, 32)
				+ ", theAuthorID: " + theAuthor + ", novelStyleID: " + novelStyle + ", theEditorID: " + theEditor + "]";
	}

}