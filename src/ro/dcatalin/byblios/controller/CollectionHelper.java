package ro.dcatalin.byblios.controller;

public class CollectionHelper {

	private int collectionId;

	private String collectionName;

	private int collectionPublisher;

	private int firstYear;

	private String collectionInfo;

	public CollectionHelper() { }

	public CollectionHelper(int collectionId, String collectionName, 
			int collectionPublisherId, int firstYear, String collectionInfo) {
		super();
		this.collectionId = collectionId;
		this.collectionName = collectionName;
		this.collectionPublisher = collectionPublisherId;
		this.firstYear = firstYear;
		this.collectionInfo = collectionInfo;
	}

	public int getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public int getCollectionPublisher() {
		return collectionPublisher;
	}

	public void setCollectionPublisher(int editorId) {
		this.collectionPublisher = editorId;
	}

	public int getFirstYear() {
		return firstYear;
	}

	public void setFirstYear(int firstYear) {
		this.firstYear = firstYear;
	}

	public String getCollectionInfo() {
		return collectionInfo;
	}

	public void setCollectionInfo(String collectionInfo) {
		this.collectionInfo = collectionInfo;
	}

	@Override
	public String toString() {
		return "BookCollectionHelper [collectionId=" + collectionId + ", collectionName=" + collectionName
				+ ", collectionPublisher=" + collectionPublisher + ", firstYear=" + firstYear + "]";
	}

}
