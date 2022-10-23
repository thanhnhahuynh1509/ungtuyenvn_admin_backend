package com.doanchuyennganh.ungtuyenvnadmin.controller;

import com.doanchuyennganh.ungtuyenvnadmin.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<T, ID> {

    protected final BaseService<T, ID> baseService;

    public BaseController(BaseService<T, ID> baseService) {
        this.baseService = baseService;
    }

    @PostMapping("")
    public ResponseEntity<T> save(@RequestBody T model) {
        return new ResponseEntity<>(baseService.save(model), HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<T> gets() {
        return baseService.gets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> get(@PathVariable ID id) {
        return ResponseEntity.ok(baseService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T model) {
        return ResponseEntity.ok(baseService.update(id, model));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable ID id) {
        baseService.delete(id);
        return ResponseEntity.ok("OK");
    }
}
