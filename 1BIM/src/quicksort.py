# def quick_sort(arr):

#     if len(arr) <= 1:
#         return arr

#     else:

#         pivo = arr[0]

#         menor_que_pivo = [x for x in arr[1:] if x <= pivo]

#         maior_que_pivo = [x for x in arr[1:] if x > pivo]

#         return quick_sort(menor_que_pivo) + [pivo] + quick_sort(maior_que_pivo)


# # Exemplo de uso:

# arr = [3, 6, 8, 10, 1, 2, 1]

# print("Array original:", arr)

# arr_ordenada = quick_sort(arr)

# print("Array ordenado:", arr_ordenada)


def quick_sort(L):
    quick_sort_aux(L, 0, len(L)-1)

def quick_sort_aux(L, esq, dir):
    if(esq < dir):
        indice = particao(L, esq , dir)
        quick_sort_aux(L, esq, indice-1)
        quick_sort_aux(L, indice+1, dir)


def particao(L, esq ,dir):
    pivo = L[esq]
    i = esq
    j = dir
    while i <= j:
        #encontra elementos maior 
        while i <= dir and L[i] <= pivo:
            i+=1
        while j >= esq and L[j] > pivo:
            j -=1

        #se indices se cruzarem
        if i < j:
           L[j], L[i] = L[i], L[j]

    #posiciona o pivo no local correto
    L[esq], L[j] = L[j], L[esq]
    return j


L = [5,4,5,3,2,1]
quick_sort(L)
print(L)