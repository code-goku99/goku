package deepu.proj.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;

import deepu.proj.spring5webapp.model.Books;

public interface BookRepository extends CrudRepository<Books, Long> {

}
