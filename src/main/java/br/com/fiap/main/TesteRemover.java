package br.com.fiap.main;

import br.com.fiap.entity.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteRemover {
    public static void main(String[] args) {

        //Criar a fábrica
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

        //Criar o Entity Manager
        EntityManager em = fabrica.createEntityManager();

        //Pesquisa o cliente que será removido
        Cliente cliente = em.find(Cliente.class, 3);

        //Chama o método de remoção
        em.remove(cliente);

        em.getTransaction().begin();
        em.getTransaction().commit();
    }
}
