package org.example.study.modules.controller.manager.dto.res

import org.example.study.modules.controller.manager.enums.ManagerRoleType

data class ManagerDto (
    val name: String,
    val email: String,
    val roleTypes : List<ManagerRoleType>?
)
