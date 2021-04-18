package by.bsu.famcs.mapper.impl;

import by.bsu.famcs.mapper.AbstractMapper;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class DefaultMapper<E, D> extends AbstractMapper<E, D> {

    private final Class<E> entityClass;

    private final Class<D> dtoClass;

    @Autowired
    protected ModelMapper mapper;

    public DefaultMapper(Class<E> entityClass, Class<D> dtoClass) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @Override
    public E toEntity(D dto) {
        return Objects.isNull(dto)
                ? null
                : mapper.map(dto, entityClass);
    }

    @Override
    public D toDto(E entity) {
        return Objects.isNull(entity)
                ? null
                : mapper.map(entity, dtoClass);
    }

    protected Converter<E, D> toDtoConverter() {
        return mappingContext -> {
            E entity = mappingContext.getSource();
            D dto = mappingContext.getDestination();
            specificMapToDto(entity, dto);
            return mappingContext.getDestination();
        };
    }

    protected Converter<D, E> toEntityConverter() {
        return mappingContext -> {
            D dto = mappingContext.getSource();
            E entity = mappingContext.getDestination();
            specificMapToEntity(dto, entity);
            return mappingContext.getDestination();
        };
    }

    void specificMapToDto(E entity, D dto) {
        throw new UnsupportedOperationException();
    }

    void specificMapToEntity(D dto, E entity) {
        throw new UnsupportedOperationException();
    }
}
