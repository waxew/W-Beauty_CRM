package com.wcrm.engine

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * نقطه شروع موتور CRM.
 *
 * این کلاس مستقل از نوع کسب‌وکار است.
 * تنظیمات صنعت از طریق Business Profile و Runtime مدیریت می‌شود.
 */
@HiltAndroidApp
class CRMEngineApplication : Application()
