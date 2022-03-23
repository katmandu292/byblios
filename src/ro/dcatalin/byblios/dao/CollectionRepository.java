package ro.dcatalin.byblios.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.dcatalin.byblios.entity.BookEntity;
import ro.dcatalin.byblios.entity.CollectionEntity;

@Repository
public class CollectionRepository implements CollectionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void savCollect(CollectionEntity collectionEntity) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(collectionEntity);
	}

	@Override
	public CollectionEntity getCollectById(Integer collectId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CollectionEntity chgCollect = currentSession.get(CollectionEntity.class,collectId);
		return chgCollect;
	}

	@Override
	public List<CollectionEntity> getAllCollections() {
		Session currentSession = sessionFactory.getCurrentSession();
		@SuppressWarnings("deprecation")
		Query<CollectionEntity> sqlGetCollections = currentSession.createQuery("from CollectionEntity", CollectionEntity.class);
		List<CollectionEntity> allCollections = sqlGetCollections.getResultList();
		return allCollections;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void delCollect(Integer collectId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CollectionEntity collect2beDel = getCollectById(collectId);
		Query<BookEntity> getBooksByCollection = currentSession.createQuery("from BookEntity where theCollection = :collectID", BookEntity.class);
		getBooksByCollection.setParameter("collectID", collect2beDel);
		List<BookEntity> allBooks =  getBooksByCollection.getResultList();
		Query<?> delQuery = currentSession.createQuery("delete from CollectionEntity where COLLECTION_ID = :collectID");
		if (allBooks.isEmpty()) {
			delQuery.setParameter("collectID", collectId);
			delQuery.executeUpdate();
		}
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
	}
}
