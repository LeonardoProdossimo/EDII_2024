from flask import Flask, request

app = Flask(__name__)


@app.route("/usuario", methods = ["GET"])
def index():
    try:
        user = request.args.get("nome", "padrão")
        idade = request.args.get("idade")
        return f"Ola {user} - {idade}"
    except:
        return "Falha na comunicação com servidor!"

@app.route("/calcula", methods = ["GET"])
def calcula():
    qtd = int(request.args.get("qtd"))
    preco = int(request.args.get("preco"))
    return f"R$ {qtd * preco}"


@app.route("/somarate", methods = ["GET"])
def somarate():
    valor = request.args.get("valor")
    if(valor is not None):
        soma = 0
        for i in range(int(valor)+1):
            soma += i
    else:
        i = 0
    return f"A soma de 0 ate {valor} deu {soma}"


app.run(debug=True)


