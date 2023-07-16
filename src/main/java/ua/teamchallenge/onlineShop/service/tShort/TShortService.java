package ua.teamchallenge.onlineShop.service.tShort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.teamchallenge.onlineShop.service.CrudService;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("ClassCanBeRecord")
@Service
@RequiredArgsConstructor
public class TShortService implements CrudService<TShortDto> {
    private final TShortRepository repository;
    private final TShortMapper mapper;

    @Override
    public List<TShortDto> findAll() {
        List<TShortDto> tShotList = repository.findAll().stream()
                .map(mapper::mapToDto).toList();
        if (tShotList.isEmpty()) {
            throw new RuntimeException("There is no T-Short found!");
        } else {
            return tShotList;
        }
    }

    @Override
    public TShortDto findById(UUID id) {
        return repository.findById(id)
                .map(mapper::mapToDto)
                .orElseThrow(()-> new RuntimeException(String.format("T-Short with given id: %s not found!", id)));
    }

    @Override
    public TShortDto create(TShortDto tShortDto) {
        try {
            TShort savedTShort = repository.save(mapper.mapToDao(tShortDto));
        return mapper.mapToDto(savedTShort);
        } catch (Exception e) {
            throw new RuntimeException("T-Short not saved! T-Short must be not null");
        }
    }

    @Override
    public TShortDto update(TShortDto tShortDto) {
        UUID tShortId = tShortDto.getId();
        TShort updatedTShort = repository.findById(tShortId)
                .map((n) -> repository.save(mapper.mapToDao(tShortDto)))
                .orElseThrow(()-> new RuntimeException(String.format(
                        "T-Short with given id: %s not updated! T-Short not exist or null", tShortId)));
        return mapper.mapToDto(updatedTShort);
    }

    @Override
    public void delete(TShortDto tShortDto) {
        try {
            repository.delete(mapper.mapToDao(tShortDto));
        } catch (Exception e) {
            throw new RuntimeException("T-Short not deleted! T-Short not exist or null");
        }
    }

    @Override
    public void deleteById(UUID id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(String.format(
                    "T-Short with given id: %s not deleted! T-Short not exist or id is null", id));
        }
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
