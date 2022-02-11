package com.example.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    @Id
    private Long id;
    private String itemName;
    private String itemPrice;
    private Integer itemAmount ;
    private Long itemID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
