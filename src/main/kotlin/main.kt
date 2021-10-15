import processing.core.PApplet

class ProcessingWrapper : PApplet() {

    init {
        setSize(600, 600)
        runSketch()
    }


    override fun setup() {}

    private var timeOffset = 0f

    var xOffset = 0f

    override fun draw() {
        timeOffset += 0.001f

        background(20)

        stroke(255)

        noFill()

//        beginShape()


        (0..width).forEach {
            if (it % 30 == 0) {
                val y = noise(xOffset) * height
                ellipse(it.toFloat(), y, 4f, 4f)
            }
            xOffset += 0.001f
        }

//        endShape()

//        noLoop()
    }
}

fun main(args: Array<String>) {
    ProcessingWrapper()
}
