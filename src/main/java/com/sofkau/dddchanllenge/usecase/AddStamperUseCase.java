package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddchanllenge.domain.contract.Contract;
import com.sofkau.dddchanllenge.domain.contract.commands.AddStamper;

public class AddStamperUseCase extends UseCase<RequestCommand<AddStamper>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddStamper> addStamperRequestCommand) {

        var command = addStamperRequestCommand.getCommand();

        var contract = Contract.from(command.getContractId(), retrieveEvents(command.getContractId().value()));

        contract.addStamper(command.getStamperId(), command.getName(), command.getContactNumber());

        emit().onResponse(new ResponseEvents((contract.getUncommittedChanges())));

    }
}
