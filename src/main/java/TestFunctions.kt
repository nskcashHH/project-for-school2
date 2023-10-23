import GlobalVariables.androidDriver
import io.appium.java_client.AppiumBy
import org.openqa.selenium.WebElement

object TestFunctions {

    fun clickToElement(locator: String, locatorType: LocatorType) {
        val element = findElement(locator, locatorType)
        element.click()
    }

    fun sendText(locator: String, locatorType: LocatorType, text: String) {
        val element = findElement(locator, locatorType)
        element.sendKeys(text)
    }

    fun clearField(locator: String, locatorType: LocatorType) {
        val element = findElement(locator, locatorType)
        element.clear()
    }

    fun checkAvailableElement(locator: String, locatorType: LocatorType): Boolean {
        val element = findElement(locator, locatorType)
        return element.isEnabled
    }


    private fun findElement(locator: String, locatorType: LocatorType): WebElement {
        return when (locatorType) {
            LocatorType.ID -> androidDriver.findElement(AppiumBy.id(locator))
            LocatorType.XPATH -> androidDriver.findElement(AppiumBy.xpath(locator))
            LocatorType.ACCESSIBILITY_ID -> androidDriver.findElement(AppiumBy.accessibilityId(locator))
        }
    }

}