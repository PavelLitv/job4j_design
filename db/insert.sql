DO
$$
    DECLARE
        user_pavel_id       INTEGER;
        user_sergey_id      INTEGER;
        role_admin_id       INTEGER;
        role_user_id        INTEGER;
        rule_all_id         INTEGER;
        rule_create_item_id INTEGER;
        category_food_id    INTEGER;
        category_alcohol_id INTEGER;
        state_created_id    INTEGER;
        state_work_id       INTEGER;
        item_first_id       INTEGER;
        item_second_id      INTEGER;

    BEGIN
        INSERT INTO users(name) VALUES ('Pavel') RETURNING id INTO user_pavel_id;
        INSERT INTO users(name) VALUES ('Sergey') RETURNING id INTO user_sergey_id;

        INSERT INTO roles(name) VALUES ('admin') RETURNING id INTO role_admin_id;
        INSERT INTO roles(name) VALUES ('user') RETURNING id INTO role_user_id;

        INSERT INTO user_role(role_id, user_id) VALUES (role_admin_id, user_pavel_id);
        INSERT INTO user_role(role_id, user_id) VALUES (role_user_id, user_sergey_id);

        INSERT INTO rules(name) VALUES ('all') RETURNING id INTO rule_all_id;
        INSERT INTO rules(name) VALUES ('create_item') RETURNING id INTO rule_create_item_id;

        INSERT INTO roles_rules(role_id, rule_id) VALUES (role_admin_id, rule_all_id);
        INSERT INTO roles_rules(role_id, rule_id) VALUES (role_user_id, rule_create_item_id);

        INSERT INTO categories(name) VALUES ('food') RETURNING id INTO category_food_id;
        INSERT INTO categories(name) VALUES ('alcohol') RETURNING id INTO category_alcohol_id;

        INSERT INTO states(name) values ('created') RETURNING id INTO state_created_id;
        INSERT INTO states(name) values ('work') RETURNING id INTO state_work_id;
        INSERT INTO states(name) values ('payment');
        INSERT INTO states(name) values ('close');

        INSERT INTO items(description, user_id, category_id, state_id)
        values ('First', user_sergey_id, category_food_id, state_created_id)
        RETURNING id INTO item_first_id;
        INSERT INTO items(description, user_id, category_id, state_id)
        values ('Second', user_sergey_id, category_alcohol_id, state_work_id)
        RETURNING id INTO item_second_id;

        INSERT INTO comments(text, item_id) VALUES ('quickly', item_first_id);
        INSERT INTO comments(text, item_id) VALUES ('waiting for delivery', item_second_id);

        INSERT INTO attaches(path, item_id) VALUES ('C:\1.txt', item_first_id);
        INSERT INTO attaches(path, item_id) VALUES ('C:\2.txt', item_second_id);
    END
$$;