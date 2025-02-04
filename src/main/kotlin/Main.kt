fun main(args: Array<String>){
    var change = 2
    val value = 1

    change = 3
    // value = 1 -- val 로 선언된 변수는 const 처럼 변경이 불가능 하다

    var name = "jeje" // 타입 추론이 가능

    var address: String // 초기화 하지 않은 변수 선언은 이렇게 한다.
    var initInt: Int
    var initIntNull: Int?
    // println("init int: $initInt, address : $address, init pointer $initIntNull") -- 초기화 하지 않은 변수는 사용 할 수 없다

    // initInt += 1 -- 초기화 하지 않은 변수는 사용 할 수 없다

    var priceA = 100
    var priceB = 200

    if (priceA >= priceB) {
        println("priceA $priceA")
    } else {
        println("priceB $priceB")
    }

    var priceNull: Int? = null
    println("priceNull $priceNull") // null safe

    if (priceA in arrayOf(100, 200, 300)) {
        println("contains priceA")
    }

    var number = 200

    when(number) {
        100 ->
            println("number 100 : $number")
        200 ->
            println("number 200 : $number")
        else ->
            println("number else $number")
    }

    when(number) {
        in 100 .. 101 -> println("number is 100 - 101")
        in 102 .. 103 -> println("number is 101 - 102")
        in 101 .. 102 -> println("number is 101 - 102") // 범위가 겹쳐도 컴파일 에러가 발생 하지 않음
        else -> println("else")
    }

    var returnValue = functionName(number, name, name)

    println("functionName return $returnValue")

    var info = Information(name, number)
    var json = info.getJson()
    var infoString = info.getString()
    println("json : $json, string : $infoString")
}


fun functionName(param: Int, param2: String, param3: String):String {
    return param2 + param3 + param
}

class Information (var name: String, var age: Int ) :Writer {
    override fun getString(): String{
        return "$name, $age"
    }
    override fun getJson(): String {
        return "{\"name\":\"$name\", \"age\":$age}"
    }

}

interface Writer {
    fun getString(): String
    fun getJson(): String
}