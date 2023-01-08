CREATE TABLE IF NOT EXISTS product(
 id integer primary key,
 description character varying(100),
 code character varying(30),
 vat float,
 sell_price float,
 buy_price float,
 stock float
);

INSERT INTO product(id, description, code, vat, sell_price, buy_price, stock) VALUES (1, 'Produs 1', '1234','19', '2','1.5',100);
INSERT INTO product(id, description, code, vat, sell_price, buy_price, stock) VALUES (2, 'Produs 2', '1235','5', '20','15',100);
INSERT INTO product(id, description, code, vat, sell_price, buy_price, stock) VALUES (3, 'Produs 3', '1236','19', '23','15',100);
INSERT INTO product(id, description, code, vat, sell_price, buy_price, stock) VALUES (4, 'Produs 4', '1237','0', '21','15',100);
INSERT INTO product(id, description, code, vat, sell_price, buy_price, stock) VALUES (5, 'Produs 5', '1238','19', '29','15',100);