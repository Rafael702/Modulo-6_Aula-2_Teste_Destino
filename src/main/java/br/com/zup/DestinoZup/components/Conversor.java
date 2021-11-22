package br.com.zup.DestinoZup.components;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Conversor {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
