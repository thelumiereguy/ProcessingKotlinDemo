package art

import processing.core.PApplet
import processing.core.PVector

class HexagonalMandela : PApplet() {

    init {
        setSize(800, 800)
        runSketch()
    }

    override fun setup() = Unit

    private var upTime = 0

    override fun draw() {

        translate(
            width / 2f,
            height / 2f
        )

        background(0)

        //backdrop
        fill(0)
        noStroke()
        circle(
            0f, 0f, 300f
        )

        stroke(255f, 150f)

        strokeWeight(1f)

        val animatedRotationAngle = radians(sin(upTime.toFloat() * 0.001f) * 360f)

        noFill()

        pushMatrix()

        (0 until 360 step 10).forEach { angle ->
            rotate(radians(angle.toFloat() + (animatedRotationAngle * 4))) {
                ellipse(150f, 0f, 100f, 150f * animatedRotationAngle)
            }
        }
        popMatrix()

        fill(0)

        circle(
            0f,
            0f,
            300f
        )

        noFill()

        rotate(angle = animatedRotationAngle) {
            drawComplexShape()
        }

        var length = 150f

        var scale = 1.0f

        repeat(6) { iteration ->

            val animatedRotationAngleIteration = -radians(sin((upTime + iteration) * 0.001f) * 360f)

            scale /= 1.7f

            length *= (1.2f) * abs(sin(upTime * 0.001f) + 0.8f)

            val sides = 6

            val rotationPhase = 30f * iteration

            val alpha = 150f - (iteration * 15)

            rotate(angle = animatedRotationAngleIteration) {
                drawShape(
                    PVector(
                        0f,
                        0f
                    ),
                    sides,
                    length,
                    rotationPhase
                ) { (startX, startY), _ ->

                    stroke(255f, alpha)

                    val angle = atan2(startY, startX)
                    pushMatrix()
                    translate(startX, startY)
                    rotate(angle + animatedRotationAngleIteration)
                    scale(scale)
                    drawComplexShape()
                    popMatrix()
                    stroke(0f, 0f)
                }
            }
        }

//        saveFrame("../art/${this::class.simpleName}/#####.png")

        upTime++
    }

    private fun drawComplexShape() {
        drawShape(
            PVector(
                0f,
                0f
            ),
            3,
            100f,
            90f
        )

        drawShape(
            PVector(
                0f,
                0f
            ),
            3,
            100f,
            270f
        )

        drawShape(
            PVector(
                0f,
                0f
            ),
            6,
            120f,
            0f
        )

        drawShape(
            PVector(
                0f,
                0f
            ),
            6,
            100f,
            90f
        ) { (startX, startY), (endX, endY) ->
            circle(
                startX,
                startY,
                40f
            )

            fill(128, 100f)

            circle(
                (startX + endX) / 2f,
                (startY + endY) / 2f,
                30f
            )

            circle(
                (startX + endX) / 2f,
                (startY + endY) / 2f,
                10f
            )

            noFill()
        }



        drawShape(
            PVector(
                0f,
                0f
            ),
            6,
            60f,
            90f
        )

        drawShape(
            PVector(
                0f,
                0f
            ),
            3,
            60f,
            90f
        ) { (startX, startY), _ ->
            circle(
                startX,
                startY,
                40f
            )
        }

        drawShape(
            PVector(
                0f,
                0f
            ),
            3,
            60f,
            270f
        ) { (startX, startY), _ ->
            circle(
                startX,
                startY,
                40f
            )
        }

        (0..360 step 90).forEach { angle ->
            rotate(radians(angle.toFloat())) {
                drawShape(
                    PVector(
                        0f,
                        0f
                    ),
                    3,
                    40f,
                    90f
                )
            }
        }
    }


    private fun drawShape(
        location: PVector,
        sides: Int,
        length: Float,
        rotationPhase: Float,
        drawAtVertexBlock: (startPair: Pair<Float, Float>, endPair: Pair<Float, Float>) -> Unit = defaultDrawAtVertexBlock
    ) {

        pushMatrix()

        val rotationAngle = 360f / sides

        translate(
            location.x,
            location.y
        )

        rotate(radians(rotationPhase))

        repeat(
            sides
        ) { side ->

            val startAngle = radians(rotationAngle * side)
            val startX = cos(startAngle) * length
            val startY = sin(startAngle) * length

            val endAngle = radians(rotationAngle * (side + 1))

            val endX = cos(endAngle) * length
            val endY = sin(endAngle) * length

            drawAtVertexBlock(
                startX to startY,
                endX to endY
            )

            line(
                startX,
                startY,
                endX,
                endY
            )
        }

        popMatrix()
    }
}


private val defaultDrawAtVertexBlock: (
    startPair: Pair<Float, Float>,
    endPair: Pair<Float, Float>
) -> Unit = { _, _ -> Unit }


inline fun PApplet.rotate(angle: Float, block: () -> Unit) {
    pushMatrix()
    rotate(angle)
    block()
    popMatrix()
}