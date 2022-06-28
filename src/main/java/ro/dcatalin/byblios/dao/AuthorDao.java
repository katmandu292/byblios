package ro.dcatalin.byblios.dao;

import java.util.List;

import ro.dcatalin.byblios.entity.AuthorEntity;

public interface AuthorDao {

	public void savAuthor(AuthorEntity author);

	public AuthorEntity getAuthorById(Integer id);

	public int getAuthorId(AuthorEntity author);

	public List<AuthorEntity> getAllAuthors();

	public void delAuthorById(Integer id);

	public void cleanup();
}
