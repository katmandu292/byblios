package ro.dcatalin.byblios.services;
import java.util.List;

import ro.dcatalin.byblios.entity.AuthorEntity;
import ro.dcatalin.byblios.entity.BookEntity;
import ro.dcatalin.byblios.entity.CollectionEntity;
import ro.dcatalin.byblios.entity.EditorEntity;
import ro.dcatalin.byblios.entity.NovelGenre;

public interface BookService {
	public List<AuthorEntity> getAllAuthors();
	public List<NovelGenre> getAllTypes();
	public List<EditorEntity> getAllEditors();
	public List<BookEntity> getAllBooks();
	public List<CollectionEntity> getAllCollections();

	public void savAuthor(AuthorEntity theAuthor);
	public void savNovelTyp(NovelGenre novelType);
	public void savEditor(EditorEntity theEditor);
	public void savBook (BookEntity theBook);
	public void savCollection(CollectionEntity col2save);

	public AuthorEntity getAuthorById(int Id);
	public NovelGenre getSingleNovelTyp(int Id);
	public EditorEntity getEditorById(int Id);
	public BookEntity getBookById(int Id);
	public CollectionEntity getCollectionById(int iD);

	public void delAuthor(int Id);
	public void delNovelTyp(int Id);
	public void delEditor(int Id);
	public void delBook(int Id);
	public void delCollection(int iD);
}
