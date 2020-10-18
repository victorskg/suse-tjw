package ifce.tjw.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.StringJoiner;

@Embeddable
public class Endereco {

    @Column
    @NotNull(message = "O estado é obrigatório.")
    private String estado;

    @Column
    @NotNull(message = "A cidade é obrigatória.")
    private String cidade;

    @Column
    @NotNull(message = "O bairro é obrigatório.")
    private String bairro;

    @Column
    @NotNull(message = "O logadouro é obrigatório.")
    private String logradouro;

    public Endereco() {
    }

    public Endereco(String estado, String cidade, String bairro, String logradouro) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(estado, endereco.estado) &&
                Objects.equals(cidade, endereco.cidade) &&
                Objects.equals(bairro, endereco.bairro) &&
                Objects.equals(logradouro, endereco.logradouro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estado, cidade, bairro, logradouro);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Endereco.class.getSimpleName() + "[", "]")
                .add("estado='" + estado + "'")
                .add("cidade='" + cidade + "'")
                .add("bairro='" + bairro + "'")
                .add("logradouro='" + logradouro + "'")
                .toString();
    }

}
