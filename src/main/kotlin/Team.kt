abstract class Team constructor(var teamName: String, var teamCity : String) {
    private var teamPlayers = mutableListOf<Player>()
    abstract var teamCaptain: Player
    open fun addPlayer(player: Player)
    {
        teamPlayers.add(player)
    }
    open fun removePlayer(player: Player): Boolean {
        return teamPlayers.remove(player)
    }
}