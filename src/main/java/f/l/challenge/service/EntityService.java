package f.l.challenge.service;

public interface EntityService<T, ID> {

    T findById(ID entityId, EntityContext ctx);

    T save(T entity, EntityContext ctx);

    T save(ID entityId, T entity, EntityContext ctx);

    T remove(ID entityId, EntityContext ctx);

}
