package com.codegym.model.service.role;

import com.codegym.model.entity.Role;
import com.codegym.model.service.GeneralService;

public interface RoleService extends GeneralService<Role> {
    Role findByName(String name);
}
