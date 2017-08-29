public class ManageAccount {
    public static void updateInfo(int user_id, String data, int operation_number) {
        try {
            // create a mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/bank?autoReconnect=true&useSSL=false";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "password");

            String update = null;
            if (operation_number == 1) {
                update = "login";
            } else if (operation_number == 2) {
                update = "password";
            } else if (operation_number == 3) {
                update = "email";
            }
            String query = "update users set " + update + " = ? where user_id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, data);
            preparedStmt.setInt(2, user_id);
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }

    public static void updateBalance(int user_id, int ammount, int operation_number) {
        try {
            // create a mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/bank?autoReconnect=true&useSSL=false";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "password");

            // create a sql date object so we can use it in our INSERT statement
            String query = "SELECT balance FROM users WHERE user_id = " + user_id;

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset

            int balance = 0;
            while (rs.next()) {
                balance = rs.getInt("balance");
                if (operation_number == 1) {
                    balance -= ammount;
                } else {
                    balance += ammount;

                }
            }
            query = "update users set balance = ? where user_id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, balance);
            preparedStmt.setInt(2, user_id);


            System.out.format("Your balance after operation is: %s", balance);
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public static void deleteAccount(int user_id) {
        try {
            // create a mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/bank?autoReconnect=true&useSSL=false";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "password");

            String query = "delete from users where user_id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, user_id);

            preparedStmt.execute();
            conn.close();
            System.out.print("Account deleted successfully!");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
