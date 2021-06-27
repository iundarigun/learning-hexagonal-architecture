package br.com.devcave.hexagonal.mybank.adapter.`in`.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Controller
@Configuration
@EnableSwagger2
class SwaggerConfiguration {
    @Bean
    fun swaggerAuth(): Docket =
        Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("br.com.devcave.hexagonal.mybank.adapter.in.web"))
            .build()

    @GetMapping("/")
    fun index(): String {
        return "redirect:swagger-ui/index.html"
    }
}