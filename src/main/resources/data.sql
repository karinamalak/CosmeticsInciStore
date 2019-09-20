--insert into user(id,email,name,password,surname) values(hibernate_sequence.NEXT_VAL,'email@email.com','name','{bcrypt}$2y$12$dqL6CtE.3DfoinrqFreD7.hU4v7SQSgxyMlVMGizzwRFlu7M8FpSK','surname'); --haslo "password1"
insert into user(email,name,password,surname) values('email@email.com','name','$2y$12$H7dhDuKP/kf0n1hnSiYyLuzqeA9cUQKEFIAeke4Qf/LTA05b.npxS','surname'); --haslo "password1"

insert into role values(1,'ADMIN');
insert into role values(2,'USER');
insert into user_role values(1,1);
insert into products values(1,	10,	'Extract',	'Description',	10	,'Citrus extract',	5);

--insert into user_role values(2,2);

//products: id, amount, category, description, measure, name, price
insert into products(amount,category,description,measure,name,price) values (100, 'Ekstrakty roślinne',
                             'Posiada działanie przeciwcellulitowe, ujędrniające i przeciwstarzeniowe. Pomaga zachować elastyczność skóry. Rozpuszczalny w fazie wodnej.',
                             '10 ml', 'Ekstrakt z zielonej herbaty', 5);
insert into products(amount,category,description,measure,name,price) values (100, 'Ekstrakty roślinne',
                             'Działa ochronnie na komórki skóry, przeciwutleniająco, pobudza odnowę naskórka. Polecany jako składnik produktów złuszczających i wygładzających skórę.',
                             '10 ml', 'Ekstrakt z jabłka', 4);
insert into products(amount,category,description,measure,name,price) values (50, 'Składniki aktywne',
                             'Nadaje włosom połysk i elastyczność.  Poprawia elastyczność naskórka i daje efekt liftingujący/ściągający.  Polecany do włosów i do skóry dojrzałej.',
                             '20 g', 'Bioferment z alg morskich', 12);
insert into products(amount,category,description,measure,name,price) values (50, 'Składniki aktywne',
                             'Posiada cenne właściwości jak łagodzenie podrażnień, działanie przeciwzapalne, przyspieszanie podziałów komórkowych , wygładzanie skóry szorstkiej i spękanej.',
                             '25 g', 'Alantoina', 13);

--insert into user_role values(2,2);

--products: id, amount, category, description, measure, name, price
insert into products(amount,category,description,measure,name,price) values (20, 'Hydrolaty',
                              'Posiada działanie przeciwcellulitowe,
                              ujędrniające i przeciwstarzeniowe. Pomaga zachować elastyczność skóry. PH prawidłowe.',
                              '50 ml', 'Hydrolat z zielonej herbaty', 10);

insert into products(amount,category,description,measure,name,price) values (50, 'Składniki aktywne',
                              'Posiada właściwości antybakteryjne, antyoksydacyjne oraz wybielające.',
                              '10 g', 'Niacynamid', 3);

insert into products(amount,category,description,measure,name,price) values (30, 'Kwasy',
                              'Posiada właściwości takie jak wybielanie oraz złuszczanie skóry. Polecany do cery dojrzałej oraz trądzikowej.',
                              '5 g', 'Kwas kojowy', 10);






