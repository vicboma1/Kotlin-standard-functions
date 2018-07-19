import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test

class Test {

    class Usuario(val nombre: String, val apellido: String, val edad: Int)

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

        val result = mutableMapOf<String, Usuario>()
                .apply {
                    "profesor" to Usuario("vic", "boma1", 10)
                    "alumno" to Usuario("v", "bolinch", 20)
                    "" to Usuario("", "", 0)
                }

        Assert.assertNotEquals(expectedFail, result::class)
        Assert.assertEquals(expectedTrue, result::class)

    }

    @org.junit.Test
    fun applyInstance() {
        val expectedTrue = LinkedHashMap::class

        mutableMapOf<String, Usuario>()
                .apply {
                    "profesor" to Usuario("vic", "boma1", 10)
                    "alumno" to Usuario("v", "bolinch", 20)
                    "" to Usuario("", "", 0)
                    Assert.assertEquals(expectedTrue, this::class)
                }
    }

    @org.junit.Test
    fun applyInstances() {
        val res = mutableMapOf<String, Usuario>()
                .apply {
                    Assert.assertTrue(this is MutableMap)
                    "profesor" to Usuario("vic", "boma1", 10)
                }
                .apply {
                    Assert.assertTrue(this is MutableMap)
                    "alumno" to Usuario("v", "bolinch", 20)
                }
                .apply {
                    Assert.assertTrue(this is MutableMap)
                    "" to Usuario("", "", 0)
                }

        Assert.assertTrue(res is MutableMap)
    }


    @Test
    fun let() {
        val expectedFail = LinkedHashMap::class
        val expectedTrue = kotlin.Pair::class

        val result = mutableMapOf<String, Usuario>()
                .let {
                    "profesor" to Usuario("vic", "boma", 10)
                    "alumno" to Usuario("v", "bolinch", 20)
                    "" to Usuario("", "", 0)
                }

        Assert.assertNotEquals(expectedFail, result::class)
        Assert.assertEquals(expectedTrue, result::class)

    }

    @Test
    fun letInstance() {
        val expectedFail = LinkedHashMap::class
        val expectedTrue = kotlin.Pair::class

        val result = mutableMapOf<String, Usuario>()
                .let {
                    "profesor" to Usuario("vic", "boma", 10)
                    "alumno" to Usuario("v", "bolinch", 20)
                    "" to Usuario("", "", 0)
                    it
                }

        Assert.assertEquals(expectedFail, result::class)
        Assert.assertNotEquals(expectedTrue, result::class)
    }

    @Test
    fun letInstanceBoolean() {
        val expectedTrue = kotlin.Boolean::class

        val result = mutableMapOf<String, Usuario>()
                .let {
                    "profesor" to Usuario("vic", "boma", 10)
                    "alumno" to Usuario("v", "bolinch", 20)
                    "" to Usuario("", "", 0)
                    true
                }

        Assert.assertEquals(result, true)
        Assert.assertEquals(expectedTrue, result::class)

    }

    @Test
    fun letInstances() {
        val result = mutableMapOf<String, Usuario>()
                .let {
                     Assert.assertTrue(it is MutableMap)
                    "profesor" to Usuario("vic", "boma", 10)
                }.let {
                    Assert.assertTrue(it is Pair)
                    "alumno" to Usuario("v", "bolinch", 20)
                    false
                }.let {
                    Assert.assertTrue(it is Boolean)
                    "" to Usuario("", "", 0)
                }

        Assert.assertTrue(result is Pair)
    }

    @Test
    fun also() {
        val expectedTrue = Boolean::class

        val result = mutableMapOf<String, Usuario>()
                .also {
                    it.put("profesor",Usuario("vic", "boma", 10))
                    it.put("alumno", Usuario("v", "bolinch", 20))
                    it.put("" , Usuario("", "", 0))
                    true
                }

        Assert.assertNotEquals(expectedTrue, result::class)
        Assert.assertTrue(result is MutableMap)
    }

    @Test
    fun alsoInstance() {
        val result = mutableMapOf<String, Usuario>()
                .also {
                    Assert.assertTrue(it is MutableMap)
                    "profesor" to Usuario("vic", "boma", 10)
                    true
                }.also {
                    Assert.assertTrue(it is MutableMap)
                    "alumno" to Usuario("v", "bolinch", 20)
                    100
                }.also {
                    Assert.assertTrue(it is MutableMap)
                    "" to Usuario("", "", 0)
                    null
                }

        Assert.assertTrue(result is MutableMap)
    }
}