import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

fun main(){

     var connection : Connection? = null
     val surnames = ArrayList<String>()
     try{

         val url = "jdbc:mysql://localhost:3306/newdb"
         val user = "developer"
         val password = "1234"

         connection = DriverManager.getConnection(url, user, password)
         val statement = connection.createStatement()
         val resultSet = statement.executeQuery("select last_name, first_name from students")

         while(resultSet.next()) {
             val lastName = resultSet.getString("last_name")
             val firstName = resultSet.getString("first_name")
             surnames.add(lastName)
             println(firstName)

         }
         println(surnames)
     }catch (e: SQLException){
         println(e.message)
     } finally {
         try {
             connection?.close()
         }catch (ex: SQLException) {
             println(ex.message)
         }
     }
 }