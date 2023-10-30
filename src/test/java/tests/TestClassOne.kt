package tests

import MainActivity
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

// запускать тесты именно через класс если все, или каждый тест по 1
class TestClassOne : MainActivity(){

    // пока что все тесты, которые у вас есть, реализуем именно в этом классе, пока что вы
    // не сможете запустить тесты сразу с нескольких классов
    @Test
    fun testOne(){
        // вызов функции needAuth = true
        println("Тест запущен")
        TimeUnit.SECONDS.sleep(10)
        val test: String = "1234"
        test[0]
    }

}