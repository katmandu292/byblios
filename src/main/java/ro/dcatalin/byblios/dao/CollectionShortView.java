package ro.dcatalin.byblios.dao;

/*
 * this particular class of objects is meant 
 * to emulate a Data Transfer Object for
 * the CollectionEntity class of objects 
 */
public class CollectionShortView {

	private int collectionId;

	private String collectionName;

	private int releaseYear;

	private EditorShortView thePublisher;

	public CollectionShortView() {
		super();
	}

	public CollectionShortView(int collectionId, String collectionName, int releaseYear, EditorShortView thePublisher) {
		super();
		this.collectionId = collectionId;
		this.collectionName = collectionName;
		this.releaseYear = releaseYear;
		this.thePublisher = thePublisher;
	}

	public int getCollectionId() {
		return collectionId;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public EditorShortView getThePublisher() {
		return thePublisher;
	}

	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public void setThePublisher(EditorShortView thePublisher) {
		this.thePublisher = thePublisher;
	}

	@Override
	public String toString() {
		return "CollectionShortView [collectionId=" + collectionId + ", collectionName="
					+ collectionName + ", releaseYear=" + releaseYear + ", thePublisher="
					+ thePublisher.getEditorName() + "]";
	}

}
