Algoritmo "AgenciaDeViagens"
// Disciplina   : [Linguagem e L�gica de Programa��o]
// Descri��o   : O algoritmo tem a capacidade de realizar o cadastro de clientes e destinos, bem como a consulta dos clientes e destinos j� cadastrados.
// Autor(a)    : Jorge Lucas Nunes Nascimento
// Data atual  : 17/07/2023

const
    MAX_CLIENTES = 5
    MAX_DESTINOS = 5

Var
    i:inteiro
    opcao: inteiro
    numClientes: inteiro
    numDestinos: inteiro
    nomeCliente: vetor [0.. MAX_CLIENTES] de caracter
    nomeDestino: vetor [0.. MAX_DESTINOS] de caracter

//Procedimento que cadastra o cliente
procedimento cadastrarCliente
inicio
    se numClientes < MAX_CLIENTES ent�o
        escreval("Digite o nome do cliente: ")
        leia(nomeCliente[numClientes])
        numClientes <- numClientes + 1
        escreval("Cliente cadastrado com sucesso!")
        escreval("")
    sen�o
        escreval("Limite m�ximo de clientes atingido.")
        escreval("")
    fimse

fimprocedimento

//Procedimento que cadastra o destino
procedimento cadastrarDestino
inicio
    se numDestinos < MAX_DESTINOS ent�o
        escreval("Digite o nome do destino: ")
        leia(nomeDestino[numDestinos])
        numDestinos <- numDestinos + 1
        escreval("Destino cadastrado com sucesso!")
        escreval("")
    sen�o
        escreval("Limite m�ximo de destinos atingido.")
        escreval("")
    fimse

fimprocedimento

//Procedimento que consulta os clientes
procedimento consultarClientes
inicio
    se numClientes > 0 ent�o
        para i de 0 ate numClientes - 1 passo 1 faca
            escreval("Cliente ", i + 1, ": ", nomeCliente[i])
        fimpara
    sen�o
        escreval("Nenhum cliente cadastrado.")
        escreval("")
    fimse
fimprocedimento

//Procedimento que consulta os destinos
procedimento consultarDestinos
inicio
    se numDestinos > 0 ent�o
        para i de 0 ate numDestinos - 1 passo 1 faca
            escreval("Destino ", i + 1, ": ", nomeDestino[i])
            escreval("")
        fimpara
    sen�o
        escreval("Nenhum destino cadastrado.")
        escreval("")
    fimse
fimprocedimento

Inicio
    numClientes <- 0
    numDestinos <- 0


    repita
        escreval("---------------------")
        escreval("Ag�ncia de Viagens")
        escreval("---------------------")
        escreval("1. Cadastrar cliente")
        escreval("2. Cadastrar destino")
        escreval("3. Consultar clientes")
        escreval("4. Consultar destinos")
        escreval("5. Sair")
        escreval("---------------------")
        escreval("Digite a op��o desejada: ")
        leia(opcao)

        escolha (opcao)
            caso 1
                cadastrarCliente
            caso 2
                cadastrarDestino
            caso 3
                consultarClientes
            caso 4
                consultarDestinos
            caso 5
                escreval("Saindo...")
            outrocaso
                escreval("Op��o inv�lida.")
        fimescolha

     ate opcao = 5

Fimalgoritmo
