package com.ProjectSpringboot.Point_of_sale.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Generates customer IDs in the format: CUS-1000, CUS-1001, CUS-1002 ...
 * Starting number: 1000
 */
public class CustomerIdGenerator implements IdentifierGenerator {

    private static final String PREFIX = "CUS-";
    private static final int START_NUMBER = 1000;

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        try {
            Connection connection = session.getJdbcConnectionAccess().obtainConnection();
            Statement statement = connection.createStatement();

            // Get the highest existing numeric part of customer_id
            ResultSet rs = statement.executeQuery(
                    "SELECT MAX(CAST(SUBSTRING(customer_id, 5) AS UNSIGNED)) FROM customer"
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
            throw new RuntimeException("Failed to generate Customer ID", e);
        }
    }
}
