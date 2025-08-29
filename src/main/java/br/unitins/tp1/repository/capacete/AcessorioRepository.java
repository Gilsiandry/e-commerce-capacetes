package br.unitins.tp1.repository.capacete;

import java.util.List;

import br.unitins.tp1.model.capacete.Acessorio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AcessorioRepository implements PanacheRepository<Acessorio> {



    public List<Acessorio> findByNome(String nome) {
        return find("SELECT p FROM Acessorio p WHERE UPPER(p.nome) LIKE ?1 ", "%" + nome.toUpperCase() + "%").list();
    }

    public List<Acessorio> findByCor(String cor) {
        return find("SELECT p FROM Acessorio p WHERE UPPER(p.cor) LIKE ?1 ", "%" + cor.toUpperCase() + "%").list();
    }
}

