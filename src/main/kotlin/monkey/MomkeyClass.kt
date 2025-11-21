package monkey
class RobotMonkey(
    id: Int,
    name: String,
    age: Int,
    rarity: Rarity,
    val chipVersion: String
) : ClassMonkey(id, name, age, rarity) {

    override fun youMonkey(): String {
        val status = if (isSold) "продана!туда ее" else "не продана("
        return "ID:$id, Имя:$name, Возраст:$age, Редкость:$rarity, Способность:$chipVersion, Статус:$status"
    }
}
class MagicMonkey(
    id: Int,
    name: String,
    age: Int,
    rarity: Rarity,
    val manaPool: Int
): ClassMonkey(id,name,age,rarity){
    override fun youMonkey(): String {
        val status=if(isSold) "прордана" else "не продана("
        return "Id $id , Имя $name , Возраст $age, Редкость  $rarity, Колличество маны $manaPool, Статус $status"
    }
}