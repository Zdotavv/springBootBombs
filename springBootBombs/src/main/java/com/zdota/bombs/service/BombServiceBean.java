package com.zdota.bombs.service;

import com.zdota.bombs.domain.Bomb;
import com.zdota.bombs.repository.BombRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BombServiceBean implements BombService{

    private final BombRepository bombRepository;


    @Override
    public Bomb create(Bomb bomb) {
        return bombRepository.save(bomb);
    }

    @Override
    public List<Bomb> view() {
        return bombRepository.findAll();

    }

    @Override
    public Bomb viewById(Integer id) {
        return bombRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity Not Found with id: " + id));
    }

    @Override
    public Bomb update(Integer id, Bomb bomb) {
            return bombRepository.findById(id)
                    .map(entity -> {
                        entity.setName(bomb.getName());
                        entity.setWeight(bomb.getWeight());
                        entity.setCountry(bomb.getCountry());
                        entity.setDate(bomb.getDate());
                        return bombRepository.save(entity);
                    })
                    .orElseThrow(() -> new EntityNotFoundException("Bomb not found with id = " + id));
        }

    @Override
    public void delete(Integer id) {
    bombRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
    bombRepository.deleteAll();
    }
}
