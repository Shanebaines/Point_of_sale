package com.ProjectSpringboot.Point_of_sale.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Generates item IDs in the format: PN-1000, PN-1001, PN-1002 ...
 * Starting number: 1000
 */
public class ItemIdGenerator implements IdentifierGenerator {

    private static final String PREFIX = "PN-";
    private static final int START_NUMBER = 1000;

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        try {
            Connection connection = session.getJdbcConnectionAccess().obtainConnection();
            Statement statement = connection.createStatement();

            // Get the highest existing numeric part of item_id
            ResultSet rs = statement.executeQuery(
                    "SELECT MAX(CAST(SUBSTRING(item_id, 4) AS UNSIGNED)) FROM item"
            );

            int nextNumber = START_NUMBER;
            if (rs.next() && rs.getString(1) != null) {
                nextNumber = rs.getInt(1) + 1;
            }

            rs.close();
            statement.close();
            session.getJdbcConnectionAccess().releaseConnection(connection);

            return PREFIX + nextNumber;

        } catch (Exception e) {
            throw new RuntimeException("Failed to generate Item ID", e);
        }
    }
}
