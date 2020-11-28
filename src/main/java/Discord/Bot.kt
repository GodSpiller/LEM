package Discord

import com.jessecorbett.diskord.dsl.bot

class Bot {
    val TOKEN = "Nzc2ODM2ODA1NDMzNDkxNDk2.X66rpw.pK5ElEN8YlmsrpuQ82CEpXqSxfs"

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