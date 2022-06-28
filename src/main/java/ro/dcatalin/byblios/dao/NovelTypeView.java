package ro.dcatalin.byblios.dao;

/*
 * this particular class of objects is meant 
 * to emulate a Data Transfer Object for
 * the NovelGenre class of objects 
 */
public class NovelTypeView {

	private int genreId;

	private String genreLabel;

	public NovelTypeView() {
		super();
	}

	public NovelTypeView(int genreId, String genreLabel) {
		super();
		this.genreId = genreId;
		this.genreLabel = genreLabel;
	}

	public int getGenreId() {
		return genreId;
	}

	public String getGenreLabel() {
		return genreLabel;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public void setGenreLabel(String genreLabel) {
		this.genreLabel = genreLabel;
	}

	@Override
	public String toString() {
		return "NovelTypeView [genreId=" + genreId + ", genreLabel=" + genreLabel + "]";
	}

}
