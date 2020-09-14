package ifce.tjw.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.StringJoiner;

import static java.time.LocalDateTime.now;

@Entity
@Table(name = "semaforo")
public class Semaforo extends EntidadeBase<Integer> {

    @Column
    private String codigo;

    @Column
    @Embedded
    private Endereco endereco;

    @Column
    private LocalDateTime dataCadastro = now();

    public Semaforo() {
    }

    public Semaforo(String codigo, Endereco endereco, LocalDateTime dataCadastro) {
        this.codigo = codigo;
        this.endereco = endereco;
        this.dataCadastro = dataCadastro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Semaforo.class.getSimpleName() + "[", "]")
                .add("codigo='" + codigo + "'")
                .add("endereco=" + endereco)
                .add("dataCadastro=" + dataCadastro)
                .toString();
    }

}
