package br.com.devcave.hexagonal.mybank

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyBankApplication

fun main(args: Array<String>) {
	runApplication<MyBankApplication>(*args)
}
