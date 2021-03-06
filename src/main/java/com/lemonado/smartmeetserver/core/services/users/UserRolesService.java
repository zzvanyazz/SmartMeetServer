package com.lemonado.smartmeetserver.core.services.users;

import com.lemonado.smartmeetserver.core.data.exceptions.ActionOnAdminRoleException;
import com.lemonado.smartmeetserver.core.data.exceptions.RoleNotFoundException;
import com.lemonado.smartmeetserver.core.data.exceptions.UserNotFoundException;
import com.lemonado.smartmeetserver.core.data.models.roles.RoleModel;
import com.lemonado.smartmeetserver.core.data.models.users.UserRoleModel;
import com.lemonado.smartmeetserver.core.repositories.UserRolesModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRolesService {

    @Autowired
    private UserRolesModelRepository userRolesModelRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    public List<UserRoleModel> streamUserRoles(long userId) throws UserNotFoundException {
        userService.ensureExists(userId);
        return userRolesModelRepository.findByUserId(userId);
    }

    public void assignUserRole(long userId, long roleId)
            throws UserNotFoundException, RoleNotFoundException, ActionOnAdminRoleException {
        userService.ensureExists(userId);
        roleService.ensureExists(roleId);
        ensureAllowed(roleId);
        if (!userRolesModelRepository.isExists(userId, roleId))
            userRolesModelRepository.saveAssign(userId, roleId);
    }

    public void removeAssignUserRole(long userId, long roleId)
            throws UserNotFoundException, RoleNotFoundException, ActionOnAdminRoleException {
        userService.ensureExists(userId);
        roleService.ensureExists(roleId);
        ensureAllowed(roleId);
        if (userRolesModelRepository.isExists(userId, roleId))
            userRolesModelRepository.removeAssign(userId, roleId);
    }

    public List<RoleModel> getUserRoles(long userId) throws UserNotFoundException, RoleNotFoundException {
        var roleIdList =  streamUserRoles(userId)
                .stream()
                .map(UserRoleModel::roleId)
                .collect(Collectors.toList());
        var userRoles = new ArrayList<RoleModel>();

        for (Long id: roleIdList) {
            var role = roleService.getById(id);
            userRoles.add(role);
        }
        return userRoles;
    }

    private void ensureAllowed(long roleId)
            throws RoleNotFoundException, ActionOnAdminRoleException {
        var role = roleService.getById(roleId);
        if (role.name().equals(RoleModel.ADMIN))
            throw new ActionOnAdminRoleException();
    }

}
