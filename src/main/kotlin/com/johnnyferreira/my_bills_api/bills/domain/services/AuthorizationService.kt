package com.johnnyferreira.my_bills_api.bills.domain.services

import com.johnnyferreira.my_bills_api.bills.domain.repositories.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthorizationService(private val repository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        return repository.findByUserName(username)
    }
}