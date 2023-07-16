package ua.teamchallenge.onlineShop.service.tShort;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TShortRepository extends JpaRepository<TShort, UUID> {
}