package io.getarrays.userservice.api;

import lombok.Data;

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}
