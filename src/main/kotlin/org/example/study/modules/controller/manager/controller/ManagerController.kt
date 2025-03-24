package org.example.study.modules.controller.manager.controller

import org.example.study.modules.controller.manager.dto.res.ManagerDto
import org.example.study.modules.controller.manager.service.managerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/manager")
class managerController(private val managerService: managerService) {

    @GetMapping("hello")
    fun hello(): String {
        return "Hello, manager!"
    }

    @GetMapping("/list")
    fun getManagers():ResponseEntity<List<Map<String, Any>>>{
        val managers = managerService.getAllUsers()
        return ResponseEntity(managers, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getManagers(@PathVariable id:Int):ResponseEntity<ManagerDto>{
        val manager = managerService.getManagersById(id)
        return ResponseEntity(manager, HttpStatus.OK)
    }
}
