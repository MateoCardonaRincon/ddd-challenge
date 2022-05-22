package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddchanllenge.domain.invoice.Invoice;
import com.sofkau.dddchanllenge.domain.invoice.commands.AddInvoiceState;

public class AddInvoiceStateUseCase extends UseCase<RequestCommand<AddInvoiceState>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddInvoiceState> addInvoiceStateRequestCommand) {

        var command = addInvoiceStateRequestCommand.getCommand();

        var invoice = Invoice.from(
                command.getInvoiceId(),
                retrieveEvents(command.getInvoiceId().value()));

        invoice.addInvoiceState(
                command.getInvoiceStateId(),
                command.getIsPayed(),
                command.getPrepayment());

        emit().onResponse(new ResponseEvents(invoice.getUncommittedChanges()));
    }
}
