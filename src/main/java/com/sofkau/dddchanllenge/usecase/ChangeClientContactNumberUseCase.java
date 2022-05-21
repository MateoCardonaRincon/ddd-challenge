package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddchanllenge.domain.contract.Contract;
import com.sofkau.dddchanllenge.domain.contract.commands.ChangeClientContactNumber;

public class ChangeClientContactNumberUseCase  extends UseCase<RequestCommand<ChangeClientContactNumber>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ChangeClientContactNumber> changeClientContactNumberRequestCommand) {

        var command = changeClientContactNumberRequestCommand.getCommand();

        var contract = Contract.from(command.getContractId(), retrieveEvents(command.getContractId().value()));

        contract.changeClientContactNumber(command.getContactNumber());

        emit().onResponse(new ResponseEvents((contract.getUncommittedChanges())));

    }
}
