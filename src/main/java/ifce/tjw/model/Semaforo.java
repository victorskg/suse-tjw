package ifce.tjw.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

import static java.time.LocalDateTime.now;

@Entity
@Table(name = "semaforo")
public class Semaforo extends EntidadeBase<Integer> {

    @Column
    @NotNull(message = "O código do semáforo é obrigatório.")
    private String codigo;

    @Column
    @Embedded
    @NotNull(message = "O endereço do semáforo é obrigatório.")
    private Endereco endereco;

    @Column
    private LocalDateTime dataCadastro = now();

    @ManyToOne
    @JoinColumn(name = "plano_semaforico_id", foreignKey = @ForeignKey(name = "fk_plano_semaforico"))
    private PlanoSemaforico planoSemaforico;

    @Transient
    private Integer idPlanoSemaforico;

    public Semaforo() {
        this.endereco = new Endereco();
    }

    public Semaforo(String codigo, Endereco endereco) {
        this.codigo = codigo;
        this.endereco = endereco;
        this.dataCadastro = now();
    }

    public Semaforo(String codigo, Endereco endereco, PlanoSemaforico planoSemaforico) {
        this.codigo = codigo;
        this.endereco = endereco;
        this.dataCadastro = now();
        this.planoSemaforico = planoSemaforico;
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

    public PlanoSemaforico getPlanoSemaforico() {
        return planoSemaforico;
    }

    public void setPlanoSemaforico(PlanoSemaforico planoSemaforico) {
        this.planoSemaforico = planoSemaforico;
    }

    public Integer getIdPlanoSemaforico() {
        return idPlanoSemaforico;
    }

    public void setIdPlanoSemaforico(Integer idPlanoSemaforico) {
        this.idPlanoSemaforico = idPlanoSemaforico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Semaforo semaforo = (Semaforo) o;
        return Objects.equals(codigo, semaforo.codigo) &&
                Objects.equals(endereco, semaforo.endereco) &&
                Objects.equals(dataCadastro, semaforo.dataCadastro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), codigo, endereco, dataCadastro);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Semaforo.class.getSimpleName() + "[", "]")
                .add("id=" + getId())
                .add("codigo='" + codigo + "'")
                .add("endereco=" + endereco)
                .add("dataCadastro=" + dataCadastro)
                .toString();
    }

}
