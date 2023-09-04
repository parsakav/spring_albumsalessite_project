insert IGNORE into role(id,name) values (1,"ROLE_USER");
insert IGNORE into role(id,name)values(2,"ROLE_ADMIN");
insert IGNORE into users(user_id,user_name,pass) values (1,"admin","$2a$10$QaJnG1fa7/F2IREG72dAIue05MbwdL5xWTT3vqV0pFEumnsTNErjq");
insert IGNORE into user_role(user_id, role_id) VALUES (1,2);
/*insert IGNORE into category(category_id,category_name) values(1,"rock");
insert IGNORE into category(category_id,category_name) values(2,"pop");
INSERT IGNORE INTO singer(singer_fname, singer_lname, singer_nickname) values ("Darush","Eghbali","Darush");
INSERT IGNORE INTO singer(singer_fname, singer_lname, singer_nickname) values ("Faeghe","Atashin","Googosh");
INSERT IGNORE INTO album(album_id, album_releasedate, album_sam, album_name, album_price, counter, singer_id) VALUES (1,"2008-11-12","Labkhand.mp3","Labkhand",12,0,1);
INSERT IGNORE INTO album(album_id, album_releasedate, album_sam, album_name, album_price, counter, singer_id) VALUES (2,"2012-11-12","Narafigh.mp3","Narafigh",18,0,1);
INSERT IGNORE INTO album(album_id, album_releasedate, album_sam, album_name, album_price, counter, singer_id) VALUES (3,"2016-11-1","Benameman.mp3","Be name man",19,0,1);
INSERT IGNORE INTO album(album_id, album_releasedate, album_sam, album_name, album_price, counter, singer_id) VALUES (4,"2015-11-1","Hamseda.mp3","Hamseda",9,0,2);
INSERT IGNORE INTO album(album_id, album_releasedate, album_sam, album_name, album_price, counter, singer_id) VALUES (5,"2009-11-1","Sahneh.mp3","Sahne",11,0,2);
INSERT IGNORE INTO album(album_id, album_releasedate, album_sam, album_name, album_price, counter, singer_id) VALUES (6,"2006-11-1","Nagobedrood.mp3","Nago bedrood",10,0,2);
INSERT IGNORE INTO category_album (category_category_id, album_id)  values (1,1);
INSERT IGNORE INTO category_album (category_category_id, album_id)  values (1,2);
INSERT IGNORE INTO category_album (category_category_id, album_id)  values (1,3);
INSERT IGNORE INTO category_album (category_category_id, album_id)  values (2,4);
INSERT IGNORE INTO category_album (category_category_id, album_id)  values (2,5);
INSERT IGNORE INTO category_album (category_category_id, album_id)  values (2,6);

*/
