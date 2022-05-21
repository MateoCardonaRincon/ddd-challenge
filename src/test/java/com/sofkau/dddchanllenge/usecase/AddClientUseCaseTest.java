package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.dddchanllenge.domain.contract.commands.AddClient;
import com.sofkau.dddchanllenge.domain.contract.events.ClientAdded;
import com.sofkau.dddchanllenge.domain.contract.events.ContractCreated;
import com.sofkau.dddchanllenge.domain.contract.values.ClientId;
import com.sofkau.dddchanllenge.domain.contract.values.DateOfContract;
import com.sofkau.dddchanllenge.domain.contract.values.ContactNumber;
import com.sofkau.dddchanllenge.domain.shared.values.ContractId;
import com.sofkau.dddchanllenge.domain.contract.values.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddClientUseCaseTest {

    private final String ROOTID = "12345";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addClientToContract() {

        var command = new AddClient(
                ContractId.of(ROOTID),
                ClientId.of("c123"),
                new Name("Mateo"),
                new ContactNumber("3216549870"));

        var useCase = new AddClientUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new ContractCreated(new DateOfContract(LocalDate.now()))
        ));

        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("The client could not be added to the contract"))
                .getDomainEvents();

        var event = (ClientAdded) events.get(0);

        Assertions.assertEquals(command.getClientId().value(), event.getClientId().value());
        Assertions.assertEquals(command.getName().value(), event.getName().value());
        Assertions.assertEquals(command.getContactNumber().value(), event.getContactNumber().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }

}