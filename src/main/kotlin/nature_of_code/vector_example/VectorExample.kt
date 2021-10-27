package nature_of_code.vector_example

import processing.core.PApplet
import processing.core.PVector

class VectorExample : PApplet() {

    private var location = PVector(0f, 0f)
    private val speed = PVector(1f, -1f)

    init {
        setSize(800, 800)
        runSketch()
    }

    override fun setup() {

    }

    override fun draw() {
        translate(width / 2f, height / 2f)
        line(0f, 0f, location.x, location.y)

        location += speed
    }

}

//operator fun PVector.plus(other: PVector): PVector {
//    return PVector(
//        x + other.x,
//        y + other.y,
//        z + other.z,
//    )
//}

operator fun PVector.plusAssign(other: PVector) {
    x += other.x
    y += other.y
    z += other.z
}
