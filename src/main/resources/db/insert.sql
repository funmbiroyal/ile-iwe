set foreign_key_checks = 0;

truncate table learning_party;
truncate table authority;
truncate table instructor;

insert into learning_party(`id`, `email`,`password`, `enabled`)
values(123, 'gracie@gmail.com', '"pass123"', false),
      (124, 'tomi@mail.com', '123pass321', false),
      (125, 'tobi@mail.com', '123pass321', false),
      (126, 'alex@mail.com', '123pass321', false),
      (127, 'craig@mail.com', '123pass321', false);

set foreign_key_checks = 1;