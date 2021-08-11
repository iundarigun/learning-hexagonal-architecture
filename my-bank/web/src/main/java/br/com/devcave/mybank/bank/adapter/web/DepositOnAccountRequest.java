package br.com.devcave.mybank.bank.adapter.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@ToString
@AllArgsConstructor(onConstructor = @__({@JsonCreator}))
class DepositOnAccountRequest {

    @NotNull
    private final Long accountId;

    @NotNull
    private final Double amount;
}
