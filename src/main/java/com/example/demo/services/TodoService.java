@Override
public Todo getById(long id) {
  Optional < Todo > optional = todoRepository.findById(id);

  if (!optional.isPresent()) {
    throw new RuntimeException(" Todo not found for id :: " + id);
  }

  Todo todo = optional.get();
  return todo;
}

@Override
public void delete(long id) {
  this.todoRepository.deleteById(id);
}