INSERT INTO TCLIENTE (APELLIDOS, CEDULA, NOMBRE, TELEFONO) VALUES ('PEREZ', '1', 'ROBERTO', '093939393');
INSERT INTO TCLIENTE (APELLIDOS, CEDULA, NOMBRE, TELEFONO) VALUES ('SANCHEZ', '2', 'RAUL', '093223333');
INSERT INTO TCUENTA (NUMERO, TIPO, CLIENTE_ID) VALUES ('22222', 'AHORRO', 1);
INSERT INTO TCUENTA (NUMERO, TIPO, CLIENTE_ID) VALUES ('33333', 'CORRIENTE', 2);
INSERT INTO TCUENTA (NUMERO, TIPO, CLIENTE_ID) VALUES ('44444', 'AHORRO', 2);
INSERT INTO TCUENTA (NUMERO, TIPO, CLIENTE_ID) VALUES ('55555', 'META', 2);
INSERT INTO TDIRECCION (DIRECCION, NOMENCLATURA, CLIENTE_ID) VALUES ('10 de agosto', 'n31', 1);
INSERT INTO TDIRECCION (DIRECCION, NOMENCLATURA, CLIENTE_ID) VALUES ('Av. Amazonas', 'n100', 1);
INSERT INTO TDIRECCION (DIRECCION, NOMENCLATURA, CLIENTE_ID) VALUES ('Av. Prensa', 'n1', 2);
INSERT INTO TINVERSION (NUMERO, TIPO, CLIENTE_ID) VALUES ('11110', 'FONDO_FIJO', 1);
INSERT INTO TINVERSION (NUMERO, TIPO, CLIENTE_ID) VALUES ('22220', 'FONDO_VARIABLE', 2);
INSERT INTO TTARJETA (NUMERO, TIPO, CLIENTE_ID) VALUES ('44549292929', 'VISA', 1);
INSERT INTO TTARJETA (NUMERO, TIPO, CLIENTE_ID) VALUES ('44542323232', 'VISA', 2);
INSERT INTO TTARJETA (NUMERO, TIPO, CLIENTE_ID) VALUES ('44212221212', 'MASTERCARD', 1);