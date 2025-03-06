package org.example.study.repositories
import org.springframework.data.jpa.repository.JpaRepository
import org.example.study.model.User

interface UserRepository : JpaRepository<User, Long>  {
}