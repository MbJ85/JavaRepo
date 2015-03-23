package fr.soat.accessWithhibernate.repositories;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class GenericRepository<E extends Serializable, PK extends Serializable>
		implements IGenericRepository<E, PK> {

	@PersistenceContext
	EntityManager entityManager;


	@Transactional
	public void create(E entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(E entity) {
		entityManager.merge(entity);
	}

	@Override
	public void delete(E entity) {
		entityManager.remove(entity);
	}

	@Override
	public E findOneEntityById(Class<E> clazz, PK id) {
		return entityManager.find(clazz, id);
	}

	@Override
	public List<E> findAllEntities() {
		return entityManager.f;
	}

}
