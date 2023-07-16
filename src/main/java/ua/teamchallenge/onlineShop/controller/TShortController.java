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
import ua.teamchallenge.onlineShop.service.tShort.TShortDto;
import ua.teamchallenge.onlineShop.service.tShort.TShortService;

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
@Tag(name = "T-Short Service",
        description = "Provide crud operations for T-Shorts")
@RequestMapping("/api/t-short")
public class TShortController implements CrudController<TShortDto> {
    private final TShortService service;
    private final ResponseEntityHandler entityHandler;

    @Override
    @GetMapping("/get/all")
    @Operation(summary = "Retrieve T-Shorts list", description = "Find T-Shorts in DB")
    public ResponseEntity<?> getAll() {
        try {
            List<TShortDto> tShortList = service.findAll();
            return ResponseEntity.ok(tShortList);
        } catch (Exception e) {
            return entityHandler.responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @GetMapping("/get")
    @Operation(summary = "Retrieve T-Short", description = "Find T-Short in DB by UUID")
    public ResponseEntity<?> getById(
            @RequestParam("id")
            @Parameter(name = "id", description = "T-Short identifier", example = "fcf12a8d-91e9-4bb6-b60b-53d6d97a9f44")
                    UUID id) {
        try {
            TShortDto tShortDto = service.findById(id);
            return ResponseEntity.ok(tShortDto);
        } catch (Exception e) {
            return entityHandler.responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @PostMapping("/create")
    @Operation(summary = "Create T-Short", description = "Creates T-Short in DB using T-Short object without UUID")
    public ResponseEntity<?> create(
            @RequestBody
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "T-Short to add", required = true,
                    content = @Content(schema=@Schema(implementation = TShortDto.class)))
                    TShortDto tShortDto) {
        try {
            TShortDto createdTShortDto = service.create(tShortDto);
            return ResponseEntity.ok(createdTShortDto);
        } catch (Exception e) {
            return entityHandler.responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @PostMapping("/update")
    @Operation(summary = "Update T-Short", description = "Updates T-Short in DB using T-Short object with UUID")
    public ResponseEntity<?> update(
            @RequestBody
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "T-Short to update", required = true,
                    content = @Content(schema=@Schema(implementation = TShortDto.class)))
                    TShortDto tShortDto) {
        try {
            TShortDto updatedTShortDto = service.create(tShortDto);
            return ResponseEntity.ok(updatedTShortDto);
        } catch (Exception e) {
            return entityHandler.responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @DeleteMapping("/delete")
    @Operation(summary = "Delete T-Short", description = "Removes T-Short from DB using T-Short object")
    public ResponseEntity<?> delete(
            @RequestBody
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "T-Short to remove", required = true,
                    content = @Content(schema=@Schema(implementation = TShortDto.class)))
                    TShortDto tShortDto) {
        try {
            service.delete(tShortDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return entityHandler.responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @DeleteMapping("/delete/id")
    @Operation(summary = "Delete T-Short", description = "Removes T-Short from DB using T-Short UUID")
    public ResponseEntity<?> deleteById(
            @RequestParam("id")
            @Parameter(name = "id", description = "T-Short identifier", example = "fcf12a8d-91e9-4bb6-b60b-53d6d97a9f44")
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
    @Operation(summary = "Delete all T-Shorts", description = "Removes all T-Shorts from DB")
    public ResponseEntity<?> deleteAll() {
        service.deleteAll();
        return ResponseEntity.ok().build();
    }
}
