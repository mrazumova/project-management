package by.bsu.famcs.service.impl;

import by.bsu.famcs.mapper.AbstractMapper;
import by.bsu.famcs.service.CrudService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public abstract class DefaultCrudService<E, D> implements CrudService<D> {

    protected AbstractMapper<E, D> mapper;

    public DefaultCrudService(AbstractMapper<E, D> mapper) {
        this.mapper = mapper;
    }

    @Override
    public Optional<D> findById(String id) {
        Optional<E> entity = getRepository().findById(id);
        return entity.map(e -> mapper.toDto(e));
    }

    @Override
    public D create(D dto) {
        E entity = mapper.toEntity(dto);
        return mapper.toDto(getRepository().save(entity));
    }

    @Override
    @Transactional
    public void delete(D dto) {
        getRepository().delete(mapper.toEntity(dto));
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
