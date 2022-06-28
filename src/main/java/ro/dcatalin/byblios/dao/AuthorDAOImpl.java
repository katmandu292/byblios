package ro.dcatalin.byblios.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.dcatalin.byblios.entity.AuthorEntity;

@Repository
public class AuthorDAOImpl implements AuthorDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void savAuthor(AuthorEntity author) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(author);
	}

	@Override
	public AuthorEntity getAuthorById(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();
		AuthorEntity chgAuthor = currentSession.get(AuthorEntity.class,id);
		return chgAuthor;
	}

	@Override
	public int getAuthorId(AuthorEntity author) {
		return author.getAuthorID();
	}

	@Override
	public void delAuthorById(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<?> delQuery = currentSession.createNativeQuery("delete from tbl_authors A"
															+ "where A.PERS_ID = :autorID");
		delQuery.setParameter("autorID", id);
		delQuery.executeUpdate();
	}

	@Override
	public List<AuthorEntity> getAllAuthors() {
		Session currentSession = sessionFactory.getCurrentSession();
//		create a query
		Query<AuthorEntity> theQuery = 
				currentSession.createNativeQuery("SELECT A.PERS_ID, A.BIRTH_YEAR, A.AUTH_NAME,"
						+ " A.AUTH_BIO FROM tbl_authors A ORDER BY A.PERS_ID", AuthorEntity.class);
		List<AuthorEntity> authors = theQuery.getResultList();
		return authors;
	}

	@Override
	public void cleanup() {
		Session currentSession = sessionFactory.getCurrentSession();

		if (currentSession.isConnected()) {
			Transaction dummyTransaction = currentSession.beginTransaction();
			System.out.println(">>> Cleanup uses Transaction: [" + dummyTransaction.toString() + "]");
		}

		currentSession.close();
	}

}
