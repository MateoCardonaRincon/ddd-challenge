package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddchanllenge.domain.contract.Contract;
import com.sofkau.dddchanllenge.domain.contract.commands.AddClient;

public class AddClientUseCase extends UseCase<RequestCommand<AddClient>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddClient> addClientRequestCommand) {
        var command = addClientRequestCommand.getCommand();

        var contract = Contract.from(command.getContractId(), retrieveEvents(command.getContractId().value()));

        contract.addClient(command.getClientId(), command.getName(), command.getContactNumber());

        emit().onResponse(new ResponseEvents((contract.getUncommittedChanges())));

    }
}
