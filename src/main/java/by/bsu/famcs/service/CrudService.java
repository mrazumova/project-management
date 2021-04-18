package by.bsu.famcs.service;

import java.util.Optional;

public interface CrudService<D> {

    Optional<D> findById(String id);

    D create(D dto);

    D update(D dto, String entityId);

    void delete(D dto);

    void deleteById(String id);

    boolean exists(String id);

}
