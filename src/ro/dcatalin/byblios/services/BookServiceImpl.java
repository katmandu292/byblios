package ro.dcatalin.byblios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import ro.dcatalin.byblios.dao.AuthorDao;
import ro.dcatalin.byblios.dao.BookDao;
import ro.dcatalin.byblios.dao.CollectionDAO;
import ro.dcatalin.byblios.dao.NovelGnDao;
import ro.dcatalin.byblios.dao.EditorDao;
import ro.dcatalin.byblios.entity.AuthorEntity;
import ro.dcatalin.byblios.entity.BookEntity;
import ro.dcatalin.byblios.entity.CollectionEntity;
import ro.dcatalin.byblios.entity.EditorEntity;
import ro.dcatalin.byblios.entity.NovelGenre;

@Service
public class BookServiceImpl implements BookService {

//	injecting the DAO objects
	@Autowired
	private AuthorDao authorDAO;
	@Autowired
	private NovelGnDao novelTypeDAO;
	@Autowired
	private EditorDao editorDAO;
	@Autowired
	private BookDao bookDAO;
	@Autowired
	private CollectionDAO theCollection;

	@Override
	@Transactional
	public List<AuthorEntity> getAllAuthors() {
		return authorDAO.getAllAuthors();
	}

	@Override
	@Transactional
	public List<NovelGenre> getAllTypes() {
		return novelTypeDAO.getAllGenres();
	}

	@Override
	@Transactional
	public List<EditorEntity> getAllEditors() {
		return editorDAO.getAllEditors();
	}

	@Override
	@Transactional
	public List<BookEntity> getAllBooks() {
		return bookDAO.getAllBooks();
	}

	@Override
	@Transactional
	public void savAuthor(AuthorEntity theAuthor) {
		authorDAO.savAuthor(theAuthor);

	}

	@Override
	@Transactional
	public void savNovelTyp(NovelGenre novelType) {
		novelTypeDAO.savNovelTyp(novelType);
	}

	@Override
	@Transactional
	public void savEditor(EditorEntity theEditor) {
		editorDAO.savEditor(theEditor);
	}

	@Override
	@Transactional
	public void savBook(BookEntity theBook) {
		bookDAO.savBook(theBook);
	}

	@Override
	@Transactional
	public AuthorEntity getAuthorById(int Id) {
		return authorDAO.getAuthorById(Id);
	}

	@Override
	@Transactional
	public NovelGenre getSingleNovelTyp(int novTypId) {
		return novelTypeDAO.getSingleNovelTyp(novTypId);
	}

	@Override
	@Transactional
	public EditorEntity getEditorById(int editorId) {
		return editorDAO.getEditorById(editorId);
	}

	@Override
	@Transactional
	public BookEntity getBookById(int bookId) {
		return bookDAO.getSingleBook(bookId);
	}

	@Override
	@Transactional
	public void delAuthor(int Id) {
		authorDAO.delAuthorById(Id);

	}

	@Override
	@Transactional
	public void delNovelTyp(int novTypId) {
		novelTypeDAO.delNovelTyp(novTypId);

	}

	@Override
	@Transactional
	public void delEditor(int editorId) {
		editorDAO.delEditor(editorId);
	}

	@Override
	@Transactional
	public void delBook(int bookId) {
		bookDAO.delBook(bookId);
	}

	@Override
	@Transactional
	public List<CollectionEntity> getAllCollections() {
		List<CollectionEntity> allBookCollections = theCollection.getAllCollections();
		return allBookCollections;
	}

	@Override
	@Transactional
	public void savCollection(CollectionEntity col2save) {
		theCollection.savCollect(col2save);
	}

	@Override
	@Transactional
	public CollectionEntity getCollectionById(int iD) {
		CollectionEntity collectionEnt = theCollection.getCollectById(iD);
		return collectionEnt;
	}

	@Override
	@Transactional
	public void delCollection(int iD) {
		theCollection.delCollect(iD);
	}
}
