package deepu.proj.spring5webapp.repository.impl;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import deepu.proj.spring5webapp.model.Author;
import deepu.proj.spring5webapp.model.Books;
import deepu.proj.spring5webapp.model.Publisher;
import deepu.proj.spring5webapp.repository.AuthorRepository;
import deepu.proj.spring5webapp.repository.BookRepository;
import deepu.proj.spring5webapp.repository.PublisherRepository;

@Component
public class GKBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	 private AuthorRepository authorRepository;
	    private BookRepository bookRepository;
	    private PublisherRepository pubRepository;

	    /**
		 * @param authorRepository
		 * @param bookRepository
		 * @param pubRepository
		 */
		public GKBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
				PublisherRepository pubRepository) {
			this.authorRepository = authorRepository;
			this.bookRepository = bookRepository;
			this.pubRepository = pubRepository;
		}

	    @Override
	    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
	        initData();
	    }

		private void initData() {
			Publisher pub = new Publisher("PUB1");
			pubRepository.save(pub);
			//Eric
	        Author eric = new Author("Eric", "Evans");
	        Books ddd = new Books("Domain Driven Design", "1234",pub);
	        eric.getBooks().add(ddd);
	        ddd.getAuthor().add(eric);

	        authorRepository.save(eric);
	        bookRepository.save(ddd);


	        //Rod
	        Author rod = new Author("Rod", "Johnson");
	        Books noEJB = new Books("J2EE Development without EJB", "23444", pub);
	        rod.getBooks().add(noEJB);
	        noEJB.getAuthor().add(rod);

	        authorRepository.save(rod);
	        bookRepository.save(noEJB);			
		}

}
