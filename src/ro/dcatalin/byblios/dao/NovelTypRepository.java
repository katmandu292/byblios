package ro.dcatalin.byblios.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//port ro.dcatalin.byblios.entity.AuthorEntity;
import ro.dcatalin.byblios.entity.BookEntity;
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
		NovelGenre novTypToBeDeleted = getSingleNovelTyp(NovTypId);
		Session currentSession = sessionFactory.getCurrentSession();
//		create a query to retrieve any attached book to the targeted Novel Type
		Query<BookEntity> getBookByNovelType = 
					currentSession.createQuery("from BookEntity where novelStyle = :NovTypID", BookEntity.class);
		getBookByNovelType.setParameter("NovTypID",novTypToBeDeleted);
		List<BookEntity> allBooks = getBookByNovelType.getResultList();
		if ( allBooks.isEmpty() ) {
			Query<?> delQuery = 
				currentSession.createQuery("delete from NovelGenre where GENRE_ID = :genreID");
			delQuery.setParameter("genreID", NovTypId);
			delQuery.executeUpdate();
		}
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
		// TODO Auto-generated method stub
	}

}
