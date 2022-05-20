package com.sofkau.dddchanllenge.contract.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.values.ContractId;
import com.sofkau.dddchanllenge.values.OrderId;

public class AssociateOrder extends Command {
    private final ContractId contractId;
    private final OrderId orderId;

    public AssociateOrder(ContractId contractId, OrderId orderId) {
        this.contractId = contractId;
        this.orderId = orderId;
    }

    public ContractId getContractId() {
        return contractId;
    }

    public OrderId getOrderId() {
        return orderId;
    }
}
