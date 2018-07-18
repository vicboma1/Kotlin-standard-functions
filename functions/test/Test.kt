import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test

class Test {

    class Usuario(val nombre:String, val apellido:String, val edad:Int)

    @org.junit.Before
    fun setUp() {
    }

    @org.junit.After
    fun tearDown() {
    }

    @org.junit.Test
    fun apply() {
        val expectedFail = Unit::class
        val expectedTrue = LinkedHashMap::class

        val result = mutableMapOf<String,Usuario>()
                .apply {
                    "profesor" to Usuario("vic","boma1", 10)
                    "alumno"   to Usuario("v" , "bolinch", 20)
                    ""         to Usuario("","",0)
                }

        Assert.assertNotEquals(expectedFail, result::class)
        Assert.assertEquals(expectedTrue, result::class)

    }

    @Test
    fun let(){
        val expectedFail = LinkedHashMap::class
        val expectedTrue = kotlin.Pair::class

        val result = mutableMapOf<String, Usuario>()
                .let {
                    "profesor" to Usuario("vic", "boma", 10)
                    "alumno"   to Usuario("v", "bolinch", 20)
                    ""         to Usuario("", "", 0)
                }

        Assert.assertNotEquals(expectedFail, result::class)
        Assert.assertEquals(expectedTrue, result::class)

    }

    @Test
    fun letInstance(){
        val expectedFail = LinkedHashMap::class
        val expectedTrue = kotlin.Pair::class

        val result = mutableMapOf<String, Usuario>()
                .let {
                    "profesor" to Usuario("vic", "boma", 10)
                    "alumno"   to Usuario("v", "bolinch", 20)
                    ""         to Usuario("", "", 0)
                    it
                }

        Assert.assertEquals(expectedFail, result::class)
        Assert.assertNotEquals(expectedTrue, result::class)

    }
}