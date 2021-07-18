package click.seichi.chamavote

import com.sk89q.worldguard.bukkit.WorldGuardPlugin
import org.bukkit.Location
import org.bukkit.World

object WorldGuard {
    private var instance: WorldGuardPlugin? = null

    fun setInstance() {
        val plugin = ChamaVote.plugin.server.pluginManager.getPlugin("WorldGuard")

        if (plugin != null && plugin is WorldGuardPlugin) instance = plugin
    }

    fun getRegions(world: World, location: Location)
        = instance?.getRegionManager(world)?.getApplicableRegions(location)?.regions?.filterNotNull()?.toSet() ?: setOf()
}
