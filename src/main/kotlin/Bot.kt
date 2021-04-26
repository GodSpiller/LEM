import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.jessecorbett.diskord.dsl.bot
import com.jessecorbett.diskord.dsl.command
import com.jessecorbett.diskord.dsl.commands
import java.io.File
import kotlin.random.Random

class Bot {
    val TOKEN = "Nzc2ODM2ODA1NDMzNDkxNDk2.X66rpw._pryJw6VZyfDj0kZ84LU0B61FkA"
    // User ids used for mentioning people
    val Broni = "146227284653637632"
    val Esben = "148814672450027520"
    val Emil = "130866695957905408"
    val Rasmus = "118062123216666626"

    val file = File("D:\\repos\\LEM\\src\\main\\kotlin\\Meals.json")
    val mapper = jacksonObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    val mealList: List<Meal> = mapper.readValue(file)


    suspend fun start() {
        val randomValues = List(7) { Random.nextInt(0, mealList.size)}
        bot(TOKEN) {
            commands("!") {
                command("Hvad skal vi have at spise i morgen?") {
                    reply("\uD83E\uDD37\u200D♂️<@$Emil>\uD83D\uDC40")
                }
                command("Hvad skal vi have at spise i næste uge?"){
                    reply("Mandag: ${mealList.get(randomValues[0]).name}" + "\n" +
                            "Tirsdag: ${mealList.get(randomValues[1]).name}" + "\n" +
                            "Onsdag: ${mealList.get(randomValues[2]).name}" + "\n" +
                            "Torsdag: ${mealList.get(randomValues[3]).name}" + "\n" +
                            "Fredag: ${mealList.get(randomValues[4]).name}" + "\n" +
                            "Lørdag: ${mealList.get(randomValues[5]).name}" + "\n" +
                            "Søndag: ${mealList.get(randomValues[6]).name}" + "\n")
                }
            }
        }
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
data class Meal(
    val name: String?,
    val cost: Int,
    val frequency: Double
)