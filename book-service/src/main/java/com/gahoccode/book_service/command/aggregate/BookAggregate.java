package com.gahoccode.book_service.command.aggregate;

import com.gahoccode.book_service.command.command.CreateBookCommand;
import com.gahoccode.book_service.command.command.DeleteBookCommand;
import com.gahoccode.book_service.command.command.UpdateBookCommand;
import com.gahoccode.book_service.command.event.BookCreatedEvent;
import com.gahoccode.book_service.command.event.BookDeletedEvent;
import com.gahoccode.book_service.command.event.BookUpdatedEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
@NoArgsConstructor
@Getter
@Setter
public class BookAggregate {

    @AggregateIdentifier
    private String id;
    private String name;
    private String author;
    private Boolean isReady;

    @CommandHandler
    public BookAggregate(CreateBookCommand command){
        BookCreatedEvent bookCreatedEvent = new BookCreatedEvent();
//        BeanUtils.copyProperties(command,bookCreatedEvent);
        bookCreatedEvent.setId(command.getId());
        bookCreatedEvent.setAuthor(command.getAuthor());
        bookCreatedEvent.setName(command.getName());
        bookCreatedEvent.setIsReady(command.getIsReady());

        AggregateLifecycle.apply(bookCreatedEvent);
    }

    @CommandHandler
    public void handle(UpdateBookCommand command){
        BookUpdatedEvent bookUpdatedEvent = new BookUpdatedEvent();
        BeanUtils.copyProperties(command,bookUpdatedEvent);
        AggregateLifecycle.apply(bookUpdatedEvent);
    }

    @CommandHandler
    public void handle(DeleteBookCommand command){
        BookDeletedEvent bookDeletedEvent = new BookDeletedEvent();
        BeanUtils.copyProperties(command,bookDeletedEvent);
        AggregateLifecycle.apply(bookDeletedEvent);
    }


    @EventSourcingHandler
    public void on(BookCreatedEvent event){
        this.id = event.getId();
        this.name = event.getName();
        this.author = event.getAuthor();
        this.isReady = event.getIsReady();
    }

    @EventSourcingHandler
    public void on(BookUpdatedEvent event){
        this.id = event.getId();
        this.name = event.getName();
        this.author = event.getAuthor();
        this.isReady = event.getIsReady();
    }

    @EventSourcingHandler
    public void on(BookDeletedEvent event){
        this.id = event.getId();
    }
}
