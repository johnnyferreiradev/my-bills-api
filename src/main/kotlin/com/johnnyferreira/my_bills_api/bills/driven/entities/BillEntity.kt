package com.johnnyferreira.my_bills_api.bills.driven.entities

import com.johnnyferreira.my_bills_api.shared.driven.entities.BaseEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "bill")
data class BillEntity(
    @Column(nullable = false)
    val title: String,

    @Column(nullable = false)
    val value: Int,

    @Column(name = "due_date", nullable = false)
    val dueDate: LocalDateTime,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val status: String,

    @Column(name = "paid_at")
    val paidAt: LocalDateTime,

    @ManyToOne
    @JoinColumn(name = "users_id")
    val user: UserEntity
) : BaseEntity()
