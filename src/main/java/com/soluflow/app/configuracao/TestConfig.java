package com.soluflow.app.configuracao;

import com.soluflow.app.dominio.usuario.Funcionario;
import com.soluflow.app.dominio.usuario.Papel;
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

        Funcionario barber1 = new Funcionario(null,"Mauricio","santiago@santiago","71992765669",Papel.DONO,true,"Corte,Barba,Sobrancelha");
        Funcionario barber2 = new Funcionario(null,"Tácio","Tacio@barberoverflow","11987864871",Papel.SECRETARIA,false,"Corte,Barba,Sobrancelha,unha");
        Funcionario barber3 = new Funcionario(null,"Ricardo","Ricardo@barberoverflow","1194587941", Papel.BARBEIRO,false,"Harmonização,Barba,Sobrancelha,unha");

        barbeiroRepositorio.saveAll(Arrays.asList(barber1, barber2, barber3));

    }
}
