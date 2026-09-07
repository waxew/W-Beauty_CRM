package com.wbeauty.crm.feature.customer

object CustomerValidator {
    fun isValidName(name: String): Boolean = name.trim().isNotEmpty()

    fun isValidPhone(phone: String): Boolean =
        phone.length >= 8
}
