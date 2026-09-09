package com.wcrm.engine.businessprofile

import com.wcrm.engine.businessprofile.profiles.auto_parts.ProfileConfig as AutoPartsProfile
import com.wcrm.engine.businessprofile.profiles.beauty_center.BeautyCenterProfile
import com.wcrm.engine.businessprofile.profiles.book_store.ProfileConfig as BookStoreProfile
import com.wcrm.engine.businessprofile.profiles.boutique.ProfileConfig as BoutiqueProfile
import com.wcrm.engine.businessprofile.profiles.grocery.ProfileConfig as GroceryProfile
import com.wcrm.engine.businessprofile.profiles.home_appliance.ProfileConfig as HomeApplianceProfile
import com.wcrm.engine.businessprofile.profiles.jewelry_store.ProfileConfig as JewelryStoreProfile
import com.wcrm.engine.businessprofile.profiles.mobile_store.MobileStoreProfile
import com.wcrm.engine.businessprofile.profiles.omnichannel.ProfileConfig as OmnichannelProfile
import com.wcrm.engine.businessprofile.profiles.pet_store.ProfileConfig as PetStoreProfile

/**
 * کاتالوگ مرکزی تمام Business Profileهای پروژه.
 *
 * هر ده Profile همیشه در سورس وجود دارند و کامل تعریف می‌شوند؛ اما در خروجی اختصاصی
 * فقط Profileی که enabled=true دارد فعال می‌شود. انتخاب Profile وظیفه برنامه‌نویس است،
 * نه کاربر نهایی.
 */
object BusinessProfileCatalog {
    val allProfiles: List<BusinessProfile> = listOf(
        MobileStoreProfile.profile,
        BeautyCenterProfile.profile,
        JewelryStoreProfile.profile,
        AutoPartsProfile.profile,
        HomeApplianceProfile.profile,
        BookStoreProfile.profile,
        GroceryProfile.profile,
        PetStoreProfile.profile,
        BoutiqueProfile.profile,
        OmnichannelProfile.profile
    )

    val supportedProfiles: List<String>
        get() = allProfiles.map { it.id }

    /**
     * Profile فعال نسخه. اگر صفر یا بیش از یک Profile فعال باشد، پیکربندی Build نامعتبر است.
     */
    fun requireActiveProfile(): BusinessProfile {
        val active = allProfiles.filter { it.enabled }
        require(active.size == 1) {
            "برای هر خروجی برنامه باید دقیقاً یک Business Profile با enabled=true وجود داشته باشد. تعداد فعلی: ${active.size}"
        }
        return active.single()
    }
}
