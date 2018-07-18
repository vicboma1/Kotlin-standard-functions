# Kotlin standard functions


## apply

```
 class Usuario(val nombre:String, val apellido:String, val edad:Int)
    
    @JvmStatic
    fun main(args :Array<String>){

       val map = mutableMapOf<String,Usuario>()
                        .apply { 
                               "profesor" to Usuario("vic","boma", 10)
                               "alumno"   to Usuario("v" , "bolinch", 20)
                               ""         to Usuario("","",0)
                           }

    }```

## let 

```
    class Usuario(val nombre:String, val apellido:String, val edad:Int)

    @JvmStatic
    fun main(args :Array<String>){

    val map = mutableMapOf<String,Usuario>()
            .let {
                "profesor" to Usuario("vic","boma", 10)
                "alumno"   to Usuario("v" , "bolinch", 20)
                ""         to Usuario("","",0)
                it
            }
    
}
```
## also 
## run 
## takeif 
## takeunless
