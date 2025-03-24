package org.example.study.dao

import org.example.study.dao.ManagerRoleEntity.Companion.referrersOn
import org.example.study.model.Manager
import org.example.study.model.ManagerRole
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ManagerEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ManagerEntity>(Manager)

    var name by Manager.name
    var email by Manager.email
    // ManagerRole과의 관계를 설정 (부모 테이블에서 자식 테이블로)
    val roles by ManagerRoleEntity referrersOn ManagerRole.roleType
}