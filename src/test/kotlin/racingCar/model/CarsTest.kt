package racingCar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

internal class CarsTest {
    @Test
    internal fun moveAll() {
        val carList = listOf(Car(CarName("joanne")), Car(CarName("pk")))
        val cars = Cars(carList)

        val movedCars = cars.moveAll(object : MoveStrategy {
            override fun canMove(): Boolean {
                return true
            }
        })

        assertThat(movedCars[0].position).isEqualTo(1)
        assertThat(movedCars[1].position).isEqualTo(1)
    }

    @Test
    internal fun `move all when stop`() {
        val carList = listOf(Car(CarName("joanne")), Car(CarName("pk")))
        val cars = Cars(carList)

        val movedCars = cars.moveAll(object : MoveStrategy {
            override fun canMove(): Boolean {
                return false
            }
        })

        assertThat(movedCars[0].position).isEqualTo(0)
        assertThat(movedCars[1].position).isEqualTo(0)
    }

    @Test
    internal fun findMaxPosition() {
        val carList = listOf(
            Car(CarName("joanne"), 10),
            Car(CarName("pk"), 10),
            Car(CarName("sally"), 1),
        )
        val cars = Cars(carList)

        val maxPosition = cars.findMaxPosition()
        assertThat(maxPosition).isEqualTo(10)
    }

    @Test
    internal fun findCarsBySamePosition() {
        val carList = listOf(
            Car(CarName("joanne"), 10),
            Car(CarName("pk"), 10),
            Car(CarName("sally"), 1),
        )
        val cars = Cars(carList)
        val carsBySamePosition = cars.findCarsBySamePosition(10)
        assertAll(
            { assertThat(carsBySamePosition).hasSize(2) },
            { assertThat(carsBySamePosition[0].position).isEqualTo(10) },
            { assertThat(carsBySamePosition[1].position).isEqualTo(10) },
        )
    }
}