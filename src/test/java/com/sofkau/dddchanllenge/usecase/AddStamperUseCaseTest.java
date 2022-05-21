package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.dddchanllenge.domain.contract.commands.AddStamper;
import com.sofkau.dddchanllenge.domain.contract.events.ContractCreated;
import com.sofkau.dddchanllenge.domain.contract.events.StamperAdded;
import com.sofkau.dddchanllenge.domain.contract.values.DateOfContract;
import com.sofkau.dddchanllenge.domain.contract.values.StamperId;
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
class AddStamperUseCaseTest {

    private final String ROOTID = "54321";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addStamperToContract() {

        var command = new AddStamper(
                ContractId.of(ROOTID),
                StamperId.of("s321"),
                new Name("Luz"),
                new ContactNumber("3210987654"));

        var useCase = new AddStamperUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new ContractCreated(new DateOfContract(LocalDateTime.now()))
        ));

        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("The stamper could not be added to the contract"))
                .getDomainEvents();

        var event = (StamperAdded) events.get(0);

        Assertions.assertEquals(command.getStamperId().value(), event.getStamperId().value());
        Assertions.assertEquals(command.getName().value(), event.getName().value());
        Assertions.assertEquals(command.getContactNumber().value(), event.getContactNumber().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }

}