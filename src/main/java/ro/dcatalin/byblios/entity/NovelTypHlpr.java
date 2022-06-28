package ro.dcatalin.byblios.entity;

public class NovelTypHlpr {

    private int genreID;

    private String genreLabel;

	public NovelTypHlpr() {
		super();
	}

	public NovelTypHlpr(int genreID, String genreLabel) {
		super();
		this.genreID = genreID;
		this.genreLabel = genreLabel;
	}

	public int getGenreID() {
		return genreID;
	}

	public String getGenreLabel() {
		return genreLabel;
	}

	public void setGenreID(int genreID) {
		this.genreID = genreID;
	}

	public void setGenreLabel(String genreLabel) {
		this.genreLabel = genreLabel;
	}

	@Override
	public String toString() {
		return "NovelTypHlpr [genreID=" + genreID + ", genreLabel=" + genreLabel + "]";
	}

}
