package ua.teamchallenge.onlineShop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.teamchallenge.onlineShop.service.ResponseEntityHandler;
import ua.teamchallenge.onlineShop.service.cup.CupDto;
import ua.teamchallenge.onlineShop.service.cup.CupService;

import java.util.List;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@SuppressWarnings("ClassCanBeRecord")
@RequiredArgsConstructor
@RestController
@CrossOrigin(
        methods = {POST, GET, PUT, DELETE/*, PATCH, OPTIONS*/},
        maxAge = 3600,
        allowedHeaders = {"x-requested-with", "origin", "content-type", "accept"},
        origins = "*"
)
@Tag(name = "Cup Service",
        description = "Provide crud operations for Cups")
@RequestMapping("/api/cup")
public class CupController implements CrudController<CupDto> {
    private final CupService service;
    private final ResponseEntityHandler entityHandler;

    @Override
    @GetMapping("/get/all")
    @Operation(summary = "Retrieve Cup list", description = "Find Cups in DB")
    public ResponseEntity<?> getAll() {
        try {
            List<CupDto> cupList = service.findAll();
            return ResponseEntity.ok(cupList);
        } catch (Exception e) {
            return entityHandler.responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @GetMapping("/get")
    @Operation(summary = "Retrieve Cup", description = "Find Cup in DB by UUID")
    public ResponseEntity<?> getById(
            @RequestParam("id")
            @Parameter(name = "id", description = "Cup identifier", example = "fcf12a8d-91e9-4bb6-b60b-53d6d97a9f44")
                    UUID id) {
        try {
            CupDto cup = service.findById(id);
            return ResponseEntity.ok(cup);
        } catch (Exception e) {
            return entityHandler.responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @PostMapping("/create")
    @Operation(summary = "Create Cup", description = "Creates Cup in DB using Cup object without UUID")
    public ResponseEntity<?> create(
            @RequestBody
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Cup to add", required = true,
                    content = @Content(schema=@Schema(implementation = CupDto.class)))
                    CupDto cupDto) {
        try {
            CupDto createdCup = service.create(cupDto);
            return ResponseEntity.ok(createdCup);
        } catch (Exception e) {
            System.err.println("Cup not saved");
            return entityHandler.responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @PostMapping("/update")
    @Operation(summary = "Update Cup", description = "Updates Cup in DB using Cup object with UUID")
    public ResponseEntity<?> update(
            @RequestBody
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Cup to update", required = true,
                    content = @Content(schema=@Schema(implementation = CupDto.class)))
                    CupDto cupDto) {
        try {
            CupDto updatedCup = service.create(cupDto);
            return ResponseEntity.ok(updatedCup);
        } catch (Exception e) {
            return entityHandler.responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @DeleteMapping("/delete")
    @Operation(summary = "Delete Cup", description = "Removes Cup from DB using Cup object")
    public ResponseEntity<?> delete(
            @RequestBody
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Cup to remove", required = true,
                    content = @Content(schema=@Schema(implementation = CupDto.class)))
                    CupDto cupDto) {
        try {
            service.delete(cupDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return entityHandler.responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @DeleteMapping("/delete/id")
    @Operation(summary = "Delete Cup", description = "Removes Cup from DB using Cup UUID")
    public ResponseEntity<?> deleteById(
            @RequestParam("id")
            @Parameter(name = "id", description = "Cup identifier", example = "fcf12a8d-91e9-4bb6-b60b-53d6d97a9f44")
                    UUID id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return entityHandler.responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @DeleteMapping("/delete/all")
    @Operation(summary = "Delete all Cups", description = "Removes all Cups from DB")
    public ResponseEntity<?> deleteAll() {
        service.deleteAll();
        return ResponseEntity.ok().build();
    }
}
