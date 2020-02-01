from flask import Flask, jsonify
import requests
import jsons
app = Flask(__name__)

@app.route('/url_test', methods=['GET'])
def hitApi():
    r=requests.get("http://localhost:7200/springtest/")
    print(r)
    return jsonify({"response":r.status_code})
if __name__ == '__main__':
    app.run(debug=True)