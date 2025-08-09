package com.soluflow.app.configuracao;

import com.soluflow.app.dominio.Pedido.Pedido;
import com.soluflow.app.dominio.Pedido.StatusPedido;
import com.soluflow.app.dominio.agendamento.Agendamento;
import com.soluflow.app.dominio.agendamento.Origem;
import com.soluflow.app.dominio.agendamento.Status;
import com.soluflow.app.dominio.cliente.Cliente;
import com.soluflow.app.dominio.pagamento.MetodoPagamento;
import com.soluflow.app.dominio.pagamento.Pagamento;
import com.soluflow.app.dominio.pagamento.StatusPagamento;
import com.soluflow.app.dominio.servico.Oficio;
import com.soluflow.app.dominio.usuario.Funcionario;
import com.soluflow.app.dominio.usuario.Papel;
import com.soluflow.app.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner {
    @Autowired
    private FuncionarioRepositorio funcionarioRepositorio;
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    @Autowired
    private OficioRepositorio oficioRepositorio;
    @Autowired
    private AgendamentoRepositorio agendamentoRepositorio;
    @Autowired
    private PedidoRepositorio pedidoRepositorio;


    @Override
    public void run(String... args) throws Exception {

        Funcionario barber1 = new Funcionario(null,"Mauricio","santiago@santiago","71992765669",Papel.DONO,true,"Corte,Barba,Sobrancelha");
        Funcionario barber2 = new Funcionario(null,"Tácio","Tacio@barberoverflow","11987864871",Papel.BARBEIRO,true,"Corte,Barba,Sobrancelha,unha");
        Funcionario barber3 = new Funcionario(null,"Ricardo","Ricardo@barberoverflow","1194587941", Papel.BARBEIRO,true,"Harmonização,Barba,Sobrancelha,unha");

        Cliente cliente1 = new Cliente(null, "Joao paulo", "71992765489");
        Cliente cliente2 = new Cliente(null, "Mario joão", "11598787952");

        Oficio cabelo = new Oficio(null,"Cabelo","corte cabelo na maquina",BigDecimal.valueOf(12.50),15);
        Oficio cabeloBarba = new Oficio(null,"Cabelo e Barba","corte de cabelo na maquina e a barba",BigDecimal.valueOf(25.50),25);
        Oficio sobrancelha = new Oficio(null,"Cabelo","corte cabelo na maquina",BigDecimal.valueOf(10),10);
        Oficio barba = new Oficio(null,"Cabelo","corte cabelo na maquina",BigDecimal.valueOf(8.50),10);

        Agendamento agendamento1 = new Agendamento(null, Instant.parse("2019-06-20T19:53:07Z"),cliente1,barber2,cabeloBarba,Status.CONFIRMADO, Origem.WHATSAPP);

        funcionarioRepositorio.saveAll(Arrays.asList(barber1, barber2, barber3));
        clienteRepositorio.saveAll(Arrays.asList(cliente1,cliente2));
        oficioRepositorio.saveAll(Arrays.asList(cabelo, cabeloBarba, sobrancelha, barba));
        agendamentoRepositorio.save(agendamento1);


        Pedido pedido = new Pedido(cliente1,agendamento1.getOficio().getValor(),StatusPedido.ABERTO, LocalDateTime.now(),LocalDateTime.now());
        pedidoRepositorio.save(pedido);

        Pagamento pag1 = new Pagamento(null,Instant.parse("2019-06-20T19:53:07Z"), pedido, MetodoPagamento.PIX, StatusPagamento.PAID);
        pedido.setPagamento(pag1);

        pedidoRepositorio.save(pedido);

    }
}
