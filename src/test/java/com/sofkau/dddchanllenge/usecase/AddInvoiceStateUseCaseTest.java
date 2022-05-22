package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.dddchanllenge.domain.contract.events.ContractCreated;
import com.sofkau.dddchanllenge.domain.contract.values.DateOfContract;
import com.sofkau.dddchanllenge.domain.invoice.commands.AddInvoiceState;
import com.sofkau.dddchanllenge.domain.invoice.events.InvoiceCreated;
import com.sofkau.dddchanllenge.domain.invoice.events.InvoiceStateAdded;
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
class AddInvoiceStateUseCaseTest {

    private final String ROOTID = "9835";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addInvoiceState() {

        var command = new AddInvoiceState(
                InvoiceId.of(ROOTID),
                InvoiceStateId.of("is123"),
                new Payed(),
                new Prepayment(10000.)
        );

        var useCase = new AddInvoiceStateUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new InvoiceCreated(new InvoiceDate(LocalDate.now()), OrderId.of("o567"))
        ));

        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("The state of the invoice could not be established"))
                .getDomainEvents();

        var event = (InvoiceStateAdded) events.get(0);

        Assertions.assertEquals(command.getIsPayed().value(), event.getIsPayed().value());
        Assertions.assertEquals(command.getPrepayment().value(), event.getPrepayment().value());
        Assertions.assertEquals(command.getInvoiceStateId().value(), event.getInvoiceStateId().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }

}