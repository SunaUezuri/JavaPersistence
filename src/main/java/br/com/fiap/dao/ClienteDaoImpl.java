package br.com.fiap.dao;

import br.com.fiap.entity.Cliente;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNaoEncontradoException;

import javax.persistence.EntityManager;

public class ClienteDaoImpl implements ClienteDao{

    private EntityManager em;

    public ClienteDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void cadastrar(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void atualizar(Cliente cliente) throws IdNaoEncontradoException {
        buscarPorId(cliente.getId());
        em.merge(cliente);
    }

    @Override
    public void remover(int id) throws IdNaoEncontradoException {
        Cliente cliente = buscarPorId(id);
        em.remove(cliente);
    }

    @Override
    public Cliente buscarPorId(int id) throws IdNaoEncontradoException {
        Cliente cliente = em.find(Cliente.class, id);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
        }

        return cliente;
    }

    @Override
    public void commit() throws CommitException {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new CommitException("Não foi possível realizar a operação.");
        }
    }
}
