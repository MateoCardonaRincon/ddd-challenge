package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.dddchanllenge.domain.invoice.commands.AddPaymentMethod;
import com.sofkau.dddchanllenge.domain.invoice.events.InvoiceCreated;
import com.sofkau.dddchanllenge.domain.invoice.events.PaymentMethodAdded;
import com.sofkau.dddchanllenge.domain.invoice.values.Amount;
import com.sofkau.dddchanllenge.domain.invoice.values.Description;
import com.sofkau.dddchanllenge.domain.invoice.values.InvoiceDate;
import com.sofkau.dddchanllenge.domain.invoice.values.PaymentMethodId;
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
class AddPaymentMethodUseCaseTest {

    private final String ROOTID = "9518";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addPaymentMethodToInvoice() {

        var command = new AddPaymentMethod(
                InvoiceId.of(ROOTID),
                PaymentMethodId.of("pm123"),
                new Description("Cash"),
                new Amount(100000)
                );

        var useCase = new AddPaymentMethodUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new InvoiceCreated(new InvoiceDate(LocalDate.now()), OrderId.of("o1234"))
        ));

        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("The payment method could not be added"))
                .getDomainEvents();

        var event = (PaymentMethodAdded) events.get(0);

        Assertions.assertEquals(command.getPaymentMethodId().value(), event.getPaymentMethodId().value());
        Assertions.assertEquals(command.getDescription().value(), event.getDescription().value());
        Assertions.assertEquals(command.getAmount().value(), event.getAmount().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }

}