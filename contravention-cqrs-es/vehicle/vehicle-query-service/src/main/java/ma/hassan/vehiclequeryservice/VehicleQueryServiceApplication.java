package ma.hassan.vehiclequeryservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.provider.Serializer;
import org.axonframework.serialization.json.JacksonSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.inject.Qualifier;

@SpringBootApplication
public class VehicleQueryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleQueryServiceApplication.class, args);
    }

}
