package ro.dcatalin.byblios.entity;

public class AuthorHelper {

	private int authorID;

    private String authorName;

	public AuthorHelper() {
		super();
	}

	public AuthorHelper(int authorID, String authorName) {
		super();
		this.authorID = authorID;
		this.authorName = authorName;
	}

	public int getAuthorID() {
		return authorID;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "AuthorHelper [authorID=" + authorID + ", authorName=" + authorName + "]";
	}

}
