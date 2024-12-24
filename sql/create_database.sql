CREATE DATABASE food_delivery;

USE food_delivery;

CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    items TEXT,
    status VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);
