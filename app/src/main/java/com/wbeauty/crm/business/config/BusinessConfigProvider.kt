package com.wbeauty.crm.business.config

/**
 * نقطه ورود واحد برای دسترسی به تنظیمات کسب و کار.
 *
 * لایه های Core نباید نام، برند، متن یا ظاهر یک کسب و کار خاص را بشناسند.
 * تمام اطلاعات وابسته به محصول از این Provider خوانده می شود.
 */
object BusinessConfigProvider {

    val profile: BusinessProfile
        get() = BusinessProfile

    val identity: BusinessIdentityConfig
        get() = BusinessIdentityConfig

    val theme: BusinessThemeConfig
        get() = BusinessThemeConfig

    val texts: BusinessTextConfig
        get() = BusinessTextConfig

    val features: BusinessFeatureConfig
        get() = BusinessFeatureConfig

    val assets: BusinessAssetsConfig
        get() = BusinessAssetsConfig
}
