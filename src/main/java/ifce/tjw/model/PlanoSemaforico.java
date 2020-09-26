package ifce.tjw.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "plano_semaforico")
public class PlanoSemaforico extends EntidadeBase<Integer> {

    @Column
    @NotNull(message = "O tempo de estado verde é obrigatório.")
    private Integer tempoVerde;

    @Column
    @NotNull(message = "O tempo de estado vermelho é obrigatório.")
    private Integer tempoVermelho;

    @Column
    @NotNull(message = "O tempo de estado amarelo é obrigatório.")
    private Integer tempoAmarelo;

    @OneToMany(mappedBy = "plano_semaforico")
    private List<Semaforo> semaforos;

    public PlanoSemaforico(){
    }

    public PlanoSemaforico(Integer tempoVerde, Integer tempoVermelho, Integer tempoAmarelo, List<Semaforo> semaforos){
        this.tempoVerde = tempoVerde;
        this.tempoVermelho = tempoVermelho;
        this.tempoAmarelo = tempoAmarelo;
    }

    public Integer getTempoVerde() {
        return tempoVerde;
    }

    public void setTempoVerde(Integer tempoVerde) {
        this.tempoVerde = tempoVerde;
    }

    public Integer getTempoVermelho() {
        return tempoVermelho;
    }

    public void setTempoVermelho(Integer tempoVermelho) {
        this.tempoVermelho = tempoVermelho;
    }

    public Integer getTempoAmarelo() {
        return tempoAmarelo;
    }

    public void setTempoAmarelo(Integer tempoAmarelo) {
        this.tempoAmarelo = tempoAmarelo;
    }

    public List<Semaforo> getSemaforos() {
        return semaforos;
    }

    public void setSemaforos(List<Semaforo> semaforos) {
        this.semaforos = semaforos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PlanoSemaforico that = (PlanoSemaforico) o;
        return Objects.equals(tempoVerde, that.tempoVerde) &&
                Objects.equals(tempoVermelho, that.tempoVermelho) &&
                Objects.equals(tempoAmarelo, that.tempoAmarelo) &&
                Objects.equals(semaforos, that.semaforos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tempoVerde, tempoVermelho, tempoAmarelo, semaforos);
    }

    @Override
    public String toString() {
        return "PlanoSemaforico{" +
                "tempoVerde=" + tempoVerde +
                ", tempoVermelho=" + tempoVermelho +
                ", tempoAmarelo=" + tempoAmarelo +
                ", semaforos=" + semaforos +
                '}';
    }
}
