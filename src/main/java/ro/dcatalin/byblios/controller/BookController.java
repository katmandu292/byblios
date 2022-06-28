package ro.dcatalin.byblios.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ro.dcatalin.byblios.service.BookService;

import ro.dcatalin.byblios.dao.AuthorShortView;
import ro.dcatalin.byblios.dao.BookShortView;
import ro.dcatalin.byblios.dao.EditorShortView;
import ro.dcatalin.byblios.dao.NovelTypeView;

import ro.dcatalin.byblios.entity.AuthorEntity;
import ro.dcatalin.byblios.entity.BookEntity;
import ro.dcatalin.byblios.entity.BookHelper;
import ro.dcatalin.byblios.entity.CollectionEntity;
import ro.dcatalin.byblios.entity.CollectionHelper;
import ro.dcatalin.byblios.entity.EditorEntity;
import ro.dcatalin.byblios.entity.NovelGenre;

@Controller
@RequestMapping("/book")
public class BookController {
/* this version of the BookTracker application
 * Version 1.5.1
 * in completion to the previous 1.4.2 version
 * has the login security layer set
*/

//	relates to the JSP file books.jsp
	private String listBooksViewName = "books";
	private String newBookFormView = "new-book";
//	relates to the JSP file show-book.jsp
	private String showBookProfile = "show-book";
	private String listBookCollectionsViewName = "list-collects";
	private String showCollectionProfile = "new-book-col";

	@Autowired
	private BookService libManager;

	@RequestMapping("/listBooks")
	public String listBooks(Model theModel) {
		List<BookShortView> allBooks = new ArrayList<BookShortView>();
		for (BookEntity tmpBook : libManager.getAllBooks()) {
			EditorEntity tmpEditor = tmpBook.getTheEditor();
			NovelGenre tmpType = tmpBook.getNovelStyle();
			AuthorEntity tmpLongAuthor = tmpBook.getTheAuthor();
			EditorShortView tmpPublisher = new EditorShortView(tmpEditor.getEditorID(),tmpEditor.getEditorName());
			AuthorShortView tmpShortAuthor = new AuthorShortView(tmpLongAuthor.getAuthorID(),tmpLongAuthor.getAuthorName());
			NovelTypeView tmpNovelType = new NovelTypeView(tmpType.getGenreID(),tmpType.getGenreLabel());
			BookShortView tmpView = new BookShortView(tmpBook.getBookID(),tmpBook.getBookTitle(),tmpBook.getBookPublYear(),tmpShortAuthor,tmpPublisher,tmpNovelType);
			allBooks.add(tmpView);
		}
		theModel.addAttribute("books", allBooks);
		return listBooksViewName;
	}

	@RequestMapping("/somebooks")
	public String listBooksByAuthor(@RequestParam("collectionId") int iD, Model theModel) {
		CollectionEntity bookSeries = libManager.getCollectionById(iD);
		List<BookShortView> someBooks = new ArrayList<BookShortView>();
		for (BookEntity tempBk : libManager.getBooksByCollection(bookSeries)) {
			EditorEntity tmpEditor = tempBk.getTheEditor();
			NovelGenre tmpType = tempBk.getNovelStyle();
			AuthorEntity tmpLongAuthor = tempBk.getTheAuthor();
			EditorShortView tmpPublisher = new EditorShortView(tmpEditor.getEditorID(),tmpEditor.getEditorName());
			AuthorShortView tmpShortAuthor = new AuthorShortView(tmpLongAuthor.getAuthorID(),tmpLongAuthor.getAuthorName());
			NovelTypeView tmpNovelType = new NovelTypeView(tmpType.getGenreID(),tmpType.getGenreLabel());
			someBooks.add(new BookShortView(tempBk.getBookID(),tempBk.getBookTitle(),tempBk.getBookPublYear(),tmpShortAuthor,tmpPublisher,tmpNovelType));
		}
		theModel.addAttribute("books", someBooks);
		return listBooksViewName;
	}

	@RequestMapping("/written")
	public String listBooksByEditor(@RequestParam("authorId") int iD, Model theModel) {
		AuthorEntity theAuthor = libManager.getAuthorById(iD);
		List<BookShortView> someBooks = new ArrayList<BookShortView>();
		for (BookEntity tempBk : libManager.getBooksByAuthor(theAuthor)) {
			EditorEntity tmpEditor = tempBk.getTheEditor();
			NovelGenre tmpType = tempBk.getNovelStyle();
			AuthorEntity tmpLongAuthor = tempBk.getTheAuthor();
			EditorShortView tmpPublisher = new EditorShortView(tmpEditor.getEditorID(),tmpEditor.getEditorName());
			AuthorShortView tmpShortAuthor = new AuthorShortView(tmpLongAuthor.getAuthorID(),tmpLongAuthor.getAuthorName());
			NovelTypeView tmpNovelType = new NovelTypeView(tmpType.getGenreID(),tmpType.getGenreLabel());
			someBooks.add(new BookShortView(tempBk.getBookID(),tempBk.getBookTitle(),tempBk.getBookPublYear(),tmpShortAuthor,tmpPublisher,tmpNovelType));
		}
		theModel.addAttribute("books", someBooks);
		return listBooksViewName;
	}

	@GetMapping("/showBook")
	public String showBook(@RequestParam("bookID") int iD, Model theModel) {
		BookEntity oldBook = libManager.getBookById(iD);
		theModel.addAttribute("oldBook", oldBook);
		return showBookProfile;
	}

	@RequestMapping("/listCollections")
	public String listCollections(Model theModel) {
		List<CollectionEntity> allBookCollections = libManager.getAllCollections();
		theModel.addAttribute("bookColls",allBookCollections);
		return listBookCollectionsViewName;
	}

	@GetMapping("/updateBook")
	public String formBookUpdate(@RequestParam("bookID") int Id, Model theModel) {

		HashMap<Integer, String> theAuthor = new HashMap<Integer, String>();
		HashMap<Integer, String> initialType = new HashMap<Integer, String>();
		HashMap<Integer, String> initialEditor = new HashMap<Integer, String>();
		HashMap<Integer, String> initialCollection = new HashMap<Integer, String>();
		
		HashMap<Integer, String> allStyles = new HashMap<Integer, String>();
		HashMap<Integer, String> allEditors = new HashMap<Integer, String>();
		HashMap<Integer, String> allNames = new HashMap<Integer, String>();
		HashMap<Integer, String> bookCollections = new HashMap<Integer, String>();

		BookEntity changedBookEntity = libManager.getBookById(Id);
		AuthorEntity initialAuthor = changedBookEntity.getTheAuthor();
		CollectionEntity initialPartOf = changedBookEntity.getBookSeries();

		String authName = initialAuthor.getAuthorName();
		Integer authorID = initialAuthor.getAuthorID();
		List<AuthorEntity> allAuthors = libManager.getAllAuthors();
		theAuthor.put(authorID, authName);

		for (AuthorEntity tmpWriter : allAuthors) {
			if ( tmpWriter.getAuthorID() != authorID ) {
				allNames.put(tmpWriter.getAuthorID(), tmpWriter.getAuthorName());
			}
		}

		NovelGenre initialStyle = changedBookEntity.getNovelStyle();
		Integer styleID = initialStyle.getGenreID();
		String bookType = initialStyle.getGenreLabel();
		initialType.put(styleID, bookType);
		List<NovelGenre> allBookTYpes = libManager.getAllTypes();
		Integer styleNbr = changedBookEntity.getNovelStyle().getGenreID();

		for (NovelGenre tempStyle : allBookTYpes) {
			if ( tempStyle.getGenreID() != styleNbr ) {
				allStyles.put(tempStyle.getGenreID(), tempStyle.getGenreLabel());
			}
		}

		List<EditorEntity> allPublishers = libManager.getAllEditors();
		EditorEntity firstPublishedBy = changedBookEntity.getTheEditor();
		Integer publisherID = firstPublishedBy.getEditorID();
		String publisherName = firstPublishedBy.getEditorName();
		initialEditor.put(publisherID, publisherName);

		for (EditorEntity tempEditor : allPublishers) {
			if ( tempEditor.getEditorID()!= publisherID ) {
				allEditors.put(tempEditor.getEditorID(), tempEditor.getEditorName());
			}
		}

		List<CollectionEntity> allCollections = libManager.getAllCollections();
		String initialCollectionName = initialPartOf.getCollectionName();
		Integer initialCollectionId = initialPartOf.getCollectionId();
		HashMap<Integer,String> initialBookCollection = new HashMap<Integer,String>();
		initialBookCollection.put(initialCollectionId,initialCollectionName);
		initialCollection.put(initialCollectionId,initialCollectionName);

		for (CollectionEntity tmpBookSeries : allCollections) {
			if (tmpBookSeries.getCollectionId() != initialCollectionId) {
				bookCollections.put(tmpBookSeries.getCollectionId(), tmpBookSeries.getCollectionName());
			}
		}

		BookHelper changedBookModel = new BookHelper(Id,changedBookEntity.getBookTitle(),
				changedBookEntity.getCodeISBN(), changedBookEntity.getBookPublYear(),
				changedBookEntity.getBookInfo(),authorID, styleID,publisherID,initialCollectionId);
		theModel.addAttribute("initialAuth",theAuthor);
		theModel.addAttribute("authorList", allNames);
		theModel.addAttribute("initialEditor", initialEditor);
		theModel.addAttribute("publishers", allEditors);
		theModel.addAttribute("initialType",initialType);
		theModel.addAttribute("novelTypes", allStyles);
		theModel.addAttribute("collection",initialBookCollection);
		theModel.addAttribute("bookCollections",bookCollections);
		theModel.addAttribute("newBook", changedBookModel);
		return newBookFormView;
	}

	@GetMapping("/updateCollection")
	public String formBookSeriesUpd(@RequestParam("bookSeriesId") int Id, Model theModel) {
		HashMap<Integer, String> initialEditor = new HashMap<Integer, String>();
		HashMap<Integer, String> allEditors = new HashMap<Integer, String>();
		CollectionEntity bookCol2update = libManager.getCollectionById(Id);
		List<EditorEntity> allPublishers = libManager.getAllEditors();
		EditorEntity firstPublishedBy = bookCol2update.getCollectionPublisher();
		initialEditor.put(firstPublishedBy.getEditorID(), firstPublishedBy.getEditorName());
		for (EditorEntity tmpEditor : allPublishers) {
			if (tmpEditor.getEditorID() != firstPublishedBy.getEditorID()) {
				allEditors.put(tmpEditor.getEditorID(), tmpEditor.getEditorName());
			}
		}
		theModel.addAttribute("initialEditor", initialEditor);
		theModel.addAttribute("publishers", allEditors);
		theModel.addAttribute("bookColls", bookCol2update);
		return showCollectionProfile;
	}

	@GetMapping("/newBook")
	public String formNewBook(Model theModel) {
		BookHelper newBook = new BookHelper();
//		this form will have to contain all authors, publishers and genres
		List<AuthorEntity> allAuthors = libManager.getAllAuthors();
//		List<AuthorHelper> allShortAuthors = new ArrayList<AuthorHelper>();
		HashMap<Integer, String> allNames = new HashMap<Integer, String>();
		for (AuthorEntity tmpWriter : allAuthors) {
			allNames.put(tmpWriter.getAuthorID(), tmpWriter.getAuthorName());
//			AuthorHelper tmpAuthor = new AuthorHelper(tmpWriter.getAuthorID(),tmpWriter.getAuthorName());
//			allShortAuthors.add(tmpAuthor);
		}
		List<NovelGenre> allStyles = libManager.getAllTypes();
		HashMap<Integer, String> allBookTypes = new HashMap<Integer, String>();
		for (NovelGenre tempStyle : allStyles) {
			allBookTypes.put(tempStyle.getGenreID(), tempStyle.getGenreLabel());
		}
		List<EditorEntity> allPublishers = libManager.getAllEditors();
		HashMap<Integer, String> allEditors = new HashMap<Integer, String>();
		for (EditorEntity tempEditor : allPublishers) {
			allEditors.put(tempEditor.getEditorID(), tempEditor.getEditorName());
		}
		List<CollectionEntity> allBookSeries = libManager.getAllCollections();
		HashMap<Integer, String> allCollections = new HashMap<Integer, String>();
		for (CollectionEntity tmpBookSeries : allBookSeries) {
			allCollections.put(tmpBookSeries.getCollectionId(), tmpBookSeries.getCollectionName());
		}
		theModel.addAttribute("newBook", newBook);
		theModel.addAttribute("authorList", allNames);
		theModel.addAttribute("novelTypes",allBookTypes);
		theModel.addAttribute("bookCollections",allCollections);
		theModel.addAttribute("publishers", allEditors);
		return newBookFormView;
	}

	@GetMapping("/newCollection")
	public String formNewBookCollection(Model theModel) {
		CollectionEntity newBookColl = new CollectionEntity();
		HashMap<Integer, String> allEditors = new HashMap<Integer, String>();
		List<EditorEntity> allPublishers = libManager.getAllEditors();
		for (EditorEntity tmpEditor : allPublishers) {
			allEditors.put(tmpEditor.getEditorID(), tmpEditor.getEditorName());
		}
		theModel.addAttribute("bookColls", newBookColl);
		theModel.addAttribute("publishers",allEditors);
		return showCollectionProfile;
	}

	@PostMapping("/savBook")
	public String savBook(@ModelAttribute("newBook") BookHelper theBook) {
//		attention to the data collected through the Save Form
//		integer values cannot successfully replace the complex Objects
//		like Author, Editor or Novel Genre
		EditorEntity theEditor = libManager.getEditorById(theBook.getTheEditor());
		AuthorEntity theAuthor = libManager.getAuthorById(theBook.getTheAuthor());
		NovelGenre theNovelStyle = libManager.getSingleNovelTyp(theBook.getNovelStyle());
		CollectionEntity theBookSeries = libManager.getCollectionById(theBook.getBookSeries());
		int bookID = theBook.getBookID();

		if (bookID == 0) {
			BookEntity bookToSave = new BookEntity( theBook.getBookTitle(),
												 theBook.getCodeISBN(),
												 theBook.getBookPublYear(),
												 theBook.getBookInfo(),
												 theAuthor, theNovelStyle,
												 theEditor, theBookSeries);
			libManager.savBook(bookToSave);
		} else {
			BookEntity bookToSave = libManager.getBookById(theBook.getBookID());
			bookToSave.setBookTitle(theBook.getBookTitle());
			bookToSave.setCodeISBN(theBook.getCodeISBN());
			bookToSave.setBookPublYear(theBook.getBookPublYear());
			bookToSave.setBookInfo(theBook.getBookInfo());
			bookToSave.setTheAuthor(theAuthor);
			bookToSave.setNovelStyle(theNovelStyle);
			bookToSave.setTheEditor(theEditor);
			bookToSave.setBookSeries(theBookSeries);
			libManager.savBook(bookToSave);
		}

		return "redirect:/book/listBooks";
	}

	@PostMapping("/savBookCollection")
	public String savBookCollection(@ModelAttribute("bookColls") CollectionHelper booksCollection) {
//		attention to the data collected through the Save Form
		EditorEntity theEditor = libManager.getEditorById(booksCollection.getCollectionPublisher());
		int collectionId = booksCollection.getCollectionId();

		if (collectionId == 0) {
			CollectionEntity collectionToSave = new CollectionEntity(booksCollection.getCollectionName(),
					                                                                         theEditor,
					                                                      booksCollection.getFirstYear(),
					                                                booksCollection.getCollectionInfo());
			libManager.savCollection(collectionToSave);
		} else {
			CollectionEntity collectionToSave = libManager.getCollectionById(booksCollection.getCollectionId());
			collectionToSave.setCollectionName(booksCollection.getCollectionName());
			collectionToSave.setCollectionPublisher(theEditor);
			collectionToSave.setFirstYear(booksCollection.getFirstYear());
			collectionToSave.setCollectionInfo(booksCollection.getCollectionInfo());
			libManager.savCollection(collectionToSave);
		};
		return "redirect:/book/listCollections";
	}

	@GetMapping("/delBook")
	public String delBook(@RequestParam("bookID") int Id) {
		libManager.delBook(Id);
		return "redirect:/lib/listBooks";
	}

	@GetMapping("delBookCollection")
	public String delBookCollection(@RequestParam("bookSeriesId") int iD) {
		libManager.delCollection(iD);
		return "redirect:/book/listCollections";
	}
}
