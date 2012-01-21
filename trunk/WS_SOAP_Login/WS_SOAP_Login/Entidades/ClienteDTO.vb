Public Class ClienteDTO
    Public vid As Integer
    Public vcod_codigo As String
    Public vape_pat_cliente As String
    Public vnombre As String
    Public vape_mat_cliente As String
    Public vdireccion As String
    Public vtipo_documento As Integer
    Public vnro_documento As String
    Public vtelefono As String
    Public vemail As String
    Public vusuarior As String
    Public vdistrito As String


    Public Property ID_Cliente() As String
        Get
            Return vid
        End Get
        Set(ByVal value As String)
            vid = value
        End Set
    End Property

    Public Property Codigo() As String
        Get
            Return vcod_codigo
        End Get
        Set(ByVal value As String)
            If value <> "" Then
                vcod_codigo = value
            End If
        End Set
    End Property

    Public Property ApellidoPaterno() As String
        Get
            Return vape_pat_cliente
        End Get
        Set(ByVal value As String)
            If value <> "" Then
                vape_pat_cliente = value
            End If
        End Set
    End Property

    Public Property ApellidoMaterno() As String
        Get
            Return vape_mat_cliente
        End Get
        Set(ByVal value As String)
            If value <> "" Then
                vape_mat_cliente = value
            End If
        End Set
    End Property

    Public Property Nombre_Cliente() As String
        Get
            Return vnombre
        End Get
        Set(ByVal value As String)
            If value <> "" Then
                vnombre = value
            End If
        End Set
    End Property

    Public Property Direccion_Cliente() As String
        Get
            Return vdireccion
        End Get
        Set(ByVal value As String)
            If value <> "" Then
                vdireccion = value
            End If
        End Set
    End Property

    Public Property Tipo_Documento() As Integer
        Get
            Return vtipo_documento
        End Get
        Set(ByVal value As Integer)
            If value <> 0 Then
                vtipo_documento = value
            End If
        End Set
    End Property


    Public Property Numero_Documento() As String
        Get
            Return vnro_documento
        End Get
        Set(ByVal value As String)
            If value <> "" Then
                vnro_documento = value
            End If
        End Set
    End Property

    Public Property Telefono() As String
        Get
            Return vtelefono
        End Get
        Set(ByVal value As String)
            If value <> "" Then
                vtelefono = value
            End If
        End Set
    End Property

    Public Property Email() As String
        Get
            Return vemail
        End Get
        Set(ByVal value As String)
            If value <> "" Then
                vemail = value
            End If
        End Set
    End Property


    Public Property Usuario_Retorno() As String
        Get
            Return vusuarior
        End Get
        Set(ByVal value As String)
            If value <> "" Then
                vusuarior = value
            End If
        End Set
    End Property

    Public Property Distrito() As String
        Get
            Return vdistrito
        End Get
        Set(ByVal value As String)
            If value <> "" Then
                vdistrito = value
            End If
        End Set
    End Property

End Class
