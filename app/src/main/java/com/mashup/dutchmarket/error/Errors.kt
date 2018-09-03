package com.mashup.dutchmarket.error

abstract class Errors : Throwable() {
    abstract val errorText: String
}

class CannotVerifyAuthCode: Errors() {
    override val errorText: String = "인증 코드를 받을 수 없습니다."
}

class NotConnectedNetworkError : Errors() {
    override val errorText: String = "인터넷이 연결되어 있지 않습니다."
}