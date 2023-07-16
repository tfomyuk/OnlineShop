package ua.teamchallenge.onlineShop.service.shopper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.teamchallenge.onlineShop.service.CrudService;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("ClassCanBeRecord")
@Service
@RequiredArgsConstructor
public class ShopperService implements CrudService<ShopperDto> {
    private final ShopperRepository repository;
    private final ShopperMapper mapper;

    @Override
    public List<ShopperDto> findAll() {
        List<ShopperDto> shopperList = repository.findAll().stream()
                .map(mapper::mapToDto).toList();
        if (shopperList.isEmpty()) {
            throw new RuntimeException("There is no Shoppers found!");
        } else {
            return shopperList;
        }
    }

    @Override
    public ShopperDto findById(UUID id) {
        return repository.findById(id)
                .map(mapper::mapToDto)
                .orElseThrow(() -> new RuntimeException(String.format("Shopper with given id: %s not found!", id)));
    }

    @Override
    public ShopperDto create(ShopperDto shopperDto) {
        try {
            Shopper savedShopper = repository.save(mapper.mapToDao(shopperDto));
            return mapper.mapToDto(savedShopper);
        } catch (Exception e) {
            throw new RuntimeException("Shopper not saved! Shopper must be not null");
        }
    }

    @Override
    public ShopperDto update(ShopperDto shopperDto) {
        UUID shopperId = shopperDto.getId();
        Shopper updatedShopper = repository.findById(shopperId)
                .map((n) -> repository.save(mapper.mapToDao(shopperDto)))
                .orElseThrow(() -> new RuntimeException(String.format(
                        "Shopper with given id: %s not updated! Shopper not exist or null", shopperId)));
        return mapper.mapToDto(updatedShopper);
    }

    @Override
    public void delete(ShopperDto shopperDto) {
        try {
            repository.delete(mapper.mapToDao(shopperDto));
        } catch (Exception e) {
            throw new RuntimeException("Shopper not deleted! Shopper not exist or null");
        }
    }

    @Override
    public void deleteById(UUID id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(String.format(
                    "Shopper with given id: %s not deleted! Shopper not exist or id is null", id));
        }
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
