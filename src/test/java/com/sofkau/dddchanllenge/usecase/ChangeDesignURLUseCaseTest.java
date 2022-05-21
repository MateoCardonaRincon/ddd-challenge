package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.dddchanllenge.domain.contract.commands.AddClient;
import com.sofkau.dddchanllenge.domain.contract.events.ClientAdded;
import com.sofkau.dddchanllenge.domain.contract.events.ContractCreated;
import com.sofkau.dddchanllenge.domain.contract.values.ClientId;
import com.sofkau.dddchanllenge.domain.contract.values.DateOfContract;
import com.sofkau.dddchanllenge.domain.order.commands.AddDesign;
import com.sofkau.dddchanllenge.domain.order.commands.ChangeDesignURL;
import com.sofkau.dddchanllenge.domain.order.events.DesignAdded;
import com.sofkau.dddchanllenge.domain.order.events.DesignURLChanged;
import com.sofkau.dddchanllenge.domain.order.events.OrderCreated;
import com.sofkau.dddchanllenge.domain.order.values.DateOfOrder;
import com.sofkau.dddchanllenge.domain.order.values.DesignId;
import com.sofkau.dddchanllenge.domain.order.values.Technique;
import com.sofkau.dddchanllenge.domain.order.values.URL;
import com.sofkau.dddchanllenge.domain.shared.values.ContactNumber;
import com.sofkau.dddchanllenge.domain.shared.values.ContractId;
import com.sofkau.dddchanllenge.domain.shared.values.Name;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChangeDesignURLUseCaseTest {

    private final String ROOTID = "aaaaa";

    @Mock
    private DomainEventRepository repository;

    @Test
    void changeDesignURL() {

        var command = new ChangeDesignURL(OrderId.of(ROOTID), new URL("https://mytesturl.png"));

        var useCase = new ChangeDesignURLUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new OrderCreated(new DateOfOrder(LocalDateTime.now())),
                new DesignAdded(
                        DesignId.of("d123"),
                        new URL("https://priorurl.png"),
                        new Technique("Textile paint"))
        ));

        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("The URL  of the design could not be added"))
                .getDomainEvents();

        var event = (DesignURLChanged) events.get(0);

        Assertions.assertEquals(command.getUrl().value(), event.getUrl().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }

}