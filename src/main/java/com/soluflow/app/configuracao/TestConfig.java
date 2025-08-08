package com.soluflow.app.configuracao;

import com.soluflow.app.dominio.usuario.Barbeiro;
import com.soluflow.app.repositorio.BarbeiroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner {
    @Autowired
    private BarbeiroRepositorio barbeiroRepositorio;

    @Override
    public void run(String... args) throws Exception {

        Barbeiro barber1 = new Barbeiro(null,"Mauricio","santiago@santiago","71992765669",true,List.of("Corte", "Barba", "Sobrancelha"));
        Barbeiro barber2 = new Barbeiro(null,"Tácio","Tacio@barberoverflow","11987864871",false,List.of("Corte", "Barba", "Sobrancelha","unha"));
        Barbeiro barber3 = new Barbeiro(null,"Ricardo","Ricardo@barberoverflow","1194587941",false,List.of("Harmonização", "Barba", "Sobrancelha","unha"));

        barbeiroRepositorio.saveAll(Arrays.asList(barber1, barber2, barber3));

    }
}
