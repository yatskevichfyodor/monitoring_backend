package base.anygame.model.dto

data class ServerDto (
        val id: Long = 0,
        val name: String = "",
        val ip: String = "",
        val gameId: Long = 0,
        val gameName: String? = "",
        val activePlayersNumber: Int = 0,
        val maxPlayersNumber: Int = 0,
        val imageData: String = ""
) {
    override fun equals(other: Any?): Boolean {
        return true
    }
    override fun hashCode(): Int {
        return 1
    }
    override fun toString(): String {
        return ""
    }
}