package racingCar

import racingCar.model.Car
import racingCar.model.Cars
import racingCar.model.MoveStrategy

class RacingCarGame (private var cars: Cars, private val tryNumber: Int){

    fun race(moveStrategy: MoveStrategy): Pair<List<Cars>, List<Car>> {
        val carsGroup = mutableListOf<Cars>()
        repeat(tryNumber) {
            cars = cars.moveAll(moveStrategy)
            carsGroup.add(this.cars)
        }

        return carsGroup to findWinners()
    }

    private fun findWinners(): List<Car> {
        val maxPosition = cars.findMaxPosition()
        return cars.findCarsBySamePosition(maxPosition)
    }
}