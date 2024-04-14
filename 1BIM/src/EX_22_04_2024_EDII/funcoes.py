import requests
import unidecode
import time as t
from copy import deepcopy

listaResponse = []
auxMergeComp = [0]
auxQuickComp = [0]

def busca():
    req = requests.get(f"https://servicodados.ibge.gov.br/api/v1/localidades/distritos")
    return req.json()

def pesquisa():
    conteudo = busca()
    if(conteudo == []):
        return ["Nada encontrado", "Nada encontrado"]
    return separaInfoEmLista(conteudo)

def separaInfoEmLista(conteudo):
    cidades = []

    for i in range(len(conteudo)):
        cidades.append(unidecode.unidecode(conteudo[i]["municipio"]["nome"]))

    # cidades = [
    # "João", "Maria", "Pedro", "Ana", "José", "Carlos", "Luiza", "Paula", "Fernando",
    # "João", "Maria", "Pedro", "Ana", "José", "Carlos", "Luiza", "Paula", "Fernando",
    # "Juliana", "Mariana", "Rafael", "Aline", "André", "Lucas", "Camila", "Patrícia",
    # "Eduardo", "Roberto", "Bruna", "Letícia", "Vinícius", "Tatiana", "Diego", "Débora",
    # "Gustavo", "Natália", "Fábio", "Marcela", "Isabela", "Alexandre", "Cristina", "Daniel",
    # "Elaine", "Felipe", "Gabriela", "Hugo", "Ingrid", "Jorge", "Karina", "Leandro",
    # "Márcia", "Nelson", "Olivia", "Pablo", "Raquel", "Sérgio", "Talita", "Umberto",
    # "Márcia", "Nelson", "Olivia", "Pablo", "Raquel", "Sérgio", "Talita", "Umberto",
    # "Valentina", "Wagner", "Xavier", "Yasmin", "Zuleide", "Alice", "Breno", "Clara",
    # "Davi", "Eloá", "Fernanda", "Giovanni", "Heloísa", "Ícaro", "Júlia", "Kauã",
    # "Larissa", "Miguel", "Natasha", "Otávio", "Priscila", "Quiteria", "Rodrigo", "Sara",
    # "Thiago", "Úrsula", "Vitória", "William", "Xandão", "Yago", "Zara", "Adriano",
    # "Bianca", "Caio", "Diana", "Érica", "Felícia", "Guilherme", "Hérica", "Igor",
    # "Jéssica", "Kaique", "Lívia", "Matheus", "Nádia", "Otto", "Pâmela", "Quintino",
    # "Rita", "Sandro", "Tábata", "Ulisses", "Vanessa", "Wesley", "Xuxa", "Yuri", "Zélia"]


    return organiza(cidades)

def organiza(lista):
    selection(deepcopy(lista))
    bubble(deepcopy(lista))
    merge(deepcopy(lista))
    quick(deepcopy(lista))
    return listaResponse

#bloco do selection sort
def selection(lista):
    inicio = t.time()
    comp = 0
    for i in range(len(lista)-1):
        menor = i
        for j in range(i+1, len(lista)):
            if(lista[menor] > lista[j]):
                menor = j
            comp += 1
        if(menor != i):
            lista[i], lista[menor] = lista[menor], lista[i]
    fim = t.time()
   # print(lista)
    listaResponse.append(["Selection sort", f"Tempo de exe. {(fim-inicio):.5f} seg", f"Num. Comparacoes: {comp}"])


#bloco do bubble sort
def bubble(lista):
    comp = 0
    inicio = t.time()
    j = len(lista)-1
    while j > 0:
        for i in range(j):
            if lista[i] > lista[i+1]:
                lista[i], lista[i+1] = lista[i+1], lista[i]
            comp += 1
        j -= 1
    fim = t.time()
    # print(lista)
    listaResponse.append(["Bubble sort", f"Tempo de exe. {(fim-inicio):.5f} seg", f"Num. Comparacoes: {comp}"])


#bloco do merge sort
def intercala(inicio, meio, fim, lista):
    listaAux = []
    i = inicio
    j = meio
    while i < meio and j < fim:
        if lista[i] < lista[j]:
            listaAux.append(lista[i])
            i = i + 1
        else:
            listaAux.append(lista[j])
            j = j + 1
        auxMergeComp[0] += 1
    while j < fim:
        listaAux.append(lista[j])
        j += 1
    while i < meio:
        listaAux.append(lista[i])
        i += 1
    for k in range(inicio, fim):
        lista[k] = listaAux[k-inicio]

def merge(lista):
    tempoInicial = t.time()
    mergeRecursivo(0, len(lista), lista)
    tempoFinal = t.time()
    listaResponse.append(["Merge sort", f"Tempo de exe: {(tempoFinal-tempoInicial):.5f} seg", f"Num. Comparacoes: {auxMergeComp[0]}"])

def mergeRecursivo(inicio, fim, lista):
    if inicio < fim-1:
        meio = (inicio + fim) // 2
        mergeRecursivo(inicio, meio, lista)
        mergeRecursivo(meio, fim, lista)
        intercala(inicio, meio, fim, lista)
        

#bloco do quick sort
def quick(lista):
    inicio = t.time()
    quickSortOrdena(lista, 0, len(lista)-1)
    fim = t.time()
    listaResponse.append(["Quick sort", f"Tempo de exe: {(fim-inicio):.5f} seg", f"Num. Comparacoes: {auxQuickComp[0]}"])

def quickSortOrdena(lista, esq, dir):
    if esq < dir:
        indice = particao(lista, esq, dir)
        quickSortOrdena(lista, esq, indice - 1)
        quickSortOrdena(lista, indice + 1, dir)

def particao(lista, esq, dir):
    indice_pivo = (esq+dir)//2
    pivo = lista[indice_pivo]
    i = esq
    j = dir
    while i <= j:
        while i <= dir and lista[i] <= pivo:
            i += 1
            auxQuickComp[0] += 1
        while j >= esq and lista[j] > pivo:
            j -= 1
            auxQuickComp[0] += 1
        if i < j:
            lista[i], lista[j] = lista[j], lista[i]
        
    lista[indice_pivo], lista[j] = lista[j], lista[indice_pivo]
    return j