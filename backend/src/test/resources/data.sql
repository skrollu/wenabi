INSERT INTO users (username, password)
VALUES ('company_user', '$2a$12$pOiMlIZtvvtjuKGGR0KCk.HsFNb/mjc/7WGnssoboA/0XLKgkKr02'),
       ('association_user', '$2a$12$pOiMlIZtvvtjuKGGR0KCk.HsFNb/mjc/7WGnssoboA/0XLKgkKr02'),
       ('user1', '$2a$12$pOiMlIZtvvtjuKGGR0KCk.HsFNb/mjc/7WGnssoboA/0XLKgkKr02'),
       ('user2', '$2a$12$pOiMlIZtvvtjuKGGR0KCk.HsFNb/mjc/7WGnssoboA/0XLKgkKr02'),
       ('user3', '$2a$12$pOiMlIZtvvtjuKGGR0KCk.HsFNb/mjc/7WGnssoboA/0XLKgkKr02')
;

INSERT INTO role (name)
VALUES ('ROLE_USER'),
       ('ROLE_ASSOCIATION')
;

INSERT INTO users_role (users_id, role_id)
VALUES (1,1),
       (2,1),
       (2,2),
       (3,1),
       (4,1),
       (5,1)
;

INSERT INTO company (name)
VALUES ('Wenabi'),
       ('Company 1'),
       ('Company 2'),
       ('Company 3');

INSERT INTO profile (first_name, last_name, company_id, users_id)
VALUES ('John', 'Doe', 1, 1),
       ('Mike', 'Simpson', 2, 2),
       ('Jean', 'Dupond', 3, 3),
       ('Satoshi', 'Nakamoto', 4, 4),
       ('Michel', 'Francois', 1, 5)
;

INSERT INTO initiative (title, street_name, city, postal_code, country, coordinator_profile_id)
VALUES ('Distribuer des repas chauds le soir aux plus démunis', '17 rue des lilas', 'Paris', '75000', 'FR', 1),
       ('Collectez de denrées alimentaire', '256 rue du bonheur', 'Paris', '75000', 'FR', 2),
       ('Distribuez des repas chauds à la Porte de la Villette', 'Avenue Victor Hugo', 'Paris', '75000', 'FR', 3),
       ('Je donne un livre pour la collecte de La Chorba !', 'Chemin du topinambour', 'Lyon', '69000', 'FR', 4),
       ('Accompagnez un jeune dans sa scolarité', 'Rue fresques', 'Nîmes', '30000', 'FR', 5)
;

INSERT INTO wish (status, created_date, volunteer_profile_id, initiative_id)
VALUES ('DISCUSSION', CURRENT_TIMESTAMP() - 1, 1, 2),
       ('APPLICATION', DATEADD('DAY', -7, CURRENT_TIMESTAMP()), 2, 3),
       ('WAITING_ASSOCIATION_VALIDATION', CURRENT_TIMESTAMP(), 3, 2),
       ('IN_PROGRESS', DATEADD('DAY', -9, CURRENT_TIMESTAMP()), 4, 3),
       ('USER_HAS_PARTICIPATED', CURRENT_TIMESTAMP(), 2, 3),
       ('CANCELLED', CURRENT_TIMESTAMP(), 5, 5),
       ('IN_PROGRESS', CURRENT_TIMESTAMP(), 3, 5),
       ('USER_HAS_PARTICIPATED', CURRENT_TIMESTAMP(), 3, 4),
       ('CANCELLED', DATEADD('DAY', -1, CURRENT_TIMESTAMP()), 4, 4),
       ('DISCUSSION', CURRENT_TIMESTAMP(), 3, 3),
       ('CANCELLED', DATEADD('DAY', -15, CURRENT_TIMESTAMP()), 5, 1),
       ('DISCUSSION', CURRENT_TIMESTAMP(), 5, 3)
;