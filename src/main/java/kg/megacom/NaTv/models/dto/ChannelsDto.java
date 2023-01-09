package kg.megacom.NaTv.models.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class ChannelsDto {
    Long id;
    String name;
    int orderNum;
    String photo;
    Boolean active;
}
