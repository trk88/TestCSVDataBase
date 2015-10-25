package by.database.dao;

import by.entity.Entity;

import java.util.List;

/**
 * Created by NotePad.by on 20.10.2015.
 */
public interface EntityDAO {
    void addEntity(Entity entity);
    List<Entity> showEntities(String sortValue);

}
