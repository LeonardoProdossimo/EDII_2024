import requests

def busca(nome):
    req = requests.get(f"https://servicodados.ibge.gov.br/api/v2/censos/nomes/{nome}")
    return req.json()

def calcula_ocorrencias(nome, tipoOperacao):
    conteudo = busca(nome)
    response = conteudo[0].get("res", [])
    return achaMetodo(response, tipoOperacao)

def achaMetodo(response, tipoOperacao):
    print(response)
    listaFrequencia = [valor['frequencia'] for valor in response]
    listaPeriodo = [periodo['periodo'] for periodo in response]
    
    if tipoOperacao == "sum":
        print("caiu 1")
        return sum(listaFrequencia)
    
    elif tipoOperacao == "min":
        print("caiu 2")
        print(listaPeriodo[listaFrequencia.index(min(listaFrequencia))])
        return [min(listaFrequencia), listaPeriodo[listaFrequencia.index(min(listaFrequencia))]]
    
    else:
        print("caiu 3")
        return [max(listaFrequencia), listaPeriodo[listaFrequencia.index(max(listaFrequencia))]]
