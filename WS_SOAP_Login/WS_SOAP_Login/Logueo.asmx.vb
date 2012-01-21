Imports System.Web.Services
Imports System.Web.Services.Protocols
Imports System.ComponentModel
Imports MySql.Data.MySqlClient
Imports System.Security.Cryptography
Imports System.Text

' To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line.
' <System.Web.Script.Services.ScriptService()> _
<System.Web.Services.WebService(Namespace:="http://tempuri.org/")> _
<System.Web.Services.WebServiceBinding(ConformsTo:=WsiProfiles.BasicProfile1_1)> _
<ToolboxItem(False)> _
Public Class Logueo
    Inherits System.Web.Services.WebService

    <WebMethod(Description:="Método para el Login")> _
    Public Function RetornaCliente(ByVal usuario As String, ByVal clave As String) As ClienteDTO

        clave = GetSHA1(clave)

        Dim cmd As New MySqlCommand

        'Variable para Conexion a MySql
        Dim myConnection As MySqlConnection = New MySqlConnection

        'Asigna la cadena de conexion
        myConnection.ConnectionString = ConfigurationManager.ConnectionStrings("cnxMySql").ConnectionString
        'myConnection.ConnectionString = "Server=localhost;Database=srs;Uid=root;Pwd=mysql;"

        'Abre la conexion
        myConnection.Open()

        cmd.Connection = myConnection

        cmd.CommandText = "SP_VALIDAR_USUARIO"
        cmd.CommandType = CommandType.StoredProcedure

        cmd.Parameters.Add("@VUSUARIO", MySqlDbType.String)
        cmd.Parameters.Add("@VCLAVE", MySqlDbType.String)

        cmd.Parameters.Add("@VID", MySqlDbType.Int16)
        cmd.Parameters("@VID").Direction = ParameterDirection.Output

        cmd.Parameters.Add("@VCODIGO", MySqlDbType.String)
        cmd.Parameters("@VCODIGO").Direction = ParameterDirection.Output

        cmd.Parameters.Add("@VAPEPATERNO", MySqlDbType.String)
        cmd.Parameters("@VAPEPATERNO").Direction = ParameterDirection.Output

        cmd.Parameters.Add("@VNOMBRE", MySqlDbType.String)
        cmd.Parameters("@VNOMBRE").Direction = ParameterDirection.Output

        cmd.Parameters.Add("@VAPEMATERNO", MySqlDbType.String)
        cmd.Parameters("@VAPEMATERNO").Direction = ParameterDirection.Output

        cmd.Parameters.Add("@VDIRECCION", MySqlDbType.String)
        cmd.Parameters("@VDIRECCION").Direction = ParameterDirection.Output

        cmd.Parameters.Add("@VTIPODOCUMENTO", MySqlDbType.Int16)
        cmd.Parameters("@VTIPODOCUMENTO").Direction = ParameterDirection.Output

        cmd.Parameters.Add("@VNRODOCUMENTO", MySqlDbType.String)
        cmd.Parameters("@VNRODOCUMENTO").Direction = ParameterDirection.Output

        cmd.Parameters.Add("@VTELEFONO", MySqlDbType.String)
        cmd.Parameters("@VTELEFONO").Direction = ParameterDirection.Output

        cmd.Parameters.Add("@VEMAIL", MySqlDbType.String)
        cmd.Parameters("@VEMAIL").Direction = ParameterDirection.Output

        cmd.Parameters.Add("@VUSUARIOR", MySqlDbType.String)
        cmd.Parameters("@VUSUARIOR").Direction = ParameterDirection.Output

        cmd.Parameters.Add("@VDISTRITO", MySqlDbType.String)
        cmd.Parameters("@VDISTRITO").Direction = ParameterDirection.Output

        cmd.Parameters("@VUSUARIO").Value = usuario
        cmd.Parameters("@VCLAVE").Value = clave

        Dim reader As MySqlDataReader
        reader = cmd.ExecuteReader

        Dim service As ClienteDTO = New ClienteDTO

        While reader.Read()

            service.ID_Cliente = reader.GetValue(0)
            service.Codigo = reader.GetValue(1)
            service.ApellidoPaterno = reader.GetValue(2)
            service.Nombre_Cliente = reader.GetValue(3)
            service.ApellidoMaterno = reader.GetValue(4)
            service.Direccion_Cliente = reader.GetValue(5)
            service.Tipo_Documento = reader.GetValue(6)
            service.Numero_Documento = reader.GetValue(7)
            service.Telefono = reader.GetValue(8)
            service.Email = reader.GetValue(9)
            service.Usuario_Retorno = reader.GetValue(10)
            service.Distrito = reader.GetValue(11)

            Return service

        End While

        'arreglo(0) = reader.GetValue(0)
        'arreglo(1) = reader.GetValue(1)
        'arreglo(2) = reader.GetValue(2)
        'arreglo(3) = reader.GetValue(3)
        'arreglo(4) = reader.GetValue(4)
        'arreglo(5) = reader.GetValue(5)
        'arreglo(6) = reader.GetValue(6)
        'arreglo(7) = reader.GetValue(7)
        'arreglo(8) = reader.GetValue(8)
        'arreglo(9) = reader.GetValue(9)
        'arreglo(10) = reader.GetValue(10)
        'arreglo(11) = reader.GetValue(11)




        myConnection.Close()


    End Function


    Public Function GetSHA1(ByVal clave As String)
        Dim sha1 As SHA1 = SHA1Managed.Create()
        Dim encoding As New ASCIIEncoding()
        Dim stream As Byte() = Nothing
        Dim sb As New StringBuilder()
        stream = sha1.ComputeHash(encoding.GetBytes(clave))
        For i As Integer = 0 To (stream.Length - 1)
            sb.AppendFormat("{0:x2}", stream(i))
        Next

        Return sb.ToString

    End Function

End Class