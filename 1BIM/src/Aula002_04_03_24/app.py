from flask import Flask, request
import ibge as i

app = Flask(__name__)

@app.route("/busca_nome")
def busca_nome():
    try:
        nome = request.args.get("nome")
        soma = i.calcula_ocorrencias(nome, "sum")
        return{
            "nome_procurado": nome,
            "total_ocorrencias": soma
        }
    except Exception as e:
        return "Falha: "+str(e)
    
@app.route("/menor_frequencia")
def menor():
    try:
        nome = request.args.get("nome")
        min = i.calcula_ocorrencias(nome, "min")
        return{
            "nome_procurado": nome,
            "periodo": min["periodo"].replace("[",""),
            "menor_ocorrencia": min["frequencia"]
        }
    except Exception as e:
        return "Falha: "+str(e)

@app.route("/maior_frequencia")
def maior():
    try:
        nome = request.args.get("nome")
        max = i.calcula_ocorrencias(nome, "max")
        return{
            "nome_procurado": nome,
            "periodo": max["periodo"].replace("[",""),
            "maior_ocorrencia": max["frequencia"]
        }
    except Exception as e:
        return "Falha: "+str(e)

@app.route("/selection_sort")
def selection_sort():
    try:
        nome = request.args.get("nome")
        selection_sort = i.calcula_ocorrencias(nome, "selection_sort")
        return selection_sort
    except Exception as e:
        return "Falha: "+str(e)

@app.route("/bubble_sort")
def bubble_sort():
    try:
        nome = request.args.get("nome")
        bubble_sort = i.calcula_ocorrencias(nome, "bubble_sort")
        return bubble_sort
    except Exception as e:
        return "Falha: "+str(e)

@app.route("/merge_sort")
def bubble_sort():
    try:
        nome = request.args.get("nome")
        merge_sort = i.calcula_ocorrencias(nome, "merge_sort")
        return merge_sort
    except Exception as e:
        return "Falha: "+str(e)

if __name__ == "__main__":
    app.run()