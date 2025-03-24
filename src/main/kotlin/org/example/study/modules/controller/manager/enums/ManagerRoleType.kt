package org.example.study.modules.controller.manager.enums

enum class ManagerRoleType {
    DSB, // 대시보드
    CSM, // 상담관리
    RDS; // 입소관리

    companion object {
        fun fromString(role: String): ManagerRoleType? {
            return try {
                valueOf(role)
            } catch (e: IllegalArgumentException) {
                null
            }
        }
    }
}


//enum class ManagerRoleType(val role: String) {
//    DSB("DSB"), // 대시보드
//    CSM("CSM"), // 상담관리
//    RDS("RDS"); // 입소관리
//
//    companion object {
//        fun fromString(role: String): ManagerRoleType? {
//            return values().find { it.role == role }
//        }
//    }
//}