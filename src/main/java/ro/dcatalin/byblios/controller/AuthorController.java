package ro.dcatalin.byblios.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ro.dcatalin.byblios.dao.AuthorShortView;
import ro.dcatalin.byblios.entity.AuthorEntity;
import ro.dcatalin.byblios.entity.EditorEntity;
import ro.dcatalin.byblios.entity.NovelGenre;
import ro.dcatalin.byblios.service.BookService;

@Controller
@RequestMapping("/lib")
public class AuthorController {

//	relates to the JSP file new-author.jsp
	private String formNewAuthorView = "new-author";
	private String pageAuthorDisplay = "show-author";
	private String listPublishersView = "list-editors";
	private String listBookTypesView = "list-genres";
	private String listAuthorsView = "list-authors";

	@Autowired
	private BookService libManager;

	@RequestMapping("/listEditors")
	public String listEditors(Model theModel) {
		List<EditorEntity> allEditors = libManager.getAllEditors();
		theModel.addAttribute("editors",allEditors);
		return listPublishersView;
	}

	@RequestMapping("/listGenres")
	public String listGenres(Model theModel) {
//		get authors from the service layer object
		List<NovelGenre> allNovelTypes = libManager.getAllTypes();
//		add the authors list to the model
		theModel.addAttribute("book_types",allNovelTypes);
		return listBookTypesView;
	}

	@GetMapping("/listAuthors")
	public String listAuthors(Model theModel) {
		List<AuthorShortView> allAuthors = new ArrayList<AuthorShortView>();
		for (AuthorEntity tmpAuthor : libManager.getAllAuthors()) {
			AuthorShortView author = new AuthorShortView(tmpAuthor.getAuthorID(), tmpAuthor.getAuthorName());
			allAuthors.add(author);
		}
		theModel.addAttribute("authors",allAuthors);
		return listAuthorsView;
//		render on the web page this model (file list-authors.jsp)
	}

	@GetMapping("/updateEditor")
	public String formEditorUpdate(@RequestParam("editorID") int Id, Model theModel) {
		EditorEntity chgEditor = libManager.getEditorById(Id);
		theModel.addAttribute("new_editor",chgEditor);
		return "new-editor";
	}

	@GetMapping("/updateNovelType")
	public String formBookTypeUpdate(@RequestParam("genreID") int Id, Model theModel) {
//		get the NovelGenre using the BookService Managing Service
		NovelGenre chgBookType = libManager.getSingleNovelTyp(Id);
//		set NovelGenre as a model attribute to pre-populate the form
		theModel.addAttribute("new_novel_type", chgBookType);
		return "new-type";
	}

	@GetMapping("/updateAuthor")
	public String formAuthUpdate(@RequestParam("authorId") int Id, Model theModel) {
//		get the AuthorEntity using the BookService Managing Service
		AuthorEntity chgAuthor = libManager.getAuthorById(Id);
//		set Author as a model attribute to pre-populate the form
		theModel.addAttribute("new_author", chgAuthor);
		return formNewAuthorView;
	}

	@GetMapping("/showAuthor")
	public String authorPage(@RequestParam("authorId") int iD, Model theModel) {
		AuthorEntity theAuthor = libManager.getAuthorById(iD);
		theModel.addAttribute("author",theAuthor);
		return pageAuthorDisplay;
	}

	@GetMapping("/newEditor")
	public String formNewEditor(Model theModel) {
		EditorEntity newEditor = new EditorEntity();
		theModel.addAttribute("new_editor",newEditor);
		return "new-editor";
	}

	@GetMapping("/newNovelType")
	public String formBookNewType(Model theModel) {
//		get the NovelGenre using the BookService Managing Service
		NovelGenre newBookType = new NovelGenre();
//		set NovelGenre as a model attribute to pre-populate the form
		theModel.addAttribute("new_novel_type", newBookType);
		return "new-type";
	}

	@GetMapping("/newAuthor")
	public String formNewAuthor(Model theModel) {
//		create model attribute to bind form data
		AuthorEntity newAuthor = new AuthorEntity();
		theModel.addAttribute("new_author", newAuthor);
		return formNewAuthorView;
	}

	@PostMapping("/savEditor")
	public String savEditor(@ModelAttribute("new_editor") EditorEntity theEditor) {
//		save the Editor using the BookService Managing Service
		libManager.savEditor(theEditor);
		return "redirect:/lib/listEditors";
	}

	@PostMapping("/savNovelType")
	public String saveBookTYpe(@ModelAttribute("new_novel_type") NovelGenre newBookTYpe) {
		libManager.savNovelTyp(newBookTYpe);
		return "redirect:/lib/listGenres";
	}

	@PostMapping("/savAuthor")
	public String saveCustomer(@ModelAttribute("new_author") AuthorEntity newAuthor) {
		libManager.savAuthor(newAuthor);
		return "redirect:/lib/listAuthors";
	}

	@GetMapping("/delEditor")
	public String delEditor(@RequestParam("editorID") int Id) {
		libManager.delEditor(Id);
		return "redirect:/lib/listEditors";
	}

	@GetMapping("/delNovelType")
	public String delNovelType(@RequestParam("genreID") int theId) {
//		delete a Novel Type
		libManager.delNovelTyp(theId);
		return "redirect:/lib/listGenres";
	}

	@GetMapping("/delAuthor")
	public String deleAuthor(@RequestParam("authorId") int theId) {
//		delete an Author
		libManager.delAuthor(theId);
		return "redirect:/lib/listAuthors";
	}
}
