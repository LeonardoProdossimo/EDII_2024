from flask import Flask, request
import funcoes as f

app = Flask(__name__)

@app.route("/brasil")
def todas():
    try:
         return f.pesquisa("")
    except Exception as e:
        return "Falha: "+str(e)
    
@app.route("/por_estado")
def porEstado():
    try:
        uf = request.args.get("uf")
        por_estado = f.pesquisa(uf)
        return por_estado
    except Exception as e:
        return "Falha: "+str(e)

if __name__ == "__main__":
    app.run()