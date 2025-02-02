package br.com.hytech.rhsouthsystem.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<Entity, Id, Repository extends JpaRepository<Entity, Id>> {
    private final Repository repository;

    protected AbstractService(Repository repository) {
        this.repository = repository;
    }

    public Optional<Entity> findById(Id id) {
        return repository.findById(id);
    }

    public Collection<Entity> findAll() {
        return repository.findAll();
    }

    public List<Entity> saveAll(List<Entity> entities) {
        return repository.saveAll(entities);
    }

    public Entity save(Entity entity) {
        entity = validateSave(entity);
        return repository.save(entity);
    }

    public abstract Entity validateSave(Entity entity);

    public void deleteById(Id id){
        repository.deleteById(id);
    }

    public void delete(Entity entity){
        repository.delete(entity);
    }

    public Repository getRepository(){
        return this.repository;
    }
}
