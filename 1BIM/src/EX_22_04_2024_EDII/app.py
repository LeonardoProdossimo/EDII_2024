from flask import Flask, request
import funcoes as f

app = Flask(__name__)

@app.route("/selection_sort")
def todas():
    try:
         return f.pesquisa("selection")
    except Exception as e:
        return "Falha: "+str(e)

@app.route("/quick_sort")
def todas():
    try:
         return f.pesquisa("quick")
    except Exception as e:
        return "Falha: "+str(e)

if __name__ == "__main__":
    app.run()