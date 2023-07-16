package ua.teamchallenge.onlineShop.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.teamchallenge.onlineShop.service.cup.CupDto;
import ua.teamchallenge.onlineShop.service.cup.CupService;

import java.util.List;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@SuppressWarnings("ClassCanBeRecord")
@RequiredArgsConstructor
@RestController
@CrossOrigin(
        methods = {POST, GET, OPTIONS, PUT, DELETE, PATCH},
        maxAge = 3600,
        allowedHeaders = {"x-requested-with", "origin", "content-type", "accept"},
        origins = "*"
)
@Tag(   name = "Cups Service",
        description = "Provide crud operations for Cups")
@RequestMapping("/api/cup")
public class CupController implements CrudController<CupDto> {
    private final CupService service;

    @Override
    @GetMapping("/get/all")
    public ResponseEntity<?> getAll() {
        try {
            List<CupDto> cupList = service.findAll();
            return ResponseEntity.ok(cupList);
        } catch (Exception e) {
            return responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @GetMapping("/get")
    public ResponseEntity<?> getById(@RequestParam("id") UUID id) {
        System.err.println("UUID: "+id);
        try {
            CupDto cup = service.findById(id);
            return ResponseEntity.ok(cup);
        } catch (Exception e) {
            return responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CupDto cupDto) {
        try {
            CupDto createdCup = service.create(cupDto);
            return ResponseEntity.ok(createdCup);
        } catch (Exception e) {
            System.err.println("cup not saved");
            return responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody  CupDto cupDto) {
        try {
            CupDto updatedCup = service.create(cupDto);
            return ResponseEntity.ok(updatedCup);
        } catch (Exception e) {
            return responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody  CupDto cupDto) {
        try {
            service.delete(cupDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @DeleteMapping("/delete/id")
    public ResponseEntity<?> deleteById(@RequestParam("id") UUID id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @DeleteMapping("/delete/all")
    public ResponseEntity<?> deleteAll() {
        service.deleteAll();
        return ResponseEntity.ok().build();
    }

    private ResponseEntity<?> responseEntityNotFound(String exception) {
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), exception),
                HttpStatus.NOT_FOUND);
    }
}
