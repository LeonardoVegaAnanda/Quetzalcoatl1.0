package mx.com.ananda.ometecuhtli.quetzalcoatl.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class GlobalConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }}
