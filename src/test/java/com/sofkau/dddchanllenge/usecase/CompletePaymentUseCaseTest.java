package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.dddchanllenge.domain.contract.events.ClientContactNumberChanged;
import com.sofkau.dddchanllenge.domain.invoice.commands.CompletePayment;
import com.sofkau.dddchanllenge.domain.invoice.events.InvoiceCreated;
import com.sofkau.dddchanllenge.domain.invoice.events.InvoiceStateAdded;
import com.sofkau.dddchanllenge.domain.invoice.events.PaymentCompleted;
import com.sofkau.dddchanllenge.domain.invoice.values.InvoiceDate;
import com.sofkau.dddchanllenge.domain.invoice.values.InvoiceStateId;
import com.sofkau.dddchanllenge.domain.invoice.values.Payed;
import com.sofkau.dddchanllenge.domain.invoice.values.Prepayment;
import com.sofkau.dddchanllenge.domain.shared.values.InvoiceId;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class CompletePaymentUseCaseTest {

    private final String ROOTID = "35735";

    @Mock
    private DomainEventRepository repository;

    @Test
    void completePaymentOfInvoice() {

        var command = new CompletePayment(InvoiceId.of(ROOTID));

        var useCase = new CompletePaymentUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new InvoiceCreated(new InvoiceDate(LocalDate.now()), OrderId.of("o123")),
                new InvoiceStateAdded(InvoiceStateId.of(ROOTID), new Payed(), new Prepayment(20000.))
        ));

        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("The payment could not be completed"))
                .getDomainEvents();

        var event = (PaymentCompleted) events.get(0);

        Assertions.assertEquals(command.getPayed().value(), event.getPayed().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }

}