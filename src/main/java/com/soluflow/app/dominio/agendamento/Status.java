package com.soluflow.app.dominio.agendamento;

public enum Status {

    AGENDADO(1),        // Reservado, mas ainda não confirmado
    CONFIRMADO(2),      // Cliente confirmou a presença
    CANCELADO(3),       // Cancelado (cliente ou funcionário)
    CONCLUIDO(4),       // Serviço realizado
    NAO_COMPARECEU(5),  // Cliente faltou
    REAGENDADO(6)  ;     // Agendamento foi movido

    private int code;

    private Status(int code){
        this.code= code;
    }

    public int getCode(){
        return code;
    }

    public static Status valueOf(int code){
        for(Status valor : Status.values()){
            if (valor.getCode()==code){
                return valor;
            }
        }
        throw new IllegalArgumentException("Status invalido de agendamento");
    }
}

