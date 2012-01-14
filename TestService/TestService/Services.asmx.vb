Imports System.Web.Services
Imports System.Web.Services.Protocols
Imports System.ComponentModel
Imports MySql.Data.MySqlClient

' To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line.
' <System.Web.Script.Services.ScriptService()> _
<System.Web.Services.WebService(Namespace:="http://tempuri.org/")> _
<System.Web.Services.WebServiceBinding(ConformsTo:=WsiProfiles.BasicProfile1_1)> _
<ToolboxItem(False)> _
Public Class servicios
    Inherits System.Web.Services.WebService

    
    <WebMethod()> Public Function GetMessage() As String
        Return "PROBANDO WEB SERVICE"
    End Function


    <WebMethod()> Public Function CalculaPromedio(ByVal Numero1 As Double, ByVal Numero2 As Double) As Double

        Return (Numero1 + Numero2) / 2

    End Function


    <WebMethod()> Public Function Login(ByVal user As String, ByVal password As String) As String

        Dim valida As String

        If user = "Freddy" And password = "Casas" Then
            valida = "Correcto"
        Else
            valida = "Incorrecto"
        End If

        Return valida

    End Function


    <WebMethod(Description:="Método web que llama a un procedimiento almacenado parametrizado.")> _
    Public Function EjecutarLogin(ByVal usuario As String, ByVal clave As String) As Integer

        Dim resultado As String

        Dim cmd As New MySqlCommand

        'Variable para Conexion a MySql
        Dim myConnection As MySqlConnection = New MySqlConnection

        'Asigna la cadena de conexion
        myConnection.ConnectionString = "Server=localhost;Database=srs;Uid=root;Pwd=mysql;"

        'Abre la conexion
        myConnection.Open()

        cmd.Connection = myConnection

        cmd.CommandText = "SP_VALIDARUSUARIO"
        cmd.CommandType = CommandType.StoredProcedure

        cmd.Parameters.Add("@VUSUARIO", MySqlDbType.String)
        cmd.Parameters.Add("@VCLAVE", MySqlDbType.String)
        cmd.Parameters.Add("@VRESULTADO", MySqlDbType.Int16)
        cmd.Parameters("@VRESULTADO").Direction = ParameterDirection.Output

        cmd.Parameters("@VUSUARIO").Value = usuario
        cmd.Parameters("@VCLAVE").Value = clave
        cmd.Parameters("@VRESULTADO").Value = 0

        cmd.ExecuteNonQuery()

        myConnection.Close()

        resultado = cmd.Parameters("@VRESULTADO").Value

        Return resultado

    End Function


    '' ''<WebMethod()> _
    '' ''Public Function SendMessage(ByVal message As String) As String
    '' ''    Return "Message received as: " & message
    '' ''End Function

    '' ''<WebMethod()> _
    '' ''Public Function ReverseMessageFunction(ByVal message As String) As String
    '' ''    Return StrReverse(message)
    '' ''End Function

    '' ''<WebMethod()> Public Sub ReverseMessageSub(ByRef message As String)
    '' ''    message = StrReverse(message)
    '' ''End Sub




End Class