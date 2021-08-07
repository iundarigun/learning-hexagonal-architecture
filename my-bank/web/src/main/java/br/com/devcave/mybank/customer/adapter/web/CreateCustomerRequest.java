package br.com.devcave.mybank.customer.adapter.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@ToString
@AllArgsConstructor(onConstructor = @__({@JsonCreator}))
class CreateCustomerRequest {

    @NotBlank
    @Size(min = 3, max = 255)
    private final String name;

    @NotBlank
    @Size(min = 3, max = 20)
    private final String document;
}
