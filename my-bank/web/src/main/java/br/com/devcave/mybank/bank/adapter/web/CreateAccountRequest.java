package br.com.devcave.mybank.bank.adapter.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@AllArgsConstructor(onConstructor = @__({@JsonCreator}))
class CreateAccountRequest {

    @NotNull
    private final Long bankId;

    @NotNull
    private final Long ownerId;
}
