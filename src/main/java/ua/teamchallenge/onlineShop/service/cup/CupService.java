package ua.teamchallenge.onlineShop.service.cup;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.teamchallenge.onlineShop.service.CrudService;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("ClassCanBeRecord")
@Service
@RequiredArgsConstructor
public class CupService implements CrudService<CupDto> {
    private final CupRepository repository;
    private final CupMapper mapper;

    @Override
    public List<CupDto> findAll() {
        List<CupDto> cupList = repository.findAll().stream()
                .map(mapper::mapToDto)
                .toList();
        if (cupList.isEmpty()) {
            throw new RuntimeException("There is no Cups found!");
        } else {
            return cupList;
        }
    }

    @Override
    public CupDto findById(UUID id) {
        return repository.findById(id)
                .map(mapper::mapToDto)
                .orElseThrow(() -> new RuntimeException(String.format("Cup with given id: %s not found!", id)));
    }

    @Override
    public CupDto create(CupDto cupDto) {
        try {
            Cup savedCup = repository.save(mapper.mapToDao(cupDto));
            return mapper.mapToDto(savedCup);
        } catch (Exception e) {
            throw new RuntimeException("Cup not saved! Cup must be not null");
        }
    }

    @Override
    public CupDto update(CupDto cupDto) {
        UUID cupId = cupDto.getId();
        Cup updatedCup = repository.findById(cupId)
                .map((n) -> repository.save(mapper.mapToDao(cupDto)))
                .orElseThrow(() -> new RuntimeException(String.format(
                        "Cup with given id: %s not updated! Cup not exist or null", cupId)));
        return mapper.mapToDto(updatedCup);
    }

    @Override
    public void delete(CupDto cupDto) {
        try {
            repository.delete(mapper.mapToDao(cupDto));
        } catch (Exception e) {
            throw new RuntimeException("Cup not deleted! Cup not exist or null");
        }
    }

    @Override
    public void deleteById(UUID id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(String.format(
                    "Cup with given id: %s not deleted! Cup not exist or id is null", id));
        }
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
