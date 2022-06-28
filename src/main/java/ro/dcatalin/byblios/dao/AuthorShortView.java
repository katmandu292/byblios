package ro.dcatalin.byblios.dao;

/*
 * this particular class of objects is meant 
 * to emulate a Data Transfer Object for
 * the AuthorEntity class of objects 
 */
public class AuthorShortView {

	private int authorId;

	private String fullName;

	public AuthorShortView() {
		super();
	}

	public AuthorShortView(int authorId, String fullName) {
		super();
		this.authorId = authorId;
		this.fullName = fullName;
	}

	public int getAuthorId() {
		return authorId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "AuthorShortView [authorId=" + authorId + ", fullName=" + fullName + "]";
	}

}
