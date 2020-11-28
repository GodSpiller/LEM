package Discord

import com.jessecorbett.diskord.dsl.bot

class Bot {
    val TOKEN = "Nzc2ODM2ODA1NDMzNDkxNDk2.X66rpw.Xha9p7O1KMPLyJclMg_9FQPcg0M"

    suspend fun pingpong() {

        bot(TOKEN) {
            messageCreated {
                if (it.content == "Oliver") {
                    it reply "suttar"
                }
            }
        }
    }
}