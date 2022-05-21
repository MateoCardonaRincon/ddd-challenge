package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddchanllenge.domain.order.Order;
import com.sofkau.dddchanllenge.domain.order.commands.CreateOrder;

public class CreateOrderUseCase extends UseCase<RequestCommand<CreateOrder>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateOrder> createOrderRequestCommand) {

        var command = createOrderRequestCommand.getCommand();

        var order = new Order(command.getOrderId(), command.getDateOfOrder());

        emit().onResponse(new ResponseEvents(order.getUncommittedChanges()));
    }
}
