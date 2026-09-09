package com.wcrm.engine.config

import com.wcrm.engine.BuildConfig

/**
 * کانفیگ مرکزی برنامه.
 *
 * اطلاعات هویتی، برندینگ، تبلیغات، بروزرسانی و رفتارهای عمومی برنامه
 * باید از این فایل خوانده شوند تا برای ساخت یک اپ مستقل نیاز به پراکندگی
 * تنظیمات در فایل‌های مختلف نباشد.
 */
object AppConfig {

    object Identity {
        const val appName: String = "W-CRM"
        const val shortDescription: String = "مدیریت ارتباط با مشتریان و کسب‌وکار"
        const val launcherIconName: String = "ic_launcher"
        const val appLogoName: String = "ic_launcher"
        const val companyLogoName: String = "ic_as_team"
        const val companyName: String = "آکادمی آموزشی AS Team"
        const val supportEmail: String = "AS.Developers.Support@Gmail.Com"
        val versionName: String get() = BuildConfig.VERSION_NAME
        val versionCode: Int get() = BuildConfig.VERSION_CODE
    }

    object Branding {
        const val showAppNameInHeader: Boolean = true
        const val showAppLogoInHeader: Boolean = false
        const val useBusinessProfileVisuals: Boolean = true
        const val useBusinessProfileDashboard: Boolean = true
        const val useBusinessProfileTerminology: Boolean = true
    }

    object Ads {
        /** کل سیستم تبلیغات در سطح برنامه */
        const val enabled: Boolean = false

        /** در حالت مهمان، در صورت enabled=true تبلیغ مجاز است. */
        const val showForGuest: Boolean = true

        /** برای کاربر بدون اشتراک فعال، در صورت enabled=true تبلیغ مجاز است. */
        const val showForNonVip: Boolean = true

        /** کاربر VIP تا پایان اعتبار اشتراک تبلیغ نمی‌بیند. */
        const val hideForVip: Boolean = true

        /** محل قراردادن شناسه/کد شبکه تبلیغاتی در آینده. */
        const val providerName: String = ""
        const val appId: String = ""
        const val bannerUnitId: String = ""
        const val interstitialUnitId: String = ""
    }

    object Subscription {
        const val vipEnabled: Boolean = true
        const val guestAllowed: Boolean = true
    }

    object Update {
        const val checkOnAppStart: Boolean = true
        const val showPopupWhenUpdateAvailable: Boolean = true
        const val showNotificationDot: Boolean = true
        const val updateCheckUrl: String = ""
    }

    object Splash {
        const val enabled: Boolean = true
        const val showLogoMotion: Boolean = true
        const val minimumDurationMs: Long = 900L
    }

    object Header {
        const val showHamburgerMenu: Boolean = true
        const val showCenterBrand: Boolean = true
        const val showSectionMenu: Boolean = true
    }

    object Drawer {
        const val enabled: Boolean = true
        const val showProfileImage: Boolean = true
        const val allowProfileImageCrop: Boolean = true
        const val showSettings: Boolean = true
        const val showNotifications: Boolean = true
        const val showAbout: Boolean = true
        const val showContactUs: Boolean = true
        const val showShare: Boolean = true
        const val showBackupRestore: Boolean = true
        const val showUpdate: Boolean = true
    }

    object Backup {
        const val enabled: Boolean = true
        const val includeAllUserData: Boolean = true
    }

    object Navigation {
        /**
         * Back اول: بازگشت معمول داخل همان جریان.
         * اگر کاربر از Drawer/Section menu وارد جریان دیگری شده باشد، Back به Home می‌رود.
         */
        const val crossSectionBackGoesHome: Boolean = true
        const val secondBackGoesHome: Boolean = true
    }

    object Texts {
        const val noNotifications: String = "شما اعلان جدیدی ندارید"
        const val updateAvailable: String = "نسخه جدید رسید"
        const val settings: String = "تنظیمات"
        const val notifications: String = "اعلان‌ها"
        const val about: String = "درباره نرم افزار"
        const val contactUs: String = "تماس با ما"
        const val share: String = "معرفی به دوستان"
        const val backupRestore: String = "پشتیبان گیری"
        const val update: String = "آپدیت"
    }
}

/**
 * تنها نقطه تصمیم برای نمایش تبلیغ.
 * وضعیت VIP/Guest از لایه حساب کاربر وارد این تابع می‌شود و UI نباید منطق تبلیغ را تکرار کند.
 */
fun shouldShowAds(isGuest: Boolean, hasActiveVip: Boolean): Boolean {
    if (!AppConfig.Ads.enabled) return false
    if (hasActiveVip && AppConfig.Ads.hideForVip) return false
    if (isGuest) return AppConfig.Ads.showForGuest
    return AppConfig.Ads.showForNonVip
}
