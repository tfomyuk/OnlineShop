package ua.teamchallenge.onlineShop.service.shopper;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShopperRepository extends JpaRepository<Shopper, UUID> {
}