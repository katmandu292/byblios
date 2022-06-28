package ro.dcatalin.byblios.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.dcatalin.byblios.entity.AuthorEntity;
import ro.dcatalin.byblios.entity.BookEntity;
import ro.dcatalin.byblios.entity.CollectionEntity;
import ro.dcatalin.byblios.entity.EditorEntity;
import ro.dcatalin.byblios.entity.NovelGenre;

@Repository
public class BookRepository implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private AuthorDao author;

	@Autowired
	private CollectionDAO bookSeries;

	@Override
	public void savBook(BookEntity book) {
		Session currentSession = sessionFactory.getCurrentSession();
		CollectionEntity theCollection = book.getBookSeries();
		if (theCollection.getCollectionId()!=1323000) {
			book.setTheEditor(theCollection.getCollectionPublisher());
		}
//		save the new/modified BookEntity object
		currentSession.saveOrUpdate(book);
	}

	@Override
	public BookEntity getSingleBook(Integer bookId) {
		Session currentSession = sessionFactory.getCurrentSession();
//		create a query to retrieve a Book by its ID
		BookEntity retBook = currentSession.get(BookEntity.class,bookId);
		return retBook;
	}

	@Override
	public List<BookEntity> getBooksByAuthor(int authorId) {
		Session currentSession = sessionFactory.getCurrentSession();
		AuthorEntity theAuthor = author.getAuthorById(authorId);
		if (theAuthor == null) {
			return null;
		} else {
			Query<BookEntity> theQuery = 
					currentSession.createQuery("from BookEntity where theAuthor=:theAuthor", BookEntity.class);
				theQuery.setParameter("theAuthor", theAuthor);
				return theQuery.getResultList();
		}
	}

	@Override
	public List<BookEntity> getAllBooks() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<BookEntity> theQuery = 
				currentSession.createQuery("from BookEntity", BookEntity.class);
//		execute query and get result list
		List<BookEntity> allBooks = theQuery.getResultList();
//		return the results
		return allBooks;
	}

	@Override
	public void delBook(Integer bookId) {
//		get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
//		create a query to erase a Book by his ID
		Query<?> delQuery = currentSession.createQuery("delete from BookEntity where VOLUME_ID = :bookID");
		delQuery.setParameter("bookID", bookId);
		delQuery.executeUpdate();
	}

	@Override
	public void cleanup() {
		AuthorEntity firstAuthor = new AuthorEntity("Clive Cussler",1931,"TBD");
		NovelGenre firstType = new NovelGenre("aventura","TBD");
		EditorEntity firstEditor = new EditorEntity("No Name", "Empty Field", "Empty Field");
		EditorEntity literaPubl = new EditorEntity("Litera","OP 53, CP 212, Sector 4, Bucuresti, România","TBD");
		CollectionEntity nullCollection = new CollectionEntity("NoName", firstEditor, 1850, "Empty Field for filling out unknown collection situation");
		BookEntity firstBook = new BookEntity("Aurul Spartanilor","978-606-600-900-3",2012,"TBD",firstAuthor,firstType,literaPubl, nullCollection);
		Session currentSession = sessionFactory.getCurrentSession();
		@SuppressWarnings("unused")
		Query<?> delQuery = currentSession.createQuery("delete from BookEntity");
		currentSession.saveOrUpdate(firstBook);
	}

	@Override
	public List<BookEntity> getBooksByCollection(int bookSeriesId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CollectionEntity theBookSeries = bookSeries.getCollectById(bookSeriesId);
		if (theBookSeries == null) {
			return null;
		} else {
			Query<BookEntity> theQuery = 
					currentSession.createQuery("from BookEntity where bookSeries=:theContainer", BookEntity.class);
			theQuery.setParameter("theContainer", theBookSeries);
			return theQuery.getResultList();
		}
	}

}
