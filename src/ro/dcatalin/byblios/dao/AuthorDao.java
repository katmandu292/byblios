package ro.dcatalin.byblios.dao;

import java.util.List;
import ro.dcatalin.byblios.entity.AuthorEntity;

public interface AuthorDao {

// Create a record in the authors table
	public void savAuthor(AuthorEntity author);

// Retrieve a single author
	public AuthorEntity getAuthorById(Integer id);

// Retrieve all authors from the table
	public List<AuthorEntity> getAllAuthors();

// Delete a specific author from the table
	public void delAuthorById(Integer id);

	public void cleanup();

}