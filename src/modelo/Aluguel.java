package modelo;

import javax.persistence.*;

import daojpa.Trigger;

import java.time.LocalDate;

import java.util.Date;
import java.util.Objects;


@Entity
//@EntityListeners( Trigger.class )  // CLASSE QUE IMPLEMENTA OS EVENTOS (TRIGGERS)
@Table(name = "tb_aluguel")
public class Aluguel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "DATE")
    private LocalDate dataAluguel = LocalDate.now();


    @Temporal(TemporalType.DATE)
    private Date dataDevolucao = new Date();

    @Column
    private double valorDiaria;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    public Aluguel (){}

    public Aluguel(Date dataDevolucao,double valorDiaria,  Cliente cliente, Veiculo veiculo) {
        super();
        this.dataDevolucao = dataDevolucao;
        this.valorDiaria = valorDiaria;
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDate getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(LocalDate dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluguel aluguel = (Aluguel) o;
        return id == aluguel.id &&
                Double.compare(aluguel.valorDiaria, valorDiaria) == 0 &&
                Objects.equals(dataAluguel, aluguel.dataAluguel) &&
                Objects.equals(dataDevolucao, aluguel.dataDevolucao) &&
                Objects.equals(cliente, aluguel.cliente) &&
                Objects.equals(veiculo, aluguel.veiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataAluguel, dataDevolucao, valorDiaria, cliente, veiculo);
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "id=" + id +
                ", dataAluguel=" + dataAluguel +
                ", dataDevolucao=" + dataDevolucao +
                ", valorDiaria=" + valorDiaria +
                ", cliente=" + cliente +
                ", veiculo=" + veiculo +
                '}';
    }
}
