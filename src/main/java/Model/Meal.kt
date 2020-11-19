package Model

class Meal (val name: String, val ingredients: List<Ingredient>, val frequency: Double, val isDoubleDay: Boolean) {
    val price get() = ingredients.sumByDouble { ingredient -> ingredient.price }
}