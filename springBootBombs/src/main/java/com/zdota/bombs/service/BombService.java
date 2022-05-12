package com.zdota.bombs.service;

import com.zdota.bombs.domain.Bomb;

import java.util.List;

public interface BombService {
    Bomb create(Bomb bomb);

    List<Bomb> view();

    Bomb viewById(Integer id);

    Bomb update(Integer id, Bomb bomb);

    void delete(Integer id);

    void deleteAll();
}

