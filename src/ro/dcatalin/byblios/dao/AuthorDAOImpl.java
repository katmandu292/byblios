package ro.dcatalin.byblios.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import ro.dcatalin.byblios.entity.AuthorEntity;
import ro.dcatalin.byblios.entity.BookEntity;

@Repository
public class AuthorDAOImpl implements AuthorDao {
//  injecting my SessionFactory (lecture )
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void savAuthor(AuthorEntity author) {
//		get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
//		save the new/modified AuthorEntity object
		currentSession.saveOrUpdate(author);
	}

	@Override
	public AuthorEntity getAuthorById(Integer id) {
//		get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
//		create a query to retrieve an Author by his ID
		AuthorEntity chgAuthor = currentSession.get(AuthorEntity.class,id);
		return chgAuthor;
	}

	@Override
	public void delAuthorById(Integer authorID) {
//		get the current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
//		create query to retrieve any attached book to the targeted Author
		AuthorEntity authorToBeDeleted = getAuthorById(authorID);
		Query<BookEntity> getBooksByAuthor = currentSession.createQuery("from BookEntity where theAuthor = :delAuthor", BookEntity.class);
		getBooksByAuthor.setParameter("delAuthor", authorToBeDeleted);
//		execute query and get result list
		List<BookEntity> allBooks = getBooksByAuthor.getResultList();
//		create a query to erase an Author by his ID
		Query<?> delQuery = currentSession.createNativeQuery("delete from TBL_AUTHORS where PERS_ID = :autorID");
		delQuery.setParameter("autorID", authorID);
		if (allBooks.isEmpty()) {
			delQuery.executeUpdate();
		}
	}

	@Override
	public List<AuthorEntity> getAllAuthors() {
//		get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();		
//		create a query
		Query<AuthorEntity> theQuery = 
				currentSession.createNativeQuery("SELECT A.PERS_ID, A.BIRTH_YEAR, A.AUTH_NAME, A.AUTH_BIO FROM TBL_AUTHORS A ORDER BY A.PERS_ID", AuthorEntity.class);
//		execute query and get result list
		List<AuthorEntity> authors = theQuery.getResultList();
//		return the results
		return authors;
	}

	@Override
	public void cleanup() {
//		TODO Auto-generated method stub
	}

}
