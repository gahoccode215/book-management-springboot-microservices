package com.gahoccode.book_service.command.event;

import com.gahoccode.book_service.command.data.Book;
import com.gahoccode.book_service.command.data.BookRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookEventsHandler {

    @Autowired
    private BookRepository bookRepository;

    @EventHandler
    public void on(BookCreatedEvent event){
        Book book = new Book();
//        BeanUtils.copyProperties(event,book);
        book.setId(event.getId()); // Gán thủ công
        book.setAuthor(event.getAuthor());
        book.setName(event.getName());
        book.setIsReady(event.getIsReady());
        bookRepository.save(book);
    }

    @EventHandler
    public void on(BookUpdatedEvent event){
        Optional<Book> oldBook = bookRepository.findById(event.getId());
        oldBook.ifPresent(book -> {
            book.setName(event.getName());
            book.setAuthor(event.getAuthor());
            book.setIsReady(event.getIsReady());
            bookRepository.save(book);
        });
    }
    @EventHandler
    public void on(BookDeletedEvent event){
        Optional<Book> oldBook = bookRepository.findById(event.getId());
        oldBook.ifPresent(book -> bookRepository.delete(book));
    }
}
