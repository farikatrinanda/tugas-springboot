public interface TodoInterface {
    List<Todo> getAll();
    void store(Todo todo);
    Todo getById(long id);
    void delete(long id);
}