package com.ssg.sales.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
@Slf4j
public class TenantConnectionProvider implements MultiTenantConnectionProvider {

    private DataSource datasource;

    public TenantConnectionProvider(DataSource dataSource){
        this.datasource = dataSource;
    }

    @Override
    public Connection getAnyConnection() throws SQLException {
        return datasource.getConnection();
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public Connection getConnection(String tenantIdentifier) throws SQLException {
        final Connection connection = getAnyConnection();
        if(!tenantIdentifier.equals("public")){
//            connection.createStatement().execute(String.format("USE %s;", tenantIdentifier));
            log.info("setting schema: "+tenantIdentifier);
            connection.setSchema(tenantIdentifier);
//            connection.setSchema("db_"+tenantIdentifier);
        } else{
            log.info("setting schema: public");
//            connection.createStatement().execute("USE main_db");
            connection.setSchema("public");
        }
        return connection;
    }

    @Override
    public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
        connection.setSchema(null);
        releaseAnyConnection(connection);
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    @Override
    public boolean isUnwrappableAs(Class unwrapType) {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> unwrapType) {
        return null;
    }
}
