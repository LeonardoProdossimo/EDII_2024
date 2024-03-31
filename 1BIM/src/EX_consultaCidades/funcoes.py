import requests
import unidecode

def busca(uf):
    if(uf == ""):
        req = requests.get(f"https://servicodados.ibge.gov.br/api/v1/localidades/distritos?orderBy=nome")
    else:
        req = requests.get(f"https://servicodados.ibge.gov.br/api/v1/localidades/estados/{uf}/distritos")
    return req.json()

def pesquisa(uf):
    conteudo = busca(uf)
    
    if(conteudo == []):
        return ["Nada encontrado", "Nada encontrado"]
    return organizaJson(conteudo)

def organizaJson(conteudo):
    cidades = []
    for i in range(len(conteudo)):
        cidade = [unidecode.unidecode(conteudo[i]["municipio"]["nome"]), conteudo[i]["municipio"]["microrregiao"]["mesorregiao"]["UF"]["sigla"]]
        cidades.append(cidade)
    return sorted(cidades, key=lambda item: item[0])
        