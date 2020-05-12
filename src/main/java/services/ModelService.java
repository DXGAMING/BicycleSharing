package services;

import dao.DataBaseApi;
import dao.util.HibernateSessionFactoryUtil;
import models.AbstractModel;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class ModelService<T extends AbstractModel> implements DataBaseApi<T>
{

	@Override
	public void save(final T value)
	{
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(value);
		tx.commit();
		session.close();
	}

	@Override
	public void update(final T value)
	{
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(value);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(final T value)
	{
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(value);
		tx.commit();
		session.close();
	}

	@Override
	public T findById(final Class<T> type ,final String id)
	{
		return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(type,id);
	}
}
