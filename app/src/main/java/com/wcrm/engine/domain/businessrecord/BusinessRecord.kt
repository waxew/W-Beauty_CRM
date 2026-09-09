package com.wcrm.engine.domain.businessrecord

/**
 * مدل عمومی رکورد کسب و کار.
 *
 * داده اختصاصی هر Profile داخل payloadJson ذخیره می‌شود تا Core مستقل از صنف بماند.
 */
data class BusinessRecord(
    val id: Long = 0,
    val profileId: String,
    val moduleId: String,
    val title: String,
    val payloadJson: String,
    val createdAt: Long = System.currentTimeMillis()
)
