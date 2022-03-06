class Customers(
    override var userName:String, override var password:String, var accountType:Int,
    var balance:Double) : Person {

    val transHistory: MutableList<String> = mutableListOf()
    //deposit = 1, withdraw = 2, transfer = 3

    //constructor
    constructor() : this("default", "default", 10, 0.0)

    fun printHistory() {
        var type: String = ""
        var rest: String = ""

        println("------------TRANSACTIO HISTORY ------------")
        for (history in transHistory) {
            type = history.substring(0, 1)
            rest = history.substring(1, history.length)
            when (type) {
                "1" -> println("Deposit: $rest")
                "2" -> println("Withdraw: $rest")
                "3" -> println("Transfer: $rest")
            }
        }
    }

    override fun printC() {
        println("User name= $userName | Password= $password | Account Type= $accountType | Balance= $balance")
    }
}