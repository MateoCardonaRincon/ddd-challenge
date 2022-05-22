package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.dddchanllenge.domain.order.Tshirt;
import com.sofkau.dddchanllenge.domain.order.commands.CreateOrder;
import com.sofkau.dddchanllenge.domain.order.events.OrderCreated;
import com.sofkau.dddchanllenge.domain.order.values.Completed;
import com.sofkau.dddchanllenge.domain.order.values.DateOfOrder;
import com.sofkau.dddchanllenge.domain.order.values.Price;
import com.sofkau.dddchanllenge.domain.order.values.TshirtId;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class CreateOrderUseCaseTest {

    @Test
    void createOrder(){
        var command = new CreateOrder(
                OrderId.of("o123"),
                new DateOfOrder(LocalDate.now()));

        var useCase = new CreateOrderUseCase();

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("The order could not be created"))
                .getDomainEvents();

        var event = (OrderCreated) events.get(0);
        Assertions.assertEquals(command.getDateOfOrder().value(), event.getDateOfOrder().value());
        Assertions.assertEquals(new Completed().value(), event.getCompleted().value());
    }

}