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
