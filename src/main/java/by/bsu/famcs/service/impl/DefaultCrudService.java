package by.bsu.famcs.service.impl;

import by.bsu.famcs.service.CrudService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public abstract class DefaultCrudService<E> implements CrudService<E> {

    @Override
    public Optional<E> findById(String id) {
        return getRepository().findById(id);
    }

    @Override
    public E create(E entity) {
        return getRepository().save(entity);
    }

    @Override
    @Transactional
    public void delete(E entity) {
        getRepository().delete(entity);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        getRepository().deleteById(id);
    }

    @Override
    public boolean exists(String id) {
        return getRepository().existsById(id);
    }

    protected E getEntity(String id) {
        return getRepository().findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id " + id + " not found"));
    }

    protected abstract CrudRepository<E, String> getRepository();

}
