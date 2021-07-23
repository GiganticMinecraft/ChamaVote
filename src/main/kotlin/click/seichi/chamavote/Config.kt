package click.seichi.chamavote

import org.bukkit.configuration.file.FileConfiguration

object Config {
    private lateinit var config: FileConfiguration

    fun load() {
        saveDefaultConfig()

        reloadConfig()
        config = ChamaVote.plugin.config
    }

    fun setData(path: String, value: String?) {
        config.set(path, value)
        saveConfig()
    }

    fun getSection(path: String) = config.getConfigurationSection(path)

    private fun reloadConfig() = ChamaVote.plugin.reloadConfig()

    private fun saveDefaultConfig() = ChamaVote.plugin.saveDefaultConfig()

    private fun saveConfig() = ChamaVote.plugin.saveConfig()
}