package racingCar.model

import racingCar.generateRandomNumber

class RandomMoveStrategy: MoveStrategy {
    override fun canMove(): Boolean {
        return generateRandomNumber() >= MOVE_PIVOT
    }

    companion object {
        const val MOVE_PIVOT: Int = 4
    }
}