from flask import Flask, request
import funcoes as f

app = Flask(__name__)

@app.route("/")
def inicia():
    try:
         return f.pesquisa()
    except Exception as e:
        return "Falha: "+str(e)

if __name__ == "__main__":
    app.run()