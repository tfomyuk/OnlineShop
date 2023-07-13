INSERT INTO roles(id, name) values
('b7308272-2c87-4138-9680-a9fbbc1fed19', 'ROLE_USER'),
('fcf12a8d-91e9-4bb6-b60b-53d6d97a9f44', 'ROLE_ADMIN');

INSERT INTO users (id, login, password)
VALUES
--admin 123456
--user 123456
('e95c01cc-bdb3-42ae-a57d-d71d6b1f56ca','admin','$2a$12$gwyWkPhNWYHDUiE.Ylwh2OxlBWL6hJXcKP7iu7mEhCYDiQNXdRQ/y'),
('e95c01cc-bdb3-42ae-a57d-d71d6b1f56cb','user', '$2a$12$gwyWkPhNWYHDUiE.Ylwh2OxlBWL6hJXcKP7iu7mEhCYDiQNXdRQ/y');


INSERT INTO user_roles (role_id, user_id)
VALUES
('fcf12a8d-91e9-4bb6-b60b-53d6d97a9f44', 'e95c01cc-bdb3-42ae-a57d-d71d6b1f56ca'),
('b7308272-2c87-4138-9680-a9fbbc1fed19', 'e95c01cc-bdb3-42ae-a57d-d71d6b1f56cb');