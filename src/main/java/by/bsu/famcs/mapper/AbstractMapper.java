package by.bsu.famcs.mapper;

public abstract class AbstractMapper<E, D> {

    public abstract E toEntity(D dto);

    public abstract D toDto(E entity);

}
