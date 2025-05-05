package com.gahoccode.book_service.command.aggregate;

import com.gahoccode.book_service.command.command.CreateBookCommand;
import com.gahoccode.book_service.command.event.BookCreatedEvent;
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


    @EventSourcingHandler
    public void on(BookCreatedEvent event){
        this.id = event.getId();
        this.name = event.getName();
        this.author = event.getAuthor();
        this.isReady = event.getIsReady();
    }
}
