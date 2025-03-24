package org.example.study.model

import org.example.study.modules.controller.manager.enums.ManagerRoleType
import org.hibernate.mapping.UniqueKey
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Table

object ManagerRole : IntIdTable("manager_role") {
    val managerId = reference("managerId", Manager.id)
    val roleType = enumerationByName("roleType",10, ManagerRoleType::class)

    // managerId와 roleType이 유니크하도록 설정
    init {
        uniqueIndex("idx_manager_role", managerId, roleType)
    }
}