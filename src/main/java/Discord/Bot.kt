package Discord

import com.jessecorbett.diskord.dsl.bot
import com.jessecorbett.diskord.dsl.command
import com.jessecorbett.diskord.dsl.commands

class Bot {
    val TOKEN = "alright then keep your secrets"
    // User ids used for mentioning people
    val Broni = "146227284653637632"
    val Esben = "148814672450027520"
    val Emil = "130866695957905408"
    val Rasmus = "118062123216666626"

    suspend fun start() {
        bot(TOKEN) {
            commands("!") {
                command("Hvad skal vi have at spise i morgen?") {
                    reply("\uD83E\uDD37\u200D♂️<@$Emil>\uD83D\uDC40")
                    delete()
                }
                command("Hvad skal vi have at spise i næste uge?"){
                    reply("Mandag: \uD83E\uDD37\u200D♂️" + "\n" +
                               "Tirsdag: \uD83E\uDD37\u200D♂️" + "\n" +
                               "Onsdag: \uD83E\uDD37\u200D♂️" + "\n" +
                               "Torsdag: \uD83E\uDD37\u200D♂️" + "\n" +
                               "Fredag: \uD83E\uDD37\u200D♂️" + "\n" +
                               "Lørdag: \uD83E\uDD37\u200D♂️" + "\n" +
                               "Søndag: \uD83E\uDD37\u200D♂️" + "\n")
                }
            }
        }
    }
}