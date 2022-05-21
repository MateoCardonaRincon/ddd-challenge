package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.dddchanllenge.domain.contract.commands.ChangeClientContactNumber;
import com.sofkau.dddchanllenge.domain.contract.events.ClientAdded;
import com.sofkau.dddchanllenge.domain.contract.events.ClientContactNumberChanged;
import com.sofkau.dddchanllenge.domain.contract.events.ContractCreated;
import com.sofkau.dddchanllenge.domain.contract.values.ClientId;
import com.sofkau.dddchanllenge.domain.contract.values.DateOfContract;
import com.sofkau.dddchanllenge.domain.shared.values.ContactNumber;
import com.sofkau.dddchanllenge.domain.shared.values.ContractId;
import com.sofkau.dddchanllenge.domain.shared.values.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ChangeClientContactNumberUseCaseTest {

    private final String ROOTID = "98765";

    @Mock
    private DomainEventRepository repository;

    @Test
    void changeClientContactNumber() {

        var command = new ChangeClientContactNumber(
                ContractId.of(ROOTID),
                new ContactNumber("3147781255"));

        var useCase = new ChangeClientContactNumberUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new ContractCreated(new DateOfContract(LocalDateTime.now())),
                new ClientAdded(
                        ClientId.of("ccn123"),
                        new Name("Mateo"),
                        new ContactNumber("3156605933"))
        ));

        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("The client's contact number could not be changed"))
                .getDomainEvents();

        var event = (ClientContactNumberChanged) events.get(0);

        Assertions.assertEquals(command.getContactNumber().value(), event.getContactNumber().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }

}