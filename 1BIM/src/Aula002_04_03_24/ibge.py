import requests

def busca(nome):
    req = requests.get(f"https://servicodados.ibge.gov.br/api/v2/censos/nomes/{nome}")
    return req.json()

def calcula_ocorrencias(nome, tipoOperacao):
    conteudo = busca(nome)
    if(conteudo == []):
        return ["Nada encontrado", "Nada encontrado"]
    response = conteudo[0].get("res", [])
    return achaMetodo(response, tipoOperacao)


def achaMetodo(response, tipoOperacao):
    print(response[1]["frequencia"])
    listaFrequencia = [valor['frequencia'] for valor in response]
    
    if tipoOperacao == "sum":
        print("caiu 1")
        return sum(listaFrequencia)
    
    elif tipoOperacao == "min":
        print("caiu 2")
        return response[listaFrequencia.index(min(listaFrequencia))]
    
    elif tipoOperacao == "max":
        print("caiu 3")
        return response[listaFrequencia.index(max(listaFrequencia))]
    
    else: 
        print("caiu 4")
        for i in range(len(response)-1):
            menor = i
            for j in range(i+1, len(response)):
                if(response[menor]["frequencia"] > response[j]["frequencia"]):
                    menor = j
            if(menor != i):
                response[i], response[menor] = response[menor], response[i]
        return response
