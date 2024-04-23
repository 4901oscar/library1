package Interface;

import java.util.List;

public interface CRUD<T> {
    public boolean create(T obj);
    public boolean update(T obj);
    public boolean delete(int id);
    public List<T> list();
}
