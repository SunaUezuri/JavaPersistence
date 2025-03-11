package br.com.fiap.entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "TDS_T_CLIENTE")
@SequenceGenerator(name = "cliente", sequenceName = "SQ_TDS_T_CLIENTE", allocationSize = 1)
public class Cliente {

    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
    private Integer id;

    @Column(name = "nm_cliente", nullable = false, length = 100)
    private String nome;

    @Temporal(TemporalType.DATE)
    private Calendar dataNascimento;

}
