package ro.dcatalin.byblios.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.dcatalin.byblios.entity.NovelGenre;

@Repository
public class NovelTypRepository implements NovelGnDao {

//  injecting my SessionFactory (lecture )
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public NovelGenre getSingleNovelTyp(Integer NovTypId) {
		Session currentSession = sessionFactory.getCurrentSession();
		NovelGenre chgNovelType = currentSession.get(NovelGenre.class,NovTypId);
		return chgNovelType;
	}

	@Override
	public List<NovelGenre> getAllGenres() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<NovelGenre> theQuery = 
				currentSession.createQuery("from NovelGenre", NovelGenre.class);
		List<NovelGenre> allNovelTypes = theQuery.getResultList();
		return allNovelTypes;
	}

	@Override
	public void delNovelTyp(Integer NovTypId) {
		Session currentSession = sessionFactory.getCurrentSession();
//		NovelGenre bookType2beDel = getSingleNovelTyp(NovTypId);
//		Query<BookEntity> booksRelated = currentSession.createQuery("from BookEntity where novelStyle = :novTypId",BookEntity.class);
//		booksRelated.setParameter("novTypId", bookType2beDel);
//		List<BookEntity> attachedBooks= booksRelated.getResultList();
		Query<?> delQuery = 
				currentSession.createQuery("delete from NovelGenre where GENRE_ID = :genreID");
		delQuery.setParameter("genreID", NovTypId);
//		if (attachedBooks.isEmpty()) {
			delQuery.executeUpdate();
//		}
	}

	@Override
	public void savNovelTyp(NovelGenre novelType) {
//		get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
//		save the new/modified NovelGenre object
		currentSession.saveOrUpdate(novelType);
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
