package ua.teamchallenge.onlineShop.service.cup;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CupRepository extends JpaRepository<Cup, UUID> {
}