package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddchanllenge.domain.invoice.Invoice;
import com.sofkau.dddchanllenge.domain.invoice.commands.AddPaymentMethod;

public class AddPaymentMethodUseCase extends UseCase<RequestCommand<AddPaymentMethod>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddPaymentMethod> addPaymentMethodRequestCommand) {
        var command = addPaymentMethodRequestCommand.getCommand();

        var invoice = Invoice.from(command.getInvoiceId(), retrieveEvents(command.getInvoiceId().value()));

        invoice.addPaymentMethod(
                command.getPaymentMethodId(),
                command.getDescription(),
                command.getAmount());

        emit().onResponse(new ResponseEvents(invoice.getUncommittedChanges()));
    }
}
