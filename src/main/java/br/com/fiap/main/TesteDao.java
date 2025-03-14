package br.com.fiap.main;

import br.com.fiap.dao.ClienteDao;
import br.com.fiap.dao.ClienteDaoImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.enums.Genero;
import br.com.fiap.exception.IdNaoEncontradoException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteDao {

    //Implementar o CRUD com o DAO
    public static void main(String[] args) {

        //Cria a fábrica
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

        //Criar o Entity manager
        EntityManager em = fabrica.createEntityManager();

        //Instanciar o DAO
        ClienteDao dao = new ClienteDaoImpl(em);

        //Cadastrar um Cliente (CREATE -> INSERT)
        Cliente cliente = new Cliente("Wesley", new GregorianCalendar(2005, Calendar.JUNE, 11), 1000000.0,
                "55566677788", Genero.MASCULINO);

        try {
            dao.cadastrar(cliente);
            dao.commit();
            System.out.println("Cliente cadastrado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Pesquisar um cliente (READ -> SELECT)
        try {
            Cliente busca = dao.buscarPorId(3);
            System.out.println(busca.getNome());
        } catch (IdNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        //Atualizar um cliente (UPDATE -> UPDATE)

        try {
            cliente.setNome("Suna");
            cliente.setGenero(Genero.OUTROS);
            dao.atualizar(cliente);
            dao.commit();
            System.out.println("Cliente atualizado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Remover um Cliente (DELETE -> DELETE)
        try {
            dao.remover(2);
            dao.commit();
            System.out.println("Cliente removido!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
