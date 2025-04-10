Imports System

Module ArraysAlgoVB

    Dim rand As New Random()
    Dim verify As Boolean = True
    Dim contExecute As Integer = 0
    Dim auxSwitch As Integer

    Sub CloneArray(original() As Integer, ByRef copia() As Integer)
        'Adiciona o array original para o auxiliar
        If copia.Length = 0 Then
            ReDim copia(original.Length - 1)
            Array.Copy(original, copia, original.Length)

        Else
            ' Modificas a posicao do arney copia previamente clonado pelo addAll(original)
            For i As Integer = 0 To original.Length - 1
                copia(i) = original(i)
            Next
        End If
    End Sub

    Sub OrganizeArray(ByRef array() As Integer, ByRef arrayAux() As Integer)
        'Ordena os pares e verifica que ainda existe mais
        While verify
            contExecute = 0
            For i As Integer = 0 To array.Length - 2
                If (array(i) = 1 Or array(i) Mod 2 <> 0) AndAlso (array(i + 1) Mod 2 = 0) Then
                    auxSwitch = arrayAux(i)
                    arrayAux(i) = arrayAux(i + 1)
                    arrayAux(i + 1) = auxSwitch
                    contExecute += 1
                End If
            Next
            ' Verifica se houve alguma troca, se sim ele clona o arney auxiliar como original e corre o array novamente!
            If contExecute = 0 Then
                verify = False
            Else
                CloneArray(arrayAux, array)
            End If
        End While
    End Sub

    Sub CreateRandom(nrElementos As Integer, ByRef original() As Integer)
        ReDim original(nrElementos - 1)
        For i As Integer = 0 To nrElementos - 1
            original(i) = rand.Next(1, 101)
        Next
    End Sub

    Sub Main()
        Console.WriteLine("---------(Elementos São Gerados Aleatoriamente)-----------")
        Console.Write("Digite a Quantidade do Elemento DO Array: ")
        Dim nrElementos As Integer = Integer.Parse(Console.ReadLine())

        Dim array() As Integer = {}
        Dim arrayAux() As Integer = {}

        ' Cria e clona o array para o arrayAux!
        CreateRandom(nrElementos, array)
        CloneArray(array, arrayAux)

        Console.WriteLine("Array Original:")
        Console.Write("[")
        For Each num As Integer In array
            Console.Write(" "&num)
        Next
        Console.WriteLine("]")


        ' Organiza o Array usando o ArrayAux como base!
        OrganizeArray(array, arrayAux)

        Console.WriteLine("Array Organizado:")
        Console.Write("[")
        For Each num As Integer In arrayAux
            Console.Write(" "&num)
        Next
        Console.Write("]")

    End Sub

End Module
