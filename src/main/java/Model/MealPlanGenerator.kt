package Model

import java.util.*
import kotlin.math.abs
import kotlin.math.pow
import kotlin.random.Random

fun Date.differenceDays(other: Date): Int = ((this.time - other.time).toDouble() / 86400).toInt()
infix fun Date.isConsecutive(other: Date) = this.differenceDays(other) == -1

class MealPlanGenerator(val meals: List<Meal>) {

    private val totalFrequency = meals.sumByDouble { it.frequency }

    companion object {
        private val priceVariance = 0.3
        private val random = Random(System.currentTimeMillis())
    }


    fun generateNDays(datesToFill: List<Date>, plannedMeals: List<PlannedMeal>) {

        // Find the best meal for each day
        for (i in datesToFill.indices) {
            val (current, next) = Pair(datesToFill[i], datesToFill[i+1])

            val validMeals = if (current isConsecutive next) meals else meals.filter { !it.isDoubleDay }


            // Choose meal
            val meal = validMeals.minByOrNull {
                frequencyCost(it, plannedMeals) + recencyCost(it, current, plannedMeals)
            }!!
        }
    }

    private fun frequencyCost(m: Meal, plannedMeals: List<PlannedMeal>): Double {
        val actual = plannedMeals.count { it.meal == m }.toDouble() / plannedMeals.size
        val expected = m.frequency / totalFrequency

        return (actual - expected).pow(2.0)
    }

    private fun recencyCost(m: Meal, d: Date, plannedMeals: List<PlannedMeal>): Double {
        val daysSinceLast = plannedMeals.filter { it.meal == m }.map { abs(d.differenceDays(it.date)) }.minOrNull() ?: Int.MAX_VALUE
        return 1.0 / daysSinceLast
    }

}