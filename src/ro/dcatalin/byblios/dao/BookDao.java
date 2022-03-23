package ro.dcatalin.byblios.dao;
import java.util.List;
import ro.dcatalin.byblios.entity.BookEntity;

public interface BookDao {

	public void savBook(BookEntity book);

	public BookEntity getSingleBook(Integer bookId);

	public List<BookEntity> getAllBooks();

	public void delBook(Integer bookId);

	public void cleanup();

}
