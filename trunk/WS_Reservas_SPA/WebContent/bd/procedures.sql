-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_anular_reserva`(
    id int(11)
)
BEGIN
    UPDATE srs.reserva r
       SET r.estado = 'A'
     WHERE r.id_reserva = id
       AND r.estado = 'G';
END

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_reserva`(
    cod_reserva char(8)
)
BEGIN

        SELECT r.id_reserva,
               r.cod_reserva,
               r.dia_reserva,
               r.mes_reserva,
               r.anio_reserva,
               r.estado,
               r.hora_inicio,
               r.hora_fin,
               s.descripcion,
               c.nombre nom_cliente,
               c.ape_pat_cliente,
               c.ape_mat_cliente,
               e.nombre nom_empleado,
               e.ape_pat_empleado,
               e.ape_mat_empleado
          FROM srs.reserva r,
               srs.cliente c,
               srs.empleado e,
               srs.servicio s
         WHERE r.cod_reserva = cod_reserva
           AND r.id_cliente = c.id_cliente
           AND r.id_empleado = e.id_empleado
           AND r.id_servicio = s.id_servicio;
END

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_obtener_horarios_disponibles`(
    id_servicio  int(11),
    dia_reserva  char(2),
    mes_reserva  char(2),
    anio_reserva char(4)
)
BEGIN

       SELECT p.valor as hora_inicio
         FROM srs.parametros p
        WHERE p.tipo = 'HORA'
          AND (p.valor + (SELECT duracion_horas
                            FROM srs.servicio s
                           WHERE s.id_servicio = id_servicio))
              <=
              (SELECT MAX(CAST(pp.valor AS UNSIGNED))
                 FROM srs.parametros pp
                WHERE pp.tipo = 'HORA')
                  AND CAST(p.valor AS UNSIGNED) >= IF((CAST(NOW() AS CHAR(10))) = CONCAT(anio_reserva,'-',mes_reserva,'-',dia_reserva),HOUR(CURTIME()) + 2,p.valor)
          AND NOT EXISTS((SELECT 1 FROM srs.reserva r
                           WHERE r.id_servicio = id_servicio
                             AND r.dia_reserva  = dia_reserva
                             AND r.mes_reserva  = mes_reserva
                             AND r.anio_reserva = anio_reserva
                             AND r.estado <> 'P'
                             AND ((p.valor + (SELECT s.duracion_horas
                                                FROM srs.servicio s
                                               WHERE s.id_servicio = r.id_servicio))
                                 BETWEEN r.hora_inicio AND r.hora_fin - 1)));
                  

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

INSERT INTO srs.usuario(usuario, clave, tipo_usuario, estado)
VALUES(_usuario, _clave, 1, 1);
    
-- Id de usuario
SET @id_usuario = LAST_INSERT_ID();

-- Código de cliente autogenerado
SET @autogenerado = (SELECT CONCAT('C', RIGHT(CONCAT('0000000',cast((cast(RIGHT(max(case c.cod_cliente when null then '0' else c.cod_cliente end),7) AS UNSIGNED INTEGER) + 1)as char)),7)) FROM srs.cliente c);

INSERT INTO cliente
(cod_cliente, ape_pat_cliente, ape_mat_cliente, nombre,
 direccion, tipo_documento_identidad, nro_documento_identidad,
 telefono, email, id_distrito, id_usuario)
VALUES
(@autogenerado, _ape_pat_cliente, _ape_mat_cliente, _nombre,
 _direccion, _tipo_documento_identidad, _nro_documento_identidad,
 _telefono, _email, _id_distrito, @id_usuario);
END

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_reserva`(
    dia         char(2),
    mes         char(2),
    anio        char(4),
    id_servicio int(11),
    id_cliente  int(11),
    id_empleado int(11),
    hora_inicio varchar(2),
    hora_fin    varchar(2),
    out codigo  char(8))
BEGIN
SET @autogenerado = (SELECT CONCAT('R', RIGHT(CONCAT('0000000',cast((cast(RIGHT(max(case r.cod_reserva when null then '0' else r.cod_reserva end),7) AS UNSIGNED INTEGER) + 1)as char)),7)) FROM srs.reserva r);

INSERT INTO srs.reserva(cod_reserva, dia_reserva, mes_reserva, anio_reserva, estado, id_servicio, id_cliente, id_empleado, hora_inicio, hora_fin)
VALUES(@autogenerado, dia, mes, anio, 'P', id_servicio, id_cliente, id_empleado, hora_inicio, hora_fin);

SET codigo = @autogenerado;
END

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_obtener_empleados_disponibles`(
    id_servicio  int(11),
    dia_reserva  char(2),
    mes_reserva  char(2),
    anio_reserva char(4),
    hora_inicio  char(2),
    hora_fin     char(2)
)
BEGIN
    SELECT e.id_empleado, e.cod_empleado, e.foto,
           e.nombre, e.ape_pat_empleado, e.ape_mat_empleado
      FROM srs.empleado e, srs.empleado_servicio es
     WHERE e.id_empleado = es.id_empleado
       AND es.id_servicio = id_servicio
       AND NOT EXISTS(SELECT 1 FROM srs.reserva r
                       WHERE r.estado = 'G'
                         AND r.dia_reserva = dia_reserva
                         AND r.mes_reserva = mes_reserva
                         AND r.anio_reserva = anio_reserva
                         AND r.hora_inicio  BETWEEN hora_inicio AND hora_fin);
                  

END