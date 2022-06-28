package ro.dcatalin.byblios.dao;

import java.util.List;

import ro.dcatalin.byblios.entity.CollectionEntity;

public interface CollectionDAO {

	public void savCollect(CollectionEntity novelType);

	public CollectionEntity getCollectById(Integer NovTypId);

	public List<CollectionEntity> getAllCollections();

	public void delCollect(Integer editorId);

	public void cleanup();
}
