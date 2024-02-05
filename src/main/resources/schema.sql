-- schema.sql

-- Define the ewm_clients table
CREATE TABLE IF NOT EXISTS ewm_clients (
                                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                           first_name VARCHAR(255),
    last_name VARCHAR(255),
    income DECIMAL(10, 2),
    net_worth DECIMAL(10, 2)
    );
