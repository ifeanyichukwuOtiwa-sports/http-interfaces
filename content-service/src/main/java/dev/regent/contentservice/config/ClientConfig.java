package dev.regent.contentservice.config;

import dev.regent.contentservice.service.ArticleClientApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ClientConfig {

    @Bean
    ArticleClientApi articleClientApi() {
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:8081/api")
                .build();

        final HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(ArticleClientApi.class);
    }
}
