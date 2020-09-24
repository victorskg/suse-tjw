package ifce.tjw;

import ifce.tjw.model.Endereco;
import ifce.tjw.model.Semaforo;
import ifce.tjw.repository.SemaforoRepository;

public class Application {

    public static void main(String[] args) {
        var repo = new SemaforoRepository();

        // Criar novo
        var endereco = new Endereco();
        endereco.setCidade("Fortaleza");
        var semaforo = new Semaforo("S01", endereco);
        System.out.println("Novo semáforo: " + repo.create(semaforo));

        // Editar semáforo
        semaforo.setCodigo("S01 EIDTADO");
        repo.update(semaforo);
        System.out.println("Semáforo editado: " + repo.read(semaforo.getId()));

        // Remover semaforo
        repo.delete(semaforo.getId());
        System.out.println("Todos: " + repo.readAll());
    }

}
