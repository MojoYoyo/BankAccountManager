public class Insert {

    public static void insertNew(String login, String password, String email) {
        try {
            // create a mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/bank?autoReconnect=true&useSSL=false";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "password");

            // create a sql date object so we can use it in our INSERT statement


            // the mysql insert statement
            String query = " INSERT INTO users (login, password, email, balance)"
                    + " VALUES (?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, login);
            preparedStmt.setString(2, password);
            preparedStmt.setString(3, email);
            preparedStmt.setInt(4, 0);

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}