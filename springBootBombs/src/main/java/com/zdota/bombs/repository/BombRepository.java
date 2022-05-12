package com.zdota.bombs.repository;

import com.zdota.bombs.domain.Bomb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BombRepository extends JpaRepository<Bomb,Integer> {

}
