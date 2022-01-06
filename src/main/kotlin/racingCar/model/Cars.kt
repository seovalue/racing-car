package racingCar.model

class Cars(val cars: List<Car>) : List<Car> by cars {

    fun moveAll(moveStrategy: MoveStrategy): Cars {
        val newCars = map { car -> car.move(moveStrategy) }
        return Cars(newCars)
    }

    fun findMaxPosition(): Int {
        var maxPosition = 0
        for (car in cars) {
            if (car.position > maxPosition) {
                maxPosition = car.position
            }
        }
        return maxPosition
    }

    fun findCarsBySamePosition(position: Int): List<Car> {
        return filter { car -> car.isSamePosition(position) }
    }
}