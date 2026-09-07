package com.wcrm.engine.businessprofile

import com.wcrm.engine.runtime.BusinessRuntime

class BusinessProfileLoader {
    fun load(profile: BusinessProfile): BusinessRuntime {
        return BusinessRuntime(
            profileId = profile.id,
            enabledModules = profile.modules
        )
    }
}
