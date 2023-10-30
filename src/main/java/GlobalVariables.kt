import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver

object GlobalVariables {

    lateinit var androidDriver: AndroidDriver
    lateinit var iosDriver: IOSDriver
    lateinit var platformType: TypeOS
}