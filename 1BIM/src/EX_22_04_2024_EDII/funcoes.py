import requests
import unidecode

def busca():
    req = requests.get(f"https://servicodados.ibge.gov.br/api/v1/localidades/distritos?orderBy=nome")
    return req.json()

def pesquisa(tipo):
    conteudo = busca()
    
    if(conteudo == []):
        return ["Nada encontrado", "Nada encontrado"]
    return organizaJson(tipo, conteudo)

def organizaJson(conteudo):
    cidades = []
    for i in range(len(conteudo)):
        cidades.append(unidecode.unidecode(conteudo[i]["municipio"]["nome"]))
    return organiza(tipo, cidades)

def organiza(tipo, lista):
    if(tipo == 'selection'):
         for i in range(len(lista)-1):
            menor = i
            for j in range(i+1, len(lista)):
                if(lista[menor] > lista[j]):
                    menor = j
            if(menor != i):
                lista[i], lista[menor] = lista[menor], lista[i]
        