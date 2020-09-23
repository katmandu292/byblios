package ro.dcatalin.byblios.dao;
import java.util.List;
//port javax.sql.DataSource;

import ro.dcatalin.byblios.entity.NovelGenre;

public interface NovelGnDao {

	public void savNovelTyp(NovelGenre novelType);

	public NovelGenre getSingleNovelTyp(Integer NovTypId);

	public List<NovelGenre> getAllGenres();

	public void delNovelTyp(Integer NovTypId);

	public void cleanup();
}
