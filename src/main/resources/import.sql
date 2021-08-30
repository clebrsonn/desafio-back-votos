INSERT INTO rulling(name) VALUES ('PAUTA 1');
insert into session(closed_time, duration, is_closed, open_time, rulling_id) VALUES (now(), 1, false, now(), (select Id from rulling));


INSERT INTO associate(cpf, name) VALUES ('1234567890', 'NOT VALID');
INSERT INTO associate(cpf, name) VALUES ('34751395025', 'Associado 1');
INSERT INTO associate(cpf, name) VALUES ('67835876060', 'Associado 2');
INSERT INTO associate(cpf, name) VALUES ('37179801062', 'Associado 1');

INSERT INTO vote(choice, cd_associate, cd_session) VALUES ('SIM', '34751395025', (select id from session));