package ro.dcatalin.byblios.entity;

public class EditorHelper {

    private int editorID;

    private String editorName;

	public EditorHelper() {
		super();
	}

	public EditorHelper(int editorID, String editorName) {
		super();
		this.editorID = editorID;
		this.editorName = editorName;
	}

	public int getEditorID() {
		return editorID;
	}

	public String getEditorName() {
		return editorName;
	}

	public void setEditorID(int editorID) {
		this.editorID = editorID;
	}

	public void setEditorName(String editorName) {
		this.editorName = editorName;
	}

	@Override
	public String toString() {
		return "EditorHelper [editorID=" + editorID + ", editorName=" + editorName + "]";
	}

}
