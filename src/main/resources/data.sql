delete from Taco_Order_Tacos;
delete from Taco_Ingredients;
delete from Taco;
delete from Taco_Order;
delete from Ingredient;

INSERT INTO "ingredient" ("id", "name", "type")
VALUES ('FLTO', 'Flour Tortilla', 'WRAP');
INSERT INTO "ingredient" ("id", "name", "type")
values ('COTO', 'Corn Tortilla', 'WRAP');
INSERT INTO "ingredient" ("id", "name", "type")
values ('MAYO', 'Mayonnaise', 'WRAP');
INSERT INTO "ingredient" ("id", "name", "type")
values ('GRBF', 'Ground Beef', 'PROTEIN');
INSERT INTO "ingredient" ("id", "name", "type")
values ('CARN', 'Carnitas', 'PROTEIN');
INSERT INTO "ingredient" ("id", "name", "type")
values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
INSERT INTO "ingredient" ("id", "name", "type")
values ('LETC', 'Lettuce', 'VEGGIES');
INSERT INTO "ingredient" ("id", "name", "type")
values ('CHED', 'Cheddar', 'CHEESE');
INSERT INTO "ingredient" ("id", "name", "type")
values ('JACK', 'Monterrey Jack', 'CHEESE');
INSERT INTO "ingredient" ("id", "name", "type")
values ('SLSA', 'Salsa', 'SAUCE');
INSERT INTO "ingredient" ("id", "name", "type")
values ('SRCR', 'Sour Cream', 'SAUCE');

INSERT INTO "users"("id","city","email","first_name","last_name","password","phone","state","street","zip")
VALUES(CAST(1 AS BIGINT), 'Galati', 'ionlefter21@gmail.com', 'Ion', 'Lefter', '$2a$10$EMD8TusqX95JwAHx3RHqceuiiU0KwRc/utgNytL4C89vwR.IloQr6',
       '0774566088', 'Galati', 'str. Domneasca 155 Camin E Ap 105', '800163');