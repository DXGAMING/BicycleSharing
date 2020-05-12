package dao;

public interface DataBaseApi<T>
{
		T findById(Class<T> type, String id);
		void save(T value);
		void update(T value);
		void delete(T value);
}
