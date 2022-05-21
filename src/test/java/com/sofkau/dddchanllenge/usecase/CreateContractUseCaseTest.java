package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.dddchanllenge.domain.contract.commands.CreateContract;
import com.sofkau.dddchanllenge.domain.contract.events.ContractCreated;
import com.sofkau.dddchanllenge.domain.contract.values.DateOfContract;
import com.sofkau.dddchanllenge.domain.shared.values.ContractId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class CreateContractUseCaseTest {

    @Test
    void createContract() {
        // Arrange
        var command = new CreateContract(
                ContractId.of("1234"),
                new DateOfContract(LocalDateTime.now()));

        var useCase = new CreateContractUseCase();

        // Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("The contract could not be created"))
                .getDomainEvents();

        // Assert
        var event = (ContractCreated) events.get(0);
        Assertions.assertEquals(command.getDateOfContract().value(), event.getDateOfContract().value());
    }
}