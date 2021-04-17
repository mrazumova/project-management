package by.bsu.famcs.service;

import java.util.Optional;

public interface CrudService<D> {

    Optional<D> findById(String id);

    D create(D entity);

    D update(D entity, String entityId);

    void delete(D entity);

    void deleteById(String id);

    boolean exists(String id);

}
