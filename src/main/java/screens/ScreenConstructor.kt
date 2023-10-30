package screens

data class ScreenConstructor(
    var androidAccessibilityId: String = "",
    val androidId: String = "",
    val androidXpath: String = "",
    val iosAccessibilityId: String = "",
    val iosId: String = "",
    val iosXpath: String = "",
    val iosClassChain: String = "",
    val iosPredicateSting: String = "",
    val elementName: String = ""
)