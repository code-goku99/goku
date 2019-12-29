package deepu.proj.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;

import deepu.proj.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
	

}
