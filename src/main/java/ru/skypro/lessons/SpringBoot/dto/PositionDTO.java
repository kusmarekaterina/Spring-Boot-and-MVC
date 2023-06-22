package ru.skypro.lessons.SpringBoot.dto;


import org.springframework.stereotype.Component;
import ru.skypro.lessons.SpringBoot.model.Position;

@Component
public class PositionDTO {
    private int id;
    private String positionName;

    public PositionDTO(int id, String positionName) {
        this.id = id;
        this.positionName = positionName;
    }

    public PositionDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public static PositionDTO fromPosition(Position position) {
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setId(position.getId());
        positionDTO.setPositionName(position.getPositionName());
        return positionDTO;
    }

    public Position toPosition() {
        Position position = new Position();
        position.setId(this.getId());
        position.setPositionName(this.getPositionName());
        return position;
    }

}
