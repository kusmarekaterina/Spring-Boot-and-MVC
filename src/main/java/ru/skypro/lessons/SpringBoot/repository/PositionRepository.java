package ru.skypro.lessons.SpringBoot.repository;

import org.springframework.data.repository.CrudRepository;
import ru.skypro.lessons.SpringBoot.model.Position;

public interface PositionRepository extends CrudRepository<Position, Integer> {

    Position findByPositionName(String positionName);

    Position findByPositionId(Long positionId);
}

