    CREATE TABLE IF NOT EXISTS users(
     id BIGSERIAL, first_name VARCHAR(64) NOT NULL,
     last_name VARCHAR(256) NOT NULL,
     money_amount DECIMAL DEFAULT 0,
     CONSTRAINT users_pk PRIMARY KEY(id));


    CREATE TABLE IF NOT EXISTS products(
    id BIGSERIAL, product_name VARCHAR(256) NOT NULL,
    price DECIMAL DEFAULT 0,
    CONSTRAINT products_pk PRIMARY KEY(id));

    CREATE TABLE IF NOT EXISTS users_products(
    user_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    CONSTRAINT users_products_users_fk FOREIGN KEY(user_id) REFERENCES users(id),
    CONSTRAINT users_products_products_fk FOREIGN KEY(product_id) REFERENCES products(id));


