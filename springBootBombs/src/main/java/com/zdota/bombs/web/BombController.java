package com.zdota.bombs.web;

import com.zdota.bombs.domain.Bomb;
import com.zdota.bombs.service.BombService;
import com.zdota.bombs.service.BombServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class BombController {

    private final BombService bombService;

    public BombController(BombService bombService) {

        this.bombService = bombService;
    }

@PostMapping("/bombs")
@ResponseStatus(HttpStatus.CREATED)
 public Bomb createBomb(@RequestBody Bomb bomb){

        return bombService.create(bomb);
    }

    @GetMapping("/bombs")
    @ResponseStatus(HttpStatus.OK)
    public List<Bomb> getAllBombs() {

        return bombService.view();
    }

    @GetMapping("/bombs/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Bomb getBomb(@PathVariable Integer id) {
        return bombService.viewById(id);
    }
    @PutMapping("/bombs/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Bomb updateBombs(@PathVariable("id") Integer id, @RequestBody Bomb bomb) {
        return bombService.update(id, bomb);
    }
    @DeleteMapping("/bombs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeBomb(@PathVariable Integer id) {
        bombService.delete(id);
    }

    @DeleteMapping("/bombs")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllBombs() {
        bombService.deleteAll();
    }

}
