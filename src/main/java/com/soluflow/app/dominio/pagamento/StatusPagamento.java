package com.soluflow.app.dominio.pagamento;

public enum StatusPagamento {

    WAITING_PAYMENT(1),
    PAID(2);


    private int code;

    private StatusPagamento(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    public static StatusPagamento valueOf(int code) {
        for(StatusPagamento valor : StatusPagamento.values()) {
            if (valor.getCode() == code) {
                return valor;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }


}
