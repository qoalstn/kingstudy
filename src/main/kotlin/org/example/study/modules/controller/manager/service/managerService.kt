package org.example.study.modules.controller.manager.service

import org.example.study.model.Manager
import org.example.study.model.ManagerRole
import org.example.study.modules.controller.manager.dto.res.ManagerDto
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service

@Service
class managerService {

    fun getAllUsers():List<Map<String,Any>>{
        val managers = transaction {
            Manager.selectAll().map {
                mapOf(
                    "id" to it[Manager.id],
                    "name" to it[Manager.name],
                    "email" to it[Manager.email],
                )
            }
        }

        println("managers : "+ managers)
        return managers
    }

    fun getManagersById(id:Int):ManagerDto?{
        println("id : "+id)

        return  transaction{
            Manager
                .leftJoin(ManagerRole)
                .select { Manager.id eq id }
                .groupBy{it[Manager.id]}
                .map { (managerId, rows)->
                    ManagerDto (
                        name = rows.first()[Manager.name],
                        email = rows.first()[Manager.email],
                        roleTypes =rows.mapNotNull { it.getOrNull(ManagerRole.roleType) }
                    )
                }
                .also { println("쿼리 결과: ${it.toList()}") } // 결과 출력
                .singleOrNull()
        }
    }
}