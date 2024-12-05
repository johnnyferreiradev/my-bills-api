package com.johnnyferreira.my_bills_api.bills.driven.entities

import com.johnnyferreira.my_bills_api.shared.driven.entities.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "reminder")
data class ReminderEntity(
    @Column(nullable = false)
    val active: Boolean = true,

    @Column(name = "notify_at", nullable = false)
    val notifyAt: LocalDateTime,

    @ManyToOne
    @JoinColumn(name = "bill_id")
    val bill: BillEntity
) : BaseEntity()