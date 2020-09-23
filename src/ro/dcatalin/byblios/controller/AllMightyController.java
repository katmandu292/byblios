package ro.dcatalin.byblios.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ro.dcatalin.byblios.entity.AuthorEntity;
import ro.dcatalin.byblios.entity.BookEntity;
import ro.dcatalin.byblios.entity.CollectionEntity;
import ro.dcatalin.byblios.entity.EditorEntity;
import ro.dcatalin.byblios.entity.NovelGenre;
import ro.dcatalin.byblios.services.BookService;

@Controller
@RequestMapping("/lib")
public class AllMightyController {
/* this very first version of the BookTracker application
 * Version 1.4.0 
 * in completion to the previous 1.3.2 version
 * this one has the latest entity - the Book Collection
*/

//  inject the complex service object (operates on all entities)
	@Autowired
	private BookService libManager;
	@Value("${application.title}")
	private String applicationTitle;

	@RequestMapping("/listBooks")
	public String listBooks(Model theModel) {
		List<BookEntity> allBooks = libManager.getAllBooks();
		for (BookEntity tempBk : allBooks) {
			String shortInfo = tempBk.getBookInfo();
			if (shortInfo.length()>16) {
				tempBk.setBookInfo(shortInfo.substring(0,15)+"...");
			}
		}
		theModel.addAttribute("books", allBooks);
		return "books";
	}


	@RequestMapping("/listAuthors")
	public String listAuthors(Model theModel) {
//		get authors from the service layer object
		List<AuthorEntity> allAuthors = libManager.getAllAuthors();
//		add the authors list to the model
		theModel.addAttribute("authors",allAuthors);
//		return the name of the JSP page that would actually
		return "list-authors";
//		render on the web page this model (file list-authors.jsp)
	}

	@RequestMapping("/listGenres")
	public String listGenres(Model theModel) {
//		get authors from the service layer object
		List<NovelGenre> allNovelTypes = libManager.getAllTypes();
//		add the authors list to the model
		theModel.addAttribute("book_types",allNovelTypes);
		return "list-genres";
	}

	@RequestMapping("/listEditors")
	public String listEditors(Model theModel) {
		List<EditorEntity> allEditors = libManager.getAllEditors();
		theModel.addAttribute("editors",allEditors);
		return "list-editors";
	}

	@RequestMapping("/listCollections")
	public String listCollecttions(Model theModel) {
		List<CollectionEntity> allBookCollections = libManager.getAllCollections();
		theModel.addAttribute("bookColls",allBookCollections);
		return "list-collects";
	}

	@GetMapping("/checkInAuthor")
	public String showFormForAddAuthor(Model theModel) {
//		create model attribute to bind form data
		AuthorEntity newAuthor = new AuthorEntity();
		theModel.addAttribute("new_author", newAuthor);
		return "new-author";
	}

	@GetMapping("/checkOutAuthor")
	public String formAuthUpdate(@RequestParam("authorId") int Id, Model theModel) {
//		get the AuthorEntity using the BookService Managing Service
		AuthorEntity chgAuthor = libManager.getAuthorById(Id);
//		set Author as a model attribute to pre-populate the form
		theModel.addAttribute("new_author", chgAuthor);
		return "new-author";
	}

	@GetMapping("/checkInNovelTyp")
	public String showFormForAddType(Model theModel) {
		// create model attribute to bind form data
		NovelGenre newNovelTyp = new NovelGenre();
		theModel.addAttribute("new_novel_type", newNovelTyp);
		return "new-type";
	}

	@GetMapping("/checkOutNovelTyp")
	public String formBookTypeUpdate(@RequestParam("genreID") int Id, Model theModel) {
//		get the NovelGenre using the BookService Managing Service
		NovelGenre chgBookType = libManager.getSingleNovelTyp(Id);
//		set NovelGenre as a model attribute to pre-populate the form
		theModel.addAttribute("new_novel_type", chgBookType);
		return "new-type";
	}

	@GetMapping("/checkInEditor")
	public String showFormForAddEditor(Model theModel) {
		EditorEntity newEditor = new EditorEntity();
		theModel.addAttribute("new_editor",newEditor);
		return "new-editor";
	}

	@GetMapping("/ckeckOutEditor")
	public String formEditorUpdate(@RequestParam("editorID") int Id, Model theModel) {
		EditorEntity chgEditor = libManager.getEditorById(Id);
		theModel.addAttribute("new_editor",chgEditor);
		return "new-editor";
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
		return "new-book-col";
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
		return "new-book-col";
	}

	@GetMapping("/addBook")
	public String showFormForAddBook(Model theModel) {
		BookEntity newBook = new BookEntity();
//		this form will have to contain all authors, publishers and genres
		List<AuthorEntity> allAuthors = libManager.getAllAuthors();
		HashMap<Integer, String> allNames = new HashMap<Integer, String>();
		for (AuthorEntity tmpWriter : allAuthors) {
			allNames.put(tmpWriter.getAuthorID(), tmpWriter.getAuthorName());
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
		List<CollectionEntity> allBookCollections = libManager.getAllCollections();
		HashMap<Integer, String> allColls = new HashMap<Integer, String>();
		for (CollectionEntity tempCollection : allBookCollections) {
			allColls.put(tempCollection.getCollectionId(), tempCollection.getCollectionName());
		}
		theModel.addAttribute("new_book", newBook);
		theModel.addAttribute("authorList", allNames);
		theModel.addAttribute("novelTypes",allBookTypes);
		theModel.addAttribute("publishers", allEditors);
		theModel.addAttribute("bookCollections", allColls);
		return "new-book";
	}

	@GetMapping("/updateBook")
	public String formBookUpdate(@RequestParam("bookID") int iD, Model theModel) {

		HashMap<Integer, String> theAuthor = new HashMap<Integer, String>();
		HashMap<Integer, String> initialType = new HashMap<Integer, String>();
		HashMap<Integer, String> initialEditor = new HashMap<Integer, String>();
		HashMap<Integer, String> initialCollector = new HashMap<Integer, String>();
		
		HashMap<Integer, String> allStyles = new HashMap<Integer, String>();
		HashMap<Integer, String> allEditors = new HashMap<Integer, String>();
		HashMap<Integer, String> allNames = new HashMap<Integer, String>();
		HashMap<Integer, String> allBookCollections = new HashMap<Integer, String>();

		BookEntity chgBook = libManager.getBookById(iD);
		AuthorEntity initialAuthor = chgBook.getTheAuthor();
		@SuppressWarnings("unused")
		EditorEntity initialPublisher = chgBook.getTheEditor();

		String authName = initialAuthor.getAuthorName();
		Integer authorID = initialAuthor.getAuthorID();
		List<AuthorEntity> allAuthors = libManager.getAllAuthors();
		theAuthor.put(authorID, authName);

		for (AuthorEntity tmpWriter : allAuthors) {
			if ( tmpWriter.getAuthorID() != authorID ) {
				allNames.put(tmpWriter.getAuthorID(), tmpWriter.getAuthorName());
			}
		}

		NovelGenre initialStyle = chgBook.getNovelStyle();
		Integer styleID = initialStyle.getGenreID();
		String bookType = initialStyle.getGenreLabel();
		initialType.put(styleID, bookType);
		List<NovelGenre> allBookTYpes = libManager.getAllTypes();
		Integer styleNbr = chgBook.getNovelStyle().getGenreID();

		for (NovelGenre tempStyle : allBookTYpes) {
			if ( tempStyle.getGenreID() != styleNbr ) {
				allStyles.put(tempStyle.getGenreID(), tempStyle.getGenreLabel());
			}
		}

		List<EditorEntity> allPublishers = libManager.getAllEditors();
		EditorEntity firstPublishedBy = chgBook.getTheEditor();
		Integer publisherID = firstPublishedBy.getEditorID();
		String publisherName = firstPublishedBy.getEditorName();
		initialEditor.put(publisherID, publisherName);

		for (EditorEntity tempEditor : allPublishers) {
			if ( tempEditor.getEditorID()!= publisherID ) {
				allEditors.put(tempEditor.getEditorID(), tempEditor.getEditorName());
			}
		}

		CollectionEntity initialBelongingTo = chgBook.getTheCollection();
		Integer collectId = initialBelongingTo.getCollectionId();
		String bookCollection = initialBelongingTo.getCollectionName();
		initialCollector.put(collectId, bookCollection);

		for (CollectionEntity tmpBookColl : libManager.getAllCollections()) {
			if (tmpBookColl.getCollectionId() != collectId) {
				allBookCollections.put(tmpBookColl.getCollectionId(), tmpBookColl.getCollectionName());
			}
		}

		theModel.addAttribute("authorList", allNames);
		theModel.addAttribute("initialAuth",theAuthor);
		theModel.addAttribute("initialType",initialType);
		theModel.addAttribute("novelTypes", allStyles);
		theModel.addAttribute("initialEditor", initialEditor);
		theModel.addAttribute("publishers", allEditors);
		theModel.addAttribute("collection",initialCollector);
		theModel.addAttribute("bookCollections", allBookCollections);
		theModel.addAttribute("new_book", chgBook);
		return "new-book";
	}

	@GetMapping("/showAuthor")
	public String showAuthor(@RequestParam("authorId") int theId, Model theModel) {
		AuthorEntity theAuthor = libManager.getAuthorById(theId);
		theModel.addAttribute("old_author", theAuthor);
		return "show-author";
	}

	@GetMapping("/showBook")
	public String showBook(@RequestParam("bookID") int iD, Model theModel) {
		BookEntity oldBook = libManager.getBookById(iD);
		theModel.addAttribute("old_book", oldBook);
		return "show-book";
	}

	@PostMapping("/sav_author")
	public String saveCustomer(@ModelAttribute("new_author") AuthorEntity newAuthor) {
//		save the Author using the BookService Managing Service
		libManager.savAuthor(newAuthor);
		return "redirect:/lib/listAuthors";
	}

	@PostMapping("/sav_novel_type")
	public String saveBookTYpe(@ModelAttribute("new_novel_type") NovelGenre newBookTYpe) {
//		save the NovelGenre using the BookService Managing Service
		libManager.savNovelTyp(newBookTYpe);
		return "redirect:/lib/listGenres";
	}

	@PostMapping("/savEditor")
	public String savEditor(@ModelAttribute("new_editor") EditorEntity theEditor) {
//		save the Editor using the BookService Managing Service
		libManager.savEditor(theEditor);
		return "redirect:/lib/listEditors";
	}

	@GetMapping("/savBookCollection")
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
		return "redirect:/lib/listCollections";
	}

	@PostMapping("/savBook")
	public String savBook(@ModelAttribute("new_book") BookHelper theBook) {
//		attention to the data collected through the Save Form
//		integer values cannot successfully replace the complex Objects
//		like Author, Editor or Novel Genre
		EditorEntity theEditor = libManager.getEditorById(theBook.getTheEditor());
		AuthorEntity theAuthor = libManager.getAuthorById(theBook.getTheAuthor());
		NovelGenre theNovelStyle = libManager.getSingleNovelTyp(theBook.getNovelStyle());
		CollectionEntity theCollection = libManager.getCollectionById(theBook.getTheCollection());
		int bookID = theBook.getBookID();

		if (bookID == 0) {
			BookEntity bookToSave = new BookEntity( theBook.getBookTitle(),
												 theBook.getCodeISBN(),
												 theBook.getBookPublYear(),
												 theBook.getBookInfo(),
												 theAuthor, theNovelStyle,
												 theEditor, theCollection);
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
			bookToSave.setTheCollection(theCollection);
			libManager.savBook(bookToSave);
		}

		return "redirect:/lib/listBooks";
	}

	@GetMapping("/delAuthor")
	public String deleAuthor(@RequestParam("authorId") int theId) {
//		delete an Author
		libManager.delAuthor(theId);
		
		return "redirect:/lib/listAuthors";
	}

	@GetMapping("/delNovelType")
	public String delNovelType(@RequestParam("genreID") int theId) {
//		delete a Novel Type
		libManager.delNovelTyp(theId);
		return "redirect:/lib/listGenres";
	}

	@GetMapping("/delEditor")
	public String delEditor(@RequestParam("editorID") int Id) {
		libManager.delEditor(Id);
		return "redirect:/lib/listEditors";
	}

	@GetMapping("/delBook")
	public String delBook(@RequestParam("bookID") int Id) {
		libManager.delBook(Id);
		return "redirect:/lib/listBooks";
	}

	@GetMapping("delBookCollection")
	public String delBookCollection(@RequestParam("bookSeriesId") int iD) {
		libManager.delCollection(iD);
		return "redirect:/lib/listCollections";
	}
}
