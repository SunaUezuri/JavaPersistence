package br.com.fiap.main;

import javax.persistence.Persistence;

public class Teste {
    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
    }
}
