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
import ua.teamchallenge.onlineShop.service.shopper.ShopperDto;
import ua.teamchallenge.onlineShop.service.shopper.ShopperService;

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
@Tag(name = "Shopper Service",
        description = "Provide crud operations for Shoppers")
@RequestMapping("/api/shopper")
public class ShopperController implements CrudController<ShopperDto> {
    private final ShopperService service;
    private final ResponseEntityHandler entityHandler;

    @Override
    @GetMapping("/get/all")
    @Operation(summary = "Retrieve Shoppers list", description = "Find Shoppers in DB")
    public ResponseEntity<?> getAll() {
        try {
            List<ShopperDto> shopperList = service.findAll();
            return ResponseEntity.ok(shopperList);
        } catch (Exception e) {
            return entityHandler.responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @GetMapping("/get")
    @Operation(summary = "Retrieve Shopper", description = "Find Shopper in DB by UUID")
    public ResponseEntity<?> getById(
            @RequestParam("id")
            @Parameter(name = "id", description = "Shopper identifier", example = "fcf12a8d-91e9-4bb6-b60b-53d6d97a9f44")
                    UUID id) {
        try {
            ShopperDto shopperDto = service.findById(id);
            return ResponseEntity.ok(shopperDto);
        } catch (Exception e) {
            return entityHandler.responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @PostMapping("/create")
    @Operation(summary = "Create Shopper", description = "Creates Shopper in DB using Shopper object without UUID")
    public ResponseEntity<?> create(
            @RequestBody
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Shopper to add", required = true,
                    content = @Content(schema=@Schema(implementation = ShopperDto.class)))
                    ShopperDto shopperDto) {
        try {
            ShopperDto createdShopper = service.create(shopperDto);
            return ResponseEntity.ok(createdShopper);
        } catch (Exception e) {
            return entityHandler.responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @PostMapping("/update")
    @Operation(summary = "Update Shopper", description = "Updates Shopper in DB using Shopper object with UUID")
    public ResponseEntity<?> update(
            @RequestBody
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Shopper to update", required = true,
                    content = @Content(schema=@Schema(implementation = ShopperDto.class)))
                    ShopperDto shopperDto) {
        try {
            ShopperDto updatedShopper = service.update(shopperDto);
            return ResponseEntity.ok(updatedShopper);
        } catch (Exception e) {
            return entityHandler.responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @DeleteMapping("/delete")
    @Operation(summary = "Delete Shopper", description = "Removes Shopper from DB using Shopper object")
    public ResponseEntity<?> delete(
            @RequestBody
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Shopper to remove", required = true,
                    content = @Content(schema=@Schema(implementation = ShopperDto.class)))
                    ShopperDto shopperDto) {
        try {
            service.delete(shopperDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return entityHandler.responseEntityNotFound(e.getMessage());
        }
    }

    @Override
    @DeleteMapping("/delete/id")
    @Operation(summary = "Delete Shopper", description = "Removes Shopper from DB using Shopper UUID")
    public ResponseEntity<?> deleteById(
            @RequestParam("id")
            @Parameter(name = "id", description = "Shopper identifier", example = "fcf12a8d-91e9-4bb6-b60b-53d6d97a9f44")
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
    @Operation(summary = "Delete all Shoppers", description = "Removes all Shoppers from DB")
    public ResponseEntity<?> deleteAll() {
        service.deleteAll();
        return ResponseEntity.ok().build();
    }
}
