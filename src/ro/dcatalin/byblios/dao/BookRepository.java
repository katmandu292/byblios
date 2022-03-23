package ro.dcatalin.byblios.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.Collection;
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

	@Override
	public void savBook(BookEntity book) {
//		get current hibernate session
		String initialInfo = book.getBookInfo();
		StringBuilder finalInfo = new StringBuilder();
		finalInfo.append(initialInfo);
		while (finalInfo.length()<17) {
			finalInfo.append(' ');	
		}
		book.setBookInfo(finalInfo.toString());
		EditorEntity bookEditor = book.getTheEditor();
		CollectionEntity bookCollection = book.getTheCollection();
//		if by any chance we send an editor which does not comply with the collection
//		then the collection publisher shall become the designated editor of the current book
		if ((bookEditor.getEditorID() != bookCollection.getCollectionPublisher().getEditorID()) &&
				(bookCollection.getCollectionId() != 1323000)) {
			book.setTheEditor(bookCollection.getCollectionPublisher());
		}
		Session currentSession = sessionFactory.getCurrentSession();
//		save the new/modified BookEntity object
		currentSession.saveOrUpdate(book);
	}

	@Override
	public BookEntity getSingleBook(Integer bookId) {
//		get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
//		create a query to retrieve a Book by its ID
		BookEntity retBook = currentSession.get(BookEntity.class,bookId);
		return retBook;
}

	@Override
	public List<BookEntity> getAllBooks() {
//		get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();		
//		create a query
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
		Query delQuery = currentSession.createQuery("delete from BookEntity where VOLUME_ID = :bookID");
		delQuery.setParameter("bookID", bookId);
		delQuery.executeUpdate();
	}

	@Override
	public void cleanup() {
		AuthorEntity firstAuthor = new AuthorEntity("Clive Cussler",1931,"TBD");
		NovelGenre firstType = new NovelGenre("aventura","TBD");
		EditorEntity firstEditor = new EditorEntity("Litera","OP 53, CP 212, Sector 4, Bucuresti, România","TBD");
		CollectionEntity firstCollection = new CollectionEntity("No Collection", firstEditor, 1970, "TBD");
		BookEntity firstBook = new BookEntity("Aurul Spartanilor", "978-606-600-900-3", 2012, "TBD              ",
				firstAuthor, firstType, firstEditor, firstCollection);
		Session currentSession = sessionFactory.getCurrentSession();
		@SuppressWarnings("unused")
		Query delQuery = currentSession.createQuery("delete from BookEntity");
		currentSession.saveOrUpdate(firstBook);
	}

}
