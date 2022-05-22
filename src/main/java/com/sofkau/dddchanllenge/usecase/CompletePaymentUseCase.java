package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddchanllenge.domain.invoice.Invoice;
import com.sofkau.dddchanllenge.domain.invoice.commands.CompletePayment;

public class CompletePaymentUseCase extends UseCase<RequestCommand<CompletePayment>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CompletePayment> completePaymentRequestCommand) {

        var command = completePaymentRequestCommand.getCommand();

        var invoice = Invoice.from(
                command.getInvoiceId(),
                retrieveEvents(command.getInvoiceId().value()));

        invoice.completePayment();

        emit().onResponse(new ResponseEvents(invoice.getUncommittedChanges()));
    }
}
