package ifce.tjw.model.enums;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;

import static java.util.Arrays.stream;

public enum Acao {

    CREATE("cadastrar"),
    READ("listar"),
    UPDATE("atualizar"),
    DELETE("excluir");

    private String nome;

    Acao(String nome) {
        this.nome = nome;
    }

    public static Acao fromRequest(HttpServletRequest request) {
        return Optional.ofNullable(request.getParameter("acao"))
                .map(s -> stream(values()).filter(v -> v.nome.equals(s)).findAny().orElse(READ))
                .orElse(READ);
    }

    public String getNome() {
        return nome;
    }
}
