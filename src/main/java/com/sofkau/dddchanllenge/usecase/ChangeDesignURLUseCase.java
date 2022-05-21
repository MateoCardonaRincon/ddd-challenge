package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddchanllenge.domain.order.Order;
import com.sofkau.dddchanllenge.domain.order.commands.ChangeDesignURL;

public class ChangeDesignURLUseCase extends UseCase<RequestCommand<ChangeDesignURL>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ChangeDesignURL> changeDesignURLRequestCommand) {

        var command = changeDesignURLRequestCommand.getCommand();

        var order = Order.from(command.getOrderId(), retrieveEvents(command.getOrderId().value()));

        order.changeDesignURL(command.getUrl());

        emit().onResponse(new ResponseEvents(order.getUncommittedChanges()));

    }
}
