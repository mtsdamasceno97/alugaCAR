package modelo;

import daojpa.Trigger;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_veiculo_20162370022_20171370027", indexes = {@Index(name = "index_placa", columnList = "placa")})
public class Veiculo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String placa;

    private String marca;

    private String modelo;

    private int ano;

    private int disponiveis;

    @OneToMany (cascade=CascadeType.ALL)
    @JoinColumn(name = "veiculo_id")
    private List<Aluguel> alugueis = new ArrayList<>();

    @Version
    private int versao;

    public Veiculo(){}

    public Veiculo (String placa, String marca, String modelo, int ano, int disponiveis) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.disponiveis = disponiveis;
    }

    //GET & SET
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    public void baixarDisponiveis() {
        disponiveis = disponiveis - 1;
    }

    @Override
    public String toString() {
        return "Placa: " + placa
                + "\nMarca: " + marca
                + "\nModelo: " + modelo
                + "\nAno: " + ano
                + "\nDisponiveis: " + disponiveis
                + "\nVersao" + versao;
    }



}
