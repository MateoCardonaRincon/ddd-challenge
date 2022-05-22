package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.dddchanllenge.domain.order.commands.AddTshirt;
import com.sofkau.dddchanllenge.domain.order.events.OrderCreated;
import com.sofkau.dddchanllenge.domain.order.events.TshirtAdded;
import com.sofkau.dddchanllenge.domain.order.values.DateOfOrder;
import com.sofkau.dddchanllenge.domain.order.values.Done;
import com.sofkau.dddchanllenge.domain.order.values.Price;
import com.sofkau.dddchanllenge.domain.order.values.TshirtId;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddTshirtUseCaseTest {

    private final String ROOTID = "xxxxx";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addTshirtToOrder() {

        var command = new AddTshirt(
                OrderId.of(ROOTID),
                TshirtId.of("ts123"),
                new Price(20000.));

        var useCase = new AddTshirtUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new OrderCreated(new DateOfOrder(LocalDate.now()))
        ));

        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("The t-shirt could not be added to the contract"))
                .getDomainEvents();

        var event = (TshirtAdded) events.get(0);

        Assertions.assertEquals(command.getTshirtId().value(), event.getTshirtId().value());
        Assertions.assertEquals(command.getPrice().value(), event.getPrice().value());
        Assertions.assertEquals(new Done().value(), event.getDone().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }

}