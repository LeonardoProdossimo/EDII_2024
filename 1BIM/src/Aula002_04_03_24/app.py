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
            "periodo": min[1].replace("[",""),
            "menor_ocorrencia": min[0]
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
            "periodo": max[1].replace("[",""),
            "menor_ocorrencia": max[0]
        }
    except Exception as e:
        return "Falha: "+str(e)

if __name__ == "__main__":
    app.run()