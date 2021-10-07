package pl.fissst.codeandcoffee.springbootaws.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

@Configuration
public class JacksonConfiguration {

    @Bean
    public MappingJackson2MessageConverter mappingJackson2MessageConverter() {
        MappingJackson2MessageConverter jackson2MessageConverter = new MappingJackson2MessageConverter();
        jackson2MessageConverter.setObjectMapper(objectMapper());
        return jackson2MessageConverter;
    }

    private ObjectMapper objectMapper() {
        return new ObjectMapper()
                .configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .registerModule(new JavaTimeModule());
    }
}