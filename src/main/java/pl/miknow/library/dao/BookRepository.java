package pl.miknow.library.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.miknow.library.dao.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
