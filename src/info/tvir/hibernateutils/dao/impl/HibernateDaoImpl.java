package info.tvir.hibernateutils.dao.impl;

import info.tvir.hibernateutils.dao.IDao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class HibernateDaoImpl<T, ID extends Serializable > implements IDao<T, ID>{
	
	private Class<T> entityClass;
	protected HibernateTemplate template;
	
	protected HibernateDaoImpl(Class<T> persistClass){
		this.entityClass = persistClass;
	}
	
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public ID create(T entity) {
		return (ID) template.save(entity);
	}

	@Override
	@Transactional
	public void delete(T entity) {
		template.delete(entity);		
	}

	@Override
	@Transactional
	public void deleteAll(Collection<T> entities) {
		template.deleteAll(entities);		
	}
		
	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public T findById(ID id){
		return (T) template.get(this.entityClass, id);
	}
	
	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")	
	public List<T> findAll(T exampleEntity, int startIndex, int fetchSize) {
		return template.findByExample(exampleEntity, startIndex, fetchSize);
	}	

	@Override
	@Transactional
	public void update(T entity) {
		template.update(entity);		
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
}
