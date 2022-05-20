package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddchanllenge.domain.contract.Contract;
import com.sofkau.dddchanllenge.domain.contract.commands.CreateContract;

public class CreateContractUseCase extends UseCase<RequestCommand<CreateContract>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateContract> createContractRequestCommand) {
        var command = createContractRequestCommand.getCommand();
        var contract = new Contract(command.getContractId(), command.getDateOfContract());

        emit().onResponse(new ResponseEvents(contract.getUncommittedChanges()));
    }
}
