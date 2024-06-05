INSERT INTO coffee
    (name, price)
VALUES ('Espresso', 2.50),
       ('Latte', 3.50),
       ('Cappuccino', 6.50);

INSERT INTO store
    (name, location)
VALUES ('Starbucks', 'Rue Faubourg');

INSERT INTO employee
    (age, first_name, last_name, salary, store_id)
VALUES (32, 'John', 'Doe', 3354, 1),
       (78, 'Sylvain', 'Bonnaure', 1315, 1);

INSERT INTO store_coffees
    (stores_id, coffees_id)
VALUES (1, 1),
       (1, 2),
       (1, 3);