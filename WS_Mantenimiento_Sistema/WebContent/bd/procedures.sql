-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_validar_usuario`(
    usuario VARCHAR(15)
)
BEGIN
    SELECT COUNT(id_usuario) AS existe
      FROM srs.usuario u
     WHERE u.usuario = usuario;
END

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_cliente`(
    _ape_pat_cliente varchar(50),
    _ape_mat_cliente varchar(50),
    _nombre varchar(50),
    _direccion varchar(100),
    _telefono varchar(15),
    _email varchar(50),
    _tipo_documento_identidad int,
    _nro_documento_identidad varchar(30),
    _id_distrito varchar(30),
    _usuario varchar(15),
    _clave char(40)
)
BEGIN
    DECLARE _id_usuario int(10);

    IF(_usuario <> '' AND _clave <> '') THEN
        INSERT INTO srs.usuario(usuario, clave, tipo_usuario, estado)
        VALUES(_usuario, _clave, 1, 1);
        
        SET _id_usuario = LAST_INSERT_ID();
    END IF;

    -- Código de cliente autogenerado
    SET @autogenerado = (SELECT CONCAT('C', RIGHT(CONCAT('0000000',cast((cast(RIGHT(max(case c.cod_cliente when null then '0' else c.cod_cliente end),7) AS UNSIGNED INTEGER) + 1)as char)),7)) FROM srs.cliente c);

    INSERT INTO cliente
    (cod_cliente, ape_pat_cliente, ape_mat_cliente, nombre,
     direccion, tipo_documento_identidad, nro_documento_identidad,
     telefono, email, id_distrito, id_usuario)
    VALUES
    (@autogenerado, _ape_pat_cliente, _ape_mat_cliente, _nombre,
     _direccion, _tipo_documento_identidad, _nro_documento_identidad,
     _telefono, _email, _id_distrito, _id_usuario);
END

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_empleado`(
    vnombres VARCHAR(50), 
    vapePatEmp VARCHAR(50), 
    vapeMatEmp VARCHAR(50), 
    vdireccion VARCHAR(100), 
    vtipo_doc_identidad INT(11), 
    vnro_doc_identidad VARCHAR(30), 
    vdistrito CHAR(6), 
    vcargo CHAR(1), 
    vfoto VARCHAR(100), 
    email VARCHAR(50), 
    vusuario VARCHAR(15), 
    vclave CHAR(40)
)
BEGIN
    DECLARE vid_usuario int(10);

    IF(vusuario <> '' AND vclave <> '') THEN
        INSERT INTO srs.usuario(usuario, clave, tipo_usuario, estado)
        VALUES(vusuario, vclave, 2, 1);

        SET vid_usuario = LAST_INSERT_ID();
    END IF;

    -- Generar el código de empleado 
    SET @auto_codempleado = (SELECT CONCAT('E', RIGHT(CONCAT('0000000',cast((cast(RIGHT(max(case e.cod_empleado when null then '0' else e.cod_empleado end),7) AS UNSIGNED INTEGER) + 1)as char)),7)) FROM srs.empleado e);

    -- Registrar al empleado usando el código de empleado generado y el id de usuario obtenido
    INSERT INTO srs.empleado
    (nombre, ape_pat_empleado, ape_mat_empleado, direccion, tipo_documento_identidad, 
     nro_documento_identidad, distrito, cod_empleado, cargo, foto, id_usuario, email)
    VALUES
    (vnombres, vapePatEmp, vapeMatEmp, vdireccion, vtipo_doc_identidad, vnro_doc_identidad,
     vdistrito, @auto_codempleado, vcargo, vfoto, vid_usuario, email);

END

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_departamentos`()
BEGIN

        SELECT d.id_departamento, d.nombre
          FROM srs.departamento d;
END

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_provincias`(
    id_departamento char(2)
)
BEGIN

        SELECT p.id_provincia, p.nombre
          FROM srs.provincia p
         WHERE p.id_departamento = id_departamento;
END

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_distritos`(
    id_provincia char(4)
)
BEGIN

        SELECT d.id_distrito, d.nombre
          FROM srs.distrito d
         WHERE d.id_provincia = id_provincia;
END
