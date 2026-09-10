package business_profile

/**
 * Runtime state for the currently selected Business Profile.
 *
 * This layer only resolves configuration and must not contain
 * industry-specific business logic.
 */
object BusinessProfileRuntime {

    private var activeProfileId: String = "mobile_store_001"

    fun setActiveProfile(profileId: String): Boolean {
        if (!StoreProfileRegistry.exists(profileId)) return false
        activeProfileId = profileId
        return true
    }

    fun getActiveProfileId(): String = activeProfileId

    fun getActiveProfileType(): String? =
        StoreProfileRegistry.getType(activeProfileId)
}
