package com.lemonado.smartmeetserver.core.services.users;

import com.lemonado.smartmeetserver.core.data.exceptions.RoleNotFoundException;
import com.lemonado.smartmeetserver.core.data.models.roles.RoleModel;
import com.lemonado.smartmeetserver.core.repositories.RoleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleModelRepository roleModelRepository;

    public List<RoleModel> getAll() {
        return roleModelRepository.getAll();
    }

    public long findId(String name) throws RoleNotFoundException {
        return roleModelRepository
                .findId(name)
                .orElseThrow(() -> new RoleNotFoundException(name));
    }

    public RoleModel getById(long id) throws RoleNotFoundException {
        return roleModelRepository.findById(id).orElseThrow(RoleNotFoundException::new);
    }

    public RoleModel getByName(String name) throws RoleNotFoundException {
        return roleModelRepository
                .findByName(name)
                .orElseThrow(() -> new RoleNotFoundException(name));

    }

    public void ensureExists(long roleId) throws RoleNotFoundException {
        if (!roleModelRepository.isExists(roleId))
            throw new RoleNotFoundException();
    }

}
