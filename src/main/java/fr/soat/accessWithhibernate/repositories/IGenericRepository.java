package fr.soat.accessWithhibernate.repositories;

import java.util.List;

public interface IGenericRepository<E, PK> {

	void create(E entity);

	void update(E entity);

	void delete(E entity);

	E findOneEntityById(Class<E> clazz, PK id);

	List<E> findAllEntities(Class<E> clazz);
}
