package com.johnnyferreira.my_bills_api.bills.driven.entities

import com.johnnyferreira.my_bills_api.bills.domain.enums.UserRoleEnum
import jakarta.persistence.*
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false, unique = true)
    val username: String,

    @Column(nullable = false)
    val password: String,

    @Column(nullable = false, unique = true)
    val email: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val role: UserRoleEnum,

    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false, updatable = false)
    val updatedAt: LocalDateTime = LocalDateTime.now(),
) : UserDetails {
    override fun getAuthorities(): List<SimpleGrantedAuthority> {
        return when (role) {
            UserRoleEnum.ADMIN -> listOf(
                SimpleGrantedAuthority("ROLE_ADMIN"),
                SimpleGrantedAuthority("ROLE_USER")
            )

            UserRoleEnum.USER -> listOf(SimpleGrantedAuthority("ROLE_USER"))
        }
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }
}