Imports MySql.Data.MySqlClient


Partial Public Class _Default
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

    End Sub


    Public Function llamarProcedimiento(ByVal usuario As String, ByVal clave As String) As Integer

        Dim cmd As New MySqlCommand

        'Variable para Conexion a MySql
        Dim myConnection As MySqlConnection = New MySqlConnection()

        'Asigna la cadena de conexion
        myConnection.ConnectionString = "Server=localhost;Database=srs;Uid=root;Pwd=mysql;"

        'Abre la conexion
        myConnection.Open()

        cmd.Connection = myConnection

        cmd.CommandText = "LLAMADA"
        cmd.CommandType = CommandType.StoredProcedure

        cmd.Parameters.Add("@VUSUARIO", MySqlDbType.String)
        cmd.Parameters.Add("@VCLAVE", MySqlDbType.String)
        cmd.Parameters.Add("@VRESULTADO", MySqlDbType.Int16, ParameterDirection.Output)


        cmd.Parameters("@VUSUARIO").Value = usuario
        cmd.Parameters("@VCLAVE").Value = clave
        'cmd.Parameters("@VRESULTADO").Value = 0

        txtResultado.Text = cmd.ExecuteNonQuery()





        myConnection.Close()

    End Function

   

    Protected Sub Button4_Click(ByVal sender As Object, ByVal e As EventArgs) Handles Button4.Click
        Dim user As String
        Dim password As String

        user = txtUser.Text
        password = txtPassword.Text


        Dim servicioSOAP As New Promedio.servicios

        txtResultado.Text = servicioSOAP.EjecutarLogin(user, password)

        If txtResultado.Text = 1 Then
            Response.Redirect("Menu.aspx")
        Else
            MsgBox("USUARIO INCORRECTO")
        End If
    End Sub
End Class