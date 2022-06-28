package ro.dcatalin.byblios.dao;

import java.util.List;

import ro.dcatalin.byblios.entity.EditorEntity;

public interface EditorDao {

	public void savEditor(EditorEntity novelType);

	public EditorEntity getEditorById(Integer NovTypId);

	public List<EditorEntity> getAllEditors();

	public void delEditor(Integer editorId);

	public void cleanup();
}
