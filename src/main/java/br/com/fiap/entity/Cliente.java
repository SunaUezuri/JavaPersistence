package br.com.fiap.entity;

import br.com.fiap.entity.enums.Genero;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "TDS_T_CLIENTE")
@SequenceGenerator(name = "cliente", sequenceName = "SQ_TDS_T_CLIENTE", allocationSize = 1) //Gera uma sequence para a tabela
public class Cliente {

    //Atributos da classe

    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente") //Define a estratégia utilizada na criação da PK e relaciona a SQ
    private Integer id;

    @Column(name = "nm_cliente", nullable = false, length = 100)
    private String nome;

    @Temporal(TemporalType.DATE) //Grava somente a data no banco
    @Column(name = "dt_nascimento")
    private Calendar dataNascimento;

    @CreationTimestamp //Criar a data atual automaticamente no cadastro
    @Temporal(TemporalType.TIMESTAMP) //Grava a data e a hora no banco
    @Column(name = "dt_cadastro", updatable = false)
    private Calendar dataCadastro;

    @Column(name = "vl_credito", precision = 10, scale = 3)
    private Double credito;

    @Column(name = "nr_cpf", nullable = false, length = 11)
    private String cpf;

    @Transient //Não será uma coluna na tabela
    private Integer idade;

    @Lob
    @Column(name = "fl_foto")
    private byte[] foto;

    @Enumerated(EnumType.STRING) //Gravar o texto da constante
    @Column(name = "ds_genero", length = 20)
    private Genero genero;

    //Métodos da classe
    @PostPersist
    private void executar() {
        System.out.println("Método executando...");
    }

    //Construtores da classe
    public Cliente() {}

    public Cliente(String nome, Calendar dataNascimento, Double credito, String cpf, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.credito = credito;
        this.cpf = cpf;
        this.genero = genero;
    }

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Double getCredito() {
        return credito;
    }

    public void setCredito(Double credito) {
        this.credito = credito;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }


}
