package First;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDAO {
    public Long save(Connection connection, Order order) {
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO ORDER (NAME, ADDRESS) VALUES (?, ?)";

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, order.getName());
            pstmt.setString(2, order.getAddress());

            pstmt.executeUpdate();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();

            if (generatedKeys.next()) {
                long orderId = generatedKeys.getLong(1);
                return orderId;
            }

            return null;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                pstmt.close();
            } catch (Exception e) {
                // ...
            }
        }
    }
}
