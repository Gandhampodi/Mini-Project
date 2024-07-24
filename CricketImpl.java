package Cricket;

import java.sql.*;

public class CricketImpl implements CricketInterf {

    @Override
    public void createCricket(Cricketer cricketer) {
        Connection con = DBConnection.createDBConnection("cricinfo");
        String query = "insert into cricket values(?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, 45);
            pstm.setString(2, "Rohit");
            pstm.setInt(3, 37);
            pstm.setInt(4, 45000);
            int cnt = pstm.executeUpdate();

            if (cnt != 0) {
                System.out.println("Cricketer Inserted Successfully");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public void showAllCricketer() {
        Connection con = DBConnection.createDBConnection("cricinfo");
        String query = "select * from cricket";
        System.out.println("Cricketer details :");
        System.out.format("%s\t%s\t%s\t%s\n", "ID", "Name", "Salary", "age");
        try {
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                System.out.format("%s\t%s\t%s\t%s\n",
                        resultSet.getInt(1),
                        resultSet.getString(2), resultSet.getInt(3),
                        resultSet.getInt(4));
                System.out.println("-------------------------------");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void ShowCricketBasedOnId(int cricketerid) {
        Connection con = DBConnection.createDBConnection("cricinfo");
        String query = "select * from cricket where id =" + cricketerid;
        try {
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                System.out.format("%s\t%s\t%s\t%s\n",
                        resultSet.getInt(1),
                        resultSet.getString(2), resultSet.getInt(3),
                        resultSet.getInt(4));
                System.out.println("-------------------------------");
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void UpdateCricketer(int id1, String name) {
        Connection con = DBConnection.createDBConnection("cricinfo");
        String query = "update cricket set name=? where id=? ";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setInt(2, id1);
            int cnt = pstmt.executeUpdate();
            if (cnt != 0) {
                System.out.println("Cricket updated details");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

    @Override
    public void createCricketer(Cricketer cricketer) {

    }

    @Override
    public void deleteCricketer(int id) {
        Connection con = DBConnection.createDBConnection("cricinfo");
        String query = "delete from cricket where id=?";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            int cnt = pstmt.executeUpdate();
            if (cnt != 0) {
                System.out.println("cricket deleted");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void main(String agr[]) {
        CricketImpl cricket = new CricketImpl();
        cricket.createCricket(null);
        // get
        cricket.showAllCricketer();
        // update
        cricket.UpdateCricketer(45, "Sai");
        // get
        cricket.showAllCricketer();
        // delete
        cricket.deleteCricketer(45);
        // get
        cricket.showAllCricketer();
    }

    private void createCricketer() {
    }


}


