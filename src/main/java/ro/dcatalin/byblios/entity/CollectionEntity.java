package ro.dcatalin.byblios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_collections")
public class CollectionEntity {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="COLLECTION_ID")
	 private int collectionId;

	 @Column(name="COLLECTION_NAME")
	 private String collectionName;

	 @ManyToOne
	 @JoinColumn(name="COLLECTION_PUBL")
	 private EditorEntity collectionPublisher;

	 @Column(name="COLLECTION_YEAR")
	 private int firstYear;

	 @Column(name="COLLECTION_INFO")
	 private String collectionInfo;

	public CollectionEntity() {
		super();
	}

	public CollectionEntity(int collectionId, String collectionName, 
			EditorEntity collectionPublisher, int firstYear, String collectionInfo) {
		super();
		this.collectionId = collectionId;
		this.collectionName = collectionName;
		this.collectionPublisher = collectionPublisher;
		this.firstYear = firstYear;
		this.collectionInfo = collectionInfo;
	}

	public CollectionEntity(String collectionName, EditorEntity collectionPublisher, int firstYear, String collectionInfo) {
		super();
		this.collectionName = collectionName;
		this.collectionPublisher = collectionPublisher;
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

	public EditorEntity getCollectionPublisher() {
		return collectionPublisher;
	}

	public void setCollectionPublisher(EditorEntity collectionPublisher) {
		this.collectionPublisher = collectionPublisher;
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
		return "CollectionEntity [collectionId=" + collectionId + ", collectionName=" + collectionName
				+ ", collectionInfo=" + collectionInfo.substring(1,16) + "]";
	}
}
