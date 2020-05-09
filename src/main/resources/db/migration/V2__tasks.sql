SET search_path TO time_controller;

DROP TABLE IF EXISTS tasks CASCADE;
CREATE TABLE tasks
(
    id              bigserial,
    title           varchar(64) NOT NULL,
    description     varchar(255),
    type            varchar(16) DEFAULT 'THOUGHT',
    user_id         int NOT NULL,

    is_done         boolean DEFAULT false,
    is_active       boolean DEFAULT true,
    is_deleted      boolean DEFAULT false,
    is_in_archive   boolean DEFAULT false,
    is_canseled     boolean DEFAULT false,

    created_at      timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at      timestamp,
    deleted_at      timestamp,
    started_at      timestamp,
    total_time      bigint,
    until_time      timestamp,

    PRIMARY KEY (id),
    FOREIGN KEY (user_id)
        REFERENCES users (id)
);


INSERT INTO tasks (title, description, user_id)
VALUES  
        ('Integer nec odio.', 'Sed non quam.', 1),
        ('Praesent libero.', 'Ut ultrices ultrices enim.', 1),
        ('Sed cursus ante dapibus diam.', 'Curabitur sit amet mauris.', 1),
        ('Sed nisi.', 'Morbi in dui quis est pulvinar ullamcorper.', 1),
        ('Duis sagittis ipsum.', 'Nunc feugiat mi a tellus consequat imperdiet.', 1),
        ('Praesent mauris.', 'Nulla facilisi.', 1),
        ('Mauris massa.', 'Integer lacinia sollicitudin massa.', 1),
        ('Vestibulum lacinia arcu eget nulla.', 'Cras metus.', 1),
        ('Curabitur sodales ligula in libero.', 'Sed aliquet risus a tortor.', 1),
        ('Sed dignissim lacinia nunc.', 'Integer id quam.', 1),
        ('Curabitur tortor.', 'Morbi mi.', 1),
        ('Pellentesque nibh.', 'Proin sodales libero eget ante.', 1),
        ('Aenean quam.', 'Nulla quam.', 1),
        ('In scelerisque sem at dolor.', 'Aenean laoreet.', 1),
        ('Maecenas mattis.', 'Proin ut ligula vel nunc egestas porttitor.', 1),
        ('Sed convallis tristique sem.', 'Fusce ac turpis quis ligula lacinia aliquet.', 1),
        ('Mauris ipsum.', 'In vel mi sit amet augue congue elementum.', 1),
        ('Nulla quis sem at nibh elementum imperdiet.', 'Morbi in ipsum sit amet pede facilisis laoreet.', 1),
        ('Quisque volutpat condimentum velit.', 'Vestibulum tincidunt malesuada tellus.', 1),
        ('Nam nec ante.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 1),
        ('Fusce nec tellus sed augue semper porta.', 'Suspendisse in justo eu magna luctus suscipit.', 2),
        ('Nulla facilisi.', 'Donec lacus nunc, viverra nec, blandit vel, egestas et, augue.', 2),
        ('Ut fringilla.', 'Quisque cursus, metus vitae pharetra auctor, sem massa mattis sem, at interdum magna augue eget diam.', 2),
        ('Suspendisse potenti.', 'Quisque nisl felis, venenatis tristique, dignissim in, ultrices sit amet, augue.', 2),
        ('Vestibulum sapien.', 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Morbi lacinia molestie dui.', 2),
        ('Proin quam.', 'Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.', 2),
        ('Etiam ultrices.', 'Morbi lectus risus, iaculis vel, suscipit quis, luctus non, massa.', 2),
        ('Sed lectus.', 'Nulla metus metus, ullamcorper vel, tincidunt sed, euismod in, nibh.', 2),
        ('Integer euismod lacus luctus magna.', 'Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.', 2),
        ('Praesent blandit dolor.', 'Sed lacinia, urna non tincidunt mattis, tortor neque adipiscing diam, a cursus ipsum ante quis turpis.', 2)
;

--SELECT * FROM tasks;



DROP TABLE IF EXISTS tasks_dates CASCADE;
CREATE TABLE tasks_days
(
    task_id         bigserial NOT NULL,
    day             date NOT NULL,
    was_at_work     boolean,

    PRIMARY KEY (task_id, day),
    FOREIGN KEY (task_id)
        REFERENCES tasks (id)
);
-- SELECT * FROM tasks_days;
