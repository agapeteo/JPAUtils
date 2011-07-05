package info.tvir.hibernateutils.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface IDao<T, ID extends Serializable> {
	
	ID create(T entity);
	
	List<T> findAll(T exampleEntity, int startIndex, int fetchSize);	
	
	T findById(ID id);
	
	void update(T entity);
	
	void delete(T entity);
	
	void deleteAll(Collection<T> entities);

}
