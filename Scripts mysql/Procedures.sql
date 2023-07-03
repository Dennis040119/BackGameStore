/********Procedures GameStore******************************/

use gamestore;

/****Procedure listar usuarios activos**/
DELIMITER //
create procedure ListarUsuariosActivos()
begin
select*from usuario where estado like 'ac' ;
end//
DELIMITER ;

call ListarUsuariosActivos()

/****Procedure eliminar usuarios(cambiarles el estado a ic)**/

DELIMITER //
drop procedure eliminarUsuario;
create procedure eliminarUsuario(id varchar(5) )
begin
update usuario set estado='ic' where userid=id ;
end//
DELIMITER ;

call eliminarUsuario('us002')