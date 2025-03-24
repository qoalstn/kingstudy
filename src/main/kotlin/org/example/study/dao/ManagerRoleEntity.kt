package org.example.study.dao

import org.example.study.model.ManagerRole
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ManagerRoleEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ManagerRoleEntity>(ManagerRole)

    var manager by ManagerEntity referencedOn ManagerRole.managerId
    var roleType by ManagerRole.roleType
}