package general_cases_for_tests

object AuthorizationScenarios {

    fun checkAuthorizationUser(needAuthorizationUser: Boolean){
        /* тут должна быть логика проверки авторизации пользователя
        на входе одна и нужных булевых переменных, вторую нужно получить путем
        проверки доступности элемента

         */

        // нужно описать 4 ветки
        val testBoolean = false // переменная для примера, вам нужно будет получить ее через функцию и назвать иначе

        when {
            needAuthorizationUser && testBoolean -> {}
            needAuthorizationUser && !testBoolean -> {}
            !needAuthorizationUser && testBoolean -> {}
            !needAuthorizationUser && !testBoolean -> {}
        }

    }
}