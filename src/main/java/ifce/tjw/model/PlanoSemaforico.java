package ifce.tjw.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.time.LocalDateTime.now;

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

    @OneToMany(mappedBy = "planoSemaforico")
    private List<Semaforo> semaforos = new ArrayList<>();

    @Column
    private LocalDateTime dataCadastro = now();

    public PlanoSemaforico() {
    }

    public PlanoSemaforico(Integer tempoVerde, Integer tempoVermelho, Integer tempoAmarelo) {
        this.tempoVerde = tempoVerde;
        this.tempoVermelho = tempoVermelho;
        this.tempoAmarelo = tempoAmarelo;
        this.dataCadastro = now();
    }

    public PlanoSemaforico(Integer tempoVerde, Integer tempoVermelho, Integer tempoAmarelo, List<Semaforo> semaforos) {
        this.tempoVerde = tempoVerde;
        this.tempoVermelho = tempoVermelho;
        this.tempoAmarelo = tempoAmarelo;
        this.semaforos = semaforos;
        this.dataCadastro = now();
    }

    public void adicionarSemaforo(Semaforo semaforo) {
        semaforos.add(semaforo);
        semaforo.setPlanoSemaforico(this);
    }

    public void removerSemaforo(Semaforo semaforo) {
        semaforos.remove(semaforo);
        semaforo.setPlanoSemaforico(null);
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

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
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
                Objects.equals(dataCadastro, that.dataCadastro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tempoVerde, tempoVermelho, tempoAmarelo, dataCadastro);
    }

    @Override
    public String toString() {
        return "PlanoSemaforico{" +
                "tempoVerde=" + tempoVerde +
                ", tempoVermelho=" + tempoVermelho +
                ", tempoAmarelo=" + tempoAmarelo +
                ", dataCadastro=" + dataCadastro +
                '}';
    }

}
