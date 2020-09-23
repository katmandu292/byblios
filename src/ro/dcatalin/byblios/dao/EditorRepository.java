package ro.dcatalin.byblios.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.dcatalin.byblios.entity.BookEntity;
import ro.dcatalin.byblios.entity.EditorEntity;

@Repository
public class EditorRepository implements EditorDao {
/* 
 * Corrected in version 1.2.9
 * supersedes the v1.2.8 by using HQL instead of Native SQL
 *
*/
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void savEditor(EditorEntity editorEntity) {
//		get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
//		save the new/modified AuthorEntity object
		currentSession.saveOrUpdate(editorEntity);
	}

	@Override
	public EditorEntity getEditorById(Integer editorId) {
//		get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
//		create a query to retrieve an Author by his ID
		EditorEntity chgEditor = currentSession.get(EditorEntity.class,editorId);
		return chgEditor;
	}

	@Override
	public List<EditorEntity> getAllEditors() {
//		get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();		
//		create a query
		Query<EditorEntity> theQuery = 
				currentSession.createQuery("from EditorEntity", EditorEntity.class);
//		execute query and get result list
		List<EditorEntity> allEditors = theQuery.getResultList();
//		return the results
		return allEditors;
	}

	@Override
	public void delEditor(Integer editorId) {
		EditorEntity editorToBeDeleted =  getEditorById(editorId);
//		get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
//		create a query to retrieve any attached book to the targeted Editor
		Query<BookEntity> getBooksByEditor = currentSession.createQuery("from BookEntity where theEditor = :editorID", BookEntity.class);
		getBooksByEditor.setParameter("editorID", editorToBeDeleted);
		List<BookEntity> allBooks = getBooksByEditor.getResultList();
//		create a query to erase an Author by his ID
		if ( allBooks.isEmpty() ) {
			Query<?> delQuery = currentSession.createQuery("delete from EditorEntity where EDITOR_ID = :editorID");
			delQuery.setParameter("editorID", editorId);
			delQuery.executeUpdate();
		}
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub

	}

}
