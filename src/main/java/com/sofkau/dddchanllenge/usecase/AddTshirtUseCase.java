package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddchanllenge.domain.order.Order;
import com.sofkau.dddchanllenge.domain.order.commands.AddTshirt;

public class AddTshirtUseCase extends UseCase<RequestCommand<AddTshirt>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddTshirt> addTshirtRequestCommand) {

        var command = addTshirtRequestCommand.getCommand();

        var order = Order.from(command.getOrderId(), retrieveEvents());

        order.addTshirt(command.getTshirtId(), command.getPrice());

        emit().onResponse(new ResponseEvents(order.getUncommittedChanges()));
    }
}
