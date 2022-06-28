package ro.dcatalin.byblios.dao;

/*
 * this particular class of objects is meant 
 * to emulate a Data Transfer Object for
 * the EditorEntity class of objects 
 */
public class EditorShortView {

	private int editorId;

	private String editorName;

	public EditorShortView() {
		super();
	}

	public EditorShortView(int editorId, String editorName) {
		super();
		this.editorId = editorId;
		this.editorName = editorName;
	}

	public int getEditorId() {
		return editorId;
	}

	public String getEditorName() {
		return editorName;
	}

	public void setEditorId(int editorId) {
		this.editorId = editorId;
	}

	public void setEditorName(String editorName) {
		this.editorName = editorName;
	}

	@Override
	public String toString() {
		return "EditorShortView [editorId=" + editorId + ", editorName=" + editorName + "]";
	}
}
