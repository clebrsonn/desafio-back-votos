package br.com.hytech.rhsouthsystem.service;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public abstract class AbstractService<Entity, Id, Repository extends JpaRepository<Entity, Id>> {
    private final Repository repository;

    protected AbstractService(Repository repository) {
        this.repository = repository;
    }

    public Entity findById(Id id) {
        return repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    public Collection<Entity> findAll() {
        return repository.findAll();
    }

    public List<Entity> saveAll(List<Entity> entities) {
        return repository.saveAll(entities);
    }

    public Entity save(Entity entity) {
        return repository.save(entity);
    }

    public void deleteById(Id id){
        repository.deleteById(id);
    }

    public void delete(Entity entity){
        repository.delete(entity);
    }
}
