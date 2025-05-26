from flask import Flask, request, jsonify
from flask_cors import CORS
import google.generativeai as genai

app = Flask(__name__)
CORS(app, resources={r"/api/*": {"origins": "*"}})

# Configure Gemini API
genai.configure(api_key='AIzaSyDBRt2F1K3lILPBS00BioNivr3E61Jp8Jk')
model = genai.GenerativeModel('gemini-1.5-flash')

@app.route('/api/nutrition', methods=['GET'])
def get_nutrition():
    veg = request.args.get('vegetable', '').strip()
    if not veg:
        return jsonify({'error': 'Vegetable name is required'}), 400

    prompt = f"Give nutritional facts of {veg} in 2-3 lines."

    try:
        response = model.generate_content(prompt)
        return jsonify({'nutrition': response.text})
    except Exception as e:
        print("Error occurred:", e)
        return jsonify({'error': 'Failed to fetch nutritional facts'}), 500

if __name__ == '__main__':
    app.run(debug=True)
