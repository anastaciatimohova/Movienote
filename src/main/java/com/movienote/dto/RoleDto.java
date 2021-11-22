package com.movienote.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.movienote.model.Role;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleDto {

    private String name;

    public Role toRole() {

        Role role = new Role();

        role.setName(name);

        return role;
    }

    public RoleDto toDto(Role role) {

        RoleDto roleDto = new RoleDto();

        roleDto.setName(role.getName());

        return roleDto;
    }
}
