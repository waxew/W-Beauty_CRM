package com.wcrm.engine.runtime.shared

import com.wcrm.engine.businessprofile.BusinessModule
import com.wcrm.engine.businessprofile.BusinessProfileRegistry

/** Registry خواندنی Runtime که مستقیماً از Business Profile فعال تغذیه می‌شود. */
class RuntimeRegistry {
    fun modules(): Set<BusinessModule> = BusinessProfileRegistry.enabledModules()

    fun isEnabled(module: BusinessModule): Boolean = BusinessProfileRegistry.isModuleEnabled(module)
}
