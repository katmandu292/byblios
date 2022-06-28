package ro.dcatalin.byblios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_editors")
public class EditorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EDITOR_ID")
    private int editorID;

    @Column(name="EDITOR_NAME")
    private String editorName;

    @Column(name="ADDRESS")
    private String editorBase;

    @Column(name="EDITOR_INFO")
    private String editorInfo;

    public EditorEntity() {
    	
    }
    public EditorEntity(String editorName, String editorBase, String editorInfo) {
        this.editorName = editorName;
        this.editorBase = editorBase;
        this.editorInfo = editorInfo;
    }
	public int getEditorID() {
		return editorID;
	}
	public void setEditorID(int editorID) {
		this.editorID = editorID;
	}
	public String getEditorName() {
		return editorName;
	}
	public void setEditorName(String editorName) {
		this.editorName = editorName;
	}
	public String getEditorBase() {
		return editorBase;
	}
	public void setEditorBase(String editorBase) {
		this.editorBase = editorBase;
	}
	public String getEditorInfo() {
		return editorInfo;
	}
	public void setEditorInfo(String editorInfo) {
		this.editorInfo = editorInfo;
	}
	@Override
	public String toString() {
		return "EditorEntity [editorID: " + editorID + ", editorName: " + editorName + ", Adress: " + editorBase
				+ ", About: " + editorInfo + "]";
	}

}
