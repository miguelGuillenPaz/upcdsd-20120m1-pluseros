using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using WSREST_Login.Dominio;
using MySql.Data;
using MySql.Data.MySqlClient;
using System.Security.Cryptography;
using System.Text;
using System.Web.Configuration;


namespace WSREST_Login.Persistencia
{
    public class UsuarioDAO
    {
        public Usuario AutenticarUsuario(String usuario, String clave)
        {
            Usuario usuarioEncontrado = null;

            string claveSHA1 = string.Empty;
            claveSHA1 = GetSHA1(clave);

            string connectionString = WebConfigurationManager.ConnectionStrings["cnxMySql"].ConnectionString;
 
            string sql = "(SELECT u.usuario, u.tipo_usuario, u.estado, c.email, " +
                         "        CONCAT(c.nombre, ' ' , c.ape_pat_cliente, ' ', c.ape_mat_cliente) as nombre " +
                         "   FROM usuario u, cliente2 c " +
                         "  WHERE u.id_usuario = c.id_usuario " +
                         "    AND u.usuario = @user " +
                         "    AND u.clave = @clave) " +
                         "  UNION " +
                         "(SELECT u.usuario, u.tipo_usuario, u.estado, c.email, " +
                         "        CONCAT(c.nombre, ' ' , c.ape_pat_empleado, ' ', c.ape_mat_empleado) as nombre " +
                         "   FROM usuario u, empleado2 c " +
                         "  WHERE u.id_usuario = c.id_usuario " +
                         "    AND u.usuario = @user " +
                         "    AND u.clave = @clave)";

            //using (MySqlConnection con = new MySqlConnection(ConexionUtil.cadena))
            using (MySqlConnection con = new MySqlConnection(connectionString))

            {
                con.Open();
                using (MySqlCommand com = new MySqlCommand(sql, con))
                {
                    com.Parameters.Add(new MySqlParameter("@user", usuario));
                    com.Parameters.Add(new MySqlParameter("@clave", claveSHA1));
                    using (MySqlDataReader resultado = com.ExecuteReader())
                    {
                        if (resultado.Read())
                        {
                            usuarioEncontrado = new Usuario()
                            {
                                usuario = (string)resultado["usuario"],
                                tipoUsuario = Int32.Parse(resultado["tipo_usuario"].ToString()),
                                estado = Int32.Parse(resultado["estado"].ToString()),
                                nombre = (string)resultado["nombre"],
                                email = (string)resultado["email"]
                            };
                        }
                    }

                }
            }
            return usuarioEncontrado;
        }

        public static string GetSHA1(string cadena)
        {
            SHA1 sha1 = SHA1Managed.Create();
            ASCIIEncoding encoding = new ASCIIEncoding();
            byte[] stream = null;
            StringBuilder sb = new StringBuilder();
            stream = sha1.ComputeHash(encoding.GetBytes(cadena));
            for (int i = 0; i < stream.Length; i++) {
                sb.AppendFormat("{0:x2}", stream[i]);
            }

            return sb.ToString();
        }


    }
}