package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddchanllenge.domain.order.Order;
import com.sofkau.dddchanllenge.domain.order.commands.CheckTshirtAsDone;

public class CheckTshirtAsDoneUseCase extends UseCase<RequestCommand<CheckTshirtAsDone>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CheckTshirtAsDone> checkTshirtAsDoneRequestCommand) {

        var command = checkTshirtAsDoneRequestCommand.getCommand();

        var order = Order.from(command.getOrderId(), retrieveEvents());

        order.checkTshirtAsDone(command.getTshirtId());

        emit().onResponse(new ResponseEvents(order.getUncommittedChanges()));

    }
}
