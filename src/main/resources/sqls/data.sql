USE shout_db;

/* Gender is an enum with values such as:

   1: Male
   2: Female
   3: Other

 */

## Users
INSERT INTO user(id, username, description, gender, password)
VALUES (1, 'Frankensteiner', 'Have a very bad humor and loves old movies', 1, 'AsdF4D%');

INSERT INTO user(id, username, description, gender, password)
VALUES (2, 'KittenLover', 'Loves every animals, especially cats', 2, '123456');

INSERT INTO user(id, username, description, gender, password)
VALUES (3, 'JE', 'People call me a troll, because I am...', 1, 'QSCQSCqsc');

## Posts
INSERT INTO post(id, title, content, date, is_political_correct, user_id)
VALUES (1,'Cats are amazing',
        'My cat is red and white with stripes, her name is Pluffy and she is amazing!',
        '1995-06-15 11:31:31',1,2);

INSERT INTO post(id, title, content, date, is_political_correct, user_id)
VALUES (2,'Vaccines sucks',
        'Do not take the vaccine, it destroys your dna!',
        '2020-06-15 11:31:31',0,3);

INSERT INTO post(id, title, content, date, is_political_correct, user_id)
VALUES (3,'Y not the first on moon?:D',
        'I find it so retarded, yet funny that some people don\'t believe, but then there is something we can laugh about. :P',
        '2003-06-15 11:31:31',0,1);

## Hashtags
INSERT INTO post_hashtags(post_id, hashtags)
VALUES (2,'#conspiracy');
INSERT INTO post_hashtags(post_id, hashtags)
VALUES (3,'#conspiracy');

INSERT INTO post_hashtags(post_id, hashtags)
VALUES (1,'#animals');

INSERT INTO post_hashtags(post_id, hashtags)
VALUES (1,'#cute');

## Comments
INSERT INTO comment(id, content, date, user_id)
VALUES (1,'I\'m not retard, you are! Why can you be so naive and trust the government?','2003-06-15 11:51:31',3);
INSERT INTO post_comments(post_id, comments_id)
VALUES (3,1);