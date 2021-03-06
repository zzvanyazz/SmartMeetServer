package com.lemonado.smartmeetserver.web.rest.controllers;


import com.lemonado.smartmeetserver.core.services.users.RoleService;
import com.lemonado.smartmeetserver.web.rest.models.auth.AuthorityRole;
import com.lemonado.smartmeetserver.web.rest.models.mappings.RoleMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/roles")
public class RoleController {


    @Autowired
    private RoleService roleService;


    @ApiOperation("List roles.")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Secured({AuthorityRole.ADMIN, AuthorityRole.MANAGER})
    public ResponseEntity<?> listRoles() {
        var roles = roleService.getAll();
        var roleDtos = roles.stream().map(RoleMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(roleDtos);
    }

}
