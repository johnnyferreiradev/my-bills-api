package com.johnnyferreira.my_bills_api.bills.domain.repositories

import com.johnnyferreira.my_bills_api.bills.driven.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails

interface UserRepository : JpaRepository<UserEntity, String> {
    fun findByUserName(username: String): UserDetails
}