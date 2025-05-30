package com.in28minutes.rest.webservices.restful_web_services.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// RESTful Web Services - Hello World Example
@RestController
public class HelloWorldController {

    private static MessageSource messageSource;

    // Constructor injection is used to inject the MessageSource bean
    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // GET
    // URL - /hello-world
    // method - "helloWorld"
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    // Path Parameters
    // /users/{id}/todos/{id} => /users/1/todos/200
    // /hello-world/path-variable/{name}
    // http://localhost:8080/hello-world/path-variable/jorge

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        // @PathVariable annotation is used to extract the value from the URI
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    // This endpoint is for demonstration purposes and does not implement actual
    // internationalization
    // - Example: 'en-US', 'fr-FR', 'nl-NL', 'es-ES', 'de-DE', 'it-IT', etc.
    // - Example: 'en' - English, (Good Morning)
    // 'fr' - French, (Bonjour)
    // 'nl' - Dutch, (Goedemorgen)
    // - Example: 'es' - Spanish, (Buenos Días)
    // - Example: 'de' - German, (Guten Morgen)
    // - Example: 'it' - Italian, (Buongiorno)
    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null,
                "Default Message", locale);
    }
}
