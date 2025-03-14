package br.com.fiap.main;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.enums.Genero;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteAtualizacao {
    public static void main(String[] args) {

        //Instanciar um Cliente sem o ID
        Cliente cliente = new Cliente("Nicolas", new GregorianCalendar(2015, Calendar.JUNE, 9),
                200.0, "77799955566", Genero.MASCULINO);

        cliente.setId(10);

        //Instanciar uma Fábrica de Entity Manager
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

        //Criando o Entity Manager
        EntityManager em = fabrica.createEntityManager();

        //Atualizar o cliente no banco de dados
        Cliente copiaGerenciada = em.merge(cliente);

        em.getTransaction().begin();
        em.getTransaction().commit();

        copiaGerenciada.setNome("Nicolau");

        em.getTransaction().begin();
        em.getTransaction().commit();

        System.out.println("Cadastro realizado com sucesso!");
    }

}
