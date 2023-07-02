package f.l.challenge.dao;

import f.l.challenge.exception.EntityDoesNotExistException;

public interface EntityDAO<T, ID> {

    T findById(ID entityId) throws EntityDoesNotExistException;

    T create(T entity);

    T update(ID entityId,
             T entity) throws EntityDoesNotExistException;

    T delete(ID entityId) throws EntityDoesNotExistException;

}
