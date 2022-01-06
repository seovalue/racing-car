package racingCar.model

class Car(
    val carName: CarName,
    val position: Int = 0,
) {
    fun move(moveStrategy: MoveStrategy): Car {
        if (moveStrategy.canMove()) {
            return Car(carName, position + 1)
        }
        return this
    }

    fun isSamePosition(position: Int): Boolean {
        return this.position == position
    }

    fun name() : String {
        return carName.name
    }
}