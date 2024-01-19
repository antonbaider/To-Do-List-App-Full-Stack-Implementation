INSERT INTO roles (id, name) VALUES (1, 'ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'USER');
INSERT INTO roles (id, name) VALUES (3, 'MODER');

INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (5, 'Nick', 'Green', 'nick@mail.com', '$2a$10$CJgEoobU2gm0euD4ygru4ukBf9g8fYnPrMvYk.q0GMfOcIDtUhEwC', 2);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (6, 'Nora', 'White', 'nora@mail.com', '$2a$10$yYQaJrHzjOgD5wWCyelp0e1Yv1KEKeqUlYfLZQ1OQvyUrnEcX/rOy', 2);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (4, 'Mike', 'Brown', 'mike@mail.com', '$2a$10$CdEJ2PKXgUCIwU4pDQWICuiPjxb1lysoX7jrN.Y4MTMoY9pjfPALO', 1);
-- Insert additional users
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (7, 'Emma', 'Smith', 'emma@mail.com', '$2a$10$1aR7EpsGwjt.2HNoxNCGfuSJJKrmpRc1ATo6Ku69cvZ/jQ9vtow9S', 2);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (8, 'Daniel', 'Johnson', 'daniel@mail.com', '$2a$10$uUzHlj3mXU2jjzd4YyYMEuX9JdG2Lwbb.5ztu5VslviXytdL7qXXW', 1);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (9, 'Sophia', 'Miller', 'sophia@mail.com', '$2a$10$Db8KsI.GFLXJ7sDClxu8tuELB3rsTMYjUn7vdYbfOAK2bG68bFj8O', 2);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (10, 'Ethan', 'Davis', 'ethan@mail.com', '$2a$10$LbH0tVW0cNZHVH0AX4w2Juhzoq4Nm4lSZ7J2kI.PswYpxG9aS0V5G', 1);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (11, 'Olivia', 'Brown', 'olivia@mail.com', '$2a$10$Fh4qY0jU3MWtrh/jDoy49O/TmtrROsbhjKYVYZFmdRg08oWKFu5Xu', 2);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (12, 'Liam', 'Wilson', 'liam@mail.com', '$2a$10$gBtXpXAFo4kv3DGRaE1x7.dZPfIb5SyOwGx3e4h4v/7/DLg0SQ1k6', 1);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (13, 'Ava', 'Jones', 'ava@mail.com', '$2a$10$dRoFqYtpaT9H/PgLwFNdLOBlzsgGcH7zJ8tWM87SshNVO8M6kv3LG', 2);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (14, 'Noah', 'Garcia', 'noah@mail.com', '$2a$10$TWB29GOSdPHzwaG3Cuv7WOM3a8o52g6gEFZujHC6/6mQdf2vT0C/W', 1);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (15, 'Isabella', 'Rodriguez', 'isabella@mail.com', '$2a$10$Gt6IfQPZz5EqvhrLshJG2et0qZqDfJftcMysclXmsfFXHBFTQYRVW', 2);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (16, 'James', 'Martinez', 'james@mail.com', '$2a$10$kNL01cO0z.Y6b3Z1VPrzyeRxP1wq89ezUp0hG8JqBChZ.rQcDGutW', 1);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (17, 'Charlotte', 'Taylor', 'charlotte@mail.com', '$2a$10$k6tHVb76kBeNlpzPbc/vf.0QO9Om1WqTQUyG/xt3dDkG3Ve0i1X7y', 2);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (18, 'Benjamin', 'Hernandez', 'benjamin@mail.com', '$2a$10$FhGiZQnl7xuBcLj02bR72uNyPrd/e0XpRKRC5PE7ey2N2MfR9kRUy', 1);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (19, 'Amelia', 'Young', 'amelia@mail.com', '$2a$10$fGJJ3AfG9hHZpW7o.I59ReJ8uYvDXoA6VlBhgzZrh5uMwr8y2pg0.', 2);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (20, 'Mason', 'Lopez', 'mason@mail.com', '$2a$10$QlOjABXwO0IUoos./xUfmOwLhxygqdzZAzF3yMXYlTEmeC/BwFNNC', 1);

INSERT INTO states (id, name) VALUES (5, 'New');
INSERT INTO states (id, name) VALUES (6, 'Doing');
INSERT INTO states (id, name) VALUES (7, 'Verify');
INSERT INTO states (id, name) VALUES (8, 'Done');

INSERT INTO todos (id, title, created_at, owner_id) VALUES (7, 'Mike''s To-Do #1', '2020-09-16 14:00:04.810221', 4);
INSERT INTO todos (id, title, created_at, owner_id) VALUES (8, 'Mike''s To-Do #2', '2020-09-16 14:00:11.480271', 4);
INSERT INTO todos (id, title, created_at, owner_id) VALUES (9, 'Mike''s To-Do #3', '2020-09-16 14:00:16.351238', 4);
INSERT INTO todos (id, title, created_at, owner_id) VALUES (10, 'Nick''s To-Do #1', '2020-09-16 14:14:54.532337', 5);
INSERT INTO todos (id, title, created_at, owner_id) VALUES (11, 'Nick''s To-Do #2', '2020-09-16 14:15:04.707176', 5);
INSERT INTO todos (id, title, created_at, owner_id) VALUES (12, 'Nora''s To-Do #1', '2020-09-16 14:15:32.464391', 6);
INSERT INTO todos (id, title, created_at, owner_id) VALUES (13, 'Nora''s To-Do #2', '2020-09-16 14:15:39.16246', 6);

INSERT INTO tasks (id, name, priority, todo_id, state_id) VALUES (6, 'Task #2', 'LOW', 7, 5);
INSERT INTO tasks (id, name, priority, todo_id, state_id) VALUES (5, 'Task #1', 'HIGH', 7, 8);
INSERT INTO tasks (id, name, priority, todo_id, state_id) VALUES (7, 'Task #3', 'MEDIUM', 7, 6);

INSERT INTO todo_collaborator (todo_id, collaborator_id) VALUES (7, 5);
INSERT INTO todo_collaborator (todo_id, collaborator_id) VALUES (7, 6);
INSERT INTO todo_collaborator (todo_id, collaborator_id) VALUES (10, 6);
INSERT INTO todo_collaborator (todo_id, collaborator_id) VALUES (10, 4);
INSERT INTO todo_collaborator (todo_id, collaborator_id) VALUES (12, 5);
INSERT INTO todo_collaborator (todo_id, collaborator_id) VALUES (12, 4);