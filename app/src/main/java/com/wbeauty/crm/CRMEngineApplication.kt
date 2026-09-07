package com.wbeauty.crm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * نقطه شروع موتور CRM.
 *
 * وظیفه:
 * - راه‌اندازی هسته برنامه
 * - آماده‌سازی Dependency Injection
 * - آماده‌سازی Runtime مربوط به Business Profile
 *
 * این کلاس نباید وابسته به صنعت خاصی باشد.
 * تنظیمات کسب‌وکار از طریق Business Profile تعیین می‌شود.
 */
@HiltAndroidApp
class CRMEngineApplication : Application()
