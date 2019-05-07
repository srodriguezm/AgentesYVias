delete from agenteentity;
delete from agenteviahistoricoentity;
delete from viaentity;

insert into viaentity (id, callecarrera, nivelcongestion, numero, tipo) values (200, 'Calle', 37.9, 127, 'Carretera Principal');
insert into viaentity (id, callecarrera, nivelcongestion, numero, tipo) values (201, 'Calle', 24, 187, 'Carretera Secundaria');
insert into viaentity (id, callecarrera, nivelcongestion, numero, tipo) values (202, 'Carrera', 77.9, 7, 'Autopista');
insert into viaentity (id, callecarrera, nivelcongestion, numero, tipo) values (203, 'Carrera', 31.4, 19, 'Carretera Secundaria');
insert into viaentity (id, callecarrera, nivelcongestion, numero, tipo) values (204, 'Calle', 94.5, 26, 'Autopista');


insert into agenteentity (id, codigo, codigosecrett, experiencia, nombre, viaactual) values (200, '54DCTF8', 'SECT2049', 10.5, 'Julian Arenas', 200);
insert into agenteentity (id, codigo, codigosecrett, experiencia, nombre, viaactual) values (201, '54CHETM8', 'SECT2049', 30.9, 'Daniel Brawn', 201);
insert into agenteentity (id, codigo, codigosecrett, experiencia, nombre, viaactual) values (202, '54ALV998', 'SECT45049', 1.2, 'Jake Peralta', 202);
insert into agenteentity (id, codigo, codigosecrett, experiencia, nombre, viaactual) values (203, 'BKLNG69', 'SECT2042', 14.5, 'Amy Santiago', 203);
insert into agenteentity (id, codigo, codigosecrett, experiencia, nombre, viaactual) values (204, 'RGGH486', 'SECTA48049', 7.0, 'Terry Jeffords', 204);

insert into agenteviahistoricoentity (id, activa, fecharegistro, agente_id, via_id) values (200, 1,{ts '2017-07-04 15:52:25'}, 200, 200);
insert into agenteviahistoricoentity (id, activa, fecharegistro, agente_id, via_id) values (201, 0,{ts '2017-07-04 15:52:25'}, 201, 201);
insert into agenteviahistoricoentity (id, activa, fecharegistro, agente_id, via_id) values (202, 1,{ts '2017-07-04 15:52:25'}, 202, 203);
insert into agenteviahistoricoentity (id, activa, fecharegistro, agente_id, via_id) values (203, 1,{ts '2017-07-04 15:52:25'}, 203, 203);
insert into agenteviahistoricoentity (id, activa, fecharegistro, agente_id, via_id) values (204, 1,{ts '2017-07-04 15:52:25'}, 204, 200);
insert into agenteviahistoricoentity (id, activa, fecharegistro, agente_id, via_id) values (205, 0,{ts '2016-04-02 15:52:25'}, 204, 200);